package Controlador;


import MenuIni.*;


public class Controler {

    private static Tabuleiro tab_p = new Tabuleiro(); 
	private static Botoes botoes =  new Botoes(); 
	public static MenuInicial menuIni = null;
	public static Jogo jogo ; 
	public static int player_turn = -1; 
	private static int numTurn = 0;
	// public static Deck deck = new Deck();
	
	Controler(){ 
		
	}
    
	public static void main(String args[]) {
		jogo = new Jogo(); 
	    menuIni = new MenuInicial(); 
	 }	
	
	public static void novoJovo() { 
		jogo = new Jogo(); 
	}
	
	public static void setMenuIniVisible(boolean b) { 
		menuIni.setVisible(b); 
	}
	
	public static void setJogoVisible(boolean b) { 
		jogo.repaint(); 
		jogo.setVisible(b);
		
	}
	
	public static Tabuleiro getTab_p() { 
		return tab_p; 
	}
	
	public static Botoes getBotoes_p() { 
		return botoes; 
	}
	

	public static void rodada(int d1, int d2) {
		player_turn++; 
		if( player_turn > tab_p.getPlayersNum() - 1) { 
			player_turn = 0; 
		}
		Pin p = tab_p.getPin(player_turn); 
		int soma = d1 + d2; 
		int pos = (p.getPosition() + soma) % 40 ; 
		p.moveTo(pos); 
		tab_p.repaint(); 
		tab_p.setVisible(true);	
	
		if(d1 == d2) {
			player_turn--;
			numTurn++;
			if(numTurn == 3) {
				player_turn++;
				numTurn = 0;
			}
		}
	}
	
}
