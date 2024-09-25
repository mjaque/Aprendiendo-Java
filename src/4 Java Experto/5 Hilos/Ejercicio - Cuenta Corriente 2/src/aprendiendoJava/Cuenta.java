package aprendiendoJava;

// Esta clase implementa una Cuenta Bancaria

public class Cuenta{
	private double saldo = 0.0;
	
	public double getSaldo(){
		return this.saldo;
	}
	
	public void setSaldo(double saldo){
		this.saldo = saldo;
	}
}