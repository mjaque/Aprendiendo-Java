package es.escueladeprogramacion;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FicherosBinarios {

	public static void main(String[] args) {
		
		//Uso de ficheros binarios (de datos)
		
		//Escritura utilizando FileOutputStream y BufferedOutputStream
		//Datos básicos a escribir en el fichero
		String texto = "Texto de prueba";
		int entero = -346;
		float real1 = 3.141592f;
		double real2 = 6.022E23;
		boolean booleano = true;
		
		try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("datos.dat"))))){
			//Añadimos true al constructor de FileOutputStream para anexar al fichero.
			dos.writeUTF(texto);
			dos.writeInt(entero);
			dos.writeFloat(real1);
			dos.writeDouble(real2);
			dos.writeBoolean(booleano);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Lectura
		try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("datos.dat"))))){
			texto = dis.readUTF();
			System.out.println(texto);
			entero = dis.readInt();
			System.out.println(entero);
			real1 = dis.readFloat();
			System.out.println(real1);
			real2 = dis.readDouble();
			System.out.println(real2);
			booleano = dis.readBoolean();
			System.out.println(booleano);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Lectura hasta fin del fichero
		try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("datos.dat"))))){
			//Naturalmente no sabemos el tipo, pero podemos leer los bytes.
			while(dis.available() > 0) {
				System.out.println(dis.read());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
