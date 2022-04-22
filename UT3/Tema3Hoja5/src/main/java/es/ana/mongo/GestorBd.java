package es.ana.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.addToSet;
import static com.mongodb.client.model.Updates.pull;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author usuario
 */
public class GestorBd
{
    Scanner teclado = new Scanner(System.in);
    MongoClient cliente = MongoClients.create("mongodb://root:root@localhost:27017");
    MongoDatabase centroDb = cliente.getDatabase("geografia");
    MongoCollection<Document> ccaa = centroDb.getCollection("ccaa");

    public void insertarCCAA(Document doc)
    {
        ccaa.insertOne(doc);
    }

    public Document buscarccaaCodigo(int cod)
    {
        Document documento = ccaa.find(eq("codigo", cod)).first();
        if (documento != null)
        {
            return documento;

        }
        return null;
    }

    public Document listaProvincias(int codigo, ArrayList<String> listaProvincias)
    {
        ccaa.updateOne(eq("codigo", codigo), set("provincias", listaProvincias));
        Document documento = ccaa.find(eq("codigo", codigo)).first();
        return documento;

    }

    public UpdateResult insertarProvinciaArray(int codigo, String provincia)
    {
        return ccaa.updateOne(eq("codigo", codigo), addToSet("provincias", provincia));

    }

    public UpdateResult modificarNombreCCAA(int codigo, String nombre)
    {
        return ccaa.updateOne(eq("codigo", codigo), set("nombre", nombre));

    }

    public UpdateResult eliminarProvinciaArray(int codigo, String provincia)
    {
        return ccaa.updateOne(eq("codigo", codigo), pull("provincias", provincia));

    }

    public Document capitalExiste(int codigo)
    {
        Document documento = ccaa.find(eq("codigo", codigo)).first();
        Document doccapital = (Document) documento.get("capital");
        return doccapital;
    }

    public UpdateResult crearCapital(int codigo, String nombre, int habitantes)
    {
        Document capital = new Document("nombre", nombre).append("habitantes", habitantes);
        //insertar la capital en el documento ccaa 
        return ccaa.updateOne(eq("codigo", codigo), set("capital", capital));

    }

    public UpdateResult nuevoAtributo(int codigo, String nombreAtributo, String valorAtributo)
    {
        return ccaa.updateOne(eq("codigo", codigo), set(nombreAtributo, valorAtributo));

    }

    public DeleteResult borrarComunidad(int codigo)
    {
        return ccaa.deleteOne(eq("codigo", codigo));
    }

}
