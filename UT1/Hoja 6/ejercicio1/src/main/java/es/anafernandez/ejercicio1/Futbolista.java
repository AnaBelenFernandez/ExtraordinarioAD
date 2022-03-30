/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio1;

import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class Futbolista {
    private int id;
    private String nombre;
    private String apellidos;
    private String alias;
    private String puesto;
    private float altura;
    private LocalDate fechaNac;
    private String codEquipo;

    public Futbolista() {
    }

    public Futbolista(int id, String nombre, String apellidos, String alias, String puesto, float altura, LocalDate fechaNac) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.alias = alias;
        this.puesto = puesto;
        this.altura = altura;
        this.fechaNac = fechaNac;
    }

    public Futbolista(int id, String nombre, String apellidos, String alias, String puesto, float altura, LocalDate fechaNac, String codEquipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.alias = alias;
        this.puesto = puesto;
        this.altura = altura;
        this.fechaNac = fechaNac;
        this.codEquipo = codEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    @Override
    public String toString() {
        return "Futbolista{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", alias=" + alias + ", puesto=" + puesto + ", altura=" + altura + ", fechaNac=" + fechaNac + ", codEquipo=" + codEquipo + '}';
    }
    
    
    
}
