/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.leerdirectorio;

import java.io.File;

/**
 *
 * @author DELL
 */
public class Principal {

    public static void main(String[] args) {

        File directorio = new File(".");
        String[] archivos = directorio.list();
        //nombres de los ficheros
        System.out.println("----lista de nombres----");
        for (int i = 0; i < archivos.length; i++) {
            System.out.println(archivos[i]);
        }
//lista de ficheros
System.out.println("---lista de ficheros a la que extraemos el nombre----");
        File[] listaFicheros = directorio.listFiles();
        for (int i = 0; i < listaFicheros.length; i++) {
            System.out.println(listaFicheros[i].getName());

        }
    }
}
