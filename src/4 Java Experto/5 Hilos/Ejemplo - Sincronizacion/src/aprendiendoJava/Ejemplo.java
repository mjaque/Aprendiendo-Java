package aprendiendoJava;

/**
* Cuando varios hilos ejecutan simultáneamente un mismo código pueden producirse dos tipos de errores:
	- Interferencia de Hilos: que puede causar pérdidas de actualizaciones en memoria.
	- Incosistencias de Memoria: causadas por diferencias en el orden de ejecución de instrucciones.
 Para evitar ambas debemos garantizar que, a los bloques críticos de código, no puedan entrar varios hilos a la vez.
 Esto se denomina "sincronización".
*/

public class Ejemplo{

	public static void main(String[] args) {
		//Creamos un objeto que compartirán ambos hilos
		Cuenta cuenta = new Cuenta();

		//Creamos dos hilos Runnables
		Thread hilo1 = new Thread(new HiloRunnable(cuenta));
		Thread hilo2 = new Thread(new HiloRunnable(cuenta));
		
		//Y los lanzamos
		hilo1.start();
		hilo2.start();
		System.out.println("main(): Todos los hilos lanzados.");
		
		//Esperamos a que terminen (join)
		try{
			hilo1.join();
			hilo2.join();
			System.out.println("Ya han terminado todos.");
		}catch(InterruptedException e){
			//Aunque no hay nadie para interrumpirle.
			System.out.println("main(): Me han interrumpido la espera.");
		}
		System.out.println("El saldo de la cuenta es: " + cuenta.getSaldo());
	}
}
