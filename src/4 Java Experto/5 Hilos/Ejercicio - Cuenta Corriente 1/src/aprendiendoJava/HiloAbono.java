package aprendiendoJava;

// Este hilo realiza 10 ingresos en la cuenta.
public class HiloAbono implements Runnable {
	private static final double IMPORTE = 100;	//Definimos el importe a ingresar en cada operación
	private static final int NUM_INGRESOS = 10;	//Definimos el número de ingresos a realizar
	private static final int T_OPERACION = 50;	//Simula el tiempo que tarda en realizarse la operación
	
	private Cuenta cuenta;				//Cuenta sobre la que operaremos.

	public HiloAbono(Cuenta cuenta){
		this.cuenta = cuenta;
	}

	@Override
	public void run() {
		System.out.println("HiloAbono: Iniciando los abonos.");
		
		for(int i=0; i < NUM_INGRESOS; i++){
			System.out.println("HiloAbono: Esperando a la cuenta.");
			synchronized(cuenta){	//Ningún thread puede entrar en un bloque synchronized cuenta hasta que este thread salga
				System.out.println("HiloAbono: Abonando vez " + i + ".");
				double saldoActual = cuenta.getSaldo();
				System.out.println("HiloAbono: Saldo inicial " + saldoActual + ".");
				this.abonar(saldoActual + IMPORTE);
				System.out.println("HiloAbono: Saldo final " + cuenta.getSaldo() + ".");
			}
			System.out.println("HiloCargo: Cuenta liberada.");
		}
	}
	
	private void abonar(double saldo){
		try{
			Thread.sleep(T_OPERACION);
			this.cuenta.setSaldo(saldo);
		}catch(InterruptedException e){}
	}
}