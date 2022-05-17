package es.anafernandez.hoja3ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:postgresql://192.168.0.1/concursomusica.db");
		} catch (ClassNotFoundException ex) {
			System.err.println("Error al cargar el driver");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
