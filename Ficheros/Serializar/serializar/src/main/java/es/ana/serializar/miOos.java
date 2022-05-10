package es.ana.serializar;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author usuario
 */
public class miOos extends ObjectOutputStream
{
    public miOos(OutputStream out) throws IOException
    {
        super(out);
    }

    protected miOos() throws IOException, SecurityException
    {
        super();
    }

    /* Redefinición del método de escribir la cabecera para que no haga nada. */
    @Override
    protected void writeStreamHeader() throws IOException
    {
    }
}
