package es.ana.conexion;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 *
 * @author usuario
 */
public class Conexion
{
    private static Conexion instance;
    private MongoDatabase db;
    private MongoCollection<Document> coleccionAlumnos;
    private MongoCollection<Document> coleccionCursos;

    private Conexion()
    {
        try ( MongoClient cliente = MongoClients.create("mongodb://root:root@localhost:27017"))
        {
            if (cliente != null)
            {
                System.out.println("Conexión OK");
                db = cliente.getDatabase("formacion");
                coleccionAlumnos = db.getCollection("alumnos");
                coleccionCursos = db.getCollection("cursos");

            } else
            {
                System.out.println("no se pudo realizar la conexión");
            }
        }
    }
     public static Conexion getInstance()
    {
        if (instance == null)
        {
            instance = new Conexion();
        }
        return instance;
    }
     
      public MongoDatabase getBaseDatos()
    {
        return db;
    }

    public MongoCollection<Document> getColeccionAlumnos()
    {
        return coleccionAlumnos;
    }

    public MongoCollection<Document> getColeccionCursos()
    {
        return coleccionCursos;
    }
}
