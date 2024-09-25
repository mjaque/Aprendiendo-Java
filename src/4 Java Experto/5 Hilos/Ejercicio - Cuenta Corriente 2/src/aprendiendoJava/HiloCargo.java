	package aprendiendoJava;

// Este hilo realiza 5 cargos en la cuenta.
public class HiloCargo implements Runnable {
	private static final double IMPORTE = 10;	//Definimos el importe a cargar en cada operación
	private static final int NUM_CARGOS = 5;	//Definimos el número de cargos a realizar
	private static final int T_OPERACION = 25;	//Simula el tiempo que tarda en realizarse la operación

	private Cuenta cuenta;	//Cuenta sobre la que operaremos.
	Ejercicio.Operacion proximaOperacion;

	public HiloCargo(Cuenta cuenta, Ejercicio.Operacion proximaOperacion){
		this.cuenta = cuenta;
		this.proximaOperacion = proximaOperacion;
	}
	
	public HiloCargo(Cuenta cuenta){
		this.cuenta = cuenta;
	}

	@Override
	public void run() {
		System.out.println("HiloCargo: Iniciando los cargos.");
		
		for(int i=0; i < NUM_CARGOS; i++){
			try{
				System.out.println("HiloCargo: Esperando a la cuenta.");
				synchronized(cuenta){	//Ningún thread puede entrar en un bloque synchronized cuenta hasta que este thread salga
					//Comprobamos que sea el turno de nuestra operación
					if (this.proximaOperacion != Ejercicio.Operacion.CARGO){
						System.out.println("HiloAbono: Esperando al turno.");
						cuenta.wait();	//Dejamos que otros hilos entren en el bloque y esperamos
					}
					//Ya hemos conseguido el turno
					System.out.println("HiloCargo: Cargando vez " + i + ".");
					double saldoActual = cuenta.getSaldo();
					System.out.println("HiloCargo: Saldo inicial " + saldoActual + ".");
					this.cargar(saldoActual + IMPORTE);
					cuenta.notify();	//Dejamos libre el bloque
					System.out.println("HiloCArgo: Saldo final " + cuenta.getSaldo() + ".");
				}
				System.out.println("HiloCargo: Bloque liberado.");
			}catch(InterruptedException e){
				System.out.println("HiloCargo: Interrumpido.");
			}
		}
	}
	
	private void cargar(double saldo){
		try{
			Thread.sleep(T_OPERACION);
			this.cuenta.setSaldo(saldo);
		}catch(InterruptedException e){}
	}
	
}