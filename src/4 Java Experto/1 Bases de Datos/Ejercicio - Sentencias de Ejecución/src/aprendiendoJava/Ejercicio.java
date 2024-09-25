package aprendiendoJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
* Haz un programa que conecte con una base de datos, cree una sentencia y la utilice para crear una tabla con tres columnas (entero, texto, fecha), insertar en ella 5 registros, borrar el tercero y modificar el cuarto.
*/

public class Ejercicio {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/test";

	public static void main(String[] args) {
		
		try {
			Class.forName(DRIVER); 
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}
	
		Properties propiedades = new Properties();
		propiedades.put("user", "root");
		propiedades.put("password", "root");
		try(
			Connection conexion = DriverManager.getConnection(URL, propiedades);
			Statement sentencia = conexion.createStatement();
			){
		
			sentencia.execute("DROP TABLE IF EXISTS Prueba");
			sentencia.execute("CREATE TABLE Prueba (id INT PRIMARY KEY, texto VARCHAR(50), fecha DATE)");
			sentencia.execute("INSERT INTO Prueba VALUES (1, 'texto 1', '2001-01-01')");
			sentencia.execute("INSERT INTO Prueba VALUES (2, 'texto 2', '2002-02-02')");
			sentencia.execute("INSERT INTO Prueba VALUES (3, 'texto 3', '2003-03-03')");
			sentencia.execute("INSERT INTO Prueba VALUES (4, 'texto 4', '2004-04-04')");
			sentencia.execute("INSERT INTO Prueba VALUES (5, 'texto 5', '2005-05-05')");
			sentencia.execute("DELETE FROM Prueba WHERE id = 3");
			sentencia.execute("UPDATE Prueba SET texto = 'texto Corregido' WHERE id = 4");
			
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}

    }
    
}