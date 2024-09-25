package aprendiendoJava;

/**
* Haz un programa que genere arrays de números enteros aleatorios y lo ordene utilizando los algoritmos de: selection sort, insertion sort, bubble sort, merge sort, quick sort y heap sort. Mide el tiempo que tarda cada uno
*/

public class Ejercicio {
	static final int TAM = 2500;
	static final int RANGO_MIN = -1000;
	static final int RANGO_MAX = +1000;

	public static void main(String[] args) {
		long tInicial;

		Integer[] lista = new Integer[TAM];

		// SELECTION SORT
		cargar(lista);
		tInicial = System.currentTimeMillis();
		selectionSort(lista);
		mostrar(lista);
		System.out.println("Tiempo Selection Sort: " + (System.currentTimeMillis() - tInicial) + " ms.");

		// INSERTION SORT
		cargar(lista);
		tInicial = System.currentTimeMillis();
		insertionSort(lista);
		mostrar(lista);
		System.out.println("Tiempo Insertion Sort: " + (System.currentTimeMillis() - tInicial) + " ms.");

		// BUBBLE SORT
		cargar(lista);
		tInicial = System.currentTimeMillis();
		bubbleSort(lista);
		mostrar(lista);
		System.out.println("Tiempo Bubble Sort: " + (System.currentTimeMillis() - tInicial) + " ms.");

		// MERGE SORT
		cargar(lista);
		tInicial = System.currentTimeMillis();
		lista = mergeSort(lista);
		mostrar(lista);
		System.out.println("Tiempo Merge Sort: " + (System.currentTimeMillis() - tInicial) + " ms.");

		// QUICK SORT
		cargar(lista);
		tInicial = System.currentTimeMillis();
		quickSort(lista);
		mostrar(lista);
		System.out.println("Tiempo Quick Sort: " + (System.currentTimeMillis() - tInicial) + " ms.");

		// HEAP SORT
		cargar(lista);
		tInicial = System.currentTimeMillis();
		heapSort(lista);
		mostrar(lista);
		System.out.println("Tiempo Heap Sort: " + (System.currentTimeMillis() - tInicial) + " ms.");

	}

	static void cargar(Integer l[]) {
		for (int i = 0; i < l.length; i++)
			l[i] = (int) (Math.random() * (RANGO_MAX - RANGO_MIN) + RANGO_MIN);
	}

	static void mostrar(Integer l[]) {
		System.out.println();
		for (int i = 0; i < l.length; i++)
			System.out.print(l[i] + " ");
		System.out.println();
	}

	static void selectionSort(Integer l[]) {

		// Recorremos todos menos el último
		for (int j = 0; j < l.length - 1; j++) {

			// Buscamos el mínimo del resto de la lista (desde j al final)
			int indiceMin = j;
			for (int i = j + 1; i < l.length; i++) {
				if (l[i] < l[indiceMin])
					indiceMin = i;
			}

			if (indiceMin != j) {
				// Cambiamos l[j] con el mínimo
				Integer aux = l[j];
				l[j] = l[indiceMin];
				l[indiceMin] = aux;
			}
		}
	}

	static void insertionSort(Integer l[]) {
		// Recorremos desde el segundo
		for (int i = 1; i < l.length; i++) {
			int tmp = l[i]; // Guardamos el que estamos mirando
			int j = i - 1;
			while (j >= 0 && tmp < l[j]) { // Miramos los anteriores
				l[j + 1] = l[j]; // Si son mayores, los cambio (muevo hacia la
									// derecha)
				j--;
			}
			l[j + 1] = tmp; // Pongo el guardado
		}
	}

	static void bubbleSort(Integer l[]) {
		boolean cambiado;
		do {
			cambiado = false;
			// Recorro del primero al penúltimo
			for (int i = 0; i < l.length - 1; i++)
				// Si el que estamos mirando es mayor que el siguiente, los
				// cambio
				if (l[i] > l[i + 1]) {
					int aux = l[i];
					l[i] = l[i + 1];
					l[i + 1] = aux;
					cambiado = true;
				}
		} while (cambiado);
	}

