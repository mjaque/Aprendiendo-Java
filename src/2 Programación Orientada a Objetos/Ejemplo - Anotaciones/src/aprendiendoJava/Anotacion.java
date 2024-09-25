package aprendiendoJava;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;

//Para poder leer los valores de la anotación durante la ejecución del programa
@Retention(RetentionPolicy.RUNTIME)	

//Para que la anotación aparezca en Javadoc
@Documented

public @interface Anotacion {
   String valor1();
   int valor2() default 1;
   String valor3() default "N/A";
   String[] array1();
}