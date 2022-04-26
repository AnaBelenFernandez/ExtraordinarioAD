package com.ana.ejercicio3;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Principal
{
    public static void main(String[] args)
    {
        //crear un directorio
        String nombre = "directorioCreado";
        File directorio = new File(nombre);
        Boolean creado = directorio.mkdir();
        if (creado)
        {
            try
            {
                System.out.println("directorio creado");
                //crear dos archivos dentro
                File fichero1 = new File(directorio, "fichero1");
                fichero1.createNewFile();
                File fichero2 = new File(directorio, "fichero2");
                fichero2.createNewFile();
            } catch (IOException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else
        {
            System.out.println("el directorio no se ha creado");
        }
    }
}