	static Integer[] mergeSort(Integer l[]) {

		if (l.length <= 1)
			return l;

		// Como la lista es demasiado larga, la dividimos -> Lista de 10 elemen
		Integer l1[] = mergeDivide(l, 0, l.length / 2 - 1); // 0 -> 4
		Integer l2[] = mergeDivide(l, l.length / 2, l.length - 1); // 5 -> 9

		l1 = mergeSort(l1);
		l2 = mergeSort(l2);

		l = merge(l1, l2);

		return l;
	}

	static Integer[] mergeDivide(Integer l[], int ini, int fin) {
		int tam = fin - ini + 1;
		Integer[] resultado = new Integer[tam];
		for (int i = 0; i < tam; i++)
			resultado[i] = l[ini + i];

		return resultado;
	}

	static Integer[] merge(Integer l1[], Integer l2[]) {
		int tam = l1.length + l2.length;
		Integer[] result = new Integer[tam];

		int i1 = 0, i2 = 0; // Índices sobre l1 y l2
		for (int i = 0; i < tam; i++) { // Índice sobre result

			if (i1 > l1.length - 1) { // Hemos consumido la primera lista
				result[i] = l2[i2];
				i2 = i2 + 1;
			} else if (i2 > l2.length - 1) { // Hemos consumido la segunda lista
				result[i] = l1[i1];
				i1 = i1 + 1;
			} else if (l1[i1] < l2[i2]) {
				result[i] = l1[i1];
				i1 = i1 + 1;
			} else {
				result[i] = l2[i2];
				i2 = i2 + 1;
			}
		}
		return result;
	}

	static void quickSort(Integer l[]) {
		quickSortRecursive(l, 0, l.length - 1);
	}

	static void quickSortRecursive(Integer l[], int derecha, int izquierda) {
		int pivote = l[derecha]; // Cogemos el primero como pivote (optimizable)
		int i = derecha; // i recorrerá la lista de izquierda a derecha.
		int j = izquierda; // i recorrerá la lista de derecha a izquierda.

		// Ordenamos la lista poniendo a la izquierda los menores que el pivote
		// y a la derecha los mayores
		while (i < j) { // Hasta que se crucen las búsquedas
			while (l[i] <= pivote && i < j) // Localizamos el primer elemento de
											// la izquierda mayor que el pivote
				i++;
			while (l[j] > pivote) // Localizamos el primer elemento de la
									// derecha menor que el pivote (si lo hay)
				j--; // si no lo encuentra, para en el pivote

			if (i < j) { // Si no se han cruzado, los cambiamos
				int aux = l[i];
				l[i] = l[j];
				l[j] = aux;
			}
		}
		// Colocamos el pivote en su lugar final en la lista ordenada.
		l[derecha] = l[j];
		l[j] = pivote;

		if (derecha < j - 1)
			quickSortRecursive(l, derecha, j - 1); // Ordenamos la subcadena
													// izquierda
		if (j + 1 < izquierda)
			quickSortRecursive(l, j + 1, izquierda); // Ordenamos la subcadena
														// derecha
	}

	static void heapSort(Integer l[]) {
        
		heapBuild(l);
		int limite = l.length - 1;
        
        for(int i = limite; i > 0; i--){
            //Cambiamos el primer elemento del heap (mínimo) a la última posición (i)
            int aux = l[0];
            l[0] = l[i];
            l[i] = aux;
            heapMax(l, 0, --limite);
        }
	}
	
	static void heapBuild(Integer l[]){
		//Creamos el heap ordenando desde la mitad al principio.
		for (int i = (l.length-1)/2; i >= 0; i--)
			heapMax(l, i, l.length-1);
	}
	
	static void heapMax(Integer l[], int i, int limite){
		//Vemos que nodo es el máximo del padre y sus hijos y los cambiamos
		//Pero no buscamos más allá del límite porque al final del algoritmo
		//iremos poniendo (desde el final) los elementos ordenados
		int izqda = i * 2 + 1;
		int dcha = i * 2 + 2;
		int max = i;		//Suponemos que el máximo es el padre
		
		if (izqda <= limite && l[izqda] > l[max])	//El máximo es el izquierdo
			max = izqda;
		if (dcha <= limite && l[dcha] > l[max])	//El máximo es el de la derecha
			max = dcha;
		
		if (max != i){	//Los cambiamos
			int aux = l[i];
			l[i] = l[max];
			l[max] = aux;
			heapMax(l, max, limite);	//Ordenamos en la posición que hemos cambiado.
		}
	}
}