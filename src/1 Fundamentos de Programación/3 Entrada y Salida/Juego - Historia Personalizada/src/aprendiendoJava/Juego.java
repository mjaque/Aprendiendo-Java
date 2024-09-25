package aprendiendoJava;

import java.util.Scanner;

/**
* Haz un programa que pregunte al usuario algunos datos personales (como su nombre, edad, ciudad en la que vive, color favorito, etc.). Luego utiliza esa información para crear una historia personalizada.
*/

public class Juego {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String nombre;
		String ciudad;
		int num;

		System.out.println("\nHAZ TU HISTORIA\n");
		
		System.out.print("Por favor, dime tu nombre: ");
		nombre = sc.nextLine();
		System.out.print("¿En qué ciudad quieres que transcurra la historia? ");
		ciudad = sc.nextLine();
		System.out.print("Y por último, dime un número: ");
		num = sc.nextInt();
		
		System.out.println("\nUn día que hacía mucho calor, " + nombre + " se fue a dar un paseo junto al río.");
		System.out.print("\nEl calor apretaba y " + nombre + " se entretuvo contando los patos del río. Había " + num + ".");
		System.out.println(" Así que pensó, \"Con este calor, mejor me voy a tomar " + num + " helados y dejo el paseo para otro día\".");
		System.out.println("\nY dicho y hecho. " + nombre + " fue a la heladería y se zampó " + num + " helados de pistacho (su favorito).\n\n");
	}
	
}