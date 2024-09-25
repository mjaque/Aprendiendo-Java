package academia19e37;

public class AlgoritmosBasicos {
	
	static final int MAX = 10;

	public static void main(String[] args) {
		
		//Creamos un array de enteros aleatorios
		int vector[] = new int[MAX];
		for (int i = 0; i < vector.length; i++)
			vector[i] = (int)(Math.random() * 10);
		
		mostrar(vector);
		
		contador(vector);
		sumador(vector);
		sumaConFiltro(vector);
		maximo(vector);
		bandera(vector);
	}
	
	private static void mostrar(int v[]) {
		System.out.print("Vector: ");
		for (int i = 0; i < v.length; i++)
			System.out.print(v[i] + " ");
		System.out.println();
	}
	
	/**
	 * Algoritmo de contador.
	 * Cuenta el número de elementos del array que cumplen una condición.
	 * @param v
	 */
	private static void contador(int v[]) {
		int contador = 0;						//Inicializamos el contador a cero.
		for (int i = 0; i < v.length; i++) {	//Recorremos los elementos del array
			if (v[i] % 2 == 0) {				//Si se cumple la condición (en este caso "ser par")
				contador++;						//Incremento el contador
			}
		}										//Al finalizar el bucle
												//Muestro el resultado.
		System.out.println("Hay " + contador + " pares en el vector.");	
	}

	/**
	 * Algoritmo sumador.
	 * Suma los elementos de un vector.
	 * @param v
	 */
	private static void sumador(int v[]) {
		int suma = 0;							//Inicializo la suma a cero
		for (int i = 0; i < v.length; i++) {	//Recorremos el array
			suma += v[i];						//Sumo cada elemento
		}
		//Al finalizar el bucle, muestro el resultado
		System.out.println("La suma de elementos es " + suma);
	}
	
	/**
	 * Algoritmo sumador con filtro.
	 * Suma algunos elementos de un vector.
	 * @param v
	 */
	private static void sumaConFiltro(int v[]) {
		int suma = 0;							//Inicializo la suma a cero
		for (int i = 0; i < v.length; i++) {	//Recorremos el array
			if (v[i] % 2 == 0) {				//Si el elemento cumple la condición (en este caso, "ser par")
				suma += v[i];					//Lo sumo
			}
		}
		//Al finalizar el bucle, muestro el resultado
		System.out.println("La suma de los pares es " + suma);
	}
	
	/**
	 * Algoritmo de máximo/mínimo
	 * Encuentra el valor máximo (o mínimo) del vector
	 * 
	 */
	private static void maximo(int v[]) {
		int maximo = v[0];					//Inicializo el máximo/mínimo en el primer elemento del vector
		int pos = 0;						//Si necesito también la posición, la inicializo en cero
		for (int i = 1; i < v.length; i++) {//Recorremos el resto de elementos (nos saltamos el primero)
			if (v[i] > maximo) {			//Miro si el elemento supera al máximo (o al mínimo)
				maximo = v[i];				//Si es así, cambio el máximo
				pos = i;					//Anoto la posición del nuevo máximo/mínimo
			}
		} //Al finalizar el bucle, muestro el resultado
		System.out.println("El máximo es " + maximo);
		System.out.println("Y está en la posición " + pos);
	}
	
	/**
	 * Algoritmo de bandera
	 * Nos indica si se cumple alguna condición
	 */
	private static void bandera(int v[]) {
		//Bandera para detectar si hay algún valor a cero
		boolean hayCero = false;			//Inicializamos la bandera a false
		for (int i = 0; i < v.length; i++) {//Recorremos los elementos del array
			if (v[i] == 0) {				//Si detectamos que se cumple la condición
				hayCero = true;				//Levantamos la bandera
				break;						//Salimos del bucle
			}
		}
		if (hayCero)						//Analizamos el resultado
			System.out.println("Hay algún valor a cero.");
		else
			System.out.println("No hay ningún valor a cero.");
	}	

}
