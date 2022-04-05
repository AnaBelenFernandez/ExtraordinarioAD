/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio1;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author DELL
 */
public class Profesor implements Serializable{
    private int numRegistro;
    private String nombre;
    private LocalDate fechaIngreso;
    private Instituto instituto;

    public Profesor(int numRegistro, String nombre, LocalDate fechaIngreso, Instituto instituto) {
        this.numRegistro = numRegistro;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.instituto = instituto;
    }
    

    public int getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(int numRegistro) {
        this.numRegistro = numRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Instituto getInstituto() {
        return instituto;
    }

    public void setInstituto(Instituto instituto) {
        this.instituto = instituto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.numRegistro;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profesor other = (Profesor) obj;
        if (this.numRegistro != other.numRegistro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
       
        return "Profesor{" + "numRegistro=" + numRegistro + ", nombre=" + nombre + ", fechaIngreso= " + fechaIngreso + " instituto "+instituto.getNombre()+ '}';
    }
    
    
}
