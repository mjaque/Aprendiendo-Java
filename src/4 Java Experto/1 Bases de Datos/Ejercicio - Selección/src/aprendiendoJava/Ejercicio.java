package aprendiendoJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.Properties;

/**
* Haz un programa que conecte con la base de datos del ejemplo anterior y muestre por pantalla el contenido de todas sus filas.
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
			ResultSet rs = sentencia.executeQuery("SELECT id, texto, fecha FROM Prueba");
			){
		
			while (rs.next()){
				int id = rs.getInt("id");
				String texto = rs.getString(2);	//Las columnas se numeran desde el 1
				Date fecha = rs.getDate("fecha");
				System.out.println("id: " + id + " texto: " + texto + " fecha: " + fecha);
			}
			
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}

    }
    
}