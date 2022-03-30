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
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class MenuFicheros {

    public static void main(String[] args) {
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
                File numeros = new File("numeros.dat");
                int aleatorio;              
                switch (opcion) {
                    case 1:
                        //grabar en el fichero personas.txt
                        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("personas.txt", true), "utf-8"));
                        bw.write(recogerDatos());
                        bw.close();
                        break;
                    case 2:
                        br = new BufferedReader(new FileReader("personas.txt"));
                        String linea;
                        Boolean encontrado = false;
                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                            if (linea.equalsIgnoreCase(recogerDatos())) {
                                System.out.println("Ese nombre ya existe" + linea);
                                encontrado = true;
                            }
                            else{
                                System.out.println("el nombre no existe en nuestra base de datos");}
                            break;
                        }
                }
            } catch (UnsupportedEncodingException ex) {
                System.out.println(ex.getMessage());;
            } catch (FileNotFoundException ex) {
                System.out.println("archivo no encontrado");
            } catch (IOException ex) {
                System.out.println("error de E/S");
            }

        } while (opcion != 6);
    }

    public static String recogerDatos() {
        Scanner teclado = new Scanner(System.in);
        String apellido = "";
        String nombre = "";
        String nombreCompleto = "";
        System.out.println("teclee apellidos");
        apellido = teclado.next();
        teclado.nextLine();
        System.out.println("sus apellidos son-->" + apellido);
        System.out.println("teclee nombre");
        nombre = teclado.nextLine();
        System.out.println("su nombre es -->" + nombre);
        //se unifican en una linea de texto
        nombreCompleto = apellido.toUpperCase() + ", " + nombre.toUpperCase() + "\n";
        System.out.println(nombreCompleto);
        return nombreCompleto;
    }
}
