package aprendiendoJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.Properties;


/**
* Haz un programa que conecte con la base de datos del ejemplo anterior y realice la misma consulta del ejercicio anterior. Pero ahora insertará un nuevo registro antes de recorrerlo. Luego, al recorrerlo, si el primer campo entero tiene valor 5, modificará el registro siguiente. Y si tiene valor 10 borrará el registro anterior. Finalmente mostrará todos los registros que quedan por pantalla.
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
			Statement sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = sentencia.executeQuery("SELECT id, texto, fecha FROM Prueba");
			){
		
			//Inserción de registro
			rs.moveToInsertRow();
			rs.updateInt("id", 10);
			rs.updateString("texto", "texto 10");
			rs.updateDate("fecha", new Date(System.currentTimeMillis()));
			rs.insertRow();
			rs.beforeFirst();

			//Recorremos el conjunto de resultados
			while (rs.next()){
				int id = rs.getInt("id");
				if (id == 5)
					if (rs.next()){	//Modificamos el registro siguiente (si existe)
						rs.updateString("texto", "TEXTO MODIFICADO");
						rs.updateRow();
					}
				else if (id == 10){
					if (rs.previous()){	//Borramos el anterior (si existe).
						rs.deleteRow();
						rs.next(); //Nos movemos al siguiente para no volver al 10.
					}
				}
			}
			
			rs.beforeFirst();	//Vamos al principio
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