package aprendiendoJava.datos;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class BD{
	private static final String DRIVER = "org.h2.Driver";
	private static final String URL = "jdbc:h2:file:./data/empresa";

	private static final String SQL_DROP_DEPARTAMENTOS = "DROP TABLE IF EXISTS departamentos";
	private static final String SQL_DROP_EMPLEADOS = "DROP TABLE IF EXISTS empleados";
	private static final String SQL_CREATE_DEPARTAMENTOS = "CREATE TABLE departamentos (id INT PRIMARY KEY, nombre VARCHAR(50), presupuesto FLOAT)"; 
	private static final String SQL_CREATE_EMPLEADOS = "CREATE TABLE empleados (id INT PRIMARY KEY, nombre VARCHAR(50), apellidos VARCHAR(100), fecha_nacimiento DATE, idDepartamento INT)";
	
	private boolean preparada = false;
	private Connection conexion;
	private Statement sentencia;
	
	public BD(){
		try {
			Class.forName(DRIVER); 
			this.conexion = DriverManager.getConnection(URL);
			this.sentencia = this.conexion.createStatement();
			this.preparada = true;
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
			System.exit(-1);
		}catch(SQLException ex){
			ex.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void inicializar(){
		try{
			this.sentencia.execute(SQL_DROP_DEPARTAMENTOS);
			this.sentencia.execute(SQL_DROP_EMPLEADOS);
			this.sentencia.execute(SQL_CREATE_DEPARTAMENTOS);
			this.sentencia.execute(SQL_CREATE_EMPLEADOS);
		}catch(SQLException ex){
			ex.printStackTrace();
			System.exit(-1);
		}
	}
}
 
