package Controlador;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.*;
import java.awt.image.BufferedImage; 

public class Tabuleiro  extends JPanel {
	private BufferedImage i=null;
	public static ArrayList<Jogador>jogadores = new ArrayList<Jogador>(); 
	private int num;
	
	public Tabuleiro(){
		num = 0;
		try {
		   i=ImageIO.read(new File("images/tabuleiro.png"));
		}
		catch(IOException e) {
		   System.out.println(e.getMessage());
		   System.exit(1);
		}		
		setBounds(0,0,700,700); 
		setVisible(true); 
		repaint(); 
	}
	
	public void addJogador() { 
		jogadores.add(new Jogador(num)); 
		num++;
	}
	
	public int getNumJogadores() {
		return num;
	}
	public Jogador getJogador(int index) {
		return jogadores.get(index);
	}
	@Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    	Graphics2D g2d = (Graphics2D) g;
	        g2d.drawImage(i, 0, 0, null);
	        for( int j=0; j < num; j++) { 
	        	Jogador jog = jogadores.get(j); 
	        	g2d.drawImage(jog.getJogadorImage(), jog.getPosX()+jog.getOffset(), jog.getPosY()+jog.getOffset(), null); 
	        }
	}
	
}