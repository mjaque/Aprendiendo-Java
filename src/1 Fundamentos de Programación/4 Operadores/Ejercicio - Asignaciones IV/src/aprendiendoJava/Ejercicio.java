package aprendiendoJava;

/**
* Crea tres variables con los valores numéricos que quieras. Ahora incrementa la primera con el valor de la segunda y decrementa la segunda con el valor de la tercera.
*/

public class Ejercicio {

	public static void main(String[] args){
		int a = -17;
		float b = 3E4f;
		double c = -37E-2;

		a += b;
		b -= c;

		System.out.println("a = " + a + "\nb = " + b + "\nc = " + c);
	}
	
}
