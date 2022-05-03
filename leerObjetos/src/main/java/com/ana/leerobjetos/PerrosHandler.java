package com.ana.leerobjetos;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author usuario
 */
public class PerrosHandler extends DefaultHandler
{

    private List<Perro> perros;
    private StringBuilder valorElemento;

    @Override
    public void startDocument() throws SAXException
    {
        super.startDocument();
        this.perros = new ArrayList();
        System.out.println("Se ha iniciado la lectura del documento");
    }

    @Override
    public void endDocument() throws SAXException
    {
        super.endDocument();
        System.out.println("Finalizada la lectura del documento");
    }
     @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException
    {
        super.startElement(uri, localName, qName, attributes);
        //Voy a evaluar todas las posible etiquetas de inicio 
        switch (qName) 
        {
            case "perros" ->
            {
                System.out.println("lista de perros");
            }  
             case "perro" ->
            {
                System.out.println("Datos del perro " + (perros.size() + 1));
                perros.add(new Perro());
            }
                
            case "nombre", "edad" -> this.valorElemento = new StringBuilder();    
        }
    }
     @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        super.characters(ch, start, length);
        //Esto puede ser un texto de un valor de una marca
        //o incluso un espacio o un ENTER que haya entre dos marcas.
        //Solo se obtiene el texto. No puede saberse a que corresponde

        //Usamos StringBuffer para extraerlos como String del array chars
        if (this.valorElemento == null)
            this.valorElemento = new StringBuilder();
        else
            this.valorElemento.append(ch, start, length);
    }
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        super.endElement(uri, localName, qName);
        //Evaluamos las marcas de fin que necesitemos
        switch (qName)
        {
            case "nombre" ->
            {
                System.out.println("\tNombre: " + this.valorElemento);
                this.perros.get(this.perros.size()-1).setNombre(this.valorElemento.toString());
            }
            case "raza" ->
            {
                System.out.println("\tRaza: " + this.valorElemento);
                this.perros.get(this.perros.size()-1).setRaza(this.valorElemento.toString());
            }
        }
    }

    public List<Perro> getPerros()
    {
        return perros;
    }
    

}
