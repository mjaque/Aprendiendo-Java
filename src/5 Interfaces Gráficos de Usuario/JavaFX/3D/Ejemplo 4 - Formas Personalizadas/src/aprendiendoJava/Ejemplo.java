package aprendiendoJava;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.shape.MeshView;
import javafx.scene.paint.PhongMaterial;
import javafx.stage.Stage;
import javafx.scene.shape.DrawMode;
import javafx.scene.paint.Color;


/**
	Crear una forma personalizada con TriangleMesh
*/

public class Ejemplo extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage ventana) throws Exception {
		//Ponemos el título a la ventana.
		ventana.setTitle("Ejemplo 4");
		
		//Creamos una pirámide
		TriangleMesh piramide = new TriangleMesh();
		
		piramide.getTexCoords().addAll(0,0); //Coordenadas de textura que no utilizamos
		
		//Colección de vértices
		float h = 150;                    // Altura
		float a = 300;                    // Arista
		piramide.getPoints().addAll(
			0,    0,    0,            // Arriba
			0,    h,    -a/2,         // Delante
			-a/2, h,    0,            // Izquierda
			a/2,  h,    0,            // Derecha
			0,    h,    a/2           // Atrás
		);
		
		//Coordenadas de las caras
		piramide.getFaces().addAll(
        0,0,  2,0,  1,0,          // Delantera Izqda
        0,0,  1,0,  3,0,          // Delantera derecha
        0,0,  3,0,  4,0,          // Atrás derecha
        0,0,  4,0,  2,0,          // Atrás Izquierda
        4,0,  1,0,  2,0,          // Abajo atrás
        4,0,  3,0,  1,0           // Abajo delante
		); 
		
		final PhongMaterial redMaterial = new PhongMaterial();
		redMaterial.setSpecularColor(Color.ORANGE);
		redMaterial.setDiffuseColor(Color.RED);
		
		MeshView piramideView = new MeshView(piramide);
		piramideView.setDrawMode(DrawMode.FILL);
		piramideView.setMaterial(redMaterial);
		
		Group grupo = new Group(piramideView);
		//grupo.getChildren().add(piramide);
		
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
 
