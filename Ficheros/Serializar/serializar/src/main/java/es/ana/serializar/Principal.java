package es.ana.serializar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
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
        ObjectOutputStream os = null;
        try
        {
            List<Perro> perros = new ArrayList();
            Perro perro1 = new Perro("Otto", "Border Collie");
            Perro perro2 = new Perro("Martirio", "Schnauzer Gigante");
            perros.add(perro1);
            perros.add(perro2);
            File fichero = new File("perros.dat");
            if (fichero.exists())
            {
                os = new miOos(new FileOutputStream(fichero, true));
            } else
            {
                os = new ObjectOutputStream(new FileOutputStream(fichero, true));
            }
            for (Perro perro : perros)
            {
                os.writeObject(perro);
            }
            os.close();
            //leer
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            for (Perro perro : perros)
            {
                Perro p = (Perro) ois.readObject();
                System.out.println(p.toString());
            }

            ois.close();
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                os.close();

            } catch (IOException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
