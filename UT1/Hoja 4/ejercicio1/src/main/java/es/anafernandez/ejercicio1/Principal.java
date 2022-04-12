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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Principal {

    public static void main(String[] args) {
        FileOutputStream fos = null;
        File fichero = new File("futbolistas.dat");
        try {

            //creo la lista de Futbolistas
            List<Futbolista> futbolistas = new ArrayList<>();
            short numero = 1;
            short num=2;
            byte posicion = 1;
            String alias = "";
            Float altura;
            String equipo = "";
            Futbolista f1 = new Futbolista(numero, "ronaldinho", posicion, 1.8f, "MAD");
            Futbolista f2 = new Futbolista(num, "Cascarita", posicion, 1.8f, "BCN");
            Futbolista f3 = new Futbolista(num, "Zidanne", posicion, 1.9f, "MAD");
            futbolistas.add(f1);
            futbolistas.add(f2);
            futbolistas.add(f3);
            //añadir futbolistas al fichero
            fos = new FileOutputStream(fichero);
            DataOutputStream escritor = new DataOutputStream(fos);
            for (Futbolista f : futbolistas) {
                escritor.writeShort(f.getNumero());
                escritor.writeUTF(f.getAlias());
                escritor.writeByte(f.getPosicion());
                escritor.writeFloat(f.getAltura());
                escritor.writeUTF(f.getEquipo());

            }
            //buscarfutbolista
            buscarFutbolista(numero,fichero);
            //listar futbolistas de equipo
            buscarxEquipo("MAD", fichero);
            //listar futbolistas
            FileInputStream fis = new FileInputStream(fichero);
            DataInputStream lector = new DataInputStream(fis);
            while (true) {
                numero = lector.readShort();
                alias = lector.readUTF();
                posicion = lector.readByte();
                altura = lector.readFloat();
                equipo = lector.readUTF();
                Futbolista futbolista = new Futbolista(numero, alias, posicion, altura, equipo);
                System.out.println(futbolista.toString());
                futbolistas.add(futbolista);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void buscarxEquipo(String equipoBuscado, File fichero) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fichero);
            DataInputStream lector = new DataInputStream(fis);
            while (true) {
                short numero = lector.readShort();
                String alias = lector.readUTF();
                byte posicion = lector.readByte();
                float altura = lector.readFloat();
                String equipo = lector.readUTF();
                Futbolista futbolista = new Futbolista(numero, alias, posicion, altura, equipo);
                if (equipo.equalsIgnoreCase(equipoBuscado)) {
                    System.out.println(futbolista.toString());
                
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      public static void buscarFutbolista(short identificador, File fichero) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fichero);
            DataInputStream lector = new DataInputStream(fis);
            while (true) {
                short numero = lector.readShort();
                String alias = lector.readUTF();
                byte posicion = lector.readByte();
                float altura = lector.readFloat();
                String equipo = lector.readUTF();
                Futbolista futbolista = new Futbolista(numero, alias, posicion, altura, equipo);
                if (Short.compare(numero, identificador)==0) {
                    System.out.println(futbolista.toString());
                } 

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
