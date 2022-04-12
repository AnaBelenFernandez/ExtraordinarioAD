/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Principal
{

    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        FileOutputStream fos = null;
        File fichero = new File("futbolistas.dat");

        //creo la lista de Futbolistas
        List<Futbolista> futbolistas = new ArrayList<>();
        int numero;
        byte posicion = 1;
        String alias = "";
        Float altura;
        String equipo = "";
        Futbolista f1 = new Futbolista(1, "ronaldinho", posicion, 1.8f, "MAD");
        Futbolista f2 = new Futbolista(2, "Cascarita", posicion, 1.8f, "BCN");
        Futbolista f3 = new Futbolista(3, "Zidanne", posicion, 1.9f, "MAD");
        futbolistas.add(f1);
        futbolistas.add(f2);
        futbolistas.add(f3);
        int opcion = 8;
        /*1 Añadir futbolista
2 Listar futbolistas
3 Listar futbolistas de equipo
4 Buscar futbolista
5 Modificar equipo de futbolista
6 Modificar datos de futbolista
7 Eliminar futbolista
0 Salir*/
        System.out.println("TECLEA UNA OPCION");
        System.out.println("1-Listar Futbolistas");
        System.out.println("2- Listar futbolistas de equipo");
        System.out.println("3- Buscar futbolista");
        System.out.println("4- Añadir futbolista");
        System.out.println("5- Modificar equipo de futbolista");
        System.out.println("6- Modificar datos de futbolista");
        System.out.println("7- Eliminar futbolista");
        opcion = teclado.nextInt();
        switch (opcion)
        {
            case 1:
               try
                {
                    FileInputStream fis = new FileInputStream(fichero);
                    DataInputStream lector = new DataInputStream(fis);
                    while (true)
                    {
                        numero = lector.readInt();
                        alias = lector.readUTF();
                        posicion = lector.readByte();
                        altura = lector.readFloat();
                        equipo = lector.readUTF();
                        Futbolista futbolista = new Futbolista(numero, alias, posicion, altura, equipo);
                        System.out.println(futbolista.toString());
                        futbolistas.add(futbolista);
                    }

            } catch (FileNotFoundException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case 2:
                buscarxEquipo("MAD", fichero);
                break;
            case 3:
                buscarFutbolista(2, fichero);
                break;
            case 4:
                     try
                {
                    fos = new FileOutputStream(fichero);
                    DataOutputStream escritor = new DataOutputStream(fos);
                    for (Futbolista f : futbolistas)
                    {
                        escritor.writeShort(f.getNumero());
                        escritor.writeUTF(f.getAlias());
                        escritor.writeByte(f.getPosicion());
                        escritor.writeFloat(f.getAltura());
                        escritor.writeUTF(f.getEquipo());

                    }
            } catch (IOException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);

            }
            break;
            case 5:
                //buscamos el futbolista
                Futbolista f = buscarFutbolista(2, fichero);
                //ahora modificamos el futbolista
                int dorsal = f.getNumero();
                modificarEquipo(dorsal, fichero, "BCN");

                break;
        }
    }

    public static void modificarEquipo(int dorsal, File fichero, String equipoNuevo)
    {
        Futbolista f = null;
        File nuevoFichero = new File("copiafutbolistas.dat");
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(fichero);
            DataInputStream lector = new DataInputStream(fis);
            while (true)
            {
                int numero = lector.readInt();
                String alias = lector.readUTF();
                byte posicion = lector.readByte();
                float altura = lector.readFloat();
                String equipo = lector.readUTF();
                f = new Futbolista(numero, alias, posicion, altura, equipo);
                FileOutputStream fos = new FileOutputStream(nuevoFichero);
                DataOutputStream escritor = new DataOutputStream(fos);
                escritor.writeInt(f.getNumero());
                escritor.writeUTF(f.getAlias());
                escritor.writeByte(f.getPosicion());
                escritor.writeFloat(f.getAltura());
                escritor.writeUTF(f.getEquipo());

                if (numero == dorsal)
                {
                    f.setEquipo(equipoNuevo);
                    escritor.writeInt(f.getNumero());
                    escritor.writeUTF(f.getAlias());
                    escritor.writeByte(f.getPosicion());
                    escritor.writeFloat(f.getAltura());
                    escritor.writeUTF(f.getEquipo());

                }

            }
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(Principal.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex)
        {
            Logger.getLogger(Principal.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                fis.close();

            } catch (IOException ex)
            {
                Logger.getLogger(Principal.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void buscarxEquipo(String equipoBuscado, File fichero)
    {
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(fichero);
            DataInputStream lector = new DataInputStream(fis);
            while (true)
            {
                int numero = lector.readInt();
                String alias = lector.readUTF();
                byte posicion = lector.readByte();
                float altura = lector.readFloat();
                String equipo = lector.readUTF();
                Futbolista futbolista = new Futbolista(numero, alias, posicion, altura, equipo);
                if (equipo.equalsIgnoreCase(equipoBuscado))
                {
                    System.out.println(futbolista.toString());

                }

            }
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                fis.close();
            } catch (IOException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Futbolista buscarFutbolista(int identificador, File fichero)
    {
        Futbolista futbolista = null;

        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(fichero);
            DataInputStream lector = new DataInputStream(fis);
            while (true)
            {
                int numero = lector.readInt();
                String alias = lector.readUTF();
                byte posicion = lector.readByte();
                float altura = lector.readFloat();
                String equipo = lector.readUTF();
                futbolista = new Futbolista(numero, alias, posicion, altura, equipo);
                if (numero == identificador)
                {
                    System.out.println(futbolista.toString());

                }

            }
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(Principal.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex)
        {
            Logger.getLogger(Principal.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                fis.close();

            } catch (IOException ex)
            {
                Logger.getLogger(Principal.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return futbolista;
    }

}
