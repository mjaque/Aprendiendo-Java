package aprendiendoJava;

import javafx.application.Platform;
import javafx.application.ConditionalFeature;

/**
* Comprueba si el sistema tiene soporte para el API de JavaFX 3D
*/

public class Soporte{

	public static void main(String[] args){
		if (Platform.isSupported(ConditionalFeature.SCENE3D))
			System.out.println("El sistema SOPORTA JavaFX 3D");
		else
			System.out.println("El sistema NO SOPORTA JavaFX 3D");
	}
	
}
