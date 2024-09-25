package aprendiendoJava;

/**
* Ejemplo de Servlet.
*/

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Ejemplo extends HttpServlet {

	private String mensaje;

	public void init() throws ServletException{
		//Inicialización del Servlet
		this.mensaje = "¡Hola Mundo!";
	}
	
	public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
		respuesta.setContentType("text/html");	//Establecemos el tipo de respuesta
		
		// Aquí iría la lógica para elaborar la respuesta
		
		PrintWriter out = respuesta.getWriter();
		out.println("<h1>" + mensaje + "</h1>");
	}
  
	public void destroy(){
		// Código de destrucción del Servlet
	}
}
