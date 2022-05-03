package com.ana.ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
            BufferedReader lector = null;
            try
            {
                FileWriter escritor = null;
                try
                {
                    //escribir el texto en el documento
                    escritor = new FileWriter(fichero, true);
                    char[] cad = texto.toCharArray();
                    for (int i = 0; i < cad.length; i++)
                    {
                        escritor.write(cad[i]);
                    }
                    escritor.close();
//en este caso es indiferente utilizar write que append

                } catch (IOException ex)
                {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                //ahora hay que mostrar todo el contenido del fichero cambiando las mayúsculas a minúsculas
                lector = new BufferedReader(new FileReader(fichero));
                //Es lo mismo que:
                //FileReader fr = new FileReader(fichero);
                //BufferedReader lector = new BufferedReader(fr);
                String linea;
                while ((linea = lector.readLine()) != null)
                {
                    for (int i = 0; i < linea.length(); i++)
                    {
                        char letra = linea.charAt(i);
                        if (Character.isUpperCase(letra))
                        {
                            System.out.print(Character.toLowerCase(letra));
                        } else
                        {
                            System.out.print(Character.toUpperCase(letra));
                        }

                    }
                    System.out.println("");

                }
                lector.close();
            } catch (FileNotFoundException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } finally
            {
                try
                {
                    lector.close();
                } catch (IOException ex)
                {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
