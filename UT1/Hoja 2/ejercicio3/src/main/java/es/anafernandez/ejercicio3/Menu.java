/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Menu {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();
        int opcion = 0;
        int c;
        FileOutputStream fo = null;
        FileInputStream fi = null;
        do {
            try {
                System.out.println("teclea una opción");
                System.out.println("1- Crear fichero");
                System.out.println("2- Añadir número");
                System.out.println("3- Listar números");
                System.out.println("4- Listar números en hexadecimal");
                System.out.println("5- Buscar número");
                System.out.println("6- Salir");
                opcion = teclado.nextInt();
                File numeros = new File("numeros.dat");
                int aleatorio;
                switch (opcion) {
                    case 1:
                        if (numeros.createNewFile()) {
                            System.out.println("archivo creado");
                            //pintamos 10 números aleatorios en el archivo
                            fo = new FileOutputStream(numeros);
                            for (int j = 0; j < 10; j++) {

                                aleatorio = random.nextInt(255);
                                System.out.println(aleatorio);

                                String numString = String.valueOf(aleatorio);
                                for (int i = 0; i < numString.length(); i++) {
                                    char caracter = numString.charAt(i);
                                    fo.write(caracter);
                                }
                                fo.write(10);
                            }

                        } else {
                            System.out.println("el archivo no se ha creado");
                        }
                        break;
                    case 2:

                        fo = new FileOutputStream(numeros, true);
                        System.out.println("introduce un número entre 0 y 255");
                        int numero = teclado.nextInt();
                        String n = String.valueOf(numero);
                        for (int i = 0; i < n.length(); i++) {
                            char caracter = n.charAt(i);
                            fo.write(caracter);
                        }

                        break;
                    case 3:

                        //leer el documento
                        if (numeros.exists()) {
                            fi = new FileInputStream(numeros);
                            int allNumber = fi.available();
                            System.out.println(allNumber);
                            byte[] bytes = new byte[allNumber];
                            int number = fi.read(bytes);
                            System.out.println(new String(bytes));

                        } else {
                            System.out.println("el archivo no existe");
                        }

                        break;
                    case 4:
                        String hexa;
                        int numer;
                        if (numeros.exists()) {

                            fi = new FileInputStream(numeros);
                            int todosNumeros = fi.available();
                            byte[] digitos = new byte[todosNumeros];
                            while (fi.available() > 0) {
                                numer = fi.read();
                                hexa = Integer.toHexString(numer);
                                System.out.println(hexa);
                            }
                        }
                        break;
                    case 5:
                        System.out.println("introduzca un número para buscar");
                        int buscar = teclado.nextInt();
                        int contador = 0;
                        fi = new FileInputStream(numeros);
                        int todosNumeros = fi.available();
                        byte[] digitos = new byte[todosNumeros];
                        for (int i = 0; i < digitos.length; i++) {
                            numer = digitos[i];
                            System.out.println(numer);
                            contador++;
                            if (numer == buscar) {
                                System.out.println("El número ya existe: " + numer + "en la posición" + contador);
                            }
                        }
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (opcion != 6);
    }

}
