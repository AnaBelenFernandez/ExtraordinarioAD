package es.ana.mongo;

import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author usuario
 */
public class Principal
{
    public static void main(String[] args)
    {
        GestorBd gestorbd = new GestorBd();
        Scanner teclado = new Scanner(System.in);
        int opcion = 11;
        do
        {
            Document d;
            System.out.println("teclea una opción");
            System.out.println("1- Insertar una Comunidad Autónoma");
            System.out.println("2- Ver datos de una CCAA");
            System.out.println("3- Cargar lista de provincias");
            System.out.println("4- Añadir una provincia");
            System.out.println("5- Cambiar nombre de CCAA");
            System.out.println("6- Eliminar provincia");
            System.out.println("7- Añadir capital");
            System.out.println("8- Añadir fecha del Estatuto de Autonomía");
            System.out.println("9- Ver/Eliminar CCAA");
            System.out.println("0- Salir");
            opcion = teclado.nextInt();
            Document documento = null;
            int codigo;
            switch (opcion)

            {
                case 1:
                    //creo un documento con datos recogidos por teclado
                    documento = pedirDatos();
                    System.out.println(documento.toString());
                    //añado el documento a la bd
                    gestorbd.insertarCCAA(documento);
                    break;
                case 2:
                    //pedir código ccaa por teclado
                    System.out.println("introduce código de CCAA");
                    codigo = teclado.nextInt();
                    //existe
                    documento = gestorbd.buscarccaaCodigo(codigo);
                    if (documento != null)
                    {
                        //--> escribir número de habitantes, extensión y capital
                        String nom = (String) documento.get("nombre");
                        int extension = (int) documento.getInteger("extension");
                        Document docCapital = (Document) documento.get("capital");
                        String capital = (String) docCapital.getString("nombre");
                        System.out.println("Nombre: " + nom + "  Extension: " + extension
                                + " NombreCapital: " + capital);
                        //escribir en formato json
                        System.out.println(documento.toJson());
                        //no existe: avisar
                    } else
                    {
                        System.out.println("no existe esa comunidad en nuestra base de datos");
                    }

                    break;
                case 3:
                    //opcion3
                    //busco el código en la lista de provincias
                    System.out.println("introduce código de CCAA");
                    codigo = teclado.nextInt();
                    documento = gestorbd.buscarccaaCodigo(codigo);
                    //si lo encuentro--> pregunto por la lista de provincias y la cargo en un ArrayList
                    if (documento != null)
                    {
                        //cargo un array por teclado con los nombres de las provincias
                        String provincia = "";
                        ArrayList<String> listaProvincias = new ArrayList();
                        boolean nombreValido = false;
                        do
                        {
                            System.out.println("introduce provincia. X para salir");
                            provincia = teclado.nextLine();
                            if (!provincia.equalsIgnoreCase("x"))
                            {
                                nombreValido = true;
                            } else if (!provincia.equalsIgnoreCase(""))
                            {
                                nombreValido = true;
                            }
                            if (nombreValido)
                            {
                                listaProvincias.add(provincia);
                            }
                        } while (!provincia.equalsIgnoreCase("X"));
                        documento = gestorbd.listaProvincias(codigo, listaProvincias);
                        System.out.println(documento.toJson());
                    } else
                    {
                        //no lo encuentro
                        System.out.println("ese código no corresponde a ninguna ccaa de nuestra base de datos");
                    }
                    break;
                case 4:
                    //opcion4
                    //pedir código de CCAA y buscar              
                    System.out.println("introduce código de CCAA");
                    codigo = teclado.nextInt();
                    documento = gestorbd.buscarccaaCodigo(codigo);
                    //introducir nueva provincia
                    if (documento != null)
                    {
                        System.out.println("teclea nombre de provincia");
                        String provincia = teclado.nextLine();
                        if (gestorbd.insertarProvinciaArray(codigo, provincia).getMatchedCount() != 1)
                        {
                            throw new IllegalStateException(
                                    String.format("Error al añadir la provincia(matched= %s, modified= %s).",
                                            gestorbd.insertarProvinciaArray(codigo, provincia).getMatchedCount(),
                                            gestorbd.insertarProvinciaArray(codigo, provincia).getModifiedCount()));
                        } else
                        {

                            System.out.println("provincia insertada ");
                        }

                    } else
                    {
                        System.out.println("Comunidad no encontrada en nuestra base de datos");
                    }

                    break;
                case 5:
                    //buscar ccaa
                    System.out.println("introduce código de CCAA");
                    codigo = teclado.nextInt();
                    documento = gestorbd.buscarccaaCodigo(codigo);
                    if (documento != null)
                    //cambiar nombre
                    {
                        System.out.println("teclea nuevo nombre para la ccaa");
                        String ccaa = teclado.nextLine();
                        if (gestorbd.modificarNombreCCAA(codigo, ccaa).getMatchedCount() != 1)
                        {
                            throw new IllegalStateException(
                                    String.format("Error al añadir la provincia(matched= %s, modified= %s).",
                                            gestorbd.modificarNombreCCAA(codigo, ccaa).getMatchedCount(),
                                            gestorbd.modificarNombreCCAA(codigo, ccaa).getModifiedCount()));
                        } else
                        {

                            System.out.println("nombre modificado");
                        }

                    } else
                    {
                        System.out.println("Comunidad no encontrada en nuestra base de datos");
                    }

                    break;
                case 6:
                    //buscar ccaa
                    System.out.println("introduce código de CCAA");
                    codigo = teclado.nextInt();
                    documento = gestorbd.buscarccaaCodigo(codigo);
                    if (documento != null)
                    //borrar provincia del array
                    {
                        System.out.println("teclea provincia a eliminar");
                        String provincia = teclado.nextLine();
                        if (gestorbd.eliminarProvinciaArray(codigo, provincia).getMatchedCount() != 1)
                        {
                            throw new IllegalStateException(
                                    String.format("Error al añadir la provincia(matched= %s, modified= %s).",
                                            gestorbd.eliminarProvinciaArray(codigo, provincia).getMatchedCount(),
                                            gestorbd.eliminarProvinciaArray(codigo, provincia).getModifiedCount()));
                        } else
                        {

                            System.out.println("provincia eliminada");
                        }
                    } else
                    {
                        System.out.println("No existe esa ccaa");
                    }

                    break;
                case 7:
                    //buscar la ccaa
                    codigo = 200;
                    documento = gestorbd.buscarccaaCodigo(codigo);
                    if (documento != null)
                    //ver si la capital es null
                    {
                        Document capital = gestorbd.capitalExiste(codigo);
                        if (capital != null)
                        {
                            System.out.println("la capital ya está insertada en esta base de datos");
                        } else
                        {
                            int habitantes = 100;
                            String nombre = "Gorgoroth";
                            if (gestorbd.crearCapital(codigo, nombre, habitantes).getMatchedCount() != 1)
                            {
                                throw new IllegalStateException(
                                        String.format("Error al añadir la provincia(matched= %s, modified= %s).",
                                                gestorbd.crearCapital(codigo, nombre, habitantes).getMatchedCount(),
                                                gestorbd.crearCapital(codigo, nombre, habitantes).getModifiedCount()));
                            } else
                            {
                                System.out.println("creada y añadida la capital de esta ccaa");
                            }
                        }
                    } else
                    {
                        System.out.println("No existe esa ccaa");
                    }
                    //hay que comprobar si la capital es null
                    //crear el documento capital
                    //asignar esta capital a la Comunidad Autónoma que hemos encontrado
                    break;

                case 8:
                    codigo = 200;
                    documento = gestorbd.buscarccaaCodigo(codigo);
                    if (documento != null)
                    {//crear el atributo fecha_estatuto y asignar el valor
                        System.out.println("procedemos a modificar la ccaa");
                        String fecha="22/02/2022";
                        if (gestorbd.nuevoAtributo(codigo,"fecha_estatuto", fecha).getMatchedCount() != 1)
                        {
                            throw new IllegalStateException(
                                    String.format("Error al añadir la provincia(matched= %s, modified= %s).",
                                            gestorbd.nuevoAtributo(codigo, "fecha_estatuto",fecha).getMatchedCount(),
                                            gestorbd.nuevoAtributo(codigo,"fecha_estatuto",fecha).getModifiedCount()));
                        } else
                        {                            System.out.println("fecha del estatuto añadida");
                        }
                        
                    }
                    else{
                        System.out.println("Comunidad no encontrada");}
                    break;
                case 9:
                  codigo = 200;
                    documento = gestorbd.buscarccaaCodigo(codigo);
                    if (documento != null)
                    {//si existe, imprimir y después eliminar
                        System.out.println(documento.toJson());
                       if (gestorbd.borrarComunidad(codigo).getDeletedCount()!=1)
                        {
                            throw new IllegalStateException(
                                    String.format("Error al añadir la provincia(matched= %s, modified= %s).",
                                            gestorbd.borrarComunidad(codigo).getDeletedCount(),
                                            gestorbd.borrarComunidad(codigo).getDeletedCount()));
                        } else
                        {                            System.out.println("Comunidad Autónoma eliminada");
                        }
                        
                    }
                    else{
                        System.out.println("Comunidad no encontrada");}
                    break;
                default:
                    System.out.println("teclee un número del 0 al 9");
            }

        } while (opcion
                != 0);
    }

    public static Document pedirDatos()
    {
        Scanner teclado = new Scanner(System.in);
        Scanner tecladoStrings = new Scanner(System.in);
        System.out.println("introduce nombre");
        String nombre = tecladoStrings.nextLine();
        System.out.println("introduce código");
        int codigo = teclado.nextInt();
        System.out.println("introduce nombre de la capital");
        String nombreCapital = tecladoStrings.nextLine();
        System.out.println("introduce habitantes de la capital");
        int habitantesCapital = teclado.nextInt();
        System.out.println("introduce abreviatura");
        String abreviatura = tecladoStrings.nextLine();
        System.out.println("introduce habitantes de la Comunidad Autónoma");
        int habitantesComunidad = teclado.nextInt();
        System.out.println("introduce extensión de la Comunidad Autónoma");
        int extension = teclado.nextInt();
        Document doc1 = new Document("codigo", codigo)
                .append("nombre", nombre).append("abreviatura", abreviatura).append("capital", new Document("nombre", nombreCapital).append("habitantes", habitantesCapital))
                .append("habitantes", habitantesComunidad).append("extension", extension);

        return doc1;
    }

}
