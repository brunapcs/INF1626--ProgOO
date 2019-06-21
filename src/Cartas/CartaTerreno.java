package Cartas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.imageio.ImageIO;

public class CartaTerreno extends Cartas{
	private int casa; 
	private int hotel; 
	private int hipoteca; 
	private Vector<Integer> aluguel = new Vector<Integer>(6); 
	private BufferedImage i; 
	private int pos; 
	
	private CartaTerreno(String n ,int cas, int hot, int hip ,int a, int b , int c , int d, int e, int f , int p){ 
		super(); 
		casa = cas; 
		hotel = hot; 
		hipoteca = hip; 
		aluguel.add(a); aluguel.add(b); aluguel.add(c); aluguel.add(d); aluguel.add(e); aluguel.add(e);
		pos = p; 
	
		try {
			   i=ImageIO.read(new File("images/territorios/" + n + ".png"));
			}
		catch(IOException e1){
			   System.out.println(e1.getMessage());
			   System.exit(1);
		}
		cartas.set(pos, this); 
	}

	public static void inicializaTerreno() { 
		CartaTerreno c ; 
		c = new CartaTerreno("Leblon", 50,50,50, 6,30,90,270,400,500 , 1); 
		//inicializar todas as cartas hardcoded aqui 
	 
	}
	public BufferedImage getImage() { 
		return i; 
	}
	
	public int getCasa() {
		return casa;
	}

	public void setCasa(int casa) {
		this.casa = casa;
	}

	public int getHotel() {
		return hotel;
	}

	public void setHotel(int hotel) {
		this.hotel = hotel;
	}

	public int getHipoteca() {
		return hipoteca;
	}

	public void setHipoteca(int hipoteca) {
		this.hipoteca = hipoteca;
	}	
	
}
