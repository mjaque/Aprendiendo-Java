package aprendiendoJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
* Haz un programa que conecte con distintos sistemas de base de datos.
*/

public class Ejercicio {

	public static void main(String[] args) {
		Properties props;

		//Conexión con MySQL
		props = new Properties();
		props.put("user", "root");
		props.put("password", "root");
		try(Connection con = conectar("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/test", props);){
			System.out.println("Conexión con MySQL realizada.");
		}
		catch(ClassNotFoundException ex1){
			ex1.printStackTrace();
		}
		catch(SQLException ex2){
			ex2.printStackTrace();
		}
		
		//Conexión con H2
		props = new Properties();
		try(Connection con = conectar("org.h2.Driver", "jdbc:h2:file:./data/sample;MV_STORE=FALSE;MVCC=FALSE", props);){
			System.out.println("Conexión con H2 realizada.");
		}
		catch(ClassNotFoundException ex1){
			ex1.printStackTrace();
		}
		catch(SQLException ex2){
			ex2.printStackTrace();
		}

		//Conexión con PostgreSQL
		props = new Properties();
		props.put("user", "admin");
		props.put("password", "admin");
		try(Connection con = conectar("org.postgresql.Driver", "jdbc:postgresql://192.168.10.5:5432/test", props);){
			System.out.println("Conexión con PostgreSQL realizada.");
		}
		catch(ClassNotFoundException ex1){
			ex1.printStackTrace();
		}
		catch(SQLException ex2){
			ex2.printStackTrace();
		}

		//Conexión con Oracle
		props = new Properties();
		props.put("user", "admin");
		props.put("password", "admin");
		try(Connection con = conectar("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@localhost:1521:bd1", props);){
			System.out.println("Conexión con Oracle realizada.");
		}
		catch(ClassNotFoundException ex1){
			ex1.printStackTrace();
		}
		catch(SQLException ex2){
			ex2.printStackTrace();
		}

		
    }
    
    private static Connection conectar(String driverName, String url, Properties props) throws SQLException, ClassNotFoundException{
		Class.forName(driverName);
		return DriverManager.getConnection(url, props);
    }
	
}