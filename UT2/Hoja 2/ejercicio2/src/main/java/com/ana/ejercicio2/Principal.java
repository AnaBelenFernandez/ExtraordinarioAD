package com.ana.ejercicio2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    {Scanner teclado=new Scanner(System.in);
             try
        {          
            SAXParserFactory factoria = SAXParserFactory.newInstance();            
            SAXParser parser = factoria.newSAXParser();
                DepartamentosHandler manejador = new DepartamentosHandler();            
            File fichero = new File("universidad.xml");
            parser.parse(fichero, manejador);
            manejador.getDepartamentos().stream().forEach(System.out::println);
            System.out.println("introduce código de departamento");
            String codigo=teclado.nextLine();
           List<Departamento> lista=manejador.getDepartamentos();
           boolean existe=false;
            for (Departamento departamento : lista)
            {
                if(departamento.getCodigo().equalsIgnoreCase(codigo)){
                    System.out.println(departamento.toString());
                    existe=true;
                }              
            }
            if(existe==false){
                System.out.println("El departamento no existe");}
        }
        catch (ParserConfigurationException | SAXException  ex)
        {
            System.out.println("Error al parsear el documento");
        } catch (IOException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

}
