package aprendiendoJava;

/**
* Declara e inicializa dos variables numéricas. Haz un programa que intercambie el valor de ambas.
*/

public class Problema {

	public static void main(String[] args){
		int var1 = 10, var2 = 20, aux;
		
		aux = var1; //Guardamos var1 en aux
		var1 = var2;//Sobreescribimos var1 con var2
		var2 = aux;//Sobreescribimos var2 con aux
		
	}
}