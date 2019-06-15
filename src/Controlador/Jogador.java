package Controlador;
import javax.swing.*;
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
	public BufferedImage i=null;
	private int pin_position = 0;
	private int saldo = 2458; 
	private boolean prisao = false; 
	
	Coordenadas cord = new Coordenadas(); 
	Random num = new Random(); 
	private int offset = num.nextInt(15) +1; 
	
	public Jogador(int num) {		
			try {
			   i=ImageIO.read(new File("images/pinos/pin" + Integer.toString(num) + ".png"));
			}
			catch(IOException e){
			   System.out.println(e.getMessage());
			   System.exit(1);
			}
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