package com.ana.ejercicio1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author usuario
 */
public class Futbolista {
private int id;
private String nombre;
private String apellidos;
private Puesto puesto;
private float altura;
private LocalDate fechaNac;
private String codEquipo;

    public Futbolista()
    {
    }

    public Futbolista(int id, String nombre, String apellidos, Puesto puesto, float altura, LocalDate fechaNac, String codEquipo)
    {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.puesto = puesto;
        this.altura = altura;
        this.fechaNac = fechaNac;
        this.codEquipo = codEquipo;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellidos()
    {
        return apellidos;
    }

    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }

    public Puesto getPuesto()
    {
        return puesto;
    }

    public void setPuesto(Puesto puesto)
    {
        this.puesto = puesto;
    }

    public float getAltura()
    {
        return altura;
    }

    public void setAltura(float altura)
    {
        this.altura = altura;
    }

    public LocalDate getFechaNac()
    {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac)
    {
        this.fechaNac = fechaNac;
    }

    public String getCodEquipo()
    {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo)
    {
        this.codEquipo = codEquipo;
    }

    @Override
    public String toString()
            
            
    {DateTimeFormatter f=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%3d | %-20s | %-30s | %-30s | %3.2f | %40s ! %4s",id,nombre,apellidos,puesto,altura,fechaNac.format(f),codEquipo);
       
    }

public String toCSV(){
    //DateTimeFormatter f=DateTimeFormatter.ofPattern("dd de MM de yyyy");
return String.format("%d,%s,%s,%s,%1.2f,%s",id, nombre,apellidos, puesto, altura, fechaNac, codEquipo);
        }
}
