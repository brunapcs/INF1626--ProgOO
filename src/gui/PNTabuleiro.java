package gui;

import regras.Jogador;
import regras.Observable;
import utils.Dados;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;


import regras.Observer;

public class PNTabuleiro extends JPanel implements Observer{ 
	
	private static PNTabuleiro tab =null; 
	private BufferedImage i=null;
	private ArrayList<Jogador>jogadores = null;  
	private Dados d = null; 
	
	private PNTabuleiro() { 
		try {
		   i=ImageIO.read(new File("images/tabuleiro.png"));
		}
		catch(IOException e) {
		   System.out.println(e.getMessage());
		   System.exit(1);
		}	
		jogadores =  new ArrayList<Jogador>();
	}
	
	public static PNTabuleiro getPNTabuleiro() { 
		if (tab == null) 
			tab = new PNTabuleiro(); 
		return tab; 
	}
	
	public void addJogadores(int num){ 
		if( jogadores.size() < 1  ){ 
			for(int i = 0 ; i< num; i++) { 
				jogadores.add(new Jogador(i)); 
				}
			}
	}
	
	public Jogador getJogador(int index) {
		return jogadores.get(index);
	}
	
	public int getSizeJogadores() {
		return jogadores.size();
	}
	
	@Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    	Graphics2D g2d = (Graphics2D) g;
	        g2d.drawImage(i, 0, 0, null);
	        d = Dados.getDados(); 
	      
	        for( int j=0; j < jogadores.size(); j++) { 
	        	Jogador jog = jogadores.get(j); 
	        	g2d.drawImage(jog.getJogadorImage(), jog.getPosX()+jog.getOffset(), jog.getPosY()+jog.getOffset(), null); 
	        }
	        
	        g2d.setColor(d.getBackground());
	        g2d.fillRect(105, 385, 350, 175);
	        g2d.drawImage(d.getDimages()[0], 110, 400, 150,150, null);
	        g2d.drawImage(d.getDimages()[1], 280, 400, 150,150, null);
	
	}

	@Override
	public void notify(Observable o) {
		// TODO Auto-generated method stubHG
		
	}

	
		
}
