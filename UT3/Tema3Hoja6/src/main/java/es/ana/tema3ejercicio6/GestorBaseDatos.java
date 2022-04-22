package es.ana.tema3ejercicio6;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.exists;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Filters.or;
import static com.mongodb.client.model.Filters.size;
import static com.mongodb.client.model.Indexes.ascending;
import static com.mongodb.client.model.Indexes.descending;
import static com.mongodb.client.model.Projections.exclude;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.json.JsonWriterSettings;

/**
 *
 * @author ivan
 */
public class GestorBaseDatos
{
    private final MongoCollection<Document> coleccion;

    public GestorBaseDatos()
    {
        coleccion = Conexion.getInstance().getColeccion();
    }

    public void imprimirNombres()
    {/*Se muestran los nombres de todas las comunidades autónomas y los de sus capitales con formato 
JSON.Debes realizarlo con projection.*/
        MongoCursor<Document> cursor;
        cursor = coleccion.find().projection(fields(include("nombre", "capital.nombre"), exclude("_id"))).iterator();
        while (cursor.hasNext())
        {
            Document doc = cursor.next();
            System.out.println(doc.toJson());
        }
        cursor.close();
    }

    public void rangoHabitantes(int limiteinferior, int limitesuperior)
    {
        MongoCursor<Document> cursor = coleccion.find(and(gt("habitantes", limiteinferior), lte("habitantes", limitesuperior)))
                .sort(descending("habitantes"))
                .iterator();
        while (cursor.hasNext())
        {
            Document doc = cursor.next();
            System.out.println(doc.getString("nombre").toUpperCase() + "...." + doc.get("habitantes", Number.class).longValue());
        }
        cursor.close();

    }

    public void uniprovinciales()
    {
        /*Se escriben en pantalla los nombres de todas las comunidades autónomas que tienen una sola
provincia en el atributo array provincias.El listado se debe ordenar descendentemente por habitantes
        y ascendentemente por nombre.*/
        MongoCursor<Document> cursor = coleccion.find(size("provincias", 1))
                .sort(descending("habitantes"))
                .sort(ascending("nombre"))
                .iterator();
        while (cursor.hasNext())
        {
            Document doc = cursor.next();
            System.out.println(doc.getString("nombre").toUpperCase());
        }
        cursor.close();

    }

    public void maspobladasque(int habitantes)
    {
        /*imprimir nombre capitales con mas habitantes que los dados por teclado.
        El listado debe estar ordenado alfabéticamente por nombres de las capitales.*/
        MongoCursor<Document> cursor = coleccion.find(gt("capital.habitantes", habitantes))
                .sort(ascending("capital.nombre"))
                .iterator();
        while (cursor.hasNext())
        {
            Document doc = cursor.next();
            Document capital = (Document) doc.get("capital");
            System.out.println(capital.getString("nombre").toUpperCase());
        }
        cursor.close();

    }

    public void sinfechaestatuto()
    {
        /*Se escriben en pantalla los nombres de todas las comunidades autónomas que no tienen atributo
fecha_estatuto o que lo tienen a valor nulo.
         */ MongoCursor<Document> cursor = coleccion.find(or(exists("fecha_estatuto", false), eq("fecha_estatuto", null)))
                .sort(ascending("nombre"))
                .iterator();
        while (cursor.hasNext())
        {
            Document doc = cursor.next();
            System.out.println(doc.getString("nombre").toUpperCase());
        }
        cursor.close();

    }

    public void imprimirProvincias(int codigo)
    {
        /*Se pide por teclado el código de una comunidad autónoma y, si existe, se escribe en pantalla su
nombre y los nombres de sus provincias (uno en cada línea)*/
        Document documento = coleccion.find(eq("codigo", codigo)).first();
        //provincias es un array dentro del documento
        List<String> lista = (ArrayList<String>) documento.get("provincias");
        for (String provincia : lista)
        {
            System.out.println(provincia);
        }
    }

    public void jsontoFile()
    {
        PrintWriter escritor = null;
        try
        {
            String ruta = "fichero.txt";
            MongoCursor<Document> cursor = coleccion.find().projection(fields(include("nombre", "capital", "provincias",  "extension"), excludeId())).iterator();
            escritor = new PrintWriter(new FileWriter(new File(ruta)));
            while (cursor.hasNext())
            {
                Document documento = cursor.next();
                JsonWriterSettings configSalidaJson = JsonWriterSettings.builder().indent(true).build();
                escritor.println(documento.toJson(configSalidaJson));
                           }
             System.out.println("fichero creado correctamente");
             escritor.close();
        } catch (IOException ex)
        {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se ha podido crear el fichero"+ex.getMessage());
        }

    }
}
