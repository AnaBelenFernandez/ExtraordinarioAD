/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class MenuFicheros {

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();
        int opcion = 0;
        BufferedWriter bw = null;
        BufferedReader br = null;
        do {

            try {
                System.out.println("teclea una opción");
                System.out.println("1- Añadir Persona");
                System.out.println("2- Buscar Persona");
                System.out.println("3- Buscar Nombre");
                System.out.println("4- Apellidos comienzan por");
                System.out.println("5- Eliminar persona");
                System.out.println("6- Salir");
                opcion = teclado.nextInt();
                teclado.nextLine();
                File numeros = new File("numeros.dat");
                int aleatorio;
                switch (opcion) {
                    case 1:
                        //grabar en el fichero personas.txt
                        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("personas.txt", true), "utf-8"));
                        bw.write(recogerDatos());
                        bw.newLine();//metemos así el salto de línea entre nombres
                        bw.close();
                        break;
                    case 2:
                        br = new BufferedReader(new FileReader("personas.txt"));
                        String linea;
                        String nombreC = recogerDatos();
                        boolean encontrado = false;
                        while ((linea = br.readLine()) != null) {
                            //System.out.println(linea);
                            if (linea.equalsIgnoreCase(nombreC)) {
                                System.out.println("Ese nombre ya existe" + linea);
                                encontrado = true;
                            }
                        }
                        break;
                    case 3:
                        /*Se recoge por teclado un nombre de persona y se devuelve una lista con las personas del
fichero que tienen ese nombre. Luego se imprime la lista.*/

                        System.out.println("teclea nombre");
                        String nombreRecogido = teclado.nextLine();

                        List<String> todoslosNombres = nombres(nombreRecogido);
                        for (String n : todoslosNombres) {
                            System.out.println(n);
                        }
                        break;
                    case 4:
                        /*Se introduce los primeros caracteres de apellidos de persona y se devuelve una lista con
las personas del fichero cuyos apellidos comienzan por esos primeros caracteres. Luego se imprime
la lista*/
                        System.out.println("Teclea las tres primeras letras de un apellido");
                        String letras = teclado.nextLine();
                        List<String> encontrados = apellidosIniciales(letras);
                        for (String e : encontrados) {
                            System.out.println(e);
                        }

                        break;
                    case 5:
                        /*: Se recogen por teclado el nombre y apellidos de una persona y, si se encuentra en el
fichero, se elimina del fichero. Para hacer esto se necesita un fichero auxiliar en el que se van
guardando todos los nombres que no se tengan que eliminar.*/
                        System.out.println("Teclea Nombre");
                        String nombre = teclado.nextLine();
                        System.out.println("Teclea Apellido");
                        String ape = teclado.nextLine();
                        String nombreCompleto = ape + "," + nombre;
                        BufferedReader br5 = null;
                        List<String> listaCompleta = null;
                        try {
                            br5 = new BufferedReader(new FileReader("personas.txt"));
                            listaCompleta = new ArrayList();
                            while ((linea = br5.readLine()) != null) {
                                if (linea.equalsIgnoreCase(nombreCompleto)) {
                                    listaCompleta.remove(linea);
                                }
                            }
                            br5.close();
                            //ahora hay que sobreescribir el documento en un fichero auxiliar
                            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("auxiliar.txt", true), "utf-8"));
                            for (String l : listaCompleta) {
                                bw.write(l);
                                bw.newLine();//metemos así el salto de línea entre nombres
                            }
                            //renombramos el auxiliar
                            
                                bw.close();
                                break;

                            }catch (FileNotFoundException ex) {
                            Logger.getLogger(MenuFicheros.class.getName()).log(Level.SEVERE, null, ex);
                        }
                            catch (UnsupportedEncodingException ex)
            {
                System.out.println(ex.getMessage());}
                            catch (IOException ex)
            {
                System.out.println("error de E/S");
            }
                        }
                        while (opcion != 6);
                }
            }
        }

    

        

    

    

    public static String recogerDatos() {
        Scanner teclado = new Scanner(System.in, "ISO-8859-1");//con esta especificación se meten bien las tildes

        System.out.println("teclee apellidos");
        String apellido = teclado.next();
        teclado.nextLine();
        System.out.println("sus apellidos son-->" + apellido);
        System.out.println("teclee nombre");
        String nombre = teclado.nextLine();
        System.out.println("su nombre es -->" + nombre);
        //se unifican en una linea de texto
        String nombreCompleto = apellido.toUpperCase() + ", " + nombre.toUpperCase();
        System.out.println(nombreCompleto);
        return nombreCompleto;
    }

    public static List<String> nombres(String n) {
        BufferedReader br = null;
        List<String> nombresEncontrados = null;
        try {
            br = new BufferedReader(new FileReader("personas.txt"));
            nombresEncontrados = new ArrayList();
            String linea = "";
            boolean encontrado = false;
            while ((linea = br.readLine()) != null) {
                String[] piezas = linea.split(",");
                String nombreSolo = piezas[1].trim();//el trim elimina espacios en blanco que se hayan podido meter por teclado
                if (n.equalsIgnoreCase(nombreSolo)) {
                    nombresEncontrados.add(linea + "\n");
                    encontrado = true;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuFicheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MenuFicheros.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(MenuFicheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return nombresEncontrados;
    }

    public static List<String> apellidosIniciales(String iniciales) {
        BufferedReader br = null;
        List<String> apellidos = null;
        try {
            br = new BufferedReader(new FileReader("personas.txt"));
            apellidos = new ArrayList();
            String linea = "";
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith(iniciales.toUpperCase())) {
                    apellidos.add(linea + "\n");
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuFicheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MenuFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return apellidos;
    }
}
