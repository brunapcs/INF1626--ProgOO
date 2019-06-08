package Acoes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RolarDados extends JLabel implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		JFrame Frame1 = new JFrame();
        JPanel panel1 = new JPanel();     
		BufferedImage i1 = null, i2 = null;
		Random num1 = new Random();
		int dado1 = num1.nextInt(6) + 1;
		int dado2 = num1.nextInt(6) + 1;
		System.out.println("Primeiro dado:"+ dado1 + "	" + "Segundo dado:" + dado2 );
		if((dado1 > 0 && dado1 < 7) && (dado2 > 0 && dado2 < 7)) {
			try {
				i1 = ImageIO.read(new File("images/dados/die_face_" + Integer.toString(dado1) + ".png"));
				i2 = ImageIO.read(new File("images/dados/die_face_" + Integer.toString(dado2) + ".png"));
			}
			catch(IOException ex){
				   System.out.println(ex.getMessage());
				   System.exit(1);
			}
		}
		JLabel label1 = new JLabel(new ImageIcon(i1));
		JLabel label2 = new JLabel(new ImageIcon(i2));
		panel1.add(label1);
		panel1.add(label2);
        Frame1.setTitle("Resultados dos Dados");
        Frame1.add(panel1);
        Frame1.pack();
        Frame1.setVisible(true);
	}
}
