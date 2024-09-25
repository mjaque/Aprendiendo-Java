package aprendiendoJava;

/**
* Ejemplos de Singleton
*/

public class Ejemplo{
	
	public static void main(String[] args) {
		Singleton.INSTANCE.metodo();
		
		//La segunda vez no se ejecuta el constructor
		Singleton.INSTANCE.metodo();
	}

}