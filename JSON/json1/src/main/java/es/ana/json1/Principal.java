package es.ana.json1;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        BufferedReader lector = null;
        try
        {
            lector = Files.newBufferedReader(Paths.get("trabajadores.json"));
            Gson gson = new Gson();
            Trabajador trabajador = gson.fromJson(lector, Trabajador.class);
            System.out.println("<-------imprimir el JSON-------->");
            System.out.println(trabajador.toString());
            lector.close();
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
