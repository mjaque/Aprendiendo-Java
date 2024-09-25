package aprendiendoJava;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;

/**
* Programa que abre una ventana con el título "¡Hola Mundo!"
*/

public class Ejemplo extends Application {

	public static void main(String[] args) {
		Application.launch(args);
    }
    
    @Override
    public void start(Stage stage){
		stage.setTitle("¡Hola Mundo!");
		stage.setWidth(600);	//px
		stage.setHeight(400);	//px

		stage.show();
    }
}
