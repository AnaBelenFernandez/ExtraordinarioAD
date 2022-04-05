package com.ana.ejercicio2;

/**
 *
 * @author usuario
 */
public class Artista {
    private String nombre;
    private String url;

    public Artista()
    {
    }

    public Artista(String nombre, String url)
    {
        this.nombre = nombre;
        this.url = url;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
      @Override
    public String toString() {
        return nombre + "\n"+"\t"+"Descargar Imagen:" + url;
    }

}
