package es.escueladeprogramacion.controladores;

import com.opensymphony.xwork2.ActionSupport;
import es.escueladeprogramacion.modelos.Persona;

public class AccionRegistrar extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private Persona personaBean;

	@Override
	public String execute() throws Exception {
		//Llamaríamos el servicio para guardar personaBean en la base de datos
		//que ya vendría relleno del formulario.
        
		return SUCCESS;
	}

	@Override
	public void validate(){
		//Método para la validación de formularios asociados a esta acción
		if (personaBean.getNombre().length() == 0) 
			//Método heredado de ActionSupport para añdadir un campo de error
			this.addFieldError("personaBean.nombre", "Debe indicar su nombre.");
			
		if (personaBean.getEmail().length() == 0)
			this.addFieldError("personaBean.email", "Debe indicar su email.");

		if (personaBean.getEdad() < 18){
			System.out.println("TRON: " + personaBean.getEdad());
			this.addFieldError("personaBean.edad", "No puede registrarse si es menor de edad.");
		}
			
		//Si se han añadido errores, Struts2 no llama a execute. Devuelve INPUT
	}

	/*
		No hay método input() porque se hereda de ActionSupport y devuelve INPUT,
		que es justo lo que queremos hacer.
	*/
    
	public Persona getPersonaBean() {
		return this.personaBean;
	}
    
	public void setPersonaBean(Persona persona) {
		personaBean = persona;
	}
}
