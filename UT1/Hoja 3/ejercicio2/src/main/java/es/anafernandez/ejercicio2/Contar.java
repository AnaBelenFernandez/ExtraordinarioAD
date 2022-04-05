/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Contar {
    public static void main(String[] args) {
        BufferedReader br = null;
        String linea = "";
        try {
            Scanner teclado = new Scanner(System.in);
            System.out.println("introduce un caracter");
            String c = teclado.nextLine();
            //convertir el string a char
            char caracter = '0';
            File fichero = new File("texto.txt");
            br = new BufferedReader(new FileReader(fichero));
            String texto = "";
            //recogemos todo el texto, línea a línea con este bucle
            while ((linea = br.readLine()) != null) {
                texto = texto + linea + "\n";
            }
            char letra;
            int contador = 0;
            int posicion = 0;
            String posiciones = "";
            //se busca la primera vez que aparece
            posicion = texto.indexOf(c);
            while (posicion != -1) { //mientras se encuentre el caracter
                contador++;           //se cuenta
                //se sigue buscando a partir de la posición siguiente a la encontrada                                 
                posicion = texto.indexOf(c, posicion + 1);
                if (posicion != -1) {
                    posiciones = posiciones + " " + posicion;
                }
            }
            System.out.println("la letra " + c + " aparece " + contador + " veces en las posiciones: " + posiciones);
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no encontrado");
        } catch (IOException ex) {//io es error de entrada, salida
            System.out.println(ex.getMessage());;
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                System.out.println("error de E/S");
            }
        }
    }
}
