package aprendiendoJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.Properties;
import java.util.Scanner;
import java.time.ZonedDateTime;
import java.time.ZoneId;


/**
* Haz un programa que presente un menú para gestionar Alumnos con las siguientes opciones: a) Inicializa la base de datos creando una tabla alumno con identificador numérico, nombre, apellidos, fecha de matrícula y nota media (real); b) Pide por pantalla e inserta los datos de un alumno; c) Lista los datos de todos los alumnos; d) Modifica los datos de un alumno; e) Elimina un alumno; f) Busca todos los alumnos cuyos apellidos contengan un texto introducido y los muestra por pantalla; x) Salir.
El programa deberá utilizar sentencias preparadas y transacciones.
*/

public class Ejercicio {
	private static final String DRIVER = "org.h2.Driver";
	private static final String URL = "jdbc:h2:file:./data/alumnos";
	private static Connection conexion;
	private static final PreparedStatement[] ps = new PreparedStatement[10];;
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		try {
			Class.forName(DRIVER); 
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}
	
		try{
			conexion = DriverManager.getConnection(URL);
			
			prepararSentencias();
			
			String opcion;
			do{
				opcion = verMenu();
				switch(opcion){
					case "a":
						inicializar();
						break;
					case "b":
						insertar();
						break;
					case "c":
						listar();
						break;
					case "d":
						modificar();
						break;
					case "e":
						break;
					case "f":
						break;
					case "g":
						break;
					case "x":
						break;
					default:
						System.err.println("Opción Desconocida.");
				}
			}while(!"x".equals(opcion));
			
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}

    }
    
    private static void prepararSentencias() throws SQLException{
		//Preparamos las sentencias que vamos a utilizar 
		ps[0] = conexion.prepareStatement("DROP TABLE IF EXISTS alumnos");
		ps[1] = conexion.prepareStatement("CREATE TABLE alumnos (id INT PRIMARY KEY, nombre VARCHAR(20), apellidos VARCHAR(50), fecha_matricula DATE, nota_media REAL)");
		try{
			//Si no existe todavía la tabla, se producirá una Excepción
			ps[2] = conexion.prepareStatement("INSERT INTO alumnos VALUES(?,?,?,?,?)");
		}catch(SQLException ex){
			inicializar();
		}
		ps[2] = conexion.prepareStatement("INSERT INTO alumnos VALUES(?,?,?,?,?)");
		ps[3] = conexion.prepareStatement("SELECT id, nombre, apellidos, fecha_matricula, nota_media FROM alumnos ");
    }
    
    private static String verMenu(){
		System.out.println("\nMENÚ DE OPERACIONES");
		System.out.println("a) Inicializar.");
		System.out.println("b) Insertar.");
		System.out.println("c) Listar.");
		System.out.println("d) Modificar.");
		System.out.println("e) Borrar.");
		System.out.println("f) Buscar.");
		System.out.println("x) Salir.");
		System.out.print("Opción: ");
		return sc.nextLine();
    }
    
    private static void inicializar() throws SQLException{
		ps[0].execute();
		ps[1].execute();
		System.out.println("Base de datos inicializada.");
    }
    
    private static void insertar() throws SQLException{
		System.out.println("\nDatos del Alumno a INSERTAR:");
		
		System.out.print("Identificador: ");
		ps[2].setInt(1, sc.nextInt());
		
		System.out.print("Nombre: ");
		ps[2].setString(2, sc.next());
		
		System.out.print("Apellidos: ");
		ps[2].setString(3, sc.next());
		
		System.out.print("Fecha de Matrícula (DD-MM-AAAA): ");
		String[] trozos = sc.next().split("-");
        int anio = Integer.parseInt(trozos[2]);
        int mes = Integer.parseInt(trozos[1]) - 1;
        int dia = Integer.parseInt(trozos[0]);
        ZonedDateTime fecha = ZonedDateTime.of(anio, mes, dia, 0, 0, 0, 0, ZoneId.of("CET"));
        Date fechaMatricula = new Date(fecha.toInstant().toEpochMilli());
        ps[2].setDate(4, fechaMatricula);
        
		System.out.print("Nota Media: ");
		ps[2].setDouble(5, sc.nextDouble());

		ps[2].execute();

    }
    
    private static void listar() throws SQLException{
		System.out.println("\nLISTADO de Alumnos:");
		ResultSet rs = ps[3].executeQuery();
		while(rs.next()){
			int id = rs.getInt("id");
			String nombre = rs.getString("nombre");
			String apellidos = rs.getString("apellidos");
			Date fechaMatricula = rs.getDate("fecha_matricula");
			Float notaMedia = rs.getFloat("nota_media");
			System.out.println(id + ": " + nombre + " " + apellidos + " - " + fechaMatricula + " : " + notaMedia);
		}
		rs.close();
    }
    
    private static void modificar() throws SQLException{
		System.out.println("\nMODIFICACIÓN de alumno:");
		
    }
    
}