package aprendiendoJava;

/**
* Ejemplos de llamadas a métodos y ámbitos de variables.
*/

public class Ejemplo{
	static int var1 = 1;	//Variable global

	public static void main(String[] args) {
		int var2 = 2;	//Variables local del método main()
		
		System.out.println("var1 = " + var1 + "\tvar2 = " + var2);
		
		metodo1();
		
		metodo2(7);
    }
    
    private static void metodo1(){
		int var2 = 3;	//Variables local del método método1
		
		System.out.println("var1 = " + var1 + "\tvar2 = " + var2);
    }

	private static void metodo2(int var1){
		int var2 = 4;	//Variables local del método método1
		
		System.out.println("var1 = " + var1 + "\tvar2 = " + var2);
    }

}