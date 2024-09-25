package aprendiendoJava;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;

/**
* Ejemplo de uso de Image
*/

public class Ejemplo extends JFrame {

	public Ejemplo(){
		this.setTitle("Ejemplo de Image");
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.add(new PanelConImagen());
		
		this.setVisible(true);
	}

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Ejemplo();
			}
		});
    }
    
    class PanelConImagen extends JPanel{
    
    	private Image img;
    	
    	public PanelConImagen(){
			try{
				img = ImageIO.read(new File("happy.jpg"));
				img = img.getScaledInstance(300, 200, Image.SCALE_DEFAULT); //Para redimensionar.
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
    
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, null);
		}
    
    }
}
