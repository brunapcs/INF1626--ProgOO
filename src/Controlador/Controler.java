package Controlador;


import Acoes.RolarDados;
import MenuIni.*;


public class Controler {

    private static Tabuleiro tab_p = new Tabuleiro(); 
	private static Botoes botoes =  new Botoes(); 
	public static RolarDados dados = new RolarDados(); 
	public static MenuInicial menuIni = null;
	public static Jogo jogo = null; 

	public static int numTurn = 0; 
	public static int player_on = 0; 

	
	public static int d1Ant = 1; 
	public static int d2Ant = 0; 
	
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
		
		if(d1Ant != d2Ant){
			player_on++;
			if( player_on > tab_p.getNumJogadores() - 1){ 
				player_on = 0; 
			}
			numTurn = 0; 
		}
		else{ 
			numTurn++; 
		}
		
		Jogador jogador_on = tab_p.getJogador(player_on);
		
		if(numTurn == 3) { 
			//verificar se o jogador possui a carta "saida livre da prisao"
			//caso possua, nada ocorre, se nao possuir, prisao eh setado como true
			jogador_on.setPrisao(true); 
		}
		
		
		if(jogador_on.getPrisao() == false){	
			botoes.showPlayerOn(player_on);
			dados.setCorDado(player_on);
			jogador_on.moveTo((jogador_on.getPosition() + (d1+d2)) % 40); 
		}
		else { 
			if (d1 == d2) { 
				jogador_on.setPrisao(false);
			}
			
		}
		
		tab_p.repaint(); 
		tab_p.setVisible(true);	
		
		d1Ant = d1; 
		d2Ant = d2; 
	
	}
	
	
	
}
