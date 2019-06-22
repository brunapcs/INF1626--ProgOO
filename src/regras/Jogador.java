package regras;

import utils.Coordenadas;
import java.io.*;
import javax.imageio.*;

import Cartas.Cartas;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;


public class Jogador {
	private BufferedImage i=null;
	private int pin_position = 0;
	private int saldo = 2458; 
	private boolean prisao = false; 
	private Coordenadas cord = new Coordenadas(); 
	private Random num = new Random();
	private int offset = num.nextInt(15) +1; 
	private ArrayList<Cartas>propriedades; 
	private String cor; 
	private int arrayPos; 
	private boolean liberdade =false ; 
  
	
	public Jogador(int num) {		
		try {
		   i=ImageIO.read(new File("images/pinos/pin" + Integer.toString(num) + ".png"));
		}
		catch(IOException e){
		   System.out.println(e.getMessage());
		   System.exit(1);
		}
		setCor(num); 
		arrayPos = num; 
	}
	
	private void setCor(int i) { 
	
		switch(i){
			case 0: 
				cor = new String("vermelho") ; 
				break; 
			case 1: 
				cor = new String("azul"); 
				break; 
			case 2:
				cor = new String("laranja"); 
				break; 
			case 3: 
				cor = new String("amarelo"); 
				break; 
			case 4: 
				cor = new String("roxo"); 
				break; 
			case 5: 
				 cor = new String( "cinza"); 
				 break; 
			}
	}
	
	public String getCor() { 
		return cor; 
	}
	public BufferedImage getJogadorImage() { 
		return i; 
	}
	
	public void moveTo(int pos) { 
		pin_position = pos; 
	}
	
	public int getSaldo() { 
		return saldo; 
	}
	
	public void setSaldo(int a) { 
		saldo+=  a; 
	}
	
	public int getPosition() {
		return pin_position;
	}
	
	public int getPosX() { 
		return cord.x[pin_position]; 
	}
	
	public int getPosY() { 
		return cord.y[pin_position]; 
	}
	public int getOffset() {
		return offset;
	}

	public void setPrisao(boolean p) { 
		prisao = p; 
	}
	public boolean getPrisao() {
		return prisao;
	}

	public boolean verificaProp(Cartas terreno) { 
		return propriedades.contains(terreno); 
	}
	
	public void addProp(Cartas terreno_on) {
		propriedades.add(terreno_on); 
	}
	public void remProp(Cartas terreno) { 
		propriedades.remove(terreno); 
	}

	public void movimentaSaldo(int preco) {
		saldo += preco; 
	}
	
	public void setLiberdade(boolean b) { 
		liberdade = b; 
	}

	public boolean getLiberdade() {
		return liberdade; 
	}

	
}
