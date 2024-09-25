package aprendiendoJava;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
* Haz un programa que reproduzca un archivo mp3
*/

public class Ejercicio extends Application{

	public static void main(String[] args){
		//Ref: http://www.oracle.com/technetwork/java/javafx/downloads/supportedconfigurations-1506746.html
		System.out.println("javafx.runtime.version: " + System.getProperties().get("javafx.runtime.version"));
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Media sound = new Media(new File("test.mp3").toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}
}
