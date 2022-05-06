package com.ana.leerobjetos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author usuario
 */
public class Principal
{
    public static void main(String[] args)
    {
        Path ficheroOriginal = Paths.get("perros.txt");
        List<Perro> perros = new ArrayList();
        String raza = "";
        String nombre = "";
        Perro perro = null;
        if (Files.exists(ficheroOriginal))
        {
            int posicion;
            try
            {
                List<String> todasLineas = Files.readAllLines(ficheroOriginal);
                for (int i = 0; i < todasLineas.size(); i++)
                {
                    switch (i % 3)
                    {
                        case 0:
                            perro = new Perro();
                            perros.add(perro);
                            break;
                        case 1:
                            nombre = todasLineas.get(i);
                            perro.setNombre(nombre);
                            break;
                        case 2:
                            raza = todasLineas.get(i);
                            perro.setRaza(raza);
                    }
                }
                for (Perro p : perros)
                {
                    System.out.println(p.toString());
                }
                //ahora quiero cargar estos objetos a un xml con dom
                DocumentBuilderFactory dBFactory = DocumentBuilderFactory.newInstance();
                try
                {//creo la estructura del documento
                    DocumentBuilder constructor = dBFactory.newDocumentBuilder();
                    Document doc = constructor.newDocument();
                    doc.setXmlVersion("1.0");
                    Element elementPerros = (Element) doc.createElement("perros");
                    doc.appendChild((Node) elementPerros);
                    for (Perro pe : perros)
                    {
                        Element elementPerro = (Element) doc.createElement("perro");
                        String nom = pe.getNombre();
                        elementPerros.appendChild((Node) elementPerro);
                        Element elementNombre = doc.createElement("nombre");
                        elementNombre.appendChild(doc.createTextNode(nom));
                        elementPerro.appendChild(elementNombre);
                        Element elementRaza = doc.createElement("raza");
                        String raz = pe.getRaza();
                        elementRaza.appendChild(doc.createTextNode(raz));
                        elementPerro.appendChild(elementRaza);
                    }
                    //añado un perro al xml
                    Element elementPerro = (Element) doc.createElement("perro");
                    elementPerros.appendChild((Node) elementPerro);
                    Element elementNombre = doc.createElement("nombre");
                    elementNombre.appendChild(doc.createTextNode("Abelardo"));
                    elementPerro.appendChild(elementNombre);
                    Element elementRaza = doc.createElement("raza");
                    elementRaza.appendChild(doc.createTextNode("Fox Terrier"));
                    elementPerro.appendChild(elementRaza);
                    //lo convierto en un xml
                    Source source = new DOMSource(doc);
                    Result result = new StreamResult(Files.newBufferedWriter(Paths.get("perros.xml")));
                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.transform(source, result);
                    //lo leo
                    Files.readAllLines(Paths.get("perros.xml"))
                            .stream()
                            .forEach(System.out::println);
                    //crear una nueva lista con los datos del xml
                    List<Perro> listaxml = new ArrayList();
                    Element raiz = doc.getDocumentElement();
                    System.out.println("Raiz del XML=" + raiz.getNodeName());
                    NodeList listaPerros = raiz.getElementsByTagName("perro");
                    for (int i = 0; i < listaPerros.getLength(); i++)
                    {
                        Node nodoPerro = listaPerros.item(i);
                        Element element = (Element) nodoPerro;
                        Perro perroxml = new Perro();
                        String nombrePerro = element.getElementsByTagName("nombre").item(0).getTextContent();
                        perroxml.setNombre(nombrePerro);
                        String razaPerro = element.getElementsByTagName("raza").item(0).getTextContent();
                        perroxml.setRaza(razaPerro);
                        listaxml.add(perroxml);
                    }
                    System.out.println("<-- lectura del xml-->");
                    for (Perro perro1 : listaxml)
                    {
                        System.out.println(perro1.toString());
                    }
                    //escribir la nueva lista en un archivo de texto                

                    BufferedWriter escritor
                            = new BufferedWriter(new FileWriter("perroscopia.txt"));
                    for (Perro perro1 : listaxml)
                    {
                        escritor.newLine();
                        escritor.write(perro1.getNombre());
                        escritor.newLine();
                        escritor.write(perro1.getRaza());
                        escritor.newLine();
                    }
                    escritor.close();
                    //ahora hay que sustituir perroscopia x perros y cambiarle el nombre
                    Files.delete(ficheroOriginal);
                    File oldfile = new File("perroscopia.txt");
                    File newfile = new File("perros.txt");
                    if (oldfile.renameTo(newfile))
                    {
                        System.out.println("archivo renombrado");
                    } else
                    {
                        System.out.println("error");
                    }
                    //ahora vamos a leer perros.xml con sax
                    try
                    {
                        SAXParserFactory factoria = SAXParserFactory.newInstance();
                        SAXParser parser = factoria.newSAXParser();
                        PerrosHandler manejador = new PerrosHandler();
                        File fichero = new File("perros.xml");
                        parser.parse(fichero, manejador);
                        //lo sacamos por pantalla
                        System.out.println("<--lista SAX-->");
                        manejador.getPerros().stream().forEach(System.out::println);

                    } catch (ParserConfigurationException | SAXException | IOException ex)
                    {
                        System.out.println("Error al parsear el documento");
                    }
//convertir la lista de perros a un fichero json (listaxml está completa con abelardo)
                    BufferedWriter escritorJson = null;
                    escritorJson = Files.newBufferedWriter(Paths.get("perros.json"));
                    {
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        gson.toJson(listaxml, escritorJson);
                    }
                    escritorJson.close();
//leer el json
                    BufferedReader lector = Files.newBufferedReader(Paths.get("perros.json"));
                    Gson gson = new Gson();
                    Perro[] ps = gson.fromJson(lector, Perro[].class);
                    System.out.println("<-------imprimir el JSON-------->");
                    for (Perro perrito : ps)
                    {
                        System.out.println(perrito);
                    }
                    lector.close();
                } catch (ParserConfigurationException e)
                {
                    System.out.println(e.getMessage());
                } catch (TransformerException ex)
                {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (IOException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
