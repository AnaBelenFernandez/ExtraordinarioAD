package es.ana.pokemon;

import com.example.ListaPokemon;
import com.example.Result;
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
import pojos.Ability;
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
                //sacar las habilidades de un pokemon
                System.out.println("habilidades de " + pokemon);
                List<Ability> habilidades = objeto.getAbilities();
                for (Ability habilidade : habilidades)

                {
                    System.out.println(habilidade.toString());
                }
                lector.close();
                URL urlLista = new URL("https://pokeapi.co/api/v2/pokemon?limit=10&offset=0");
                URLConnection conexionLista = urlLista.openConnection();
                try (
                         BufferedReader lectorLista = new BufferedReader(new InputStreamReader(conexionLista.getInputStream())))
                {
                    Gson gsonLista = new Gson();
                    ListaPokemon lista = gson.fromJson(lectorLista, ListaPokemon.class);
                    List<Result> Pokemons=lista.getResults();
                    for (Result Pokemon : Pokemons)
                    {
                        System.out.println(Pokemon.getName()+"\n");
                    }
                    
                    lectorLista.close();
                }

            } catch (MalformedURLException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (MalformedURLException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }}
