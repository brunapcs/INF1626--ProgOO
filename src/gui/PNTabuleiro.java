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
	
	private static PNTabuleiro tab =null; 
	private BufferedImage i=null;
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
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println(x+" e "+y);
		
		JFrame frame = new JFrame("Visualizacao de carta selecionada");
		JPanel panel = new JPanel();
		
		frame.setSize(300, 300);
		
		panel.setSize(300, 300);
		
		if((x <= 600 && x >= 540) && (y >= 600 && y <= 700)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Leblon.png"));
			panel.add(label);	
		}
		else if ((x <= 490 && x >= 430) && (y >= 600 && y <= 700)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Av. Presidente Vargas.png"));
			panel.add(label);	
		}
		
		else if((x <= 432 && x >= 375) && (y >= 600 && y <= 700)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Av. Nossa S. de Copacabana.png"));
			panel.add(label);	
		}
		
		else if((x <= 374 && x >= 320) && (y >= 600 && y <= 700)){
			JLabel label = new JLabel(new ImageIcon("images/companhias/company1.png"));
			panel.add(label);	
		}
		
		else if((x <= 319 && x >= 264) && (y >= 600 && y <= 700)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Av. Brigadero Faria Lima.png"));
			panel.add(label);	
		}
		
		else if((x <= 263 && x >= 208) && (y >= 600 && y <= 700)){
			JLabel label = new JLabel(new ImageIcon("images/companhias/company2.png"));
			panel.add(label);	
		}
		
		else if((x <= 207 && x >= 152) && (y >= 600 && y <= 700)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Av. Reboucas.png"));
			panel.add(label);	
		}
		
		else if((x <= 151 && x >= 100) && (y >= 600 && y <= 700)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Av. 9 de Julho.png"));
			panel.add(label);	
		}
		
		else if((x <= 100 && x >= 0) && (y >= 545 && y <= 600)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Av. Europa.png"));
			panel.add(label);	
		}
		
		else if((x <= 100 && x >= 0) && (y >= 433 && y <= 488)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Rua Augusta.png"));
			panel.add(label);	
		}
		else if((x <= 100 && x >= 0) && (y >= 377 && y <= 432)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Av. Pacaembu.png"));
			panel.add(label);	
		}
		
		else if((x <= 100 && x >= 0) && (y >= 321 && y <= 376)){
			JLabel label = new JLabel(new ImageIcon("images/companhias/company3.png"));
			panel.add(label);	
		}
		
		else if((x <= 100 && x >= 0) && (y >= 211 && y <= 266)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Interlagos.png"));
			panel.add(label);	
		}
		
		else if((x <= 100 && x >= 0) && (y >= 101 && y <= 156)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Morumbi.png"));
			panel.add(label);	
		}
		
		else if((x <= 155 && x >= 100) && (y >= 0 && y <= 100)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Flamengo.png"));
			panel.add(label);	
		}
		
		else if((x <= 265 && x >= 210) && (y >= 0 && y <= 100)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Botafogo.png"));
			panel.add(label);	
		}
		
		else if((x <= 375 && x >= 320) && (y >= 0 && y <= 100)){
			JLabel label = new JLabel(new ImageIcon("images/companhias/company4.png"));
			panel.add(label);	
		}
		
		else if((x <= 430 && x >= 375) && (y >= 0 && y <= 100)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Av. Brasil.png"));
			panel.add(label);	
		}
		
		else if((x <= 540 && x >= 485) && (y >= 0 && y <= 100)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Av. Paulista.png"));
			panel.add(label);	
		}
		
		else if((x <= 600 && x >= 540) && (y >= 0 && y <= 100)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Jardim Europa.png"));
			panel.add(label);	
		}
		
		else if((x <= 700 && x >= 600) && (y >= 100 && y <= 155)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Copacabana.png"));
			panel.add(label);	
		}
		
		else if((x <= 700 && x >= 600) && (y >= 155 && y <= 210)){
			JLabel label = new JLabel(new ImageIcon("images/companhias/company5.png"));
			panel.add(label);	
		}
		
		else if((x <= 700 && x >= 600) && (y >= 210 && y <= 265)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Av. Vieira Souto.png"));
			panel.add(label);	
		}
		
		else if((x <= 700 && x >= 600) && (y >= 265 && y <= 320)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Av. Atlantica.png"));
			panel.add(label);	
		}
		
		else if((x <= 700 && x >= 600) && (y >= 320 && y <= 375)){
			JLabel label = new JLabel(new ImageIcon("images/companhias/company6.png"));
			panel.add(label);	
		}
		
		else if((x <= 700 && x >= 600) && (y >= 375 && y <= 430)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Ipanema.png"));
			panel.add(label);	
		}
		
		else if((x <= 700 && x >= 600) && (y >= 485 && y <= 540)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Jardim Paulista.png"));
			panel.add(label);	
		}
		
		else if((x <= 700 && x >= 600) && (y >= 540 && y <= 600)){
			JLabel label = new JLabel(new ImageIcon("images/territorios/Brooklin.png"));
			panel.add(label);	
		}
		
		frame.add(panel);
		frame.pack();
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
	
}
