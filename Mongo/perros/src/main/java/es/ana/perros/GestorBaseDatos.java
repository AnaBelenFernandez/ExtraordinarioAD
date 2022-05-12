package es.ana.perros;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.addToSet;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.util.List;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author usuario
 */
public class GestorBaseDatos
{
    private final MongoCollection<Document> coleccionPerros;

    Scanner teclado = new Scanner(System.in);

    public GestorBaseDatos()
    {
        coleccionPerros = Conexion.getInstance().getColeccionPerros();

    }

    public void addPerro(String nombre, String raza)
    {
        Document perro = new Document("nombre", nombre).append("raza", raza);
        InsertOneResult insercion = coleccionPerros.insertOne(perro);
        if (insercion.wasAcknowledged())
        {
            System.out.println("Perro añadido");
        }

    }

    public void ObtenerPerros()
    {
        MongoCursor<Document> perros = coleccionPerros.find().iterator();
        while (perros.hasNext())
        {
            Document perro = perros.next();
            System.out.println("Nombre: " + perro.getString("nombre"));
            System.out.println("Raza: " + perro.getString("raza"));

        }
    }

    public void cambiarRaza(String nombre, String nuevaRaza)
    {
        Document perro = coleccionPerros.find(eq("nombre", nombre)).first();
        if (perro != null)
        {
            UpdateResult updateResult = coleccionPerros.updateOne(eq("nombre", perro.getString("nombre")), set("raza", nuevaRaza));
            if (updateResult.wasAcknowledged())
            {
                System.out.println("raza modificada: " + nuevaRaza);
            }
        }
    }

    public void contarPerros(String raza)
    {
        MongoCursor<Document> perros = coleccionPerros.find().iterator();
        long c = 0;
        while (perros.hasNext())
        {
            Document perro = perros.next();
            //sacar el número total de perros de esa raza
            c = coleccionPerros.countDocuments(eq("raza", raza));

        }
        System.out.println(c + " perros de raza " + raza);
    }

    public void cambiarNombre(String nombre, String nuevoNombre)
    {
        Document perro = coleccionPerros.find(eq("nombre", nombre)).first();
        if (perro != null)
        {
            UpdateResult updateResult = coleccionPerros.updateOne(eq("nombre", perro.getString("nombre")), set("nombre", nuevoNombre));
            if (updateResult.wasAcknowledged())
            {
                System.out.println("nombre modificado: " + nuevoNombre);
            }
        }
    }

    public void borrarPerro(String nombre)
    {
        DeleteResult resultado = coleccionPerros.deleteOne(eq("nombre", nombre));
        if (resultado.wasAcknowledged())
        {
            System.out.println("Perro borrado correctamente " + nombre + " ya no figura en la base de datos");
        }
    }

    public void verPerro(String nombre)
    {
        Document perro = coleccionPerros.find(eq("nombre", nombre)).first();
        if (perro != null)
        {
            System.out.println("El perro se llama " + perro.getString("nombre") + "y es de raza " + perro.getString("raza"));
        }
    }

    public void addDueño(String nombre, String nombreDueño, int telefono)
    {  //un dueño es un objeto{} con un String nombre y un int telefono
        //buscar el perro
        Document perro = coleccionPerros.find(eq("nombre", nombre)).first();
        System.out.println("Perro al que asignaremos dueño: \n" + perro.getString("nombre"));
        if (perro != null)
        {
            //si el perro existe, hay que crear un documento con el string y el int y añadirlo 
            Document dueño = new Document("nombre", nombreDueño).append("telefono", telefono);
            UpdateResult updateResult = coleccionPerros.updateOne(eq("nombre", perro.getString("nombre")), set("dueño", dueño));
            if (updateResult.wasAcknowledged())
            {
                System.out.println("Dueño añadido");
            }
        } else
        {
            System.out.println("El perro no está en nuestra base de datos");
        }

    }

    public void addVacunas(String nombre, List<String> vacunas)
    {      //añadir un array de strings al objeto perro
        Document perro = coleccionPerros.find(eq("nombre", nombre)).first();
        if (perro != null)
        {  //si el perro existe, hay que ponerle un atributo vacunas que es una lista de Strings
            UpdateResult updateResult = coleccionPerros.updateOne(eq("nombre", perro.getString("nombre")), set("vacunas", vacunas));
            if (updateResult.wasAcknowledged())
            {
                System.out.println("Vacunas añadidas");
            }
        } else
        {
            System.out.println("El perro no está en nuestra base de datos");
        }

    }

    public void nuevaVacuna(String nombre, String vacuna)
    {
        {
            Document perro = coleccionPerros.find(eq("nombre", nombre)).first();

//si el perro existe, hay que añadir una vacuna al array 
                UpdateResult updateResult = coleccionPerros.updateOne(eq("nombre", perro.getString("nombre")), addToSet("vacunas", vacuna));
            if (updateResult.wasAcknowledged())
            {
                System.out.println("Vacuna añadida");

            } else
            {
                System.out.println("El perro no está en nuestra base de datos");
            }

        }}}
    
