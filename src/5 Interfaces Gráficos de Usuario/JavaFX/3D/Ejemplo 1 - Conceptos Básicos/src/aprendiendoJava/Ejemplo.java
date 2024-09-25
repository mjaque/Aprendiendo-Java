package aprendiendoJava;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;


/**
	Conceptos Básicos de JavaFX 3D:
		- Objetos 3D. (Sphere, Box, Cylinder y MeshView)
		- Material.
		- Cámara.
		- Luz.
		
		- Rendering: Pasar de 3D a 2D.
		- Ejes x, y. z
*/

public class Ejemplo extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage ventana) throws Exception {
		//Ponemos el título a la ventana.
		ventana.setTitle("Ejemplo 1");
		
		//Creamos una esfera de 100 de radio. Resto de parámetros por defecto (centrada en 0,0,0 y con material gris.
		Sphere esfera = new Sphere(100);
		//Se añade la cámara por defecto, paralela, en el eje z negativo, mirando al plano xy.
		//Se añade luz por defecto, centrada en la cámara y radiando en todas las direcciones.
		
		//Creamos un nodo de Grupo con la esfera.
		Group grupo = new Group(esfera);
		
		//Creamos una escena con el grupo, con anchura de 640px y altura de 480px.
		Scene escena = new Scene(grupo, 640, 480);
		
		//Movemos el grupo que contiene la esfera para centrarlo en la escena
		grupo.setTranslateX(640/2);
		grupo.setTranslateY(480/2);
		
		//Ponemos la escena en la ventana. Por defecto, la ventana se adapta al tamaño de la escena
		ventana.setScene(escena);
		
		//Mostramos la ventana
		ventana.show();
	}

}
 
