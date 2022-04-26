package es.ana.tema3ejercicio7;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Indexes.ascending;
import static com.mongodb.client.model.Updates.addToSet;
import static com.mongodb.client.model.Updates.push;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author usuario
 */
public class GestorBaseDatos
{
    private final MongoCollection<Document> coleccionAlumnos;
    private final MongoCollection<Document> coleccionCursos;
    Scanner teclado = new Scanner(System.in);

    public GestorBaseDatos()
    {
        coleccionAlumnos = Conexion.getInstance().getColeccionAlumnos();
        coleccionCursos = Conexion.getInstance().getColeccionCursos();
    }

    public void ponerNotas()
    {//voy a buscar por título porque por id me da muchísimos problemas(PREGUNTAR)
        System.out.println("Teclea id del curso");
        String id = teclado.nextLine();
        //tenemos el título--> vamos a buscar el curso en la bd y lo cargamos a un documento
        Document Doc = coleccionCursos.find(eq("_id", id)).first();
        if (Doc != null)
        //si el curso existe, hay que recorrer la colección de alumnos de ese curso
        {
            System.out.println("Curso seleccionado: \n" + Doc.getString("titulo") + " categoría: " + Doc.getString("categoria"));
            MongoCursor<Document> cursor = coleccionAlumnos.find(eq("curso", Doc.getString("_id"))).sort(ascending("apellidos", "nombre")).iterator();
            while (cursor.hasNext())
            {
                Document Alumnos = cursor.next();
                String idAlumno = Alumnos.getString("_id");
                //muestro apellidos y nombre
                System.out.println(Alumnos.getString("apellidos") + "," + Alumnos.getString("nombre"));
                //vamos pidiendo la nota por teclado
                System.out.println("introduce nota obtenida");
                double nota = teclado.nextDouble();
                coleccionAlumnos.updateOne(eq("_id", idAlumno), push("notas", nota));
                //PREGUNTAR--> con esto queda actualizada la base de datos?? da la sensación de que si

            }
            cursor.close();
        } else
        {
            System.out.println("El curso seleccionado no existe en la base de datos");
        }

    }

    public void nuevoTema()
    {
        //añadir tema a array de temas del curso
        //un tema es un objeto{} con un String título y un int horas
        //buscar el curso
        System.out.println("Teclea id del curso");
        String id = teclado.nextLine();
        //tenemos el título--> vamos a buscar el curso en la bd y lo cargamos a un documento
        Document Doc = coleccionCursos.find(eq("_id", id)).first();
        System.out.println("Curso seleccionado: \n" + Doc.getString("titulo") + " categoría: " + Doc.getString("categoria"));
        if (Doc != null)
        {
            //si el curso existe, hay que crear un documento con el string y el int y añadirlo al array
            System.out.println("introduce título del tema");
            String tituloAsig = teclado.nextLine();
            System.out.println("introduce número de horas");
            int horas = teclado.nextInt();
            Document tema = new Document("titulo", tituloAsig).append("horas", horas);
            //ahora hay que insertar ese documento en el array de temas del Documento curso
            UpdateResult updateResult = coleccionCursos.updateOne(eq("_id", Doc.getString("_id")), addToSet("temas", tema));
            if (updateResult.wasAcknowledged())
            {
                System.out.println("Tema añadido");
            }
            /*también se podría hacer del tirón 
            coleccionCursos.updateOne(eq("id", id), addToSet("temas",new Document("titulo", titulo).append("horas", horas)));*/
        } else
        {
            System.out.println("El curso no está en nuestra base de datos");
        }
    }

    public void listaAprobados()
    {
        //pido la identificación de un curso e imprimo el título y las horas
        System.out.println("Teclea id del curso");
        String id = teclado.nextLine();
        //tenemos el título--> vamos a buscar el curso en la bd y lo cargamos a un documento
        Document Doc = coleccionCursos.find(eq("_id", id)).first();
        System.out.println("Curso seleccionado: \n" + Doc.getString("titulo") + " horas: " + Doc.getInteger("horas"));
        if (Doc != null)
        {//buscar alumnos de ese curso con nota_media 5 o mayor: son dos filtros AND
            //ordenar por apellidos y luego por nombre
            //imprimir apellidos, nombre, nota_media
            MongoCursor<Document> cursor = coleccionAlumnos.find(and(eq("curso", Doc.getString("_id")), gte("nota_media", 5)))
                    .sort(ascending("apellidos"))
                    .sort(ascending("nombre"))
                    .iterator();
            //lo recorro y voy imprimiendo
            while (cursor.hasNext())
            {
                Document Alumno = cursor.next();
                System.out.printf("%-15s%-25s%4.1f\n",
                        Alumno.getString("nombre"),
                        Alumno.getString("apellidos"),
                        Alumno.getDouble("nota_media"));
            }
        } else
        {
            System.out.println("el curso no existe");
        }
    }

