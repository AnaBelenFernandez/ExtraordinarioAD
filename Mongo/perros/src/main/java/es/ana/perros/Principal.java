package es.ana.perros;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Principal
{
    private static GestorBaseDatos gestor;
    

    public static void main(String[] args)
    {

        gestor = new GestorBaseDatos();
        Scanner teclado=new Scanner(System.in);
        int opcion;
        do
        {
            System.out.println("1.-Añadir perro \n"
                    + "2.- Cambiar raza de perro \n"
                    + "3.- Obtener perros \n"
                    + "4.- Número de perros por raza.\n"
                    + "5.- Modificar nombre perro \n"
                    + "6.- Eliminar un perro \n"
                    + "7.- Datos de perro \n"                    
                    + "0.- SALIR");
            opcion = teclado.nextInt();
            switch (opcion)
            {
                case 1 ->
                   gestor.addPerro("Socio", "Setter"); 
                case 2->
                    gestor.cambiarRaza("Socio", "Bobtail");
                case 3 ->
                    gestor.ObtenerPerros();
                case 4 ->
                    gestor.contarPerros("Fox Terrier");
                case 5 ->
                    gestor.cambiarNombre("Socio", "Ada");
                case 6->
                    gestor.borrarPerro("Abelardo");
                case 7->
                    gestor.verPerro("Otto");
            }
        } while (opcion != 0);
    }
    }


