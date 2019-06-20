package regras;

import java.util.*;


import gui.PNBotoes;
import gui.PNTabuleiro;
import utils.Dados;


class CtrlRegras implements Observable {
	List<Observer> observers=new ArrayList<Observer>();
	private Dados d = null; 
	private PNTabuleiro tab = null ; 
	private PNBotoes bot = null; 
	
	private  int numTurn = 0; 
	private  int player_on = -1; 
	private  int d1Ant = 1; 
	private  int d2Ant = 0; 
	private  int banco = 0; 
	private  int numPlayers = 6; 
	
	public CtrlRegras() {
		tab = PNTabuleiro.getPNTabuleiro();
		bot = PNBotoes.getPNBotoes(); 
		d = Dados.getDados(); 
	}
	
	public void setNumPlayers(int n) { 
		numPlayers = n; 
	}
	
	public void repaintAll() { 
		tab.repaint();
	}
	
	public void rolarDados() { 
		d.sortearDados();
		tab.repaint();
	}

	public void rodada() {
		if(d1Ant != d2Ant){
			player_on++;
			if( player_on > numPlayers){ 
				player_on = 0; 
			}
			numTurn = 0; 
		}
		else{ 
			numTurn++; 
		}
		
		Jogador jogador_on = tab.getJogador(player_on);
		
		if(numTurn == 3) { 
			//verificar se o jogador possui a carta "saida livre da prisao"
			//caso possua, nada ocorre, se nao possuir, prisao eh setado como true
			jogador_on.setPrisao(true); 
		}
		
		//jogada normal, jogador nao esta preso 
		if(jogador_on.getPrisao() == false){	
			bot.showPlayerOn(player_on);
			bot.showPlayerStats(jogador_on.getSaldo()); 
			d.setCorDado(player_on);
			jogador_on.moveTo((jogador_on.getPosition() + (d.getSoma())) % 40); 
		}
		//jogada caso o jogador esta preso 
		else { 
			if (d.getDnum()[0] == d.getDnum()[1]) { 
				jogador_on.setPrisao(false);
			}	
		}
		d1Ant = d.getDnum()[0]; 
		d2Ant = d.getDnum()[1]; 
	}
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	@Override
	public Object get() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
