package aprendiendoJava;

// Este hilo realiza 5 cargos en la cuenta.
public class HiloCargo implements Runnable {
	private static final double IMPORTE = 10;	//Definimos el importe a cargar en cada operación
	private static final int NUM_CARGOS = 5;	//Definimos el número de cargos a realizar
	private static final int T_OPERACION = 25;	//Simula el tiempo que tarda en realizarse la operación

	private Cuenta cuenta;	//Cuenta sobre la que operaremos.

	public HiloCargo(Cuenta cuenta){
		this.cuenta = cuenta;
	}

	@Override
	public void run() {
		System.out.println("HiloCargo: Iniciando los cargos.");
		
		for(int i=0; i < NUM_CARGOS; i++){
			System.out.println("HiloCargo: Esperando a la cuenta.");
			synchronized(cuenta){
				System.out.println("HiloCargo: Cargando vez " + i + ".");
				double saldoActual = cuenta.getSaldo();
				System.out.println("HiloCargo: Saldo inicial " + saldoActual + ".");
				this.cargar(saldoActual - IMPORTE);
				System.out.println("HiloCargo: Saldo final " + cuenta.getSaldo() + ".");
			}
			System.out.println("HiloCargo: Cuenta liberada.");
		}
	}
	
	private void cargar(double saldo){
		try{
			Thread.sleep(T_OPERACION);
			this.cuenta.setSaldo(saldo);
		}catch(InterruptedException e){}
	}
	
}