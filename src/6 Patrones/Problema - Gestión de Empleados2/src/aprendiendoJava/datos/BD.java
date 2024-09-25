package aprendiendoJava.datos;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

/**
*	La clase BD se responsabiliza de realizar la conexión a la base de datos y de proveer a las clases de DAO de las sentencias necesarias.
*/
public class BD{
	private static final String DRIVER = "org.h2.Driver";
	private static final String URL = "jdbc:h2:file:./data/empresa";

	private static final String SQL_DROP_DEPARTAMENTOS = "DROP TABLE IF EXISTS departamentos";
	private static final String SQL_DROP_EMPLEADOS = "DROP TABLE IF EXISTS empleados";
	private static final String SQL_CREATE_DEPARTAMENTOS = "CREATE TABLE departamentos (id INT PRIMARY KEY, nombre VARCHAR(50), presupuesto FLOAT)"; 
	private static final String SQL_CREATE_EMPLEADOS = "CREATE TABLE empleados (id INT PRIMARY KEY, nombre VARCHAR(50), apellidos VARCHAR(100), fecha_nacimiento DATE, idDepartamento INT)";
	
	private boolean preparada = false;
	private static Connection conexion; //La conexión es común para todos
	private Statement sentencia;
	
	public BD(){
		try {
			Class.forName(DRIVER); 
			BD.conexion = DriverManager.getConnection(URL);
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
			System.exit(-1);
		}catch(SQLException ex){
			ex.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void inicializar(){
		if (this.sentencia == null)
			this.sentencia = this.getSentencia();
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
	
	public Statement getSentencia(){
		if(this.sentencia == null){
			try{
				this.sentencia = BD.conexion.createStatement();
			}catch(SQLException ex){
				ex.printStackTrace();
				System.exit(-1);
			}
		}
		return this.sentencia;
	}
		
	public void cerrar() throws Exception{
		try{
			if (this.sentencia != null)
				this.sentencia.close();
			if (BD.conexion != null)
				BD.conexion.close();
		}catch(SQLException ex){
			ex.printStackTrace();
			throw new Exception("Error al cerrar la base de datos.");
		}
	}
}
 
