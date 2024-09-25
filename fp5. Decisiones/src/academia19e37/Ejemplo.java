package academia19e37;

/**
* Ejemplos de decisiones.
*/

public class Ejemplo{

	public static void main(String[] args) {
		int var = 0;
		
		if (var == 0)	//Decisión simple
			System.out.println("Var es igual a cero.");
		
		if (var == 0)	//Decisión simple
			System.out.println("Var es igual a cero.");
		else
			System.out.println("Var no es igual a cero.");
		
		if ((var > 0) && (var < 10))	//Decisión con operadores booleanos
			System.out.println("Var está entre cero y diez.");
			
		if (var > 0)
			if (var < 10) //ifs anidados
				System.out.println("Var está entre cero y diez.");
		
    }
    
}