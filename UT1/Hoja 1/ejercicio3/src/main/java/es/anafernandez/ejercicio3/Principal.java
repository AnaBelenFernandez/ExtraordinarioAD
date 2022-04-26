/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio3;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Principal {

    public static void main(String[] args) {
        //crear un nuevo directorio
        //le asigno un nombre
        String nombreDirectorio = "nuevoDir";
        //instancio el file con la ruta
        File nuevo = new File(nombreDirectorio);
        //creo el directorio
        Boolean creado = nuevo.mkdir();
        if (creado) {
            try {
                System.out.println("directorio creado");
                //crear dos ficheros en su interior
                //usamos el constructor que recibe dos argumentos, la carpeta y el nombre de archivo
                File fichero1 = new File(nombreDirectorio,"fichero1.txt");
                fichero1.createNewFile();
                File fichero2 = new File(nombreDirectorio,"fichero2.txt");
                fichero2.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("El directorio no se ha creado");
        }
    }

}
