package gui;

import regras.Fachada;
import regras.Factory;
import regras.Jogador;
import regras.Observable;
import utils.Dados;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;


import regras.Observer;

public class PNTabuleiro extends JPanel implements Observable, MouseListener { 
	
	private BufferedImage aux = null;  // variavel aux para imagem das cartas
	private static PNTabuleiro tab =null; 
	private BufferedImage i=null;	// Imagem do tabuleiro
	private static ArrayList<Jogador>jogadores = new ArrayList<Jogador>();  
	private Dados d = null; 
	private static int numJogadores =0; 
	private int clickX; 
	private int clickY;
	List<Observer> lob=new ArrayList<Observer>();
	
	
	private PNTabuleiro() { 
		try {
		   i=ImageIO.read(new File("images/tabuleiro.png"));
		}
		catch(IOException e) {
		   System.out.println(e.getMessage());
		   System.exit(1);
		}
		addMouseListener(this);
	}
	
	public static PNTabuleiro getPNTabuleiro() { 
		if (tab == null) { 
			tab = new PNTabuleiro(); 
		}
		return tab; 
	}
	
	public void addJogador(Jogador j){ 
				jogadores.add(j); 
	}
	
	public void remJogador(Jogador p) {
		jogadores.remove(p); 
	}
	public ArrayList<Jogador> getJogadoresList(){ 
		return jogadores; 
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

        for( int i=0; i< jogadores.size(); i++) { 
        	Jogador jog = jogadores.get(i); 
        	
        	g2d.drawImage(jog.getJogadorImage(), jog.getPosX()+jog.getOffset(), jog.getPosY()+jog.getOffset(), null); 
        }
        if(d.getReady() == true ) { 
	        g2d.setColor(d.getBackground());
	        g2d.fillRect(105, 385, 350, 175);
	        g2d.drawImage(d.getDimages()[0], 110, 400, 150,150, null);
	        g2d.drawImage(d.getDimages()[1], 280, 400, 150,150, null);
        }
	
	}

	public void mouseClicked(MouseEvent e){
		clickX = e.getX();
		clickY = e.getY();
		celulaClicked();
	}


	public Object get() {
			int[] clicks = new int[2]; 
			clicks[0]= clickX; 
			clicks[1]= clickY; 
			
			Object obs= (Object) clicks;
			
			return obs; 
		}
		
		public void addObserver(Observer o) {
			lob.add(o);
		}
		public void removeObserver(Observer o) {
			lob.remove(o);
		}

		public void celulaClicked() {
				for(Observer o:lob)
					o.notify(this);
		}
		
		public int getClickX() {
			return clickX;
		}
		public int getClickY() { 
			return clickY; 
		}
		
	// ******* MouseListener *******	
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
