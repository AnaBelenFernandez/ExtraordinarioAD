package com.ana.ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Principal {
    public static void main(String[] args)
    {
             case 5:
                /*Opción 6: Pide por teclado el identificador de un futbolista y, si existe, elimina al futbolista del
fichero.*/
                System.out.println("introduce identificador de futbolista");
                String identificador = teclado.nextLine();
                //lo busco en el documento
                List<Futbolista> listaId = new ArrayList();
                listaId = crearLista(ruta);
                for (Futbolista fu : listaId)
                {
                    if (String.valueOf(fu.getId()).equalsIgnoreCase(identificador))
                    {
                        try
                        {
                            //borramos el futbolista de la lista
                            listaId.remove(fu);
                            //borro el documento
                            Files.deleteIfExists(ruta);
                            //reescribo el documento a partir de la nueva lista
                            escribirFichero(ruta, listaId);
                        } catch (IOException ex)
                        {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                break;
    }

}
