package aprendiendoJava;

import java.util.Scanner;

/**
* Haz un programa que le pida al usuario una variable de cada tipo y luego las presente por pantalla.
¡No te olvides de formatear la salida por pantalla para que quede bien!
*/

public class Problema {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String texto;
		int entero;
		double decimal;
		boolean booleano;
		char caracter;

		System.out.print("Dime un texto: ");
		texto = sc.nextLine();
		System.out.println("\nHas dicho: \""+ texto +"\"");

		System.out.print("Dime un entero: ");
		entero = sc.nextInt();
		System.out.println("\nHas dicho el " + entero);

		System.out.print("Dime un número decimal: ");
		decimal = sc.nextDouble();
		System.out.println("\nHas dicho el " + decimal);
		
		System.out.print("Dime un booleano (true/false): ");
		booleano = sc.nextBoolean();
		System.out.println("\nHas dicho " + booleano);
		
		//No es fácil leer solo un caracter con un Scanner
		System.out.print("Pulsa solo una tecla (y ENTER): ");
		caracter = sc.next(".").charAt(0);
		System.out.println("\nHas pulsado '" + caracter + "'");

	}
	
}