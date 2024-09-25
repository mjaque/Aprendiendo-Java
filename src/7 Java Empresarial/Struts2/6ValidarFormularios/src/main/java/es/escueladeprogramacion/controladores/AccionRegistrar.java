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
    
	public Persona getPersonaBean() {
		return this.personaBean;
	}
    
	public void setPersonaBean(Persona persona) {
		personaBean = persona;
	}
}
