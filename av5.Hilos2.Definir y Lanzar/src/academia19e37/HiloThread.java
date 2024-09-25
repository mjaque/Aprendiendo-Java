package academia19e37;

// Los hilos pueden crearse derivando la clase Thread.
// Es más lógico, pero es preferible implementar Runnable porque es más flexible

public class HiloThread extends Thread{

	@Override
	public void run() {
		System.out.println("Hola, soy un HiloThread.");
	}
}