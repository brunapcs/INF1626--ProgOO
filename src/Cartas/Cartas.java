package Cartas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cartas {
	
	 static ArrayList<Cartas> cartas = null ; 
	 static Queue<SorteReves>deck = null; 
	
	 Cartas() { 	 
	 }
	 
	 public ArrayList<Cartas> getCartas(){
		if(cartas == null ) {
			 cartas = new ArrayList<Cartas>(40); 
			 CartaCompanhia.inicializaCompanhias();
			 CartaTerreno.inicializaTerreno(); 
		 }
		return cartas; 
	 }
	 
	 public Queue<SorteReves> getSorteReves(){ 
		 if (deck == null) { 
			 deck = new LinkedList<>(); 
			 SorteReves.inicializaSorteReves(); 
		 }
		 return deck; 
	 }

}
