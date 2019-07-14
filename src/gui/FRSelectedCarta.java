package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Cartas.*; 

import regras.Fachada;
import regras.Observable;
import regras.Observer;
import gui.PNTabuleiro;

public class FRSelectedCarta extends JFrame implements Observer {
	
	Observable obs;
	Object ob;
	int clicks[];
	private BufferedImage aux = null;  
	
	public FRSelectedCarta() { 
		Fachada.getFachada().register(this);
	}
	
	public void notify(Observable o) {
		obs=o;
		ob = obs.get();
				
		clicks= (int []) ob; 
		
		showFrame(clicks[0], clicks[1]); 
	}
	
	private void showFrame(int x, int y) { 
		
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
	
	public JPanel desenhaCarta(String s) {
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

