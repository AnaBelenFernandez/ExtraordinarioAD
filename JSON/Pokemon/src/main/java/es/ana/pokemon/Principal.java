package es.ana.pokemon;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Pokemon;

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
            Scanner teclado = new Scanner(System.in);
            System.out.println("Teclea nombre de pokemon");
            String pokemon = teclado.nextLine();
            URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + pokemon);
            System.out.println(url);
            URLConnection conexion = url.openConnection();
            try (
                     BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream())))
            {
                Gson gson = new Gson();
                Pokemon objeto = gson.fromJson(lector, Pokemon.class);
                System.out.println(objeto.toString());
                lector.close();
            }

        } catch (MalformedURLException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }}}

    
