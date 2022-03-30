/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Principal {
     public static void main(String[] args) {
         ObjectInputStream os=null;
         try {
             Scanner teclado=new Scanner (System.in);
             Equipo e=new Equipo();
             e.setNumAlumnos(2);
             e.setPuntos(0);
             int opcion;
             System.out.println("MENU DE OPCIONES");
             System.out.println("1-Añadir equipo");
             System.out.println("2- Añadir alumnos");
             System.out.println("3- Leer fichero");
             System.out.println("4- Salir");
             opcion = teclado.nextInt();
             teclado.nextLine();
             switch (opcion) {
                 case 1:
                     File fichero = new File("concurso.dat");
                     ObjectOutputStream fo = null;
                     try {
                         if (fichero.exists()) {
                             fo = new MiObjectOutputStream(new FileOutputStream(fichero, true));
                             
                         } else {
                             fo = new ObjectOutputStream(new FileOutputStream(fichero, true));
                         }
                         fo.writeObject(e);
                     } catch (IOException ex) {
                         System.err.println(ex.toString());
                     } finally {
                         if (fo != null) {
                             try {
                                 fo.close();
                             } catch (IOException ex) {
                                 System.out.println("Error de lectura");
                             }
                         }
                     }
                     break;
                 case 2:
                     break;
                 case 3:
                     /*leer fichero*/
                     File f = new File("concurso.dat");
                     ObjectInputStream ois =null;
                     try{
                     new ObjectInputStream(new FileInputStream(f));
                    
                     while (true) {
                       Equipo equipo=(Equipo)ois.readObject();
                              System.out.println(equipo.toString());
                     }  
       } catch (FileNotFoundException ex) {
             Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
         }       catch (ClassNotFoundException ex) {
                     Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                 }
                     break;

     }
         }}}




