package es.ana.serializar;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Perro implements Serializable
{
    private String nombre;
    private String raza;

    public Perro()
    {
    }

    public Perro(String nombre, String raza)
    {
        this.nombre = nombre;
        this.raza = raza;
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
