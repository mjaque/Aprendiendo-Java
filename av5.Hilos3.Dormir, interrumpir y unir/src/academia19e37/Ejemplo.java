package academia19e37;

/**
* Ejemplo de dormir e interrumpir.
*/

public class Ejemplo{

	public static void main(String[] args) {
		//Creamos dos hilos Runnables
		Thread hilo1 = new Thread(new HiloRunnable("Hilo 1"));
		Thread hilo2 = new Thread(new HiloRunnable("Hilo 2"));
		
		//Creamos dos hilos Thread
		HiloThread hilo3 = new HiloThread("Hilo 3");
		HiloThread hilo4 = new HiloThread("Hilo 4");
		
		//Y los lanzamos
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo3.interrupt();	//Interrrumpimos la siesta de hilo3.
		
		System.out.println("main(): Todos los hilos lanzados.");
		
		//Esperamos a que terminen (join)
		try{
			hilo1.join(500);	//Esperamos medio segundo a que termine hilo1
		
			//Como no ha terminado, esperamos infinitamente a que terminen todos
			hilo1.join();
			hilo2.join();
			hilo3.join();
			hilo4.join();
		
			System.out.println("Ya han terminado todos.");
		}catch(InterruptedException e){
			//Aunque no hay nadie para interrumpirle.
			System.out.println("main(): Me han interrumpido la espera.");
		}
		
	}

}