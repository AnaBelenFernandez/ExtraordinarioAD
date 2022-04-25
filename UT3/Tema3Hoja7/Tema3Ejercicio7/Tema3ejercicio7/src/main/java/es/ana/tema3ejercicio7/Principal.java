package es.ana.tema3ejercicio7;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Principal
{
    private static GestorBaseDatos gestor;
    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args)
    {
        gestor = new GestorBaseDatos();
        int opcion;
        do
        {
            System.out.println("1.-Añadir notas a alumnos de curso \n"
                    + "2.- Añadir tema a curso \n"
                    + "3.- Obtener alumnos de curso \n"
                    + "4.- Número de alumnos por curso.\n"
                    + "5.- Modificar nota media de alumno \n"
                    + "6.- Modificar horas de curso \n"
                    + "7.- Datos de alumno \n"
                    + "8.- Nota media en curso \n"
                    + "0.- SALIR");
            opcion = teclado.nextInt();
            switch (opcion)
            {
                case 1 ->
                    gestor.ponerNotas();
                    case 2 ->
                    gestor.nuevoTema();
                    case 3 ->
                    gestor.listaAprobados();
                    case 4 ->
                    gestor.alumnosPorCurso();
                    case 5 ->
                    gestor.ponerNotaMedia();
                    //case 6 ->
                    //gestor.imprimirProvincias(200);
                    //case 7 ->
                    //gestor.jsontoFile();

            }
        } while (opcion != 0);
    }
}
