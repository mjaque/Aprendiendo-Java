package es.escueladeprogramacion;

import java.io.File;
import java.io.RandomAccessFile;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class FicherosAccesoAleatorio {

	public static void main(String[] args) {
		String texto = "Texto de prueba";
		int entero = -346;
		float real1 = 3.141592f;
		double real2 = 6.022E23;
		boolean booleano = true;
		
		//Podemos leer y escribir al mismo tiempo (sin cerrar el flujo
		try(RandomAccessFile raf = new RandomAccessFile(new File("datos2.dat"), "rw")){
			//Podemos escribir cualquier dato básico.
			raf.writeUTF(texto);
			raf.writeInt(entero);
			raf.writeFloat(real1);
			raf.writeDouble(real2);
			raf.writeBoolean(booleano);
			
			//Y podemos leer
			raf.seek(0);
			System.out.println(raf.readUTF());
			entero = raf.readInt();
			System.out.println(entero);
			real1 = raf.readFloat();
			System.out.println(real1);
			real2 = raf.readDouble();
			System.out.println(real2);
			booleano = raf.readBoolean();
			System.out.println(booleano);
			
			//readObj
			
			//Pero su verdadera potencia está en que podemos escribir directamente en cualquier sitio
			
			raf.seek(texto.getBytes().length + 2);	//Colocamos el puntero después del texto
													//No sé de dónde salen estos dos. ¿Carácter de fin de string?
			raf.writeInt(37);
			raf.seek(texto.getBytes().length + 2);
			System.out.println(raf.readInt());
			System.out.println(raf.readFloat());
			
		}catch(Exception e) {
			
		}

	}

}
