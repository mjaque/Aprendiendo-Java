package aprendiendoJava.aplicacion;

import aprendiendoJava.interfaz.Interfaz;
import aprendiendoJava.interfaz.Interfaz.Operacion;
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
					Principal.altaDepartamento();
					break;
				case ALTA_DEPARTAMENTO:
					break;
				case LISTADO:
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
		Departamento dep = Principal.iu.altaDepartamento();
		//Aquí irían las comprobaciones de Departamento (Reglas de aplicación)
		dep.guardar();
		Principal.iu.informar(Interfaz.Mensaje.OK, null);
	}
    
    private static void salir(){
		Principal.iu.salir();
		System.exit(0);
    }
}