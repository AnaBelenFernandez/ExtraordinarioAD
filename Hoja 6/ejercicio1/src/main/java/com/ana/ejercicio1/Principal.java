package com.ana.ejercicio1;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author usuario
 */
public class Principal {
    public static void main(String[] args)
    {
            /*Utilizando las clases de Java NIO.2 y la API Stream, muestra un listado encolumnado
con los datos de todos los futbolistas del fichero.*/
        Futbolista futbolista=new Futbolista();
        futbolista.setAltura(1.78f);
        futbolista.setApellidos("Fernández");
        futbolista.setNombre("Rocío");
        futbolista.setPuesto(Puesto.PORTERO);
        futbolista.setCodEquipo("MAD");
        futbolista.setFechaNac(LocalDate.of(1983, Month.MARCH, 13));
        futbolista.setId(01);
        System.out.println(futbolista.toString());
        System.out.println(futbolista.toCSV());
    }

}
