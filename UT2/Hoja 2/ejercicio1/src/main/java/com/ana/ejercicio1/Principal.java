package com.ana.ejercicio1;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author usuario
 */
public class Principal {
    public static void main(String[] args)
    {
            try
        {
            SAXParserFactory factoria = SAXParserFactory.newInstance();
            SAXParser parser = factoria.newSAXParser();            
            //Ahora es cuando se procede a parsear el fichero XML. Al método que parsea
            //hay que pasarle un File del fichero a parsear y un handler o manejador
            //(este debe ser un objeto de una clase creada a partir de DefaultHandler
            //Define como es el documento y como se tiene que interpretar
            DepartamentosHandler manejador = new DepartamentosHandler();            
            File fichero = new File("departamentos.xml");
            parser.parse(fichero, manejador);
            manejador.getDepartamentos().stream().forEach(System.out::println);
        }
        catch (ParserConfigurationException | SAXException | IOException ex)
        {
            System.out.println("Error al parsear el documento");
        }
    }

}
