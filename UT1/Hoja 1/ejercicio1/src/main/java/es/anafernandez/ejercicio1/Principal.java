/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio1;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //pedimos la ruta por teclado
        System.out.println("teclea el nombre del directorio");
        String ruta = teclado.nextLine();
        //incializamos el directorio
        File directorio = new File(ruta);
        File[] archivos = directorio.listFiles();
        for (int i = 0; i < archivos.length; i++) {
            System.out.println(archivos[i].getName());
            System.out.println(archivos[i].getTotalSpace());
        }
    }

}
