package es.ana.leertexto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
        FileInputStream fis = null;
        FileOutputStream fos = null;
        int c = 0;
        try
        {
            File archivo = new File("texto");
            fis = new FileInputStream(archivo);
            fos = new FileOutputStream(archivo, true);
            while (fis.available() > 0)
            {
                c = fis.read();
                char letra = (char) c;
                System.out.print(letra);
            }
            String frase = "Hurra! está escribiendo";
            for (int i = 0; i < frase.length(); i++)
            {
                char caracter = frase.charAt(i);
                fos.write(caracter);
            }

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
                fis.close();
                fos.close();
            } catch (IOException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
