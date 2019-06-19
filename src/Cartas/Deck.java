package Cartas;

import java.util.ArrayList;

public class Deck<Cartas> {
	public ArrayList<Cartas> cartas;
	
	public Cartas getCard(int index) {
		return cartas.get(index);
	}
	
	public int tamDeck() {
		return cartas.size();
	}
	
	public ArrayList<Cartas> getDeck(){
		return cartas;
	}
}
