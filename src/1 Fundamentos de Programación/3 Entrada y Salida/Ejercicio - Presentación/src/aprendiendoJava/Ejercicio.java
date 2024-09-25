package aprendiendoJava;

/**
* Haz un programa que "te presente". Para ello, define todas las variables que necesites para describirte (nombre, apellidos, altura, edad, ciudad...) y escribe las instrucciones necesarias para que esa información aparezca en la pantalla bien formateada.
¡No te olvides de formatearla bien!
*/

public class Ejercicio {

	public static void main(String[] args){
		String nombre = "Miguel";
		String apellido = "Jaque";
		double altura = 1.68; //metros
		int edad = 48;	//años
		String ciudad = "Badajoz";

		System.out.println("Hola, me llamo " + nombre + " " + apellido + ". Y vivo en " + ciudad + ".");
		System.out.println("Tengo " + edad + " años y mido " + altura + "m.");
	}
	
}