package aprendiendoJava.aplicacion;

import java.util.List;
import aprendiendoJava.interfaz.Interfaz;
import aprendiendoJava.interfaz.Interfaz.Operacion;
import aprendiendoJava.negocio.Departamento;
import aprendiendoJava.negocio.Empleado;
import aprendiendoJava.datos.BD;

public class Principal {
	private static Interfaz iu;
	private static BD bd;

	public static void main(String[] args) {
		
		Principal.iu = new Interfaz();
		Principal.bd = new BD();
		
		while(true){
			switch(Principal.iu.presentarMenu()){
				case INICIALIZAR:
					Principal.inicializar();
					break;
				case ALTA_EMPLEADO:
					Principal.altaEmpleado();
					break;
				case ALTA_DEPARTAMENTO:
					Principal.altaDepartamento();
					break;
				case LISTADO:
					Principal.listar();
					break;
				case SALIR:
					Principal.salir();
					break;
			}
		}
	}
	
	private static void inicializar(){
		Principal.bd.inicializar();
		Principal.iu.informar(Interfaz.Mensaje.OK, null);
	}
	
	private static void altaDepartamento(){
		Departamento departamento = Principal.iu.altaDepartamento();
		//Aquí irían las comprobaciones de Departamento (Reglas de aplicación)
		try{
			departamento.guardar();
			Principal.iu.informar(Interfaz.Mensaje.OK, null);
		}catch(Exception ex){
			ex.printStackTrace();
			Principal.iu.informar(Interfaz.Mensaje.ERROR, ex.getMessage());
		}
	}
	
	private static void altaEmpleado(){
		Empleado empleado = Principal.iu.altaEmpleado();
		try{
			empleado.guardar();
			Principal.iu.informar(Interfaz.Mensaje.OK, null);
		}catch(Exception ex){
			ex.printStackTrace();
			Principal.iu.informar(Interfaz.Mensaje.ERROR, ex.getMessage());
		}
	}
    
	private static void listar(){
		try{
			List<Empleado> listaEmpleados = Empleado.listar();
			Principal.iu.listar(listaEmpleados);
		}catch(Exception ex){
			ex.printStackTrace();
			Principal.iu.informar(Interfaz.Mensaje.ERROR, ex.getMessage());
		}
	}
	
    private static void salir(){
		try{
			Principal.bd.cerrar();
		}catch(Exception ex){
			ex.printStackTrace();
			Principal.iu.informar(Interfaz.Mensaje.ERROR, ex.getMessage());
		}
		finally{
			Principal.iu.salir();
			System.exit(0);
		}
    }
}