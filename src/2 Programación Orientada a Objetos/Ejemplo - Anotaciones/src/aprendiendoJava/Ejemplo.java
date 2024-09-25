package aprendiendoJava;

import java.lang.annotation.Annotation;

/**
* Ejemplos de declaración y uso de anotaciones
*/

@Anotacion(
	valor1 = "1",
	valor2 = 2,
	array1 = {"a1", "a2", "a3"}
	
)
public class Ejemplo{
	static int var1 = 1;	//Variable global

	public static void main(String[] args) {
		//Leemos las anotaciones en tiempo de ejecución
		Annotation[] anotaciones = Ejemplo.class.getAnnotations();

		for(Annotation anotacion : anotaciones){
			if(anotacion instanceof Anotacion){
				Anotacion anotacionTmp = (Anotacion) anotacion;
				System.out.println("valor1: " + anotacionTmp.valor1());
				System.out.println("valor2: " + anotacionTmp.valor2());
				String[] array1 = anotacionTmp.array1();
				System.out.println("array1[0]: " + array1[0]);
				System.out.println("array1[1]: " + array1[1]);
				System.out.println("array1[2]: " + array1[2]);
			}
		}
	}

}