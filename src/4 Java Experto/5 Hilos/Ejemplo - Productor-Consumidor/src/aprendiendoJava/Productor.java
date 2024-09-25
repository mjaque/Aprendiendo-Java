package aprendiendoJava;

import java.util.ArrayList;

public class Productor implements Runnable {
	private static int contador = 1;

	private ArrayList<Producto> puntoServicio;
	private int id;

	public Productor(ArrayList<Producto> puntoServicio){
		this.puntoServicio = puntoServicio;
		this.id = contador++;
	}

	@Override
	public void run() {
		//Produciremos 6 productos
		for(int i=0; i < 6; i++){
			//Hacemos que solo un hilo pueda utilizar el punto de servicio
			System.out.println("Productor " + this.id + ": Esperando.");
			synchronized(this.puntoServicio){
				Producto p = new Producto();
				System.out.println("Productor " + this.id + ": Producido producto " + p.getId());
				puntoServicio.add(p);
				this.puntoServicio.notify();	//Avisamos al siguiente hilo para que pueda utilizar el punto de servicio
								//sin esperar a que salgamos del bloque sincronizado.
				try{
					//Dormimos un tiempo aleatorio entre 0 y 1 segundo.
					System.out.println("Productor " + this.id + ": Durmiendo.");
					Thread.sleep((int)(Math.random()*1000));
				}catch(Exception e){}
			}
		}
	}
	
}
