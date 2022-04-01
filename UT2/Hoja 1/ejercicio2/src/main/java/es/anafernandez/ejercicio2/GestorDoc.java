/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *
 * @author DELL
 */
public class GestorDoc {

    public Document crearDocumento() {//creo un documento con su nodo raiz
        Document documento = null;
        try {
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            documento = constructor.newDocument();
            documento.setXmlVersion("1.0");
            //raiz
            Element futbolistas = documento.createElement("futbolistas");
            documento.appendChild(futbolistas);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GestorDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return documento;
    }

    public void convertirenXML(Document documento) {
        try {
            //transformación
            Source source = new DOMSource(documento);
            Result result = new StreamResult(Files.newBufferedWriter(Paths.get("futbolistas.xml")));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            //comprobación
            Files.readAllLines(Paths.get("futbolistas.xml")).stream().forEach(System.out::println);
        } catch (IOException ex) {
            Logger.getLogger(GestorDoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(GestorDoc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Futbolista insertarFutbolista(Futbolista futbolista, Document documento) {
        try {
            Element elementFutbolista = documento.createElement("futbolista");
//hijos de Futbolista
// creo número y lo añado debajo de futbolista
            Element elementNumero = documento.createElement("numero");
            elementFutbolista.appendChild(elementNumero);
            int numero = Integer.valueOf(futbolista.getNumero());
            Text textNumero = documento.createTextNode(String.valueOf(numero));
            elementNumero.appendChild(textNumero);
//creo alias
            Element elementAlias = documento.createElement("alias");
            elementFutbolista.appendChild(elementAlias);
            Text textAlias = documento.createTextNode(futbolista.getAlias());
            elementAlias.appendChild(textAlias);
//creo el resto igual
            Element elementPosicion = documento.createElement("posicion");
            elementFutbolista.appendChild(elementPosicion);
            byte pos = futbolista.getPosicion();
            Text textPosicion = documento.createTextNode(String.valueOf(pos));
            elementPosicion.appendChild(textPosicion);

            Element elementAltura = documento.createElement("altura");
            elementFutbolista.appendChild(elementAltura);
            Text textAltura = documento.createTextNode(String.valueOf(futbolista.getAltura()));
            elementAltura.appendChild(textAltura);

            Element elementEquipo = documento.createElement("equipo");

            elementFutbolista.setAttribute("equipo", futbolista.getEquipo());

            //Finalmente, se obtiene el primer nodo del documento y a él se le añade como hijo el 
            //nodo alumno que ya tiene colgando todos sus hijos y atributos creados antes.
            Node raiz = documento.getChildNodes().item(0);
            raiz.appendChild(elementFutbolista);

        } catch (DOMException e) {
            System.err.println("Error al añadir al DOM");
        }
        return futbolista;
    }

    public String ListarFutbolistas(Document documento) {
        //Obtiene el primero nodo del DOM
        Element raiz = (Element) documento.getFirstChild();
        //lista de futbolistas en el documento
        NodeList futbolistas = raiz.getElementsByTagName("futbolista");
        //lista de atributos
        List<String> atributos = new ArrayList();
        for (int i = 0; i < futbolistas.getLength(); i++) {
            if (futbolistas.item(i).getNodeType() == Node.ELEMENT_NODE) {
                atributos.addAll(procesarAtributos(futbolistas.item(i)));
            }
        }
        String cadena = "Atributos de futbolistas:\n";
        for (int i = 0; i < atributos.size(); i++) {
            //si es posición par, es el nombre del atributo. Impar el valor del atributo
            cadena += "\t" + atributos.get(i);
            cadena += (i % 2 == 0) ? "=" : "\n";
        }
        cadena += "\n======= LISTADO DE Futbolistas =======\n";
        //Obtiene una lista de nodos con todos los nodos hijo del raiz (de alumnos)
        NodeList nodosFutbolista = raiz.getChildNodes();
        for (int i = 0; i < nodosFutbolista.getLength(); i++) //Proceso los nodos hijo (nodos futbolista)
        {
            Node nodoFutbolista = nodosFutbolista.item(i);
            //Al ejecutar paso a paso este código, se observa como los nodos que encuentra son
            //de tipo 1 (ELEMENT_NODE) y tipo 3 (TEXT_NODE). 
            if (nodoFutbolista.getNodeType() == Node.ELEMENT_NODE) { //Es un nodo Alumno que hay que procesar si es de tipo Elemento
                String[] datos_nodo = procesarFutbolista(nodoFutbolista);
                cadena += String.format("| Dorsal: %-2s|", datos_nodo[0]);
                cadena += String.format("| Alias: %3s |", datos_nodo[1]);
                if (datos_nodo[2].equalsIgnoreCase("1")) {
                    cadena += String.format("| Posicion: portero |");
                }
                if (datos_nodo[2].equalsIgnoreCase("2")) {
                    cadena += String.format("| Posicion: defensa |");
                }
                if (datos_nodo[2].equalsIgnoreCase("3")) {
                    cadena += String.format("| Posicion: centrocampista |");
                }
                cadena += String.format("| Altura: %3s |", datos_nodo[3]);
                cadena += String.format("| Equipo: %3s |\n", datos_nodo[4]);
            }
        }
        return cadena;
    }

    private List<String> procesarAtributos(Node nodo) {
        List<String> atributos = new ArrayList();

        //Para saber cuantos atributos tiene el nodo
        int num = nodo.getAttributes().getLength();
        for (int i = 0; i < num; i++) {
            //De la lista de atributos añade al ArrayList el nombre de cada atributo y su valor
            //Cada vez se añaden dos valores al ArrayList
            // en las posiciones pares habrá nombres de atributos y en las impares valores de atributos
            atributos.add(nodo.getAttributes().item(i).getNodeName());
            atributos.add(nodo.getAttributes().item(i).getNodeValue());
        }
        return atributos;
    }

    private String[] procesarFutbolista(Node nodo) {
        String[] datos = new String[5];
        int contador = 0;
        NodeList nodos = nodo.getChildNodes();
        for (int i = 0; i < nodos.getLength(); i++) {
            Node nodoHijo = nodos.item(i);
            if (nodoHijo.getNodeType() == Node.ELEMENT_NODE) {
                datos[contador] = nodoHijo.getChildNodes().item(0).getNodeValue();
                contador++;
            }
        }
        return datos;
    }

    public List<Futbolista> getFutbolistasEquipo(String equipo, Document documento) {
        Futbolista futbolista = null;
        List<Futbolista> futbolistas=new ArrayList();
        Element nodo = null;
        Element raiz = (Element) documento.getFirstChild();
        NodeList nodosFutbolista = raiz.getElementsByTagName("futbolista");
        for (int i = 0; i < nodosFutbolista.getLength(); i++) {
            nodo = (Element) nodosFutbolista.item(i);
            String atributoEquipo=nodo.getAttribute("equipo");
//            String textoEquipo = nodo.getElementsByTagName("equipo").item(0).getTextContent();
            if (atributoEquipo.equalsIgnoreCase(equipo)) {
                nodo = (Element) nodosFutbolista.item(i);
            }
            futbolista = getFutbolista(nodo);
            futbolistas.add(futbolista);
        }

        return futbolistas;
    }

    private Futbolista getFutbolista(Node nodo) {
        Futbolista futbolista = null;
        if (nodo.getNodeType() == Node.ELEMENT_NODE) {
            Element nodoFutbolista = (Element) nodo;
            //crear futbolista
            String num = nodoFutbolista.getElementsByTagName("numero").item(0).getTextContent();
            Short numero = Short.valueOf(num);
            String alias = nodoFutbolista.getElementsByTagName("alias").item(0).getTextContent();
            String pos = nodoFutbolista.getElementsByTagName("posicion").item(0).getTextContent();
            byte posicion = Byte.parseByte(pos);
            String alt = nodoFutbolista.getElementsByTagName("altura").item(0).getTextContent();
            float altura = Float.parseFloat(alt);
            String equipo = nodoFutbolista.getAttribute("equipo");
            futbolista = new Futbolista(numero, alias, posicion, altura, equipo);

        }

        return futbolista;
    }
  public Futbolista cambiarEquipoFutbolista(short dorsal, Document documento, String equipo) {
        Futbolista futbolista = null;
        Element nodo = null;
          String numeroBuscar = String.valueOf(dorsal);
        Element raiz = (Element) documento.getFirstChild();
        NodeList nodosFutbolista = raiz.getElementsByTagName("futbolista");
        for (int i = 0; i < nodosFutbolista.getLength(); i++) {
            nodo = (Element) nodosFutbolista.item(i);
            String dorsalFutbolista=nodo.getElementsByTagName("numero").item(0).getTextContent();
            if (dorsalFutbolista.equalsIgnoreCase(numeroBuscar)) {
                nodo = (Element) nodosFutbolista.item(i);
                nodo.setAttribute("equipo", equipo);
                        }
            futbolista = getFutbolista(nodo);
            futbolista.setEquipo(equipo);
           
            
        }

        return futbolista;
    }
  
    public Futbolista cambiarAlturaFutbolista(short dorsal, Document documento, float altura) {
        Futbolista futbolista = null;
        Element nodo = null;
          String numeroBuscar = String.valueOf(dorsal);
        Element raiz = (Element) documento.getFirstChild();
        NodeList nodosFutbolista = raiz.getElementsByTagName("futbolista");
        for (int i = 0; i < nodosFutbolista.getLength(); i++) {
            nodo = (Element) nodosFutbolista.item(i);
            String dorsalFutbolista=nodo.getElementsByTagName("numero").item(0).getTextContent();
            if (dorsalFutbolista.equalsIgnoreCase(numeroBuscar)) {
                nodo = (Element) nodosFutbolista.item(i);
            }
            futbolista = getFutbolista(nodo);
            futbolista.setAltura(altura);            
        }

        return futbolista;
    }
}
