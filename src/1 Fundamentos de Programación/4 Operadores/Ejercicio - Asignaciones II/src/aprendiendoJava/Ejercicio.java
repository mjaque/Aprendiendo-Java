package aprendiendoJava;

/**
* Crea dos variables. A la primera asígnale el valor 6.4. Y a la segunda asígnale el resultado de comparar si el valor de la primera variable es distinto de la suma de 2.35 y 4.05.
*/

public class Ejercicio {

	public static void main(String[] args){
		float a;
		boolean b;
		a = 6.4f;
		b = (a != (2.35 + 4.05));

		System.out.println("a = " + a + "\nb = " + b);
	}
	
}
