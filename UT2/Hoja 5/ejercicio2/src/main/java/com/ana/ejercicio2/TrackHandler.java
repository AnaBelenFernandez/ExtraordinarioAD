package com.ana.ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author usuario
 */
public class TrackHandler extends DefaultHandler
{
    private List<Track> canciones;
    private StringBuilder valorElemento;
    boolean esCancion;

    @Override
    public void startDocument() throws SAXException
    {
        super.startDocument();
        this.canciones = new ArrayList();
//        System.out.println("Se ha iniciado la lectura del documento");
    }

    @Override
    public void endDocument() throws SAXException
    {
        super.endDocument();
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException
    {
        super.startElement(uri, localName, qName, (org.xml.sax.Attributes) attributes);
        switch (qName)
        {
            case "track":
            {
                esCancion = true;
                canciones.add(new Track());
                this.canciones.get(canciones.size() - 1).setRank(Integer.valueOf(attributes.getValue("rank")));
            }
            case "artista":
            {
                esCancion = false;

            }

            case "name":
                this.valorElemento = new StringBuilder();
            case "url":
                this.valorElemento = new StringBuilder();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        super.characters(ch, start, length);
        if (this.valorElemento == null)
            this.valorElemento = new StringBuilder();
        else
            this.valorElemento.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        super.endElement(uri, localName, qName);
        switch (qName)
        {
            case "url" ->
            {

                this.canciones.get(canciones.size() - 1).setUrl(this.valorElemento.toString());
            }

            case "name" ->
            {
                //como hay nombre en la canción y en el artista hay que diferenciarlos
                {
                    if (!esCancion)
                    {

                        this.canciones.get(this.canciones.size() - 1).setArtista(this.valorElemento.toString());
                    } else
                    {
                        this.canciones.get(this.canciones.size() - 1).setNombre(this.valorElemento.toString());
                    }

                }

            }
        }
    }
      public List<Track> getExitos() {
        return canciones;
    }

}
