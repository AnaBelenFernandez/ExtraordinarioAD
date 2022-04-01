/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio1;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author DELL
 */
public class Principal {
     public static void main(String[] args) {      
         try {
             DocumentBuilderFactory fabrica=DocumentBuilderFactory.newInstance();
             DocumentBuilder constructor=fabrica.newDocumentBuilder();
             Document documento=constructor.newDocument();
             documento.setXmlVersion("1.0");
             //raiz
             Element futbolistas=documento.createElement("futbolistas");
             documento.appendChild(futbolistas);
             //nodo debajo
             Element futbolista=documento.createElement("futbolista");
             futbolistas.appendChild(futbolista);
             //añadir atributo:hay que dar clave valor
             futbolista.setAttribute("equipo","");
             //¿esto hay que volverlo a hacer?
             futbolistas.appendChild(futbolista);
             Element num=documento.createElement("num");
             futbolista.appendChild(num);
             Element alias=documento.createElement("alias");
             futbolista.appendChild(alias);
             Element posicion=documento.createElement("posicion");
             futbolista.appendChild(posicion);
             Element altura=documento.createElement("altura");
             futbolista.appendChild(altura);
             
             //transformación
             Source source=new DOMSource(documento);
             Result result=new StreamResult(Files.newBufferedWriter(Paths.get("futbolistas.xml")));
             Transformer transformer= TransformerFactory.newInstance().newTransformer();
             transformer.setOutputProperty(OutputKeys.INDENT, "yes");
             transformer.transform(source, result);
             
             //comprobación
             Files.readAllLines(Paths.get("alumnos.xml")).stream().forEach(System.out::println);
             
             
         } catch (ParserConfigurationException ex) {
             Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
         } catch (TransformerConfigurationException ex) {
             Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
         } catch (TransformerException ex) {
             Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
         }

     }
    
}
