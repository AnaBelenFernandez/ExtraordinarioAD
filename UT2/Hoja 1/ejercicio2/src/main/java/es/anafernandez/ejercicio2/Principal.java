/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.w3c.dom.Document;

/**
 *
 * @author DELL
 */
public class Principal {
     public static void main(String[] args) {
         
         Scanner teclado=new Scanner (System.in);
         GestorDoc gestor=new GestorDoc();
         Document documento=gestor.crearDocumento();
         List<Futbolista> futbolistas=new ArrayList();
         Futbolista f1=new Futbolista(Short.valueOf("1"), "Limao",Byte.valueOf("1"), 1.70f, "BCN");
         Futbolista f2=new Futbolista(Short.valueOf("2"), "Cáncano",Byte.valueOf("2"), 1.70f, "BCN");
         futbolistas.add(f1);
         futbolistas.add(f2);
         int opcion=10;
         do{
         System.out.println("ELIGE OPCIÓN");
         System.out.println("1- Listar Futbolistas");
         System.out.println("2- Añadir Futbolista");
         System.out.println("3- Consultar futbolista por equipo");
         System.out.println("4- Modificar Equipo de futbolista");
         System.out.println("5- Modificar Altura de futbolista");
         System.out.println("6- Eliminar Futbolista");
         System.out.println("7- Grabar en fichero");
             System.out.println("0- Salir");
         opcion=teclado.nextInt();
         switch(opcion){
             case 1:
                 System.out.println(gestor.ListarFutbolistas(documento));
                 break;
             case 2:         
                          for(Futbolista f: futbolistas){
                        gestor.insertarFutbolista(f, documento);
             }
                 break;
             case 3:
                 //buscar futbolistas de un equipo
                 List<Futbolista> equipo=gestor.getFutbolistasEquipo("BCN", documento);
                 for (Futbolista f : equipo) {
                     System.out.println(f.toString());                     
                 }
                 break;
             case 4:
                 //modificar equipo de un futbolista
                 System.out.println(gestor.cambiarEquipoFutbolista(Short.valueOf("2"), documento, "MAD"));
               
                
                 break;
             case 5:
                 //cambiar altura futbolista
                 System.out.println(gestor.cambiarAlturaFutbolista(Short.valueOf("1"), documento, 1.90f));
                 break;
             case 7:
                 gestor.convertirenXML(documento);
                 break;
         
         
         }
     
     }while(opcion!=0);
     }
}
