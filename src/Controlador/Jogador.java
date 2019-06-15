package Controlador;
import javax.swing.*;
import Cartas.*; 
import java.io.*;
import javax.imageio.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	
	private ArrayList<Cartas> propriedades = new ArrayList<Cartas>();  
	private ArrayList<SorteReves> sorteReves = new ArrayList<SorteReves>();  
	
	public Jogador(int num) {		
			try {
			   i=ImageIO.read(new File("images/pinos/pin" + Integer.toString(num) + ".png"));
			}
			catch(IOException e){
			   System.out.println(e.getMessage());
			   System.exit(1);
			}
	}
	
	public void addPropriedade(Cartas p){ 
		String tipo = p.getTipo(); 
		if (tipo == "terreno") { 
			propriedades.add((Casas)p); 
		}
		else if (tipo == "companhia") { 
			propriedades.add((Companhias)p); 
		}
		else {
			System.out.println("Nao pode comprar esse lote"); 
		}
	}
	
	public boolean removerPropriedade(Cartas p) { 
		return propriedades.remove(p); 
	}
	
	public BufferedImage getJogadorImage() { 
		return i; 
	}
	
	public void moveTo(int pos) { 
		pin_position = pos; 
	}
	
	public void setPrisao(boolean p) { 
		prisao = p; 
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

	public boolean getPrisao() {
		return prisao;
	}
	
}