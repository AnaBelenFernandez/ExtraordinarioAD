package es.ana.perros;

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
    private MongoCollection<Document> coleccionPerros;
  

    private Conexion()
    {
        try ( MongoClient cliente = MongoClients.create("mongodb://root:root@localhost:27017"))
        {
            if (cliente != null)
            {
                System.out.println("Conexión OK");
                db = cliente.getDatabase("perros");
                coleccionPerros = db.getCollection("perross");
               
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

    public MongoCollection<Document> getColeccionPerros()
    {
        return coleccionPerros;
    }

    
}
