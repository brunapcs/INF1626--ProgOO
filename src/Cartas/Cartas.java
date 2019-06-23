package Cartas;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cartas {
	
	 static ArrayList<Cartas> cartas = null ; 
	 static Queue<SorteReves>deck = null; 
	 String tipo; 
	 String proprietario = new String("-"); 
	 private int proprietarioIndex; 
	 BufferedImage i;
	 String nome = new String(); 
	 int preco = 0; 
	 
	 Cartas() { 	 
	 }
	 
	 public static ArrayList<Cartas> getCartas(){
		if(cartas == null ) {
			 cartas = new ArrayList<Cartas>(40); 
			 
			 //inicializa array list 
			 for(int i = 0 ; i <40; i++)
				 cartas.add(null); 
			 
			 //popula array list
			 CartaCompanhia.inicializaCompanhias();
			 CartaTerreno.inicializaTerreno(); 
		 }
		return cartas; 
	 }
	 
	 public static Queue<SorteReves> getSorteReves(){ 
		 if (deck == null) { 
			 deck = new LinkedList<>(); 
			 SorteReves.inicializaSorteReves(); 
		 }
		 Collections.shuffle((List<?>) deck);
		 return deck; 
	 }
	 
	 public Cartas getCartaInPos(int i) { 
		 return cartas.get(i); 
	 }
	 
	 public static SorteReves tiraSorteReves() { 
		 return deck.poll();
	 }
	 
	 public static void insereSorteReves(SorteReves e) { 
		 	deck.add(e);
	 }
	 
	 public String getTipo() { 
		 return tipo; 
	 }
	 
	 public void setProprietario(String cor_jogador) { 
		 proprietario = new String(cor_jogador);  
	 }
	 
	 public void setPropIndex(int i) { 
		 proprietarioIndex = i; 
	 }
	 
	 public int getProprietarioIndex() { 
		return proprietarioIndex; 
	 }
	 
	 public String getProprietario() { 
		 return proprietario; 
	 }
	
	public BufferedImage getImage() {
		return i;
	}
	
	public int getPreco() { 
		return preco; 
	}

	public String getNome() {
		return nome; 
	}
		
}
