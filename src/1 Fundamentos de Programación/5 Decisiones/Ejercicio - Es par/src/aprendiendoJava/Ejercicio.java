package aprendiendoJava;

/**
* Haz un programa que le pida al usuario un número y le indique si el número es par.
*/

import java.util.Scanner;

public class Ejercicio{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;

		System.out.print("Indique un número entero: ");
		num = sc.nextInt();
		
		if (num % 2 == 0)
			System.out.println("El número es par.");
		else
			System.out.println("El número es impar.");
	}
    
}
