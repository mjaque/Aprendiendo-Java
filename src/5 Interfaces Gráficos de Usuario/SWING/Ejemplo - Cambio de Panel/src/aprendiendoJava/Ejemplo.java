package aprendiendoJava;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

/**
* 	Ejemplo de cambio de panel por menú
*/

public class Ejemplo extends JFrame implements ActionListener{

	private JMenuItem menu1, menu2;
	private JPanel1 jp1;
	private JPanel2 jp2;
	public static final Dimension DIM = new Dimension (300, 200);

	public Ejemplo() {
		this.setTitle("Ejemplo de Cambio de Panel");
		this.setLocationRelativeTo(null);	//Centramos la ventana en la pantalla
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//Operación de cierre
		
		//Creación de los Paneles
		this.jp1 = new JPanel1();
		this.jp2 = new JPanel2();
		
		this.getContentPane().add(jp1);	//Empezamos mostrando el panel 1
		this.getContentPane().setPreferredSize(DIM);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menú");
		menuBar.add(menu);
		menu1 = new JMenuItem("Panel 1");
		menu.add(menu1);
		menu2 = new JMenuItem("Panel 2");
		menu.add(menu2);
		
		//Controladores
		menu1.addActionListener(this);
		menu2.addActionListener(this);
		
		this.setJMenuBar(menuBar);
		
		this.pack();
		this.setVisible(true);	//La hacemos visible
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu1){
			this.getContentPane().removeAll();
			this.add(this.jp1);
		}
		if (e.getSource() == menu2){
			this.getContentPane().removeAll();
			this.add(this.jp2);
		}
		this.pack();	//Recalculamos las dimensiones del JFrame
		this.repaint();	//Repintamos.
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

class JPanel1 extends JPanel{
	public JPanel1(){
		this.add(new JLabel("Panel 1"));
		this.setBackground(Color.RED);
		this.setSize(Ejemplo.DIM);
	}
}

class JPanel2 extends JPanel{
	public JPanel2(){
		this.add(new JLabel("Panel 2"));
		this.setBackground(Color.BLUE);
		this.setSize(Ejemplo.DIM);
	}
}