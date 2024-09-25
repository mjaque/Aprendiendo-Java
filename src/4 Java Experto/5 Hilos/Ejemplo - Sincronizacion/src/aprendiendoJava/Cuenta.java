package aprendiendoJava;

public class Cuenta{

	private int saldo = 0;

	public void ingresar(int cantidad){
		// Este método lo programamos así para facilitar la interferencia de hilos
		try{
			int tmp = saldo;
			Thread.sleep(100);
			saldo = tmp + cantidad;
		}catch(Exception e){};
	}
	
	// Evitamos la interferencia sincronizando el método.
	// Un método sincronizado solo puede ser ejecutado por un hilo cada vez.
	public synchronized void ingresarSincronizado(int cantidad){
		try{
			int tmp = saldo;
			Thread.sleep(100);
			saldo = tmp + cantidad;
		}catch(Exception e){};
	}

	// También podemos sincronizar solo un bloque de código.
	public void ingresarBloqueSincronizado(int cantidad){
		try{
			synchronized(this){	//Utilizamos el propio objeto como monitor/semáforo
				int tmp = saldo;
				Thread.sleep(100);
				saldo = tmp + cantidad;
			}
		}catch(Exception e){};
	}

	public int getSaldo(){
		return this.saldo;
	}
}
