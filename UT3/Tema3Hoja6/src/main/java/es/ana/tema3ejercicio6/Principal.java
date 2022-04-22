package es.ana.tema3ejercicio6;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Principal
{
    private static GestorBaseDatos gestor;
    private static final Scanner teclado = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        gestor = new GestorBaseDatos();
        int opcion;
        Scanner tecladoS = new Scanner(System.in);
        do
        {
            System.out.println("1.-Obtener comunidades autónomas y capitales \n"
                    + "2.- Obtener comunidades autónomas con habitantes comprendidos entre valores\n"
                    + "3.- Obtener comunidades autónomas uniprovinciales.\n"
                    + "4.- Obtener capitales de comunidad autónoma con más habitantes que \n"
                    + "5.- Obtener comunidades autónomas sin fecha de estatuto\n"
                    + "6.- Obtener provincias de comunidad autónoma\n"
                    + "7.- Crear fichero JSON \n"
                    + "0.- SALIR");
            opcion = teclado.nextInt();
            switch (opcion)
            {
                case 1 ->
                    gestor.imprimirNombres();
                case 2 ->
                    gestor.rangoHabitantes(10, 2500000);
                 case 3 ->
                    gestor.uniprovinciales();
                case 4 ->
                    gestor.maspobladasque(10);
                case 5 ->
                    gestor.sinfechaestatuto();
                case 6 ->
                    gestor.imprimirProvincias(200);
                case 7 ->
                    gestor.jsontoFile();

            }
        } while (opcion != 0);
    }
}
