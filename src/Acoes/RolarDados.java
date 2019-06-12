package Acoes;

import Controlador.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class RolarDados extends JPanel{

	private BufferedImage i1 = null;
	private BufferedImage i2 = null;
	
	
	public RolarDados() { 
		setVisible(true);
		repaint();
	}
	
	public void sortearDados() {  
		Random num1 = new Random();
		int d1 = num1.nextInt(6) + 1;
		int d2 = num1.nextInt(6) + 1;
		
		if((d1 > 0 && d1 < 7) && (d2 > 0 && d2 < 7)) {
			try {
				i1 = ImageIO.read(new File("images/dados/die_face_" + Integer.toString(d1) + ".png"));
				i2 = ImageIO.read(new File("images/dados/die_face_" + Integer.toString(d2) + ".png"));
			}
			catch(IOException ex){
				   System.out.println(ex.getMessage());
				   System.exit(1);
			}
		}
		
		setBounds(150,150, 310, 150);
		setBackground(new Color(0,0,0,0));
		repaint(); 
		setVisible(true);
		Controler.rodada( d1,  d2); 
	}
	
	@Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    	Graphics2D g2d = (Graphics2D) g;
	        g2d.drawImage(i1, 0, 0, 150,150, null);
	        g2d.drawImage(i2, 160, 0, 150,150, null);
	}
}
