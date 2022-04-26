package com.ana.ejercicio2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author usuario
 */
public class Principal {
    public static void main(String[] args)
    {
        //leer un fichero de texto y quitarle los espacios
        String ruta = "poesia.txt";
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
