package aprendiendoJava.interfaz;

import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;
import aprendiendoJava.negocio.Departamento;
import aprendiendoJava.negocio.Empleado;

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
	
	public Empleado altaEmpleado(){
		Empleado empleado = null;
		try{
			System.out.println("\nAlta de Empleado:");
			System.out.print("Nombre: ");
			String nombre = this.scanner.next();
			System.out.print("Apellidos: ");
			String apellidos = this.scanner.next();
			System.out.print("Fecha de Nacimiento (dd-mm-aaaa): ");
			String fechaNacimientoString = this.scanner.next();
			String[] trozos = fechaNacimientoString.split("-");
			LocalDate fechaNacimiento = LocalDate.of(Integer.parseInt(trozos[2]), Integer.parseInt(trozos[1]), Integer.parseInt(trozos[0]));
			System.out.print("Identificador del Departamento: ");
			int idDepartamento = this.scanner.nextInt();
			empleado = new Empleado(nombre, apellidos, fechaNacimiento, Departamento.buscarPorId(idDepartamento));
		}catch(Exception ex){
			Interfaz.informar(Mensaje.ERROR, ex.getMessage());
		}
		return empleado;
	}
	
	public void listar(List<Empleado> listaEmpleados){
		System.out.println("\nListado de Empleados:");
		if (listaEmpleados.isEmpty())
			System.out.println(" - vacío - ");
		else
			for(Empleado empleado : listaEmpleados)
				System.out.println(" - " + empleado);
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
