package com.ana.ejercicio1;

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
        try
        {
            //copiar un fichero .txt a otro
            //leer
            fis = new FileInputStream("poesia.txt");
            //escribir
            FileOutputStream fos = new FileOutputStream("copiadepoesia.txt", true);
            //proceso de lectura-escritura
            int c;
            while (fis.available() > 0)
            {  //lectura
                c = fis.read();
                //escritura
                fos.write(c);
                //en el print convertimos el int a caracteres ascii
                System.out.print(Character.toString(c));
            }
//cierro flujjo
            fos.close();
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
                //cierro flujo
                fis.close();
            } catch (IOException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
