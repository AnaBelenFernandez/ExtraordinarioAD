/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.anafernandez.ejercicio1;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author DAM112
 */
public class MiObjectOutputStream extends ObjectOutputStream {

    /**
     * Constructor que recibe OutputStream
     *
     * @param out
     * @throws java.io.IOException
     */
    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    /**
     * Constructor sin par�metros
     *
     * @throws java.io.IOException
     */
    protected MiObjectOutputStream() throws IOException, SecurityException {
        super();
    }

    /**
     * Redefinici�n del m�todo de escribir la cabecera para que no haga nada.
     *
     * @throws java.io.IOException
     */
    @Override
    protected void writeStreamHeader() throws IOException {
    }

}
