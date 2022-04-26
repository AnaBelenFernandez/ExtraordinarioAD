package com.ana.ejercicio4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.List;
import java.util.Scanner;
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
        try
        {
            Scanner teclado = new Scanner(System.in);
            int opcion = 0;
            System.out.println("teclea una opción");
            System.out.println("1- comprobar si es un directorio");
            System.out.println("2- obtener los ficheros de un directorio");
            System.out.println("3- obtener el tamaño del fichero");
            System.out.println("4- obtener la ruta del fichero actual");
            System.out.println("5- eliminar fichero");
            System.out.println("6- mover fichero");
            System.out.println("7- renombrar fichero");
            System.out.println("8- salir");
            opcion = teclado.nextInt();
            //instanciamos el fichero
            String directorio = "carpetaNueva";
            File carpetaNueva = new File(directorio);
            Boolean creado = carpetaNueva.mkdir();
            String nombreFichero = "lobo";
            File fichero = new File("lobo");
            fichero.createNewFile();
            String nd;
            String nf;
            String ruta;
            File fi;
            switch (opcion)
            {
                case 1:
                    //comprobar si es un directorio
                    if (carpetaNueva.isDirectory())
                    {
                        System.out.println("es un directorio");
                    } else
                    {
                        System.out.println("no es un directorio");
                    }
                    break;
                case 2:
                    //obtener los ficheros del directorio
                    File directorioA = new File(".");
                    //cargamos los ficheros que hay en el directorio en un array de Files
                    File[] ficheros = directorioA.listFiles();
                    for (File ficheroA : ficheros)
                    {
                        System.out.println(ficheroA.getName());
                        if (ficheroA.isDirectory())
                        {
                            System.out.println("D");
                        } else
                        {
                            System.out.println("F");
                        }
                    }
                    break;
                case 3:
                    String nombredirectorio = ".";
                    String nombreF = "lobo";
                    //con estos dos tengo que hacer una ruta
                    ruta = nombredirectorio + "/" + nombreF;
                    File f = new File(ruta);
                    if (f.exists())
                    {
                        System.out.println(f.getTotalSpace() + " bytes");
                    }
                    break;
                case 4:
                    File rutaactual = new File(".");
                    System.out.println("la ruta actual es" + rutaactual.getAbsolutePath());
                    break;
                case 5:
                    nd = ".";
                    nf = "lobo";
                    ruta = nd + "/" + nf;
                    fi = new File(ruta);
                    if (fi.exists())
                    {
                        fi.delete();
                    } else
                    {
                        System.out.println("el fichero no existe");
                    }
                    break;
                case 6:
                    //mover un fichero de un directorio a otro
                    String rutaDirectorio = ".";
                    nombreF = "lobo";
                    File buscar = new File(rutaDirectorio, nombreF);
                    if (buscar.exists())
                    {
                        try
                        {
                            System.out.println("el archivo existe y será movido a otra carpeta");
                            String directorioDestino = "nuevoDir";
                            File nuevaCarpeta = new File(directorioDestino);
                            Boolean creadook = nuevaCarpeta.mkdir();
                            if (creadook)
                            {
                                File copia = new File(directorioDestino, "lobo");
                                copia.createNewFile();
                                Files.copy(buscar.toPath(), copia.toPath(), REPLACE_EXISTING);
                                buscar.delete();
                            }
                        } catch (IOException ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    } else
                    {
                        System.out.println("el archivo no existe");
                    }
                    break;
                case 7:
                    //cambiar el nombre a un fichero
                    File cambiar = new File("zorro");
                    fi = new File("zorra");
                    if (fi.renameTo(cambiar))
                    {
                        System.out.println("archivo renombrado correctamente");
                    }
                    break;
            }
        } catch (IOException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
