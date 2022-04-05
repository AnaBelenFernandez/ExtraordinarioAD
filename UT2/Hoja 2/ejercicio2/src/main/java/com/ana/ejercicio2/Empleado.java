package com.ana.ejercicio2;

/**
 *
 * @author usuario
 */
public class Empleado {
    private int salario;
    private String puesto;
    private String nombre;

    public Empleado()
    {
    }

    public Empleado(int salario, String puesto, String nombre)
    {
        this.salario = salario;
        this.puesto = puesto;
        this.nombre = nombre;
    }

    public int getSalario()
    {
        return salario;
    }

    public void setSalario(int salario)
    {
        this.salario = salario;
    }

    public String getPuesto()
    {
        return puesto;
    }

    public void setPuesto(String puesto)
    {
        this.puesto = puesto;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    @Override
    public String toString()
    {
        return "Empleado{" + "salario=" + salario + ", puesto=" + puesto + ", nombre=" + nombre + '}';
    }
    

}
