package aprendiendoJava;

/**
* Crea tres variables booleanas. A la primera llámale "llueve" y asígnale el valor que quieras. A la segunda llámale "tengoParaguas" y asígnale el valor que quieras. Y a la tercera llámala "meMojo" y asígnale el valor resultante de la operación lógica que determine si te mojas o no según los valores de llueve y tengoParaguas.
*/

public class Ejercicio {

	public static void main(String[] args){
		boolean llueve = true, tengoParaguas = false, meMojo;
		meMojo = llueve && !tengoParaguas;

		System.out.println("meMojo = " + meMojo);
	}
	
}
