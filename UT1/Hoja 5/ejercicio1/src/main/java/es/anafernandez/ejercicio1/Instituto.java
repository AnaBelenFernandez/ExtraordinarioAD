/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio1;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Instituto implements Serializable {
    private String nombre;
    private LocalDate fechaConstruccion;
    private String localidad;
        private ArrayList <Profesor> profesores;

    public Instituto() {
    }

    public Instituto(String nombre, LocalDate fechaConstruccion, String localidad) {
        this.nombre = nombre;
        this.fechaConstruccion = fechaConstruccion;
        this.localidad = localidad;
        this.profesores=new ArrayList();
    }
  public void añadirProfesor(Profesor p){    
    profesores.add(p);
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaConstruccion() {
        return fechaConstruccion;
    }

    public void setFechaConstruccion(LocalDate fechaConstruccion) {
        this.fechaConstruccion = fechaConstruccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    @Override
    public String toString() {
        String listaProfesores="";
        for (Profesor p : profesores) {
            listaProfesores = listaProfesores + p.toString()+ "\n";
        }
          DateTimeFormatter f = DateTimeFormatter.ofPattern("dd ' / ' MM ' / ' yyyy");
        return "Instituto{" + "nombre=" + nombre + ", fechaConstruccion=" + fechaConstruccion.format(f) + ", localidad=" + localidad +" Profesores:\n"+ listaProfesores + '}';
    }

  
    
    
}
