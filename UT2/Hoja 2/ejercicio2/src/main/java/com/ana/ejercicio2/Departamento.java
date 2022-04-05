package com.ana.ejercicio2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Departamento {
    private String telefono;
    private String tipo;
    private String codigo;    
    private String nombre;
    List<Empleado> empleados;

    public Departamento()
    {this.empleados =new ArrayList();
    }

    public Departamento(String telefono, String tipo, String codigo, String nombre, List<Empleado> empleados)
    {
        this.telefono = telefono;
        this.tipo = tipo;
        this.codigo = codigo;
        this.nombre = nombre;
        this.empleados = new ArrayList();
    }
    
    public void insertarEmpleado(Empleado empleado){
    empleados.add(empleado);
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados()
    {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados)
    {
        this.empleados = empleados;
    }

    @Override
    public String toString()
            
    {String listaEmpleados="";
        for (Empleado empleado : empleados)
        {
            listaEmpleados=listaEmpleados + empleado.toString()+"\n";
        }
        return "Departamento{" + "telefono=" + telefono + ", tipo=" + tipo + ", codigo=" + codigo + ", nombre=" + nombre + ", empleados=" + listaEmpleados + '}';
    }
    
    

}
