/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Principal {

    public static void main(String[] args) {
        // TODO code application logic here
        /*La consejería de educación quiere tener almacenados todos los profesores que imparten clase en
Cantabria.
Así pues, tendremos una aplicación con una clase Profesor en el que se almacene su
numeroRegistro, nombre y fechaIngreso (LocalDate).
Además, cada profesor tendrá asignado un Instituto (del que habrá que gestionar su nombre,
fechaConstruccion (LocalDate) y localidad).
La aplicación utilizará un fichero serializado llamado profesores.dat en el que se almacenen los
datos oportunos.
Se pide un programa que permita:
         */
        ArrayList<Instituto> listaInstitutos = new ArrayList();
        Instituto Cazoña = new Instituto("IES Leonardo Torres Quevedo", LocalDate.of(1975, Month.MARCH, 23), "Cazonia");
        Instituto SantaClara = new Instituto("IES Santa Clara", LocalDate.of(2004, Month.MARCH, 1), "Santander");
        Instituto MiguelHerrero = new Instituto("IES Miguel Herrero", LocalDate.of(1980, Month.MARCH, 15), "Torrelavega");
        listaInstitutos.add(Cazoña);
        listaInstitutos.add(SantaClara);
        listaInstitutos.add(MiguelHerrero);
        Profesor profePrueba = new Profesor(01, "Alberto", LocalDate.now(), Cazoña);
        Profesor profePrueba1 = new Profesor(02, "Ruben", LocalDate.of(2020, 05, 02), SantaClara);
        Profesor profePrueba2 = new Profesor(03, "Juan", LocalDate.of(2015, 06, 02), MiguelHerrero);
        Profesor ana = new Profesor(04, "Ana", LocalDate.of(2000, 05, 02), SantaClara);
        ArrayList<Profesor> listaProfes = new ArrayList();
        listaProfes.add(profePrueba);
        listaProfes.add(profePrueba1);
        listaProfes.add(profePrueba2);
        listaProfes.add(ana);

        Cazoña.añadirProfesor(profePrueba);
        SantaClara.añadirProfesor(profePrueba1);
        MiguelHerrero.añadirProfesor(profePrueba2);
        Scanner teclado = new Scanner(System.in);
        for (Instituto i : listaInstitutos) {
            System.out.println(i.toString());

        }
        int opcion;

        System.out.println("MENU DE OPCIONES");
        System.out.println("1-Añadir profesor");
        System.out.println("2- leer fichero");
        System.out.println("3- profesores por localidad");
        System.out.println("4- Profesores del instituto más antiguo");
        System.out.println("5- Traslado");
        System.out.println("6- Modificar datos de futbolista");
        System.out.println("7- Eliminar futbolista");
        System.out.println("0- Salir");
        opcion = teclado.nextInt();
        teclado.nextLine();
        switch (opcion) {
            case 1:
                Fichero.borrar();
                for (Profesor p : listaProfes) {

                    if (Fichero.EscribirProfesor(p)) {
                        System.out.println("profesor añadido correctamente");
                    } else {
                        System.out.println("no se pudo inscribir al profesor");
                    }
                }
                break;
            case 2:
                ArrayList<Profesor> listaPofes = Fichero.LeerFichero("profesores.dat");
                for (Profesor p : listaPofes) {
                    System.out.println(p.toString());
                }
                break;
            case 3:
                /*2. Listado de profesores de una localidad: Nos muestre los profesores que impartan clase en una
localidad. Para ello debemos pasarle el nombre de la localidad como parámetro. El resultado a
mostrar sería el nombre del profesor, seguido del nombre del instituto y, por último, los meses que
lleva impartiendo clase*/
                String nombreInstituto = "";
                ArrayList<Profesor> profes = Fichero.LeerFichero("profesores.dat");
                boolean encontrado = false;
                System.out.println("introduzca localidad");
                String localidad = teclado.nextLine();
                System.out.println("la localidad buscada es -->" + localidad);
                for (Instituto i : listaInstitutos) {
                    if (i.getLocalidad().equalsIgnoreCase(localidad)) {
                        nombreInstituto = i.getNombre();
                        //sabemos que tenemos ese instituto en  nuestro documento, vamos a buscar los profesores en el arraylist
                        encontrado = true;
                        for (Profesor p : profes) {
                            if (p.getInstituto().getNombre().equalsIgnoreCase(nombreInstituto)) {
                                System.out.println(p.toString());
                            }

                        }
                    }
                }
                if (encontrado == false) {
                    System.out.println("no se ha encontrado ningún instituto en esa localidad");
                }

                break;
            case 4:
                /*Escriba el nombre de los profesores del instituto más antiguo*/
                String nombreIns = "";
                ArrayList<Profesor> ps = Fichero.LeerFichero("profesores.dat");
                Instituto masAntiguo = null;
                Period antiguedad = Period.between(LocalDate.now(), LocalDate.now());
                //sacamos el instituto más antiguo de la lista de institutos
                for (Instituto i : listaInstitutos) {
                    Period an = Period.between(i.getFechaConstruccion(), LocalDate.now());
                    if (an.getDays() > antiguedad.getDays()) {
                        antiguedad = an;
                        nombreIns = i.getNombre();
                    }

                }
                System.out.println("El instituto + antiguo es: " + nombreIns);
                //ahora vamos a recorrer el arraylist de profesores para buscar cuáles son de este instituto
                //almacenamos los nombres en un String
                String nombres = "";
                for (Profesor p : ps) {
                    if (p.getInstituto().getNombre().equalsIgnoreCase(nombreIns)) {
                        nombres = nombres + p.getNombre() + "\n";
                    }
                }
                System.out.println("los profesores de ese instituto son:\n" + nombres);
                break;
            case 5:
                /*. Traslado del profesor. Se deberá indicar el número de registro del profesor 
                y el nuevo instituto y deberá modificarlo en el fichero. 
                Para simplificar el ejercicio sólo se deberá modificar el nombre del instituto*/
                System.out.println("introduce número de identificación del profesor");
                int numeroProfe = teclado.nextInt();
                System.out.println("introduce nuevo instituto");
                String nuevo = teclado.nextLine();
                teclado.nextLine();
                ArrayList<Profesor> pros = Fichero.LeerFichero("profesores.dat");
                for (Instituto i : listaInstitutos) {
                    if (i.getNombre().equalsIgnoreCase(nuevo)) {
                        for (Profesor p : pros) {
                            if (p.getNumRegistro() == numeroProfe) {
                                p.setInstituto(i);
                                System.out.println("profesor modificado: " + p.toString());
                            }
                        }
                    }
                }
                //ahora hay que guardar los cambios en el fichero
                //lo que quiero hacer es borrar completamente el fichero y reescribirlo entero
                //proceso de borrado
                if (Fichero.borrar()) {
                    System.out.println("fichero borrado");
                }
                //reescribimos toda la lista de profesores en el fichero
                for (Profesor p : pros) {

                    if (Fichero.EscribirProfesor(p)) {
                        System.out.println("profesor añadido correctamente");
                    } else {
                        System.out.println("no se pudo inscribir al profesor");
                    }
                }
                break;
            case 6:
                
                /*Destruir instituto. Se deberán borrar del fichero todos los profesores que pertenecen al instituto
recibido (se deberá indicar el nombre). El método deberá devolver una lista con los nombres de los
profesores borrados y a continuación se deberá mostrar.*/
                System.out.println("indicar nombre de instituto");
                String ins=teclado.nextLine();
                ArrayList<Profesor> profs = Fichero.LeerFichero("profesores.dat");   
                String listaBorrados="";
           for (Profesor p : profs) {
                            if(p.getInstituto().getNombre().equalsIgnoreCase(ins)){
                                profs.remove(p);
                                listaBorrados=listaBorrados +"\n";
                                System.out.println("lista de profesores borrados: "+listaBorrados);
                            
                        }}
                          for (Instituto i : listaInstitutos) {
                              if(i.getNombre().equalsIgnoreCase(ins)){
                                  System.out.println(i.toString());}
                            
                    }
                            if (Fichero.borrar()) {
                    System.out.println("fichero borrado");
                }
                //reescribimos toda la lista de profesores en el fichero
                for (Profesor p : profs) {

                    if (Fichero.EscribirProfesor(p)) {
                        System.out.println("profesor añadido correctamente");
                    } else {
                        System.out.println("no se pudo inscribir al profesor");
                    }
                }
                    
                
                break;
        }

    }
}
