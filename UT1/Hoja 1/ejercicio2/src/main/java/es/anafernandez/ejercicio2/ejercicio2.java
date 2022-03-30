/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio2;

import java.io.File;

/**
 *
 * @author DELL
 */
public class ejercicio2 {
     public static void main(String[] args) {

    File fichero=new File("lobo");
         System.out.println(fichero.getName());
         System.out.println(fichero.getAbsolutePath());
         System.out.println(fichero.canRead());
         System.out.println(fichero.canWrite());
   
     }
}
