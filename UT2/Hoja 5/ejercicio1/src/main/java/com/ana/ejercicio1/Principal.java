package com.ana.ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

/**
 *
 * @author usuario
 */
public class Principal
{
    public static void main(String[] args)
    {
        try
        {
            URL url1 = new URL("https://aplicaciones.ivanlorenzo.es/ad/dam2.xml");
            URL url = new URL("https://aplicaciones.ivanlorenzo.es/ad/dam2.json");
            URLConnection conexion = url1.openConnection();//cambiar aquí la url para ver uno u otro documentos
            BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String cadenaAsignaturas = lector.lines().
                    collect(Collectors.joining("\n"));
            System.out.println(cadenaAsignaturas);

        } catch (MalformedURLException ex)
        {
            System.out.println("Error " + ex.getMessage());
        } catch (IOException ex)
        {
            System.out.println("Error " + ex.getMessage());
        }
    }

}
