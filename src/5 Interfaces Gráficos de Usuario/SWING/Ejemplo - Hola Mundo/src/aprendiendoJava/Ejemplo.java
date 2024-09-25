package aprendiendoJava;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;

/**
* Programa que abre una ventana con el título "¡Hola Mundo!"
*/

public class Ejemplo extends JFrame {

	public Ejemplo() {
		this.setTitle("¡Hola Mundo!");
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);	//Centramos la ventana en la pantalla
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//Operación de cierre
		this.setVisible(true);	//La hacemos visible
	}

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
            public void run() {
				new Ejemplo();
			}
		});
    }
}
