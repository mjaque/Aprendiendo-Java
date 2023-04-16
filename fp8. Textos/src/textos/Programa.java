package textos;

public class Programa {

	public static void main(String[] args) {
		
		//Declaración de variable de tipo texto
		String texto1;
		
		//Asignación de valor
		texto1 = "abcde";
		
		//Declaración y asignación simultánea
		String texto2 = "12345";
		
		//Longitud
		System.out.println("La longitud de texto1 es " + texto1.length());
		
		//Carácter en una posición. Se empiezan a numerar en 0.
		System.out.println("El carácter en la posición 3 de texto1 es " + texto1.charAt(3 - 1));
		
		//Concatenar
		System.out.println("La concatenación de texto1 y texto 2 es " + texto1 + texto2);
		
		//Substring
		System.out.println("El substring de texto1 de la posición 2 a la 4 es " + texto1.substring(1, 4));
		System.out.println("El substring de texto1 de la posición 2 a la 4 es " + mi_substring(texto1, 1, 4));
		
		//Encontrar un carácter en un texto
		
		//Dividir un texto. 
		texto1 = "En un lugar de la Mancha de cuyo nombre no quiero acordarme";
		// Vamos a encontrar la tercera palabra del texto
		System.out.println("La tercera palabra de texto1 es " + texto1.split(" ")[2]);
		System.out.println("La tercera palabra de texto1 es " + mi_split(texto1, ' ')[2]);
		
	}

	public static String mi_substring(String texto, int inicio, int fin){
	
		String resultado = "";
		
		for (int i = inicio; i < fin; i++)
			resultado += texto.charAt(i);
	
		return resultado;
	}

	public static String[] mi_split(String texto, char separador){
		String[] resultado = null;
		String palabra = "";
		int indice = 0;
		
		for (int i = 0; i < texto.length(); i++){
			
		}
		
		return resultado;
	}
}
