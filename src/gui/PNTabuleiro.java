package gui;

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

import javax.imageio.ImageIO;
import javax.swing.*;


import regras.Observer;

public class PNTabuleiro extends JPanel implements Observer, MouseListener{ 
	
	private BufferedImage aux = null;  // variavel aux para imagem das cartas
	private static PNTabuleiro tab =null; 
	private BufferedImage i=null;	// Imagem do tabuleiro
	private static ArrayList<Jogador>jogadores = new ArrayList<Jogador>();  
	private Dados d = null; 
	
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
	        if(d.getReady() == true ) { 
		        g2d.setColor(d.getBackground());
		        g2d.fillRect(105, 385, 350, 175);
		        g2d.drawImage(d.getDimages()[0], 110, 400, 150,150, null);
		        g2d.drawImage(d.getDimages()[1], 280, 400, 150,150, null);
	        }
	
	}

	@Override
	public void notify(Observable o) {
		// TODO Auto-generated method stubHG
		
	}
	
	public void mouseClicked(MouseEvent e){
		int x = e.getX();
		int y = e.getY();
		System.out.println(x+" e "+y);
		JFrame frame = new JFrame("Visualizacao de carta selecionada");
		frame.setSize(250, 300);	
		
		if((x <= 600 && x >= 540) && (y >= 600 && y <= 700)){
			JPanel panel = desenhaCarta("territorios/Leblon");
			frame.add(panel);
		}
			
		else if ((x <= 490 && x >= 430) && (y >= 600 && y <= 700)){
			JPanel panel = desenhaCarta("territorios/Av. Presidente Vargas");
			frame.add(panel);	
		}
		
		else if((x <= 432 && x >= 375) && (y >= 600 && y <= 700)){
			JPanel panel = desenhaCarta("territorios/Av. Nossa S. de Copacabana");
			frame.add(panel);	
		}
		
		else if((x <= 374 && x >= 320) && (y >= 600 && y <= 700)){
			JPanel panel = desenhaCarta("companhias/company1");
			frame.add(panel);	
		}
		
		else if((x <= 319 && x >= 264) && (y >= 600 && y <= 700)){
			JPanel panel = desenhaCarta("territorios/Av. Brigadero Faria Lima");
			frame.add(panel);	
		}
		
		else if((x <= 263 && x >= 208) && (y >= 600 && y <= 700)){
			JPanel panel = desenhaCarta("companhias/company2");
			frame.add(panel);	
		}
		
		else if((x <= 207 && x >= 152) && (y >= 600 && y <= 700)){
			JPanel panel = desenhaCarta("territorios/Av. Reboucas");
			frame.add(panel);	
		}
		
		else if((x <= 151 && x >= 100) && (y >= 600 && y <= 700)){
			JPanel panel = desenhaCarta("territorios/Av. 9 de Julho");
			frame.add(panel);	
		}
		
		else if((x <= 100 && x >= 0) && (y >= 545 && y <= 600)){
			JPanel panel = desenhaCarta("territorios/Av. Europa");
			frame.add(panel);	
		}
		
		else if((x <= 100 && x >= 0) && (y >= 433 && y <= 488)){
			JPanel panel = desenhaCarta("territorios/Rua Augusta");
			frame.add(panel);	
		}
		else if((x <= 100 && x >= 0) && (y >= 377 && y <= 432)){
			JPanel panel = desenhaCarta("territorios/Av. Pacaembu");
			frame.add(panel);	
		}
		
		else if((x <= 100 && x >= 0) && (y >= 321 && y <= 376)){
			JPanel panel = desenhaCarta("companhias/company3");
			frame.add(panel);	
		}
		
		else if((x <= 100 && x >= 0) && (y >= 211 && y <= 266)){
			JPanel panel = desenhaCarta("territorios/Interlagos");
			frame.add(panel);	
		}
		
		else if((x <= 100 && x >= 0) && (y >= 101 && y <= 156)){
			JPanel panel = desenhaCarta("territorios/Morumbi");
			frame.add(panel);	
		}
		
		else if((x <= 155 && x >= 100) && (y >= 0 && y <= 100)){
			JPanel panel = desenhaCarta("territorios/Flamengo");
			frame.add(panel);	
		}
		
		else if((x <= 265 && x >= 210) && (y >= 0 && y <= 100)){
			JPanel panel = desenhaCarta("territorios/Botafogo");
			frame.add(panel);	
		}
		
		else if((x <= 375 && x >= 320) && (y >= 0 && y <= 100)){
			JPanel panel = desenhaCarta("companhias/company4");
			frame.add(panel);	
		}
		
		else if((x <= 430 && x >= 375) && (y >= 0 && y <= 100)){
			JPanel panel = desenhaCarta("territorios/Av. Brasil");
			frame.add(panel);	
		}
		
		else if((x <= 540 && x >= 485) && (y >= 0 && y <= 100)){
			JPanel panel = desenhaCarta("territorios/Av. Paulista");
			frame.add(panel);	
		}
		
		else if((x <= 600 && x >= 540) && (y >= 0 && y <= 100)){
			JPanel panel = desenhaCarta("territorios/Jardim Europa");
			frame.add(panel);	
		}
		
		else if((x <= 700 && x >= 600) && (y >= 100 && y <= 155)){
			JPanel panel = desenhaCarta("territorios/Copacabana");
			frame.add(panel);	
		}
		
		else if((x <= 700 && x >= 600) && (y >= 155 && y <= 210)){
			JPanel panel = desenhaCarta("companhias/company5");
			frame.add(panel);	
		}
		
		else if((x <= 700 && x >= 600) && (y >= 210 && y <= 265)){
			JPanel panel = desenhaCarta("territorios/Av. Vieira Souto");
			frame.add(panel);	
		}
		
		else if((x <= 700 && x >= 600) && (y >= 265 && y <= 320)){
			JPanel panel = desenhaCarta("territorios/Av. Atlantica");
			frame.add(panel);	
		}
		
		else if((x <= 700 && x >= 600) && (y >= 320 && y <= 375)){
			JPanel panel = desenhaCarta("companhias/company6");
			frame.add(panel);	
		}
		
		else if((x <= 700 && x >= 600) && (y >= 375 && y <= 430)){
			JPanel panel = desenhaCarta("territorios/Ipanema");
			frame.add(panel);	
		}
		
		else if((x <= 700 && x >= 600) && (y >= 485 && y <= 540)){
			JPanel panel = desenhaCarta("territorios/Jardim Paulista");
			frame.add(panel);	
		}
		
		else if((x <= 700 && x >= 600) && (y >= 540 && y <= 600)){
			JPanel panel = desenhaCarta("territorios/Brooklin");
			frame.add(panel);	
		}
		
	
		frame.setVisible(true);
		
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private JPanel desenhaCarta(String s) {
		try {
			aux = ImageIO.read(new File("images/" + s + ".png"));
			} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
					
				g2d.drawImage(aux,0,0,null);
			}
		};
		return panel;
	}
}
