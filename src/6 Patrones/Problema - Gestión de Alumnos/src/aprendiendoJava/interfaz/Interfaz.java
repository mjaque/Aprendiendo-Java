package aprendiendoJava.interfaz;

import java.util.Scanner;

public class Interfaz {
	public enum Operacion {INICIALIZAR, ALTA_DEPARTAMENTO,ALTA_EMPLEADO, LISTADO, SALIR};
	public enum Mensaje {OK, ERROR};
	
	private Scanner scanner;
	
	public Interfaz(){
		this.scanner = new Scanner(System.in);
	}
	
	public Operacion presentarMenu() {
		while (true){
			System.out.println("\nMENÚ DE OPERACIONES");
			System.out.println("a) Inicializar la Base de Datos.");
			System.out.println("b) Alta de departamento.");
			System.out.println("c) Alta de empleado.");
			System.out.println("d) Listado de empleados.");
			System.out.println("x) Salir.");
			System.out.print("Opción: ");
			String opcion = this.scanner.next();
			switch(opcion.toLowerCase()){
				case "a":
					return Operacion.INICIALIZAR;
				case "b":
					return Operacion.ALTA_DEPARTAMENTO;
				case "c":
					return Operacion.ALTA_EMPLEADO;
				case "d":
					return Operacion.LISTADO;
				case "x":
					return Operacion.SALIR;
				default:
					System.err.println("\nOperación desconocida.\n");
			}
		}
	}
	
	public Departamento altaDepartamento(){
		System.out.println("\nAlta de Departamento:");
		System.out.print("Nombre del nuevo departamento: ");
		String nombre = this.scanner.next();
		System.out.print("Presupuesto: ");
		Float presupuesto = this.scanner.nextFloat();
		return new Departamento(nombre, presupuesto);
	}
	
	public void salir(){
		scanner.close();
		System.out.println("\nFin del Programa.\n");
	}
	
	public static void informar(Mensaje tipo, String textoError){
		switch(tipo){
			case OK:
				System.out.println("La operación se realizó correctamente.");
				break;
			case ERROR:
				System.err.println("ERROR: " + textoError);
				break;
		}
	}
    
} 
