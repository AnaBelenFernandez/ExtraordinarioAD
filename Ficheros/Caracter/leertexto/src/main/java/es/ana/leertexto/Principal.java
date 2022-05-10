package es.ana.leertexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Principal
{
    public static void main(String[] args)
    {
        FileReader fr = null;
        try
        {
            File fichero = new File("texto");
            fr = new FileReader(fichero);
            int i;
            while ((i = fr.read()) != -1)
            {
                System.out.print((char) i);
            }
            //con BufferedReader
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String linea;
            System.out.println("lectura con buffered reader --> linea");
            while ((linea = br.readLine()) != null)
            {
                System.out.println(linea);
            }
//escritura con FileWriter
            String frasefw = "Esto es una frase introducida con filewriter";
            FileWriter fw = new FileWriter(fichero, true);
            char[] cad = frasefw.toCharArray();
            for (int f = 0; f < cad.length; f++)
            {
                fw.write(cad[f]);
            }
            fw.close();
            //escribir con BufferedWriter
            String frasebw = "Esto es una frase introducida con BufferedWriter";
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true));
            bw.newLine();
            bw.write(frasebw);
            bw.close();
            //escribir con PrintWriter
            String frasepw="Esto es una frase con PrintWriter";
            PrintWriter pw=new PrintWriter(new FileWriter(fichero, true));
            pw.println();
            pw.println(frasepw);
            pw.close();
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                fr.close();

            } catch (IOException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
