package academia19e37;

import java.util.ArrayList;

/**
	Uno de los ejemplos más habituales de problemas de sincronización es el de Productor/Consumidor.
	En este problema uno o varios productores generan objetos que son consumidos por uno o varios consumidores.
	Cuando los consumidores van a consumir deben esperar a que se hayan producido los productos.
	Y naturalmente no deben interferir entre ellos.

	El punto crítico está en sincronizar adecuadamente el punto donde los productores dejan su productos y de
	donde los consumidores deben recogerlos. En este ejemplo utilizaremos un ArrayList de nombre puntoServicio.
*/

public class Ejemplo{

	public static void main(String[] args) {
		//Creamos el punto de servicio
		ArrayList<Producto> puntoServicio = new ArrayList<>();		

		//Creamos dos productores. Cada uno en su hilo y con una referencia al punto de servicio
		Thread p1 = new Thread(new Productor(puntoServicio));
		Thread p2 = new Thread(new Productor(puntoServicio));

		//Creamos tres consumidores
		Thread c1 = new Thread(new Consumidor(puntoServicio));
		Thread c2 = new Thread(new Consumidor(puntoServicio));
		Thread c3 = new Thread(new Consumidor(puntoServicio));

		//Y los lanzamos
		c1.start();
		c2.start();
		c3.start();
		p1.start();
		p2.start();
		System.out.println("main(): Todos los hilos lanzados.");
		
		//Esperamos a que terminen (join)
		try{
			c1.join();
			c2.join();
			c3.join();
			p1.join();
			p2.join();
			System.out.println("Ya han terminado todos.");
		}catch(InterruptedException e){
			//Aunque no hay nadie para interrumpirle.
			System.out.println("main(): Me han interrumpido la espera.");
		}
		System.out.println("En el punto de servicio quedan " + puntoServicio.size() + " productos.");
		System.out.println("Fin del programa.");
	}
}
