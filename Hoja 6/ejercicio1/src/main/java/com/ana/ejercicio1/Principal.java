package com.ana.ejercicio1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        Scanner teclado = new Scanner(System.in);
        /*Utilizando las clases de Java NIO.2 y la API Stream, muestra un listado encolumnado
con los datos de todos los futbolistas del fichero.*/
        Path ruta = Paths.get("futbolistas.csv");
//        Futbolista f1 = new Futbolista();
//        f1.setAltura(178f);
//        f1.setApellidos("Fernández");
//        f1.setNombre("Rocío");
//        f1.setPuesto(Puesto.PORTERO);
//        f1.setCodEquipo("MAD");
//        f1.setFechaNac(LocalDate.of(1983, Month.MARCH, 13));
//        f1.setId(01);
//        Futbolista f2 = new Futbolista(02, "Alberto", "Fernández", Puesto.CENTRAL, 18f, LocalDate.of(1984, Month.MARCH, 4), "MAD");
//        Futbolista f3 = new Futbolista(03, "Alberto", "Castro", Puesto.DEFENSA, 18f, LocalDate.of(1985, Month.APRIL, 4), "MAD");
//        Futbolista f4 = new Futbolista(04, "Rubén", "Martínez", Puesto.DEFENSA, 18f, LocalDate.of(1985, Month.APRIL, 4), "MAD");
//        List<Futbolista> listaFutbolistas = new ArrayList();
//        listaFutbolistas.add(f1);
//        listaFutbolistas.add(f2);
//        listaFutbolistas.add(f3);
//        listaFutbolistas.add(f4);
//        escribirFichero(ruta, listaFutbolistas);
        List<Futbolista> listaprueba = crearLista(ruta);
        for (Futbolista futbolista : listaprueba)
        {
            System.out.println(futbolista.toString());
        }
        System.out.println("MENÚ DE OPCIONES");
        System.out.println("1-Imprimir listado de futbolistas");
        System.out.println("2-");
        int opcion;
        opcion = teclado.nextInt();
        switch (opcion)
        {
            case 1:
                //imprimir el contenido del documento
                List<String> listaf = leerFutbolistas(ruta);
                for (String linea : listaf)

                {
                    System.out.println(linea);
                }

                break;
            case 2:
                /* Muestra un listado con el id, nombre, apellidos y posición de los futbolistas del equipo
cuyo código se hay introducido por teclado.*/
                System.out.println("Teclea código de equipo");
                String codigo = teclado.nextLine();
                List<Futbolista> listafu = listaEquipo(ruta, codigo);
                for (Futbolista futbolista : listafu)
                {
                    System.out.println(String.format("%10s|%20s|%30s ", futbolista.getNombre(), futbolista.getApellidos(), futbolista.getPuesto()));
                }

                break;
            case 3:
                /**
                 * Opción 3: Pide el alias de un futbolista por teclado y escribe en pantalla los
                 * datos de todos los futbolistas que tienen ese alias.
                 */
                System.out.println("Teclea alias de jugador");
                String alias = teclado.nextLine();

                Optional<Futbolista> futbolista = null;
                List<Futbolista> lista = new ArrayList();
                lista = crearLista(ruta);
                for (Futbolista fut : lista)
                {
                    if (fut.getNombre().equalsIgnoreCase(alias))
                    {
                        futbolista = fut;//tampoco sé castear esto
                        System.out.println(futbolista.toString());
                    }
                }
                break;
            case 4:
                /*
                  Opción 4: Pide por teclado el código de un equipo y crea un fichero de datos,
                  cuyo nombre es el código del equipo y la extensión es csv.
                 */
                System.out.println("introduce código de equipo");
                String cod = teclado.nextLine();
                String nombreDoc = cod + ".csv";
                //creo el documento
                Path doc = Paths.get(nombreDoc);
                if (Files.notExists(doc))
                {
                    System.out.println("La ruta no existe. El documento se creará");
                    try
                    {
                        Files.createFile(doc);
                    } catch (IOException e)
                    {
                        System.err.println("Error de E/S al crear el fichero");
                    }
                }
                //ahora hay que escribir en él los futbolistas de ese equipo
                //los recuperamos del documento en una lista de Futbolista
                List<Futbolista> listaxequipo = listaEquipo(ruta, cod);
                //escribir esta lista en el documento
                escribirFichero(doc, listaxequipo);

                break;
            case 5:
                /*Opción 6: Pide por teclado el identificador de un futbolista y, si existe, elimina al futbolista del
fichero.*/
                System.out.println("introduce identificador de futbolista");
                String identificador = teclado.nextLine();
                //lo busco en el documento
                List<Futbolista> listaId = new ArrayList();
                listaId = crearLista(ruta);
                for (Futbolista fu : listaId)
                {
                    if (String.valueOf(fu.getId()).equalsIgnoreCase(identificador))
                    {
                        try
                        {
                            //borramos el futbolista de la lista
                            listaId.remove(fu);
                            //borro el documento
                            Files.deleteIfExists(ruta);
                            //reescribo el documento a partir de la nueva lista
                            escribirFichero(ruta, listaId);
                        } catch (IOException ex)
                        {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                break;
        }
    }

    public static List<String> leerFutbolistas(Path ruta)
    {
        List<String> todasLineas = null;
        try
        {

            //cargo todas las líneas del fichero a una lista
            todasLineas = Files.readAllLines(ruta);

        } catch (IOException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todasLineas;
    }

    private static void escribirFichero(Path ruta, List<Futbolista> lista)
    {
        if (Files.notExists(ruta))
        {
            System.out.println("La ruta no existe");
            try
            {
                Files.createFile(ruta);
            } catch (IOException e)
            {
                System.err.println("Error de E/S al crear el fichero");
            }
        }
        BufferedWriter bw = null;
        try
        {
            //quiero escribir una lista de futbolistas en un fichero
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

    private static List<Futbolista> listaEquipo(Path ruta, String codigo)
    {
        List<Futbolista> listaFutbolistas = null;
        try
        {
            //ahora vamos a cargar esta lista con los datos del documento a través de un stream
            listaFutbolistas = Files.lines(ruta)//esto devuelve un stream
                    .map(l -> l.split(","))//dividimos cada String en un array de Strings (entre comas)
                    .map(futbolista -> new Futbolista(Integer.valueOf(futbolista[0]),//instancio un futbolista
                    futbolista[1], futbolista[2], Puesto.valueOf(futbolista[3]),
                    Float.parseFloat(futbolista[4]),//en el constructor le meto los valores, r
                    LocalDate.parse(futbolista[5]), futbolista[6]))
                    .filter(f -> f.getCodEquipo().equalsIgnoreCase(codigo))//filtro por código de equipo
                    .toList();              //lo paso a lista     

        } catch (IOException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFutbolistas;
    }

}
