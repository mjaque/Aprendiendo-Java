package academia19e37;

public class Ejercicios {

	public static void main(String[] args) {

		/**
		 * Crea dos variables de tipo entero. Asigna a la primera el resultado de sumar
		 * 2 y 7 y multiplicar el resultado por 5. A la segunda variable asígnale el
		 * resto de la división de 235 entre 17. Luego incrementa la primera variable en
		 * uno.
		 */
		int a1, b1;
		a1 = (2 + 7) * 5;
		b1 = 235 % 17;
		a1++;

		System.out.println("a1 = " + a1 + "\nb1 = " + b1);

		/**
		 * Crea dos variables. A la primera asígnale el valor 6.4. Y a la segunda
		 * asígnale el resultado de comparar si el valor de la primera variable es
		 * distinto de la suma de 2.35 y 4.05.
		 */
		float a2;
		boolean b2;
		a2 = 6.4f;
		b2 = (a2 != (2.35 + 4.05));

		System.out.println("a2 = " + a2 + "\nb2 = " + b2);

		/**
		 * Crea tres variables booleanas. A la primera llámale "llueve" y asígnale el
		 * valor que quieras. A la segunda llámale "tengoParaguas" y asígnale el valor
		 * que quieras. Y a la tercera llámala "meMojo" y asígnale el valor resultante
		 * de la operación lógica que determine si te mojas o no según los valores de
		 * llueve y tengoParaguas.
		 */
		boolean llueve = true, tengoParaguas = false, meMojo;
		meMojo = llueve && !tengoParaguas;

		System.out.println("meMojo = " + meMojo);

		/**
		 * Crea tres variables con los valores numéricos que quieras. Ahora incrementa
		 * la primera con el valor de la segunda y decrementa la segunda con el valor de
		 * la tercera.
		 */
		int a3 = -17;
		float b3 = 3E4f;
		double c3 = -37E-2;

		a3 += b3;
		b3 -= c3;

		System.out.println("a3 = " + a3 + "\nb3 = " + b3 + "\nc3 = " + c3);
	}

}
