package aprendiendoJava;

// Los hilos pueden crearse derivando la clase Thread.
// Es más lógico, pero es preferible implementar Runnable porque es más flexible

public class HiloThread extends Thread{

	private String nombre;

	public HiloThread(String nombre){
		this.nombre = nombre;	//Nos servirá para identificar los hilos en la ejecución
	}

	@Override
	public void run() {
		System.out.println("Hola, soy " + this.nombre + ".");
		
		for(int i=0; i < 5; i++){
			System.out.println(this.nombre + ": durmiendo(" + i + ").");
			
			//durmiendo el Thread durante 2 segundos.
			try{
				Thread.sleep(2000);	
			}catch(InterruptedException e){
				System.out.println(this.nombre + ": Me han interrumpido la siesta.");
			}
			
			System.out.println(this.nombre + ": despertando(" + i + ").");
		}
	}
}