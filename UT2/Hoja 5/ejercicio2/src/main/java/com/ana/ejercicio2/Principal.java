package com.ana.ejercicio2;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author usuario
 */
public class Principal
{
    public static void main(String[] args)
    {
        try
        {
            /*  1.- Datos de artistas más populares en tu país
            2.- 30 mejores temas de un artista
            3.- Datos de 20 artistas más populares de un usuario concreto
            4.- Obtener 10 artistas similares a uno dado*/
            Scanner teclado = new Scanner(System.in);
            int opcion = 30;
            System.out.println("TECLEA UNA OPCIÓN");
            System.out.println("1- Artistas más populares en tu país");
            System.out.println("2- 30 mejores temas de un artista");
            System.out.println("3- 20 artistas más escuchados por alguien");
            System.out.println("4- 10 artistas similares");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion)

            {
                case 1:
                    //indicar cuantos artistas se quieren ver
                    System.out.println("indica el número de artistas");
                    int numero = teclado.nextInt();
                    URL url = new URL("https://ws.audioscrobbler.com/2.0/?method=geo.gettopartists&country=spain&api_key=1b69eab503a0c4b333b88b9947a33709&format=xml&limit=30");
                    URLConnection conexion = url.openConnection();
                    BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                    SAXParserFactory factoria = SAXParserFactory.newInstance();
                    SAXParser parser = factoria.newSAXParser();
                    ArtistaHandler manejador = new ArtistaHandler();
                    //ahora no vamos a leer de un fichero, sino de una URL
                    InputSource is = new InputSource(new URL(url.toString()).openStream());
                    //le pasamos el inputsource y el manejador al parser
                    parser.parse(is, manejador);
                    List<Artista> artistas = manejador.getArtistas();
                    System.out.println("Estos son los " + numero + " artistas más escuchados en España");
                    for (int i = 1; i < numero + 1; i++)
                    {
                        System.out.println(artistas.get(i).toString());
                    }

                    break;
                case 2:
                    //30 mejores temas de un artista
                    System.out.println("Teclea nombre de artista");
                    String artista = teclado.nextLine();
                    String direccion = "https://ws.audioscrobbler.com/2.0/?method=artist.gettoptracks&artist=" + artista + "&api_key=1b69eab503a0c4b333b88b9947a33709&format=xml&limit=30";
                    URL url2 = new URL(direccion);
                    URLConnection conexion2 = url2.openConnection();
                    BufferedReader lector2 = new BufferedReader(new InputStreamReader(conexion2.getInputStream()));
                    SAXParserFactory factoria2 = SAXParserFactory.newInstance();
                    SAXParser parser2 = factoria2.newSAXParser();
                    TrackHandler manejador2 = new TrackHandler();
                    InputSource is2 = new InputSource(new URL(url2.toString()).openStream());
                    parser2.parse(is2, manejador2);
                    List<Track> exitos = manejador2.getExitos();
                    System.out.println("Estos son los temas más escuchados de " + artista);

                    for (Track track : exitos)
                    {
                        System.out.println(track.toString());
                    }
                    break;
                case 3:
                    //20 artistas más escuchados por un usuario con GSON
                    URL url3 = new URL("https://ws.audioscrobbler.com/2.0/?method=user.gettopartists&user=Amusiqueta&api_key=1b69eab503a0c4b333b88b9947a33709&format=json&limit=20");
                    URLConnection conexion3 = url3.openConnection();
                    try (
                             BufferedReader lector3 = new BufferedReader(new InputStreamReader(conexion3.getInputStream())))
                    {
                        Gson gson = new Gson();
                        Topartists artistas3 = gson.fromJson(lector3, Topartists.class);
                        for (Artist a : artistas3.getArtist())
                        {
                            System.out.println(a.toString());
                        }
                        lector3.close();

                    } catch (MalformedURLException ex)
                    {
                        System.out.println("Error " + ex.getMessage());
                    } catch (IOException ex)
                    {
                        System.out.println("Error " + ex.getMessage());
                    }
                    break;
            }
        } catch (MalformedURLException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
