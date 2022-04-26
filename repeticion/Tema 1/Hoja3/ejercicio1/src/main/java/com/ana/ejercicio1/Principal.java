package com.ana.ejercicio1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Principal
{
    public static void main(String[] args)
    {
        String nombreFichero = "poesia.txt";
        String texto = "Firma: Miguel Hernández";
        File fichero = new File(nombreFichero);
        if (fichero.exists())
        {
            FileWriter escritor = null;
            try
            {
                //escribir el texto en el documento
                escritor = new FileWriter(fichero);
                char[] cad = texto.toCharArray();
                for (int i = 0; i < cad.length; i++)
                {
                    escritor.write(cad[i]);
                }       //en este caso es indiferente utilizar write que append
                escritor.close();

            } catch (IOException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } finally
            {
                try
                {
                    escritor.close();
                } catch (IOException ex)
                {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //ahora hay que mostrar todo el contenido del fichero cambiando las mayúsculas a minúsculas

        }
    }

}
