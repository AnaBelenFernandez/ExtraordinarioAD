package es.ana.conexion;

import com.mongodb.client.MongoCollection;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author usuario
 */
public class GestorBaseDatos {
     private final MongoCollection<Document> coleccionAlumnos;
    private final MongoCollection<Document> coleccionCursos;
    Scanner teclado = new Scanner(System.in);

    public GestorBaseDatos()
    {
        coleccionAlumnos = Conexion.getInstance().getColeccionAlumnos();
        coleccionCursos = Conexion.getInstance().getColeccionCursos();
    }

}
