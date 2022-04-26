package com.ana.ejercicio3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Principal
{
    public static void main(String[] args) throws IOException
    {

        Scanner teclado = new Scanner(System.in);
        Random random = new Random();
        int opcion = 0;
        int c;
        FileOutputStream fos = null;
        FileInputStream fis = null;
        do
        {
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
            switch (opcion)
            {
                case 1:
                    //crear un fichero con 10 números aleatorios
                    if (!numeros.exists())
                    {
                        numeros.createNewFile();
                    }
                    fos = new FileOutputStream(numeros);
                    fis = new FileInputStream(numeros);
                    for (int i = 0; i <= 10; i++)
                    {
                        {
                            aleatorio = random.nextInt(255);
                            String numString = String.valueOf(aleatorio);
                            for (int j = 0; j < numString.length(); j++)
                            {
                                char caracter = numString.charAt(j);
                                fos.write(caracter);
                            }
                            fos.write(10);
                        }
                    }
                    //leer para comprobar que ha añadido los números aleatorios
                    while (fis.available() > 0)
                    {
                        c = fis.read();
                        //en el print convertimos el int a caracteres ascii
                        System.out.print(Character.toString(c));
                    }
                    fis.close();
                    break;
                case 2:
                    //añadir un número
                    aleatorio = random.nextInt(255);
                    fos = new FileOutputStream(numeros, true);
                    String numString = String.valueOf(aleatorio);
                    for (int j = 0; j < numString.length(); j++)
                    {
                        char caracter = numString.charAt(j);
                        fos.write(caracter);
                    }
                    fos.write(10);

                    break;
                case 3:
                    fis = new FileInputStream(numeros);
                    while (fis.available() > 0)
                    {
                        c = fis.read();
                        //en el print convertimos el int a caracteres ascii
                        System.out.print(Character.toString(c));
                    }
                    fis.close();
                    break;
                case 4:
                    //comprobar si existe el fichero
                    if (numeros.exists())
                    {
                        String hexa;
                        //escribir los números en hexadecimal
                        fis = new FileInputStream(numeros);
                        while (fis.available() > 0)
                        {
                            c = fis.read();
                            if (c != 10)
                            {
                                hexa = Integer.toHexString(c);
                                System.out.println(hexa);
                            }
                        }
                        fis.close();
                    }
                    break;
                case 5:
                    //comprobar si está un número y cuántas veces está
                    String comprobar = "38";
                    int contador = 0;
                    fis = new FileInputStream(numeros);
                    while (fis.available() > 0)
                    {
                        c = fis.read();
                         String comparar=Character.toString(c);
                         if(comparar.equalsIgnoreCase(comprobar)){
                         contador++;
                         }
                        
                    }

                    fis.close();
                    if(contador>0){
                        System.out.println("el número existe en la base de datos, se repite "+contador+ " veces.");}
                    else {
                        System.out.println("el número no existe en el documento");}
                    break;
            }

        } while (opcion != 6);
    }
}
