package regras;

import java.util.*;

import Cartas.Cartas;
import Cartas.SorteReves;
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
	private int  position_on =0;
	
	private ArrayList<Cartas>cartas =  Cartas.getCartas(); 
	private SorteReves sorte_on = null; 
	private  Jogador jogador_on = null; 
	private Cartas terreno_on = null; 
	
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
	
	
	public void addCarta(int terreno_on) {
		
		jogador_on.addProp(cartas.get(terreno_on)); 
	}

	public void rodada() {
		bot.showDados(false);
		
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
		
		jogador_on = tab.getJogador(player_on);
		
		
		if(numTurn == 3) { 
			//verificar se o jogador possui a carta "saida livre da prisao"
			//caso possua, nada ocorre, se nao possuir, prisao eh setado como true
			jogador_on.setPrisao(true); 
		}
		
		//jogada normal, jogador nao esta preso 
		if(jogador_on.getPrisao() == false){	
			position_on = (jogador_on.getPosition() + (d.getSoma())) % 40; 
			terreno_on = cartas.get(position_on);
			bot.showPlayerStats(jogador_on); 
			d.setCorDado(player_on);
			jogador_on.moveTo(position_on);
			
			//verifica se posicao eh uma esquina
			/***
			 * COD AQUI
			 */
		
			if(terreno_on == null )
			{ 	
				sorte_on = Cartas.tiraSorteReves(); 
				terreno_on = sorte_on; 
			}
			bot.showTerrenoStats(terreno_on);
			bot.showEncerrarJog(true); 
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
