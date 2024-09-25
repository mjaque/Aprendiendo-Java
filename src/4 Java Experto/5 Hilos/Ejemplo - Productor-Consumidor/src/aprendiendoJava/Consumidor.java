package aprendiendoJava;

import java.util.ArrayList;

public class Consumidor implements Runnable {
	private static int contador = 1;

	private ArrayList<Producto> puntoServicio;
	private int id;

	public Consumidor(ArrayList<Producto> puntoServicio){
		this.puntoServicio = puntoServicio;
		this.id = contador++;
	}

	@Override
	public void run() {
		//Consumimos 4 productos
		for(int i=0; i < 4; i++){
			//Hacemos que solo un hilo pueda utilizar el punto de servicio
			synchronized(this.puntoServicio){
				while (puntoServicio.size() == 0){	//Si no hay productos
					try{
						System.out.println("Consumidor " + this.id + ": Esperando.");
						puntoServicio.wait();	//Liberamos el punto de servicio y esperamos un notify
					}catch(Exception e){};
				}
				Producto p = puntoServicio.remove(0);	//Cogemos el primero y lo quitamos del punto de servicio.
				this.puntoServicio.notify();	//Avisamos al siguiente hilo para que pueda utilizar el punto de servicio
								//sin esperar a que salgamos del bloque sincronizado.
				System.out.println("Consumidor " + this.id + ": Consumido producto " + p.getId());
				try{
					System.out.println("Consumidor " + this.id + ": Durmiendo.");
					//Dormimos un tiempo aleatorio entre 0 y 1 segundo.
					Thread.sleep((int)(Math.random()*1000));
				}catch(Exception e){};
			}
		}
	}
	
}
