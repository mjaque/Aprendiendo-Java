package aprendiendoJava;

// Los hilos pueden crearse implementando el interafaz Runnable.
// Es la mejor opción
public class HiloRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Hola, soy un HiloRunnable.");
	}
	
}