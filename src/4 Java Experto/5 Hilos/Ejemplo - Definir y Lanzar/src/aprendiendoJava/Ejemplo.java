package aprendiendoJava;

/**
* Ejemplo de definición y lanzamiento de hilos.
*/

public class Ejemplo{

	public static void main(String[] args) {
		//Creamos dos hilos Runnables
		Thread hilo1 = new Thread(new HiloRunnable());
		Thread hilo2 = new Thread(new HiloRunnable());
		
		//Creamos dos hilos Thread
		HiloThread hilo3 = new HiloThread();
		HiloThread hilo4 = new HiloThread();
		
		//Y los lanzamos
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
	}

}