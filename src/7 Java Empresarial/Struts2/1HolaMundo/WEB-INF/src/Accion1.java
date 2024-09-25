
//Desde el directorio src
//Compilar con: javac -classpath ../lib/\* *.java
//Publicar con: mv *.class ../classes/

public class Accion1{
	//Un POJO normal y corriente
	
	private String mensaje = "¡Hola Mundo!";
	static{
		System.out.println("TRON: Se ha instanciado la clase Accion1");
	}

	//Struts2 llamará a este método (ver struts.xml)
	//para decidir qué vista se carga.
	public String ejecutar() throws Exception {
		return "exito";
	}
   
	public String getMensaje() {
		System.out.println("TRON: Accion1.getMensaje().");
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}

