package com.ana.ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author usuario
 */
public class DepartamentosHandler extends DefaultHandler
{
    private List<Departamento> departamentos;
    private StringBuilder valorElemento;

    public List<Departamento> getDepartamentos()
    {
        return departamentos;
    }
    
    

    @Override
    public void startDocument() throws SAXException
    {
        super.startDocument();
        this.departamentos = new ArrayList();
        System.out.println("Se ha iniciado la lectura del documento");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException
    {
        super.startElement(uri, localName, qName, attributes);
        switch (qName)
        {
            case "departamento" ->
            {
                System.out.println("Datos de Departamento" + (departamentos.size() + 1));
                departamentos.add(new Departamento());
            }
            case "nombre", "localidad","empleados" ->
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
        //Evaluamos las marcas de fin que necesitemos
        switch (qName)
        {
            case "nombre" ->
            {
                System.out.println("\tNombre: " + this.valorElemento);
                this.departamentos.get(this.departamentos.size() - 1).setNombre(this.valorElemento.toString());
            }
            case "localidad" ->
            {
                System.out.println("\tLocalidad: " + this.valorElemento);
                this.departamentos.get(this.departamentos.size() - 1).setLocalidad(this.valorElemento.toString());

            }
            case "empleados" ->
            {
                System.out.println("\tNúmero de Empleados: " + this.valorElemento);
                this.departamentos.get(this.departamentos.size() - 1).setEmpleados(Integer.parseInt(this.valorElemento.toString()));

            }
        }
    }

    @Override
    public void endDocument() throws SAXException
    {
        super.endDocument();
        System.out.println("Finalizada la lectura del documento");
    }

}
