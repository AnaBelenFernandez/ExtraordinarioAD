/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio1;

import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Principal {
      public static void main(String[] args) {

             Scanner teclado=new Scanner (System.in);

             int opcion;
             System.out.println("MENU DE OPCIONES");
             System.out.println("1-Listado de futbolistas");
             System.out.println("2- Listado de futbolistas de equipo");
             System.out.println("3- Buscar futbolista");
             System.out.println("4- Crear fichero de equipo");
           System.out.println("5-Listar fichero de equipo");
           System.out.println("6- Mostrar todos los ficheros");
           System.out.println("0- Salir");            
           
             opcion = teclado.nextInt();
             teclado.nextLine();
             switch (opcion) {}
    
}}