    public void alumnosPorCurso()
    {
        //cursor de cursos--> con el iterator se hacen los cursores.
        MongoCursor<Document> cursos = coleccionCursos.find().iterator();
        while (cursos.hasNext())
        {
            Document curso = cursos.next();
            System.out.println("Título del curso: " + curso.getString("titulo"));
            //sacar el número total de alumnos de este curso es con countDocuments
            long c = coleccionAlumnos.countDocuments(eq("curso", curso.getString("_id")));
            System.out.println(c + " alumnos");
            /*otra manera de hacerlo*/
 /*MongoCursor<Document> cursor = coleccionAlumnos.aggregate(
                Arrays.asList(
                        Aggregates.group("$curso", Accumulators.sum("num", 1))
                )).iterator();*/
        }
    }

    public void ponerNotaMedia()
    {
        //se busca un alumno por id
        System.out.println("introduce id de alumno");
        String id = teclado.nextLine();
        Document alumno = coleccionAlumnos.find(eq("_id", id)).first();
        if (alumno != null)
        {
            System.out.println(alumno.getString("nombre") + " nota media actual: " + alumno.getDouble("nota_media"));
            //coger las notas del array de notas
            List<Double> notas = new ArrayList();
            notas = alumno.getList("notas", Double.class);
            //calcular la media
            double suma = 0;
            for (Double nota : notas)
            {
                suma = suma + nota;
            }
            double media = 0.0;
            if (notas.size() > 1)
            {
                media = suma / notas.size();
            }
            //ahora hay que agregar este dato al campo nota_media
            UpdateResult updateResult = coleccionAlumnos.updateOne(eq("_id", alumno.getString("_id")), set("nota_media", media));
            if (updateResult.wasAcknowledged())
            {
                System.out.println("nota media modificada: " + alumno.getDouble("nota_media"));
            }
        } else
        {
            System.out.println("el alumno no existe");
        }
    }

    public void calcularHoras()
    {
        //pido la identificación de un curso e imprimo el título y las horas
        System.out.println("Teclea id del curso");
        String id = teclado.nextLine();
        //tenemos el título--> vamos a buscar el curso en la bd y lo cargamos a un documento
        Document Doc = coleccionCursos.find(eq("_id", id)).first();
        if (Doc != null)
        {//visualizamos los datos
            System.out.println("Curso seleccionado: \n" + Doc.getString("titulo") + " horas: " + Doc.getInteger("horas"));
            // calcular total de horas en función de las horas de los temas(las tengo que coger del array de objetos temas)
            List<Document> temas = Doc.getList("temas", Document.class);
            int totalHoras = 0;
            for (Document tema : temas)
            {
                int horasTema = tema.getInteger("horas");
                totalHoras += horasTema;
            }
            //ahora hay que agregar este dato al campo horas del curso
            UpdateResult updateResult = coleccionCursos.updateOne(eq("_id", Doc.getString("_id")), set("horas", totalHoras));
            if (updateResult.wasAcknowledged())
            {
                System.out.println("horas totales modificadas: " + Doc.getInteger("horas"));
            } else
            {
                System.out.println("no se han modificado las horas");
            }

        } else
        {
            System.out.println("El curso no existe");
        }

    }

    public void mostrarDatosAlumno()
    {
        //se busca un alumno por id
        System.out.println("introduce id de alumno");
        String id = teclado.nextLine();
        Document alumno = coleccionAlumnos.find(eq("_id", id)).first();
        if (alumno != null)
        {
            String codigoCurso = alumno.getString("curso");
            Document curso = coleccionCursos.find(eq("_id", codigoCurso)).first();
            System.out.println("Nombre: " + alumno.getString("nombre") + " \n Apellidos: " + alumno.getString("apellidos") + "\n Curso: " + curso.getString("titulo"));
        }

    }

    public void notaMediaCurso()
    {
        //pido la identificación de un curso e imprimo el título y las horas
        System.out.println("Teclea id del curso");
        String id = teclado.nextLine();
        //tenemos el título--> vamos a buscar el curso en la bd y lo cargamos a un documento
        Document curso = coleccionCursos.find(eq("_id", id)).first();
        if (curso != null)
        {//visualizamos los datos
            System.out.println("Curso seleccionado: \n" + curso.getString("titulo") + " horas: " + curso.getInteger("horas"));
                   //cargo los alumnos del curso en un mongocursor con iterator
            MongoCursor<Document> alumnos = coleccionAlumnos.find(eq("curso", curso.getString("_id"))).iterator();
            //calculo el total de alumnos
            long total= coleccionAlumnos.countDocuments(eq("curso", curso.getString("_id")));
            //voy sacando la nota media de cada alumno            
            Double suma=0.0;
            while (alumnos.hasNext())
            {
                Document alumno = alumnos.next();
                Double media=alumno.getDouble("nota_media");
                suma+=media;              
            }            
            Double mediaCurso=suma/total;
            DecimalFormat formateador = new DecimalFormat("####.##");
            System.out.println("la media del curso es :"+ formateador.format(mediaCurso));

        }
    }
}
