package es.escueladeprogramacion;

/* Jerarquía de clases

 java.lang.Object
 	java.io.Writer (abstract) 			- Escribe streams de caracteres. 
 		java.io.OutputStreamWriter		- Convierte streams de caracteres en streams de bytes. Hace la codificación
 			java.io.FileWriter 			- Clase de conveniencia para escribir ficheros de caracteres. Usa codificación por defecto.
 		java.io.BufferedWriter 			- Buferea caracteres para escribirlos en streams de salida de caracteres.
 		
 	java.io.Reader	(abstract) 			-
 		java.io.InputStreamReader		-
 			java.io.FileReader			-
 		java.io.BufferedReader			-
 	
 	java.io.OutputStream (abstract) 	- Representa un stream de salida de datos.
 		java.io.FileOutputStream 		- Escribe datos a un fichero.
 		java.io.FilterOutputStream		- Superclase para todas las clases de filtros de streams de datos.
 			java.io.BufferedOutputStream- Permite bufferear operaciones de escritura.
 			java.io.DataOutputStream	- Permite escribir tipos básicos en streams de datos.
 		
 	java.io.InputStream (abstract) 		- Representa un stream de entrada de datos.
 	 	java.io.FileInputStream 		- Obtiene un stream de bytes desde un fichero.
 	 	java.io.FilterInputStream		- Superclase para todas las clases de filtros de streams de datos.
 	 		java.io.BufferedInputStream	- Permite bufferear operaciones de lectura.
 			java.io.DataInputStream		- Permite escribir leer básicos en streams de datos.
 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FicherosTexto {

	public static void main(String[] args) {
		
		//Uso de ficheros de texto
		
		//Escritura directa utilizando Files
		Path path = Paths.get("datos1.txt");
		String texto1 = "Líneas de Prueba" + System.getProperty("line.separator") + "Segunda Línea";
		byte[] bytes = texto1.getBytes(StandardCharsets.UTF_8);
		try {
			Files.write(path, bytes);
			//Tercer parámetro: opciones. Como StandardOpenOption.APPEND (https://docs.oracle.com/javase/7/docs/api/java/nio/file/StandardOpenOption.html)
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//Lectura directa utilizando Files
		try {
			List<String> lineas = Files.readAllLines(path, StandardCharsets.UTF_8);
			for(String linea : lineas)
				System.out.println(linea);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//Escritura utilizando FileWriter y BufferedWriter
		//Datos básicos a escribir en el fichero
		String texto2 = "Texto de prueba";
		int entero = -346;
		float real1 = 3.141592f;
		double real2 = 6.022E23;
		boolean booleano = true;
		
		//FileWriter utiliza solo la codificación por defecto del sistema.
		//añadir true al FileWriter para APPENDry
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("datos.txt")))){
			//añadir true al constructor de FileWriter si vamos a anexar
			bw.write(texto2 + System.getProperty("line.separator"));
			bw.write(String.valueOf(entero) + System.getProperty("line.separator"));
			bw.write(String.valueOf(real1) + System.getProperty("line.separator"));
			bw.write(String.valueOf(real2) + System.getProperty("line.separator"));
			bw.write(String.valueOf(booleano) + System.getProperty("line.separator"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Lectura utilizando FileReader y BufferedReader
		try(BufferedReader br = new BufferedReader(new FileReader(new File("datos.txt")))){
			System.out.println(br.readLine());
			//readLine() lee hasta el fin de línea.
			//BufferedReader.read() lee un único carácter
			int valor1 = Integer.valueOf(br.readLine());	//Lo que no sean Strings hay que transformarlos
			System.out.println(valor1);
			System.out.println(Float.valueOf(br.readLine()));
			System.out.println(Double.valueOf(br.readLine()));
			System.out.println(Boolean.valueOf(br.readLine()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Puedo leer ficheros de texto con Scanner sc = new Scan
		
		//Lectura hasta fin del fichero
		try(BufferedReader br = new BufferedReader(new FileReader(new File("datos.txt")))){
			String linea;
			while( (linea = br.readLine()) != null) {	//Leemos cada línea hasta el final del fichero
				System.out.println(linea);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
