package Acoes;

import Controlador.*;

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



public class RolarDados extends JLabel implements ActionListener{
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
	public void actionPerformed(ActionEvent e) {  
		Tabuleiro t = Controler.getTab_p();
		
		label1.setBounds(150, 120, 150, 150);
		label2.setBounds(320, 120, 150, 150);
		t.add(label1);	t.add(label2);
		BufferedImage i1 = null;
		BufferedImage i2 = null;
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
		Image dado1 = i1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		Image dado2 = i2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
	
		label1.setIcon(new ImageIcon(dado1));
		label2.setIcon(new ImageIcon(dado2));

     
		Controler.rodada( d1,  d2); 
	}
}
