package academia19e37;

public class HiloRunnable implements Runnable {

	private Cuenta cuenta;

	public HiloRunnable(Cuenta cuenta){
		this.cuenta = cuenta;
	}

	@Override
	public void run() {
		for(int i=0; i < 5; i++){
			//Comenta y descomenta métodos para ver los resultados
			//cuenta.ingresar(10);				//Este método falla por interferencia.
			//cuenta.ingresarSincronizado(10);		//Este método no falla.
			//cuenta.ingresarBloqueSincronizado(10);	//Este método no falla.
		}
	}
	
}
