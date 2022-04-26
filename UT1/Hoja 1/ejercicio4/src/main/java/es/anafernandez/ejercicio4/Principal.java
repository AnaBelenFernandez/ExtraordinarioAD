/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Principal {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
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
            String nombreFichero = "lobo";
            File fichero = new File("lobo");
           
            switch (opcion) {
                case 1:
                    //comprobar si es un directorio
                    if (fichero.isDirectory()) {
                        System.out.println("es un directorio");
                    } else {
                        System.out.println("no es un directorio");
                    }
                    break;
                case 2:
                    //obtener los ficheros del directorio
                    File directorio = new File(".");
                    File[] ficheros = directorio.listFiles();
                    for (int i = 0; i < ficheros.length; i++) {
                        System.out.println(ficheros[i].getName() + "  " + ficheros[i].getPath());
                        if (ficheros[i].isDirectory()) {
                            System.out.println("D");
                        } else {
                            System.out.println("F");
                        }

                    }

                    break;
                case 3:
                    //pedir por teclado ruta directorio
//                System.out.println("escriba la ruta del directorio");
//                String ruta = teclado.nextLine();
//                teclado.next();
                    System.out.println("escriba el nombre del fichero");
                    String nombre = teclado.nextLine();
                    teclado.next();
                    File dir = new File(".");
                    if (dir.exists()) {
                        System.out.println("el directorio existe");
                        if (dir.isDirectory()) {
                            System.out.println("es un directorio válido");
                            File[] archs = dir.listFiles();
                            for (int i = 0; i < archs.length; i++) {
                                System.out.println(archs[i]);
                                if (archs[i].getName().equalsIgnoreCase(nombre)) {
                                    System.out.println("el archivo es " + archs[i].getName() + "y pesa" + archs[i].getTotalSpace());
                                }
                            }
                        }
                    } else {
                        System.out.println("no es un directorio válido");
                    }

                    break;
                case 4:
                    File dire = new File(".");
                    System.out.println(dire.getAbsolutePath());
                    break;
                case 5:
//pedir la ruta de un fichero por teclado no me funciona, si la meto directamente al string, si me deja.
                    String rutaborrar = "lobo.jpg";
                    File archivoBorrar = new File(rutaborrar);
                    if (archivoBorrar.exists()) {
                        if (archivoBorrar.delete()) {
                            System.out.println("archivo borrado");
                        };
                    } else {
                        System.out.println("el archivo no existe");
                    }
                case 6:
                    String rutaDirectorio = ".";
                    String nombreF = "lobo.jpg";
                    File buscar = new File(rutaDirectorio, nombreF);
                    if (buscar.exists()) {
                        try {
                            System.out.println("el archivo existe y será movido a otra carpeta");
                            String directorioDestino = "nuevoDir";
                            File copia = new File(directorioDestino, buscar.getName());
                            Files.copy(buscar.toPath(), copia.toPath(), REPLACE_EXISTING);
                            buscar.delete();
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        System.out.println("el archivo no existe");
                    }
                    break;
                case 7:
                    String rutaRenombrar = ".";
                    String nombreR = "lobo.jpg";
                    File renombrar = new File(rutaRenombrar, nombreR);
                    if (renombrar.exists()) {
                        String nuevoNombre = "perroLobo.jpg";
                        File nuevoArchivo = new File(nuevoNombre);
                        if (renombrar.renameTo(nuevoArchivo)) {
                            System.out.println("archivo renombrado");
                        } else {
                            System.out.println("error");
                        }
                    }
                    break;
            }
        } while (opcion != 8);
    }
}
