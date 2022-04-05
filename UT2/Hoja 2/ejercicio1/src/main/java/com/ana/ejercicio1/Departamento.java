package com.ana.ejercicio1;

/**
 *
 * @author usuario
 */
public class Departamento {
    private String nombre;
    private String localidad;
    private int empleados;

    public Departamento()
    {
    }

    public Departamento(String nombre, String localidad, int empleados)
    {
        this.nombre = nombre;
        this.localidad = localidad;
        this.empleados = empleados;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getLocalidad()
    {
        return localidad;
    }

    public void setLocalidad(String localidad)
    {
        this.localidad = localidad;
    }

    public int getEmpleados()
    {
        return empleados;
    }

    public void setEmpleados(int empleados)
    {
        this.empleados = empleados;
    }

    @Override
    public String toString()
    {
        return "Departamento{" + "nombre=" + nombre + ", localidad=" + localidad + ", empleados=" + empleados + '}';
    }

    
}
