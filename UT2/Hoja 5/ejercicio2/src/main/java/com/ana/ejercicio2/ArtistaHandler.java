package com.ana.ejercicio2;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author usuario
 */
public class ArtistaHandler extends DefaultHandler
{
    private List<Artista> artistas;
    private StringBuilder valorElemento;

    @Override
    public void startDocument() throws SAXException
    {
        super.startDocument();
        this.artistas = new ArrayList();
//        System.out.println("Se ha iniciado la lectura del documento");
    }

    @Override
    public void endDocument() throws SAXException
    {
        super.endDocument();
//        System.out.println("Finalizada la lectura del documento");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException
    {
        super.startElement(uri, localName, qName, attributes);
        //Voy a evaluar todas las posible etiquetas de inicio 
        switch (qName)
        {
            case "topartists" ->
            {
                System.out.print("Mejores artistas de : " + attributes.getValue("country") + "\n");
            }
            case "artist" ->
            {
                artistas.add(new Artista());
            }
            case "name" ->
            {
                this.valorElemento = new StringBuilder();
            }
            case "url" ->
            {
                this.valorElemento = new StringBuilder();
            }
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
            case "name" ->
            {
//                System.out.println("\tNombre: " + this.valorElemento);
                this.artistas.get(this.artistas.size() - 1).setNombre(this.valorElemento.toString());
            }

            case "url" ->
            {
//                System.out.println("\tEnlace para descargar imagen: " + this.valorElemento);
                this.artistas.get(this.artistas.size() - 1).setUrl(
                        (this.valorElemento.toString()));
            }

        }
    }

    public List<Artista> getArtistas()
    {
        return artistas;
    }

}
