package es.ana.perros;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author usuario
 */
public class GestorBaseDatos {
     private final MongoCollection<Document> coleccionPerros;
   
    Scanner teclado = new Scanner(System.in);

    public GestorBaseDatos()
    {
        coleccionPerros = Conexion.getInstance().getColeccionPerros();
        
    }
    public void addPerro(String nombre, String raza){
        Document perro = new Document("nombre", nombre).append("raza", raza);
        InsertOneResult insercion = coleccionPerros.insertOne(perro);
         if (insercion.wasAcknowledged())
            {
                System.out.println("Perro añadido");
            }
        
    }
    public void ObtenerPerros(){
     MongoCursor<Document> perros = coleccionPerros.find().iterator();
        while (perros.hasNext())
        {
            Document perro = perros.next();
            System.out.println("Nombre: " + perro.getString("nombre"));
                 System.out.println("Raza: " + perro.getString("raza"));
                      
    }
      

}
public void cambiarRaza(String nombre, String nuevaRaza){
Document perro = coleccionPerros.find(eq("nombre", nombre)).first();
 if (perro != null)
        {
       UpdateResult updateResult = coleccionPerros.updateOne(eq("nombre", perro.getString("nombre")), set("raza", nuevaRaza));
            if (updateResult.wasAcknowledged())
            {
                System.out.println("raza modificada: " + perro.getString("raza"));
            } 
        }

}
}
