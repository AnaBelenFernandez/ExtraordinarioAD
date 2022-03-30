/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Fichero {

    //con este método escribimos un objeto
    public static boolean EscribirProfesor(Profesor p) {
        boolean escrito = false;
        File f = new File("profesores.dat");
        ObjectOutputStream fo = null;
        try {
            if (f.exists()) {
                fo = new MiObjectOutputStream(new FileOutputStream(f, true));

            } else {
                fo = new ObjectOutputStream(new FileOutputStream(f,true));
            }

            fo.writeObject(p);
            escrito = true;

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
        return escrito;
    }

    public static boolean borrar() {
        boolean borrado = false;
        File f = new File("profesores.dat");
        if (f.delete()) {
            borrado = true;
        }

        return borrado;
    }

    public static ArrayList<Profesor> LeerFichero(String nombrefichero) {
        ArrayList<Profesor> listaProfesores = new ArrayList();
        File f = new File(nombrefichero);
        ObjectInputStream os = null;
        try {
            os = new ObjectInputStream(new FileInputStream(f));
            Profesor p;
            while (true) {
                  p = (Profesor) os.readObject();//Casting necesario 
                listaProfesores.add(p);
            }
        } catch (EOFException e) {
            System.out.println();
        } catch (ClassNotFoundException e) {
            System.out.println("Error el tipo de objeto no es compatible");
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo");
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar");
                }
            }
        }
        return listaProfesores;
    }
}
