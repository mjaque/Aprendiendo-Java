package aprendiendoJava;

/**
* Ejemplos de bucles.
*/

public class Ejemplo{

	public static void main(String[] args) {
		//Ejemplo de bucle for
		for (int i = 0; i < 10; i++)
			System.out.println("i = " + i);
		
		System.out.println();
		
		//Ejemplo de bucle while-do
		int i = 0;
		while(i < 10){
			System.out.println("i = " + i);
			i++;
		}
		
		System.out.println();
		
		//Ejemplo de bucle do-while
		i = 0;
		do{
			System.out.println("i = " + i);
			i++;
		}while(i < 10);
		
		System.out.println();
		
		//Ejemplo de fors anidados
		for (i = 0; i < 10; i++)
			for (int j = 15; j < 20; j++)
				System.out.println("i = " + i + " - j = " + j);
    }
    
}