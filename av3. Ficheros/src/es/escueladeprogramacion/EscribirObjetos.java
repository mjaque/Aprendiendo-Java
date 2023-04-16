package es.escueladeprogramacion;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class EscribirObjetos {

	public static void main(String[] args) {

		File fichero = new File("datosObjeto.dat");
		
		//Escribimos un objeto en el fichero
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)))) {
			Clase objeto = new Clase();
			objeto.atributo1 = "Valor Atributo 1";
			objeto.atributo2 = -237;
			oos.writeObject(objeto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//Leemos un objeto del fichero
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichero)))) {
			Clase objeto2 = (Clase) ois.readObject();
			System.out.println(objeto2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Escribimos varios objetos en el fichero
		//Nota: No es posible "añadir" objetos a un fichero utilizando ObjectOutputStream,
		//si después de cerrar el stream se vuelve a abrir para añadir, se produce un StreamCorruptedException
		//una solución es sobreescribir el método ObjectOutputStreamwriteStreamHeader() para que no escriba la cabecera (header)
		//para eso basta que haga reset(). Cfr. https://stackoverflow.com/questions/1194656/appending-to-an-objectoutputstream/1195078#1195078
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)))) {
			for (int i = 0; i < 5; i++) {
				Clase objeto = new Clase();
				objeto.atributo1 = "Valor " + i;
				objeto.atributo2 = i;
				oos.writeObject(objeto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Leemos varios objetos en el fichero
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichero)))) {
			while(true) {
				Clase objeto2 = (Clase) ois.readObject();
				System.out.println(objeto2);
			}
		}catch (EOFException e) {
			System.out.println("Fin del fichero.");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Fin del Programa.");
	}
}

class Clase implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String atributo1;
	int atributo2;
	
	@Override
	public String toString() {
		return "Clase [atributo1=" + atributo1 + ", atributo2=" + atributo2 + "]";
	}
}
