package Controlador;


import Acoes.RolarDados;
import MenuIni.*;


public class Controler {

    private static Tabuleiro tab_p = new Tabuleiro(); 
	private static Botoes botoes =  new Botoes(); 
	public static RolarDados dados = new RolarDados(); 
	public static MenuInicial menuIni = null;
	public static Jogo jogo = null; 
	
	public static int player_turn = -1; 
	public static int player_on = 0; 
	private static int numTurn = 0;
	
	// public static Deck deck = new Deck();
	
	Controler(){ 
		
	}
    
	public static void main(String args[]) {
		jogo = new Jogo(); 
	    menuIni = new MenuInicial(); 
	 }	
	
	
	public static void setMenuIniVisible(boolean b) { 
		menuIni.setVisible(b); 
	}
	
	public static void setJogoVisible(boolean b) { 
		jogo.repaint(); 
		jogo.setVisible(b);
		
	}
	
	public static Jogo getJogo() { 
		return jogo; 
	}
	public static RolarDados getDados() { 
		return dados; 
	}
	
	public static Tabuleiro getTab_p() { 
		return tab_p; 
	}
	
	public static Botoes getBotoes_p() { 
		return botoes; 
	}
	
	public static int getPlayerOn() { 
		return player_on; 
	}

	public static void rodada(int d1, int d2) {
		player_turn++; 
		if( player_turn > tab_p.getNumJogadores() - 1) { 
			player_turn = 0; 
		}
		Jogador player_on = tab_p.getJogador(player_turn); 
		 
		
		botoes.showPlayerOn(player_turn);
		
		System.out.print(Integer.toString(player_turn));
		int soma = d1 + d2; 
		int pos = (player_on.getPosition() + soma) % 40 ; 
		player_on.moveTo(pos); 
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
		else { 
			numTurn = 0;
		}
	}
	
}
