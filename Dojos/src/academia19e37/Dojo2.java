// Tipos de datos

package academia19e37;

public class Dojo2 {

	public static void main(String[] args) {
		//Encontrar el máximo
		Integer a, b, c;					//Declaramos tres variables de tipo entero con los nombres a, b y c.
		Integer max = null;					//Declaramos una varibale de tipo entero de nombre max.
											//La inicializamos con el valor nulo (no ha sido definido).
		a = (int)(Math.random()*10 + 1);	//Le asignamos a a un número al azar entre 1 y 10.
		b = (int)(Math.random()*10 + 1);	//Le asignamos a b un número al azar entre 1 y 10.
		c = (int)(Math.random()*10 + 1);	//Le asignamos a c un número al azar entre 1 y 10.
		
		System.out.println("Valores: a = " + a + ", b = " + b + ", c = " + c + ".");
		
		//--------------------------------------------------------------------------------------
		//Programa para asignar a la variable max el máximo valor de a, b y c.
		
		
		//--------------------------------------------------------------------------------------		
		System.out.println("El máximo valor de a, b y c es " + max);

	}

}
