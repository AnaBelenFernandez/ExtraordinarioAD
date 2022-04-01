/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio2;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class Futbolista  {
    private short numero;
    private String alias;
    private byte posicion;
    private float altura;
    private String equipo;

    
    
    public Futbolista(short numero, String alias, byte posicion, float altura, String equipo) {
        this.numero = numero;
        this.alias = alias;
        this.posicion = posicion;
        this.altura = altura;
        this.equipo = equipo;
    }

    public Futbolista() {
    }

    public short getNumero() {
        return numero;
    }

    public void setNumero(short numero) {
        this.numero = numero;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public byte getPosicion() {
        return posicion;
    }

    public void setPosicion(byte posicion) {
        this.posicion = posicion;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return  + numero + " | "+ alias + " | " + posicion + " | " + altura + " | " + equipo;
    }
    
    
}
