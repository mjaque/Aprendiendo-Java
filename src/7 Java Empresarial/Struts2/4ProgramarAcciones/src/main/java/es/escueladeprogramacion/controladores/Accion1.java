package es.escueladeprogramacion.controladores;

import com.opensymphony.xwork2.ActionSupport;
import es.escueladeprogramacion.modelos.AlmacenMensajes;

public class Accion1 extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	//Un POJO normal y corriente
	private AlmacenMensajes almacenMensajes;
	private static int contador = 0;	// Variable de clase
	private String nombreUsuario;		//Recibirá el valor del formulario de index.jsp
	
	static{
		System.out.println("TRON: Se ha instanciado la clase Accion1");
	}

	//Struts2 llamará a este método (ver struts.xml)
	//para decidir qué vista se carga.
	@Override
	public String execute() throws Exception {
		this.almacenMensajes = new AlmacenMensajes();
		Accion1.contador++;
		if (nombreUsuario != null)
			almacenMensajes.setMensaje( almacenMensajes.getMensaje() + " " + this.nombreUsuario);

		return ActionSupport.SUCCESS;
	}
   
	public AlmacenMensajes getAlmacenMensajes() {
		return almacenMensajes;
	}

	public int getContador(){
		return Accion1.contador;
	}
	
	public void setNombreUsuario(String nombreUsuario){
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getNombreUsuario(){
		return this.nombreUsuario;
	}
}

