package aprendiendoJava;

/**
* Crear un objeto de tipo "Cuenta" que tenga un atributo saldo (double), su getter y su setter.
* Luego crear dos hilos. El primero debe abonar 10 importes en la cuenta de 100 euros. Y el segundo debe realizar 5 cargos de 10 euros.
* Pero deben actuar alternativamente, primero un abono (hasta completar los 10) y luego un cargo (hasta completar los 5).
* Utilizando notify() y wait().
*/

public class Ejercicio{
	public enum Operacion {ABONO, CARGO};

	public static void main(String[] args) {
		
		//Creamos la cuenta
		Cuenta cuenta = new Cuenta();
		Operacion proximaOperacion = Operacion.ABONO;	//Empezamos por abono
		
		Thread hiloAbono = new Thread(new HiloAbono(cuenta, proximaOperacion));
		Thread hiloCargo = new Thread(new HiloCargo(cuenta, proximaOperacion));
				
		//Y los lanzamos
		hiloAbono.start();
		hiloCargo.start();
		
		//Esperamos a que terminen los dos
		try{
			hiloAbono.join();
			hiloCargo.join();
			System.out.println("main(): Ya han terminado todos.");
			System.out.println("main(): El saldo final es " + cuenta.getSaldo() + ".");
			System.out.println("main(): El saldo final debería ser 1000 - 50 = 950.");
		}catch(InterruptedException e){
			//Aunque no hay nadie para interrumpirle.
			System.out.println("main(): Me han interrumpido la espera.");
		}
	}
}