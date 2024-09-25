package academia19e37;

/**
* Haz un método que reciba un array de enteros ordenado de menor a mayor y un valor y devuelva la posición del valor en el array. Si el valor no se encuentra en el array, devolverá la posición del primer elemento que supere al valor dado.
*/

public class BusquedaBinaria {

	public static void main(String[] args){
		int[] lista = new int[] {3,9,16,22,24,31,41,49,53,67,69,70}; 
		System.out.println("Posición de 24: " + buscar(lista, 24));
		System.out.println("Posición de 40: " + buscar(lista, 40));
		System.out.println("Posición de 0: " + buscar(lista, 0));
		System.out.println("Posición de 3: " + buscar(lista, 3));
		System.out.println("Posición de 70: " + buscar(lista, 70));
		System.out.println("Posición de 71: " + buscar(lista, 71));
	}
	
	private static int buscar(int[] lista, int valor){
            int inf = 0;
            int sup = lista.length - 1;
            while (inf <= sup) {
                // Buscamos valor en la lista
                int med = inf + (sup - inf) / 2;
                if (valor < lista[med])
                        sup = med - 1;
                else 
                        if (valor > lista[med]) 
                                inf = med + 1;
                        else
                                return med;
            }
            return inf; //No encontrado
	}
	
}