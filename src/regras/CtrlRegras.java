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

	public void nextPlayer() { 
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
			if(jogador_on.getLiberdade() == true ) { 
				jogador_on.setLiberdade(false); 
			}
			else {
				vaiPreso(); 
				player_on++; 
				if(player_on > numPlayers)
					player_on = 0;
				numTurn++; 
			}
		}
		bot.showPlayerStats(jogador_on.getSaldo(), jogador_on.getCor());
		d.setCorDado(player_on);
		tab.repaint();
	}
	
	public void comprarTerreno() {
		jogador_on.addProp(terreno_on);
		jogador_on.movimentaSaldo(-(terreno_on.getPreco())); 
		terreno_on.setProprietario(jogador_on.getCor()); 
		bot.showTerrenoStats(terreno_on.getProprietario());
		bot.showPlayerStats(jogador_on.getSaldo(), jogador_on.getCor()); 
	}
	
	public void rodada() {
		bot.showDados(false);
		
		if(jogador_on.getPrisao() == false){	
			position_on = (jogador_on.getPosition() + (d.getSoma())) % 40; 
			terreno_on = cartas.get(position_on);
			jogador_on.moveTo(position_on);
			
			if(position_on == 10 || position_on == 30) { 
				vaiPreso(); 
			}
			else if(position_on == 0 || position_on == 20 ) {
				terreno_on = null; 
				bot.setReady(false); 
			}
				
			else if(terreno_on == null )
			{ 	
				sorte_on = Cartas.tiraSorteReves(); 
				terreno_on = sorte_on; 
				efetuaAcao(); 
			}
		
			bot.setCartaImage(terreno_on.getImage()); 
			bot.showTerrenoStats(terreno_on.getProprietario());
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
	
	public void vaiPreso() {
		jogador_on.setPrisao(true);
		jogador_on.moveTo(10);
		terreno_on = null; 
		tab.repaint(); 
	}
	public void efetuaAcao() {
		String a = ((SorteReves)sorte_on).getTipo(); 
		if(a.equals("prisao")) { 
			if(jogador_on.getLiberdade() == false)
				vaiPreso(); 
			else 
				jogador_on.setLiberdade(false);
		}
		else if(a.equals("liberdade")) { 
			jogador_on.setLiberdade(true);
		}
		else if(a.equals("ponto de partida")) { 
			jogador_on.moveTo(0);
			position_on = 0;
			tab.repaint(); 
		}
		else { 
			jogador_on.movimentaSaldo(((SorteReves)sorte_on).getAcao());
			bot.showPlayerStats(jogador_on.getSaldo(), jogador_on.getCor()); 
		}	
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
