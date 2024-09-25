package aprendiendoJava;

/**
* Crea dos variables de tipo entero. Asigna a la primera el resultado de sumar 2 y 7 y multiplicar el resultado por 5. A la segunda variable asígnale el resto de la división de 235 entre 17. Luego incrementa la primera variable en uno.
*/

public class Ejercicio {

	public static void main(String[] args){
		int a, b;
		a = (2 + 7) * 5;
		b = 235 % 17;
		a++;

		System.out.println("a = " + a + "\nb = " + b);
	}
	
}
