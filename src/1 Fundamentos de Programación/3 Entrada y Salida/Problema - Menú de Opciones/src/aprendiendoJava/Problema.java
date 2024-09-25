package aprendiendoJava;

import java.util.Scanner;

/**
* Haz un programa que presente al usuario un "menú de opciones". El menú debe tener un título (el que quieras) y las siguientes opciones: a) Ver clave, b) Cambiar clave, c) Probar clave y d) Salir.
*/

public class Problema {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String opcion;

		System.out.println("\nMENÚ DE OPCIONES\n");
		
		System.out.println("\ta) Ver clave");
		System.out.println("\tb) Cambiar clave");
		System.out.println("\tc) Probar clave");
		System.out.println("\td) Salir");
		System.out.print("\tElige una opción: ");
		opcion = sc.nextLine();
		
		System.out.print("Has elegido " + opcion + "\n");
	}
	
}