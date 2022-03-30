/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Mayusmin {

    public static void main(String[] args) {
        BufferedWriter bw = null;
        String linea = "";
        try {
            Scanner teclado = new Scanner(System.in);
            System.out.println("Introduce la ruta");
            String ruta = teclado.nextLine();
            teclado.nextLine();
            System.out.println("introduce el nombre de fichero");
            String nombre = teclado.nextLine();
            teclado.nextLine();
            String rutatotal = ruta + "/" + nombre + ".txt";
            bw = new BufferedWriter(new FileWriter(rutatotal, true));
            //vamos recogiendo por teclado y añadiendo al fichero.txt
            System.out.println("Escribe el texto que quieres añadir");
            while (!(linea = teclado.nextLine()).isEmpty()) {
                bw.write(linea);
                bw.newLine();
            }
            bw.close();
            //empezamos el proceso de lectura del contenido del fichero
            File fichero = new File(rutatotal);
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String texto = "";
            //recogemos todo el texto, línea a línea con este bucle
            while ((linea = br.readLine()) != null) {
                texto = texto + linea + "\n";

            }
            char letra;
            //recorremos el texto y vamos cambiando may<-->min
            for (int i = 0; i < texto.length(); i++) {
                letra = texto.charAt(i);
                if (Character.isUpperCase(letra)) {
                    System.out.print(Character.toLowerCase(letra));
                } else if (Character.isLowerCase(letra)) {
                    System.out.print(Character.toUpperCase(letra));
                } else {
                    System.out.print(letra);
                }

            }
            br.close();

        } catch (IOException ex) {
            Logger.getLogger(Mayusmin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(Mayusmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
