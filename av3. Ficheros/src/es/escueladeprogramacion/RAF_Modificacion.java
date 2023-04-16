package es.escueladeprogramacion;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class RAF_Modificacion {

	public static void main(String[] args) {
		/* Modificar Objetos en un Fichero */
		String fichero = "datos3.dat";

		// Creamos y Rellenamos la lista
		ArrayList<Clase2> lista = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			lista.add(new Clase2("Texto" + i, i * i));

		// Escribimos el fichero dejando un espacio de 200bytes para cada objeto
		try (FileOutputStream fos = new FileOutputStream(fichero)) {
			int writeLocation = 0;
			for (Clase2 c : lista) {
				// Serializamos el objeto
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream oos2 = new ObjectOutputStream(bos);
				oos2.writeObject(c);
				oos2.flush();
				// Comprobamos que no supera el tamaño
				if (bos.size() > 200)
					throw new Exception("Demasiado grande");
				else { // Lo escribimos
					fos.getChannel().position(writeLocation);
					bos.writeTo(fos);
					writeLocation += 200;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

		// Ahora Leemos
		try (FileInputStream fis = new FileInputStream(fichero)) {
			for (int i = 0; i < 1000; i += 200) {
				fis.getChannel().position(i);
				ObjectInputStream iis = new ObjectInputStream(new BufferedInputStream(fis));
				Clase2 obj = (Clase2) iis.readObject();
				System.out.println("Salida: " + obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		//Modificamos el segundo objeto
		System.out.println("Modificando");
		try (FileOutputStream fos = new FileOutputStream(fichero)) {
			int writeLocation = 200;
			Clase2 obj = new Clase2("Prueba", 42);
			// Serializamos el objeto
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos2 = new ObjectOutputStream(bos);
			oos2.writeObject(obj);
			oos2.flush();
			// Comprobamos que no supera el tamaño
			if (bos.size() > 200)
				throw new Exception("Demasiado grande");
			else { // Lo escribimos
				fos.getChannel().position(writeLocation);
				bos.writeTo(fos);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		// Ahora Leemos
		System.out.println("Leyendo por segunda vez");
		try (FileInputStream fis = new FileInputStream(fichero)) {
			for (int i = 0; i < 4000; i += 200) {
				fis.getChannel().position(i);
				ObjectInputStream iis = new ObjectInputStream(new BufferedInputStream(fis));
				Clase2 obj = (Clase2) iis.readObject();
				System.out.println("Salida: " + obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}

class Clase2 implements Serializable {
	private static final long serialVersionUID = 1L;
	String atrib1;
	int atrib2;

	public Clase2(String atrib1, int atrib2) {
		super();
		this.atrib1 = atrib1;
		this.atrib2 = atrib2;
	}

	@Override
	public String toString() {
		return "Clase2 [atrib1=" + atrib1 + ", atrib2=" + atrib2 + "]";
	}
}
