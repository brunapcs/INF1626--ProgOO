import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Tabuleiro  extends JPanel {
	private Image i=null;
	private Tabuleiro p=this;
	
	public Tabuleiro() {
		try {
		   i=ImageIO.read(new File("images/tabuleiro.png"));
		}
		catch(IOException e) {
		   System.out.println(e.getMessage());
		   System.exit(1);
		}		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gd2=(Graphics2D) g;
		gd2.drawImage (i,0,0,null);
	}
}