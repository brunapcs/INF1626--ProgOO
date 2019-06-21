package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList; 
import java.util.Queue;

import javax.imageio.ImageIO;

import java.util.Collections;

public class SorteReves {

	private static Queue<SorteReves>deck = new LinkedList<>(); 
	private BufferedImage i;
	private int acao; 
	
	//se acao = 0 a carta eh uma carta de liberdade da prisao
	
	private SorteReves(int num, int a){ 
		acao = a; 
		try {
			   i=ImageIO.read(new File("images/sorteReves/chance" + Integer.toString(num) + ".png"));
			}
			catch(IOException e){
			   System.out.println(e.getMessage());
			   System.exit(1);
			}
		deck.add(this); 
		
	}
	
	public static Queue<SorteReves> getSorteReves(){
		if( deck.size() < 1 ) { 
			SorteReves s; 
			s = new SorteReves(1, 25); 
			// declarar todas as cartas sorte reves hardcoded aqui 
		}
		
		return deck; 
	}

	public BufferedImage getI() {
		return i;
	}

	public void setI(BufferedImage i) {
		this.i = i;
	}

	public int getAcao() {
		return acao;
	}

	public void setAcao(int acao) {
		this.acao = acao;
	}
	
	
	
}
