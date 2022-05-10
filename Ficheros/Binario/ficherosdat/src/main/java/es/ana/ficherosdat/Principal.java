package es.ana.ficherosdat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
FileInputStream fis=null;
        try
        {
            //lo primero voy a escribir
            File fichero = new File("fichero.dat");
            FileOutputStream fos = new FileOutputStream(fichero);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF("Ana");
            dos.writeInt(49);
            dos.writeDouble(1.54);
//leer binario
            fis = new FileInputStream(fichero);
            DataInputStream dis = new DataInputStream(fis);
            String nombre=dis.readUTF();
            int edad=dis.readInt();
            double altura=dis.readDouble();
            System.out.println("me llamo"+nombre+ "tengo estos años "+edad+" y mido esto "+altura);
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
            } catch (IOException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
