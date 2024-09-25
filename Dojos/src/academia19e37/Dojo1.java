// ¿Eres capaz de cambiar el valor de dos variables

package academia19e37;

public class Dojo1 {

	public static void main(String[] args) {
		Integer a, b;							//Declaramos dos variables de tipo entero con los nombres a y b.
		a = (int)(Math.random()*10 + 1);	//Le asignamos a a un número al azar entre 1 y 10.
		b = (int)(Math.random()*10 + 1);	//Le asignamos a b un número al azar entre 1 y 10.
		
		System.out.println("El valor de a es " + a + " y el valor de b es " + b + ".");

		// Programa entre estas dos líneas para intercambiar los valores de a y b.
		//------------------------------------------------------------------------------

		
		
		//------------------------------------------------------------------------------
		System.out.println("Ahora han cambiado de valor:");
		System.out.println("El valor de a es " + a + " y el valor de b es " + b + ".");
	}

}
