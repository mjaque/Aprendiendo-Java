package aprendiendoJava;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

/**
* Ejemplo de uso de menús con JavaFX
*/

public class Ejemplo extends Application {

		MenuItem menu1_1 = new MenuItem("Menú 1.1");
		MenuItem menu1_2 = new MenuItem("Menú 1.2");
		MenuItem menu2_1 = new MenuItem("Menú 2.1");

	public static void main(String[] args) {
		Application.launch(args);
    }
    
    @Override
    public void start(Stage stage){
		stage.setTitle("Ejemplo de uso de Menús");
		stage.setWidth(600);
		stage.setHeight(400);
		
		VBox raiz = new VBox();
		Scene scene = new Scene(raiz);
		

		MenuBar barraMenu = new MenuBar();
		Menu menu1 = new Menu("Menú 1");
		Menu menu2 = new Menu("Menú 2");
		menu1_1 = new MenuItem("Menú 1.1");
		menu1_2 = new MenuItem("Menú 1.2");
		menu2_1 = new MenuItem("Menú 2.1");
		menu1.getItems().addAll(menu1_1, menu1_2);
		menu2.getItems().add(menu2_1);
		barraMenu.getMenus().addAll(menu1, menu2);
		
		//Control de Menús
		menu1_1.setOnAction(this);
		menu1_2.setOnAction(this);
		menu2_1.setOnAction(this);
		
		raiz.getChildren().add(barraMenu);
		
		stage.setScene(scene);
		stage.show();
    }
}
