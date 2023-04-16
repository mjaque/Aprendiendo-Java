package academia19e37;

import java.util.ArrayList;

/**
	Las clases inmutables no tienen problemas de sincronización.

	Para hacer una clase inmutable tenemos que:
		- No hacer setters.
		- Poner todos los atributos como private y final.
		- No permitir la reescritura de métodos haciendo la clase final (método sencillo)
		O poniendo el constructor private y construyendo los objetos mediante métodos de factoría (más complicado).
		- Si los atributos incluyen referencias a objetos mutables, no permitir su cambio.

	Esta clase Ejemplo es inmutable
*/

public final class Ejemplo{
	final private int atributo1;
	final private String atributo2;
	final private ArrayList atributo3;

	public static Ejemplo Factoria(int atributo1, String atributo2){
		Ejemplo ejemplo = new Ejemplo(atributo1, atributo2);	//Creamos los objetos mediante un método estático de factoría
		return ejemplo;						//Tiene muchas ventajas: nombres más claros, puede devolver nulo o una clase derivada...
	}

	private Ejemplo(int atributo1, String atributo2){
		//Solo se puede asignar valores en el constructor
		this.atributo1 = atributo1;
		this.atributo2 = atributo2;
		this.atributo3 = new ArrayList();
		//Ahora todos los atributos son inmutables
	}

	public int getAtributo1(){
		return this.atributo1;	//Devuelve una copia del atributo1. Sin riesgo.
	}
	
	public String getAtributo2(){
		return this.atributo2;	//Devuelve una referencia al String.
					//pero no hay riesgo porque los Strings en Java son inmutables.
					//Si el receptor intenta cambiarlo, solo generará un nuevo String.
					//el valor del atributo no cambiará.
	}

	public ArrayList getAtributo3(){
		ArrayList copia = new ArrayList();	//Los ArrayList no son inmutables.
		copia.addAll(this.atributo3);		//No podemos devolver una referencia porque podrían cambiarnos el atributo
		return copia;				//Por eso le devolvemos una copia del ArrayList
	}

	public void add(Object obj){
		this.atributo3.add(obj);		//Podemos manejar el ArrayList sin riesgo. Lo que cambia es su contenido, no el atributo
							//que sigue siendo el mismo ArrayList.
	}
	
	public static void main (String[] args){
		Ejemplo ej = Ejemplo.Factoria(7, "Aprendiendo Java");
		System.out.println(ej.getAtributo2());
	}

}
