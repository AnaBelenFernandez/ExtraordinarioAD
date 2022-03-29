package com.ana.ejercicio2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Principal
{
    public static void main(String[] args)
    {
        try
        {
            Scanner teclado = new Scanner(System.in);
            Path ruta = Paths.get("futbolistas.csv");
            System.out.println("MENÚ DE OPCIONES");

            System.out.println("1-Listar futbolista");
            System.out.println("2-Añadir futbolista");
            System.out.println("3- Listar futbolistas por puesto");
            System.out.println("4-Obtener el futbolista más alto");
            System.out.println("5- Modificar puesto de futbolista");
            System.out.println("6-Eliminar futbolista");
            System.out.println("0- Salir");
            int opcion;
            opcion = teclado.nextInt();
            switch (opcion)
            {
                case 1:
                    /*Opción 1: Muestra en pantalla los datos de todos los futbolistas que hay en el fichero*/
                    List<Futbolista> todos = crearLista(ruta);
                    for (Futbolista f : todos)
                    {
                        System.out.println(f.toString());
                    }

                    break;
                case 2:
                    /*Opción 2: Pide por teclado los datos de un futbolista y lo añade al fichero. No hay que comprobar si
ese futbolista está ya cargado.*/
                    //recojo los datos y creo el objeto
                    System.out.println("introduce código");
                    int codigo = teclado.nextInt();
                    System.out.println("nombre");
                    String nombre = teclado.nextLine();
                    System.out.println("apellidos");
                    String apellidos = teclado.nextLine();
                    System.out.println("Puesto 1-Portero, 2-Delantero,3-CentroCampista 4-Defensa");
                    int puesto = teclado.nextInt();
                    System.out.println("altura");
                    float altura = teclado.nextFloat();
                    System.out.println("año");
                    int anio = teclado.nextInt();
                    System.out.println("mes");
                    int mes = teclado.nextInt();
                    System.out.println("dia");
                    int dia = teclado.nextInt();
                    System.out.println("código de equipo");
                    String cod = teclado.nextLine();
                    Futbolista futbolista = new Futbolista();
                    futbolista.setId(codigo);
                    futbolista.setNombre(nombre);
                    futbolista.setApellidos(apellidos);
                    switch (puesto)
                    {
                        case 1:
                            futbolista.setPuesto(Puesto.PORTERO);
                            break;
                        case 2:
                            futbolista.setPuesto(Puesto.DELANTERO);
                            break;
                        case 3:
                            futbolista.setPuesto(Puesto.CENTRAL);
                            break;
                        case 4:
                            futbolista.setPuesto(Puesto.DEFENSA);
                            break;
                    }
                    futbolista.setFechaNac(LocalDate.of(anio, mes, dia));
                    futbolista.setCodEquipo(cod);
                    //recojo la lista de futbolistas y le añado éste otro
                    List<Futbolista> todosFut = crearLista(ruta);
                    todosFut.add(futbolista);
                    //borro el documento
                    Files.deleteIfExists(ruta);
                    //creo un nuevo documento con la ruta completa
                    escribirFichero(ruta, todosFut);
                    break;
                case 3:
                    /*Opción 3: Pide por teclado el número de puesto de futbolista y escribe en pantalla todos los
futbolistas que juegan en ese puesto.*/
                    System.out.println("Escribe el número de puesto del futbolista \n 1-Portero, 2-Delantero,3-CentroCampista 4-Defensa");
                    int numPuesto = teclado.nextInt();
                    //asigno el puesto
                    Puesto p = Puesto.CENTRAL;
                    switch (numPuesto)
                    {
                        case 1:
                            p = Puesto.PORTERO;
                            break;
                        case 2:
                            p = Puesto.DELANTERO;
                            break;
                        case 3:
                            p = Puesto.CENTRAL;
                            break;
                        case 4:
                            p = Puesto.DEFENSA;
                            break;
                    }
                    //nos traemos la lista 
                    List<Futbolista> futs = crearLista(ruta);
                    //la recorremos e imprimimos los que jueguen en ese puesto
                    for (Futbolista fut : futs)
                    {
                        if (fut.getPuesto().equals(p))
                        {
                            System.out.println(fut.toString());
                        }
                    }
                    break;
                case 4:
                    /*Opción 4: Muestra el futbolista cuya altura sea la mayor*/
                    //nos traemos la lista 
                    List<Futbolista> lista4 = crearLista(ruta);
                    //creo un futbolista de altura cero en el que se irán cargando los más altos
                    Futbolista masAlto = new Futbolista();
                    masAlto.setAltura(0);
                    //si el futbolista es más alto, se mete a esa variable
                    for (Futbolista f : lista4)
                    {
                        if (f.getAltura() > masAlto.getAltura())
                        {
                            masAlto = f;
                        }
                    }
                    System.out.println(masAlto.toString());
                    break;
                case 5:
                    /*Pide por teclado el identificador de un futbolista y, si existe, se modifica su puesto con el
que se introduzca por teclado.*/
                    System.out.println("introduce identificador");
                    int identificador = teclado.nextInt();
                    System.out.println("introduce nuevo puesto \n 1-Portero, 2-Delantero,3-CentroCampista 4-Defensa");
                    int nuevoPuesto = teclado.nextInt();
                    teclado.nextLine();
                    //nos traemos la lista 
                    List<Futbolista> lista5 = crearLista(ruta);
                    //la recorremos buscando el id
                    for (Futbolista f : lista5)
                    {
                        if (f.getId() == identificador)
                        {
                            switch (nuevoPuesto)
                            {
                                case 1:
                                    f.setPuesto(Puesto.PORTERO);
                                    break;
                                case 2:
                                    f.setPuesto(Puesto.DELANTERO);
                                    break;
                                case 3:
                                    f.setPuesto(Puesto.CENTRAL);
                                    break;
                                case 4:
                                    f.setPuesto(Puesto.DEFENSA);
                                    break;
                            }
                            System.out.println("futbolista modificado");
                            System.out.println(f.toString());
                            //ahora habría que modificar el documento
                            //borro el documento
                            Files.deleteIfExists(ruta);
                            //reescribo el documento a partir de la nueva lista
                            escribirFichero(ruta, lista5);
                        }
                    }

                    break;
                case 6:
                    /*Opción 6: Pide por teclado el identificador de un futbolista y, si existe, elimina al futbolista del
                    fichero.*/
                    System.out.println("introduce identificador de futbolista");
                    int ide = teclado.nextInt();
                    //lo busco en el documento
                    //nos traemos la lista 
                    List<Futbolista> lista6 = crearLista(ruta);
                    //lo busco en la lista
                    for (Futbolista fu : lista6)
                        if (fu.getId() == ide)
                        {
                            if (lista6.remove(fu))
                            {
                                System.out.println("futbolista eliminado");
                            } else
                            {
                                System.out.println("no se ha podido borrar el futbolista");
                            }
                        } else
                        {
                            System.out.println("no existe ningún futbolista con ese id");
                        }
                    //borramos el futbolista de la lista
                    //borro el documento
                    Files.deleteIfExists(ruta);
                    //reescribo el documento a partir de la nueva lista
                    escribirFichero(ruta, lista6);
                    break;
            }
        } catch (IOException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static List<Futbolista> crearLista(Path ruta)
    {
        List<Futbolista> listaFutbolistas = null;
        try
        {

            //ahora vamos a cargar esta lista con los datos del documento a través de un stream
            listaFutbolistas = Files.lines(ruta)//esto devuelve un stream
                    .map(l -> l.split(","))//dividimos cada String en un array de Strings (entre comas)
                    .map(futbolista -> new Futbolista(Integer.valueOf(futbolista[0]),//instancio un futbolista
                    futbolista[1], futbolista[2], Puesto.valueOf(futbolista[3]),
                    Float.parseFloat(futbolista[4]),//en el constructor le meto los valores, aquí se podría hacer un filter
                    LocalDate.parse(futbolista[5]), futbolista[6])).toList();              //lo paso a lista     

        } catch (IOException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFutbolistas;
    }

    private static void escribirFichero(Path ruta, List<Futbolista> lista)
    {
        if (Files.notExists(ruta))
        {
            try
            {
                Files.createFile(ruta);
                System.out.println("archivo creado correctamente");
            } catch (IOException e)
            {
                System.err.println("Error de E/S al crear el fichero");
            }
        }
        BufferedWriter bw = null;
        try
        {            //quiero escribir una lista de futbolistas en un fichero
            String listaCSV = "";
            for (Futbolista futbolista : lista)
            {
                listaCSV = listaCSV + futbolista.toCSV() + "\n";
            }
            bw = Files.newBufferedWriter(ruta);
            bw.write(listaCSV);
            bw.close();
        } catch (IOException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                bw.close();
            } catch (IOException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
