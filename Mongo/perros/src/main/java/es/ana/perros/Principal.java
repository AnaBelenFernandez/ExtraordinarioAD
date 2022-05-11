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
                    + "4.- Número de perros.\n"
                    + "5.- Modificar nombre perro \n"
                    + "6.- Modificar raza perro \n"
                    + "7.- Datos de perro \n"                    
                    + "0.- SALIR");
            opcion = teclado.nextInt();
            switch (opcion)
            {
                case 1 ->
                   gestor.addPerro("Socio", "Setter");
                 

            }
        } while (opcion != 0);
    }
    }


