package com.ana.ejercicio1;

import java.io.File;

/**
 *
 * @author usuario
 */
public class Principal {
    public static void main(String[] args)
    {
        File directorio = new File(".");
        if (directorio.exists())
        {
            System.out.println("Ficheros del directorio " + ".");
            File[] listaFicheros = directorio.listFiles();
            for (File fichero: listaFicheros)
            {
                System.out.println("Nombre"+fichero.getName());
                System.out.println("Tamño"+fichero.getTotalSpace());
                System.out.println("Ruta:"+fichero.getPath());
                System.out.println("Ruta Absoluta"+fichero.getAbsolutePath());
                System.out.println("Se puede leer :"+fichero.canRead());
            }
        }
        else
        {
            System.err.println("ERROR. No existe el directorio " + ".");
        }
    }

}
