package aprendiendoJava;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* Programa que abre una ventana con el título "¡Hola Mundo!"
*/

public class Ejemplo extends JFrame implements ActionListener{

	private JMenuItem menu1_1, menu1_2, menu2_1;

	public Ejemplo() {
		this.setTitle("Ejemplo de Barrá de Menú");
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);	//Centramos la ventana en la pantalla
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//Operación de cierre
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Menú 1");
		menuBar.add(menu1);
		menu1_1 = new JMenuItem("Menú 1.1");
		menu1.add(menu1_1);
		menu1_2 = new JMenuItem("Menú 1.2");
		menu1.add(menu1_2);
		
		JMenu menu2 = new JMenu("Menú 1");
		menuBar.add(menu2);
		menu2_1 = new JMenuItem("Menú 2.1");
		menu2.add(menu2_1);
		
		//Controladores
		menu1_1.addActionListener(this);
		menu1_2.addActionListener(this);
		menu2_1.addActionListener(this);
		
		this.setJMenuBar(menuBar);
		this.setVisible(true);	//La hacemos visible
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu1_1)
			System.out.println("Se ha seleccionado el menú 1.1");
		if (e.getSource() == menu1_2)
			System.out.println("Se ha seleccionado el menú 1.2");
		if (e.getSource() == menu2_1)
			System.out.println("Se ha seleccionado el menú 2.1");
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
