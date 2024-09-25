package aprendiendoJava;

/**
* Mediante un algoritmo de backtracking coloca los números del 1 al 5 de forma que no haya dos números consecutivos.
*/

public class Ejercicio {
	private static final int NUM_ELEM = 5;

	public static void main(String[] args){
		int[] lista = new int[NUM_ELEM];	//Inicialmente están todos a cero. Es el punto inicial
		
		for(int pos = 0; pos < lista.length; pos++){	//Para todas las posiciones
			if (probar(lista, pos)){
				System.out.println("Solución: " + ver(lista));
				System.exit(0);
			}
		}
		
		System.out.println("No hay solución.");
	}

	private static boolean probar(int[] lista, int posicion){	//Prueba valores para la posición
		for(int num = 1; num <= NUM_ELEM; num++){
			lista[posicion] = num;
			if (esSolucion(lista))	//Hemos encontrado una solución
				return true;
			if (posicion >= lista.length - 1)	//Hemos llegado al final
				return false;
			if (probar(lista, posicion+1))	//Probamos cambiando la siguiente posición
				return true;
		}
		//Backtracking
		lista[posicion] = 0;	//Lo quitamos y volvemos a probar el siguiente valor de la posición anterior
		return false;
	}
	
	
	private static boolean estaUsado(int[] lista, int num){
		for (int i = 0; i < lista.length; i++)
			if (lista[i] == num)
				return true;
		return false;
	}
	
	private static String ver(int[] lista){
		String resultado = "[";
		for (int i = 0; i < lista.length; i++)
			resultado += lista[i] + " ";
		return resultado + "]";
	}
	
	
/*
	private static boolean esSolucion(int[] lista){
		System.out.println("Valorando: " + ver(lista));
		return true;
	}
*/
	
/*
	private static boolean esSolucion(int[] lista){
		System.out.println("Valorando: " + ver(lista));
		return false;
	}
*/
	
/*
	//Que no haya dos consecutivos
	private static boolean esSolucion(int[] lista){
		System.out.println("Valorando: " + ver(lista));
		for (int i = 1; i < lista.length; i++){
			if (lista[i-1] == lista[i] - 1)
				return false;
		}
		return true; //Fin de la lista
	}
*/
	

	//De mayor a menor
	private static boolean esSolucion(int[] lista){
		System.out.println("Valorando: " + ver(lista));
		if (hayVacios(lista))
			return false;
		if (hayRepetidos(lista))
			return false;
		for (int i = 1; i < lista.length; i++){
			if ((lista[i-1] != 0) && (lista[i] !=0))
				if (lista[i-1] < lista[i])
					return false;
		}
		return true; //Fin de la lista
	}
	
	private static boolean hayVacios(int[] lista){
		for (int i = 1; i < lista.length; i++)
			if (lista[i] == 0)
				return true;
		return false;
	}

	private static boolean hayRepetidos(int[] lista){
		for (int i = 0; i < lista.length - 1; i++)
			for (int j = i+1; j < lista.length; j++)
				if (lista[i] == lista[j])
					return true;
		return false;
	}
	
}