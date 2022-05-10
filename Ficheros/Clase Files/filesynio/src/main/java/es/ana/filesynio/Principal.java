package es.ana.filesynio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
        //crear un fichero y darle contenido
        Path ruta = Paths.get("original.txt");
        //comprobar si existe, si no existe, se crea
        if (Files.notExists(ruta))
        {
            try
            {
                Files.createFile(ruta);
                //escribir algo en el archivo
                BufferedWriter bw = Files.newBufferedWriter(ruta);
                bw.write("escribo contenido para copiarlo en otro archivo");
                bw.close();
                //leo el contenido para comprobar que se ha escrito bien
                BufferedReader br=Files.newBufferedReader(ruta);
                String linea;
                while((linea=br.readLine())!=null){
                    System.out.println(linea);}
                br.close();
                //hacer una copia
                Path copia = Paths.get("copia.txt");
                Files.copy(ruta, copia, StandardCopyOption.REPLACE_EXISTING);
                         //borro original                
                Files.delete(ruta);
                //cambio el nombre
                File fichero=new File("original.txt");
                File copy=new File("copia.txt");
                boolean cambiado=copy.renameTo(fichero);
                if(cambiado){
                    System.out.println("fichero renombrado correctamente");}
            } catch (IOException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
