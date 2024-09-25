package aprendiendoJava;

import java.util.List;
import java.util.ArrayList;

/**
* Vamos a probar las dos implementaciones de Listas que incluye la versión estándar de Java: ArrayList y LinkedList.		
*/

public class Ejercicio {

	public static void main(String[] args){
	
		// ArrayList - Se comporta como un array
	
		List<String> lista1;		// Creamos una variable de tipo List de Strings
		lista1 = new ArrayList<>();	// La instanciamos como un ArraList. No hace ya falta decir que es de Strings.
		
		String s1 = "Hola", s2 = "Mundo;	//Creamos dos variables de tipo String
		
		// Añadimos los Strings a la lista
		lista1.add(s1);
		lista1.add(" ");	// podemos añadir literales.
		lista1.add(s2);
		lista1.add(s2);		//podemos repetir elementos.
		
		System.out.println("lista1 tiene " + lista1.size() + " elementos.");	// El método size nos dice el número de elementos de la lista
		
		// Operaciones con Listas.
		
		
		
		// LinkedList
		// Incluye los métodos: addFirst, getFirst, removeFirst, addLast, getLast y removeLast. 
		// También implementa el interfaz de Queue.
		
		
		
		
		// DIFERENCIAS:
		// ArrayList es mas normalmente más rápida que LinkedList porque no tiene que crear nuevos nodos.
		// Usamos LinkedList si insertamos frecuentemente al principio de la lista o si iteramos frecuentemente para eliminar
		// Tiempos:			ArrayList	LinkedList
		//	Acceso a Elemento: 	Constante	O(n)
		//	Inserción al Principio:	O(n)		Constante
		//	Búsqueda y Borrado:	O(n)		Constante
		//	
	
}