package aprendiendoJava;

import java.io.File;
import java.util.StringTokenizer;

/**
* Ejemplo de Java Native Interface
Ref: https://blogs.oracle.com/moonocean/entry/a_simple_example_of_jni
*/

public class Ejemplo {
	
	public static native String nativeFoo(); 	//Declaración de la función nativa 
	private static native void sayHello();
	
	static{
			try{
			//System.loadLibrary("/lib/libfoo.so");				//Carga de la librería nativa (Linux)
			//Si sabes dónde estará la librería
			File libPath = new File (new File(".").getCanonicalPath() +File.separator + "/lib/libfoo.so");
			System.out.println("Cargando:" + libPath.getAbsolutePath());
			//System.load(libPath.getAbsolutePath());				//Carga de la librería nativa con path directo (Linux)
			System.loadLibrary("libfoo");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String property = System.getProperty("java.library.path");
		StringTokenizer parser = new StringTokenizer(property, ";");
		while (parser.hasMoreTokens()) {
			System.err.println(parser.nextToken());
		}
		Ejemplo.sayHello();
		System.out.println("Resultado: " + Ejemplo.nativeFoo());	//Uso de la librería nativa
    }
    
}