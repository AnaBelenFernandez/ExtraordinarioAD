/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Moon {

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("introduce la ruta y nombre");
        String ruta = teclado.nextLine();
        FileInputStream fi = null;
        int c;
        try {
            fi = new FileInputStream(ruta);
            while (fi.available() > 0) {
                c = fi.read();
                //le decimos que no muestre los espacios en blanco
                if (c != 32) {
                    //en el print convertimos el int a caracteres ascii
                    System.out.print(Character.toString(c));                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
