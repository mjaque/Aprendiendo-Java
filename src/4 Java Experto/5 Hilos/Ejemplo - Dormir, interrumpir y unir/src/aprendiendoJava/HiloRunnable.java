package aprendiendoJava;

// Los hilos pueden crearse implementando el interafaz Runnable.
// Es la mejor opción
public class HiloRunnable implements Runnable {

	private String nombre;

	public HiloRunnable(String nombre){
		this.nombre = nombre;	//Nos servirá para identificar los hilos en la ejecución
	}

	@Override
	public void run() {
		System.out.println("Hola, soy " + this.nombre + ".");
		
		for(int i=0; i < 5; i++){
			System.out.println(this.nombre + ": durmiendo(" + i + ").");
			
			//durmiendo el Thread durante 1 segundo.
			try{
				Thread.sleep(1000);	
			}catch(InterruptedException e){
				System.out.println(this.nombre + ": Me han interrumpido la siesta.");
			}
			
			System.out.println(this.nombre + ": despertando(" + i + ").");
		}
	}
	
}