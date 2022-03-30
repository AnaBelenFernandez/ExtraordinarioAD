/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Equipo implements Serializable {
    private String nombre;
    private int numAlumnos;
    private float puntos;
    private ArrayList<Alumno> alumnos=new ArrayList();

    public Equipo() {
    }

    public Equipo(String nombre, int numAlumnos, float puntos) {
        this.nombre = nombre;
        this.numAlumnos = numAlumnos;
        this.puntos = puntos;
        this.alumnos = new ArrayList();
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }

    public void setNumAlumnos(int numAlumnos) {
        this.numAlumnos = numAlumnos;
    }

    public float getPuntos() {
        return puntos;
    }

    public void setPuntos(float puntos) {
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        String listaAlumnos="";
        
        for (Alumno a : alumnos) {
            listaAlumnos=listaAlumnos + a.toString()+"\n";
            
        }
        return "Equipo{" + "nombre=" + nombre + ", numAlumnos=" + numAlumnos + ", puntos=" + puntos + "Alumnos"
                + listaAlumnos+'}';
    }
    
    
    
}
