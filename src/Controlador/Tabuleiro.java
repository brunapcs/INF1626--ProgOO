package Controlador;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.*;
import java.awt.image.BufferedImage; 

public class Tabuleiro  extends JPanel {
	private BufferedImage i=null;
	public ArrayList<Pin> pinos = new ArrayList<Pin>();
	
	public Tabuleiro() {
		try {
		   i=ImageIO.read(new File("images/tabuleiro.png"));
		}
		catch(IOException e) {
		   System.out.println(e.getMessage());
		   System.exit(1);
		}		
	
		setLayout(null); 
		repaint(); 
		
	}
	
	public int addPin() { 
		if (pinos.size() >= 6 ) { 
			System.out.print("Nao pode mais add jogador"); 
			return 6; 
		}
		else {
			Pin p = new Pin(); 
			pinos.add(p); 
			add(p); 
			repaint(); 
			Pin.position += 26;
			return pinos.size(); 
		} 
	}
	
	public Pin getPin(int indice) { 
		return pinos.get(indice); 
	}
	
	
	public int getPlayersNum() { 
		return pinos.size(); 
	}
	
	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        g.drawImage(i, 0, 0, null);
	}
	
}