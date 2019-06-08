import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;
 

public class Tabuleiro  extends JPanel {
	private BufferedImage i=null;
	private JLabel label = null; 
	
	public Tabuleiro() {
 
		try {
		   i=ImageIO.read(new File("images/tabuleiro.png"));
		}
		catch(IOException e) {
		   System.out.println(e.getMessage());
		   System.exit(1);
		}		
		
		label = new JLabel(new ImageIcon(i));
		add (label); 
		
	}
}