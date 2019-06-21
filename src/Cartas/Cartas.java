package Cartas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cartas {
	
	 static ArrayList<Cartas> cartas = null ; 
	 static Queue<SorteReves>deck = null; 
	
	 Cartas() { 	 
	 }
	 
	 public static ArrayList<Cartas> getCartas(){
		if(cartas == null ) {
			 cartas = new ArrayList<Cartas>(40); 
			 
			 //inicializa array list 
			 for(int i = 0 ; i <40; i++)
				 cartas.add(new Cartas()); 
			 
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
		 return deck; 
	 }

}
