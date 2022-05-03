package com.ana.leerobjetos;

/**
 *
 * @author usuario
 */
public class Perro {
    private String nombre;
    private String raza;

    public Perro()
    {
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getRaza()
    {
        return raza;
    }

    public void setRaza(String raza)
    {
        this.raza = raza;
    }

    @Override
    public String toString()
    {
        return "Perro{" + "nombre=" + nombre + ", raza=" + raza + '}';
    }
    
    

}
