package academia19e37;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Ref: https://www.oracle.com/technetwork/es/articles/java/procesamiento-streams-java-se-8-2763402-esa.html

public class UsoStreams {

	public static void main(String[] args) throws IOException {
		// Un Stream es una abstracción para procesar datos

		// Podemos obtener un Stream de un Array
		Stream<Integer> s1 = Arrays.stream(new Integer[] { 1, 2, 3, 4 });
		Stream<Integer> s2 = Stream.of(new Integer[] { 1, 2, 3, 4 });
		
		// De un ArrayList
		ArrayList<String> a1 = new ArrayList<>(Arrays.asList(new String[] { "a", "b", "c" }));
		Stream<String> s3 = a1.stream();
		
		// De un fichero
		Stream<String> s4 = Files.lines(Paths.get("fichero.csv"));
		s4.close();		//Conviene cerrar los Streams para liberar recursos.
		
		
		//Algoritmo de Contador
		System.out.println("El stream s1 tiene " + s1.count() + " elementos.");
		//OJO el stream se ha "consumido" y cerrado por la operación final count(). No puede volver a utilizarse.
		
		//Algoritmo de Suma
		//Requiere mapearse a un IntStream, DoubleStream o LongStream para que tenga el método sum()
		System.out.println("El stream s2 suma " + s2.mapToInt(Integer::intValue).sum());
		
		//Algoritmo de Máximo
		System.out.println("El máximo de s3 es " + s3.max(Comparator.comparing(String::valueOf)).get());
		
		//Algoritmo de Filtro
		Stream<Integer> s5 = Arrays.stream(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
		System.out.print("Los pares de s5 son: ");
		s5.filter(n -> {return n%2 == 0;}).forEach(p -> System.out.print(p + " "));
		System.out.println();
	}
}
