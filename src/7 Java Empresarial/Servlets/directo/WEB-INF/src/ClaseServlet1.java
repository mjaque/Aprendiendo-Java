//Clases de Java SE
import java.io.IOException;
import java.io.PrintWriter;

//Clases de Tomcat
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;


//Desde el directorio src
//Compilar con: javac -classpath ../../../../lib/servlet-api.jar *.java
//Publicar con: mv *.class ../classes/

public class ClaseServlet1 extends HttpServlet {

	//Nota: Tener en cuenta que el Servlet se instancia una vez. El objeto es compartido por todas las sesiones HTTP, 
	// así que las variables globales que se declaren serán compartidas por todos los usuarios del servlet.

	@Override
	public void init(ServletConfig config) throws ServletException {
		//Solo se ejecuta al arrancar el servlet.
		super.init(config);
		System.out.println("TRON: ClaseServlet1.init()");
	}
	
	/**
	*  Este método atiende las peticiones GET
	**/
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String html = "(ClaseServlet1): Tenemos que construir todo el documento \"a pelo\".";
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");	//etc. etc....
		out.println(html);
	}
	
}

