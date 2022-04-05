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
public class DepartamentosHandler extends DefaultHandler{
    
    private List<Departamento> departamentos;
    private StringBuilder valorElemento;
    private Empleado empleado;
    boolean esEmpleado;

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
            {esEmpleado=false;
                System.out.println("Datos de Departamento" + (departamentos.size() + 1));
                departamentos.add(new Departamento());
                System.out.print("Teléfono del Departamento: " +  attributes.getValue("telefono") + "\n");
                System.out.print("Tipo de Departamento: " +  attributes.getValue("tipo") + "\n");
                this.departamentos.get(departamentos.size()-1).setTelefono(attributes.getValue("telefono"));
                this.departamentos.get(departamentos.size()-1).setTipo((attributes.getValue("tipo")));
            }
             case "empleado" ->
            {esEmpleado=true;
                System.out.println("Datos de Empleado" + (departamentos.size() + 1));
                empleados.add(new Empleado());
                System.out.print("Salario del empleado: " +  attributes.getValue("salario") + "\n");               
                this.empleados.get(empleados.size()-1).setSalario(Integer.valueOf(attributes.getValue("salario")));
               
            }
            case "codigo", "nombre","puesto" ->
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
            case "codigo" ->
            {
                System.out.println("\tCodigo: " + this.valorElemento);
                this.departamentos.get(this.departamentos.size() - 1).setCodigo(this.valorElemento.toString());
            }
             case "puesto" ->
            {
                System.out.println("\tPuesto: " + this.valorElemento);
                this.empleados.get(this.empleados.size() - 1).setPuesto(this.valorElemento.toString());
            }
            case "nombre" ->
            {
                //como hay nombre en el departamento y en el empleaod hay que diferenciarlos
                System.out.println("\tNombre: " + this.valorElemento);
                this.departamentos.get(this.departamentos.size() - 1).setNombre(this.valorElemento.toString());

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
