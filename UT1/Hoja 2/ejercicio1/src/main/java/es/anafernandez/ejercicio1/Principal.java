/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Principal {

    public static void main(String[] args) {
        //leer byte a byte
        int c;
        //instanciamos flujos
        //stream de entrada:recibe un string con el nombre del fichero
        FileInputStream f = null;
        //stream de salida:recibe un string con el nombre del fichero
        FileOutputStream fo = null;
        try {
            //inicializamos streams
            f = new FileInputStream("entrada.txt");
            fo = new FileOutputStream("salida.txt");
            //bucle de lectura/escritura
            while (f.available() > 0) {
                //lectura
                c = f.read();
                //en el print convertimos el int a caracteres ascii
                System.out.print(Character.toString(c));
                //lo volvemos a convertir para guardarlo en un String
                String letra = Character.toString(c);
                // de String a Char
                char caracter = letra.charAt(0);
                //escribimos el char en el stream de escritura
                fo.write(caracter);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
                fo.close();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
