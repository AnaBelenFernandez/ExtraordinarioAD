package com.ana.ejercicio2;

/**
 *
 * @author usuario
 */
public class Track {
    private String artista;
    private int rank;
    private String nombre;
    private String url;

    public Track()
    {
    }

    public Track(String artista, int rank, String nombre, String url)
    {
        this.artista = artista;
        this.rank = rank;
        this.nombre = nombre;
        this.url = url;
    }

    public String getArtista()
    {
        return artista;
    }

    public void setArtista(String artista)
    {
        this.artista = artista;
    }

    public int getRank()
    {
        return rank;
    }

    public void setRank(int rank)
    {
        this.rank = rank;
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
    public String toString()
    {
        return "Track{" + "artista=" + artista + ", rank=" + rank + ", nombre=" + nombre + ", url=" + url + '}';
    }
    
    

}
