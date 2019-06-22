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
	private  int banco = 50000; 
	private  int numPlayers; 
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
	
	public void rolarDados() { 
		d.sortearDados();
		tab.repaint();
	}

	public void nextPlayer() { 
		setNumPlayers(tab.getSizeJogadores());
		if(d1Ant != d2Ant){
			player_on++;
			if(player_on == numPlayers){ 
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
		bot.showComprarTerreno(false);
		bot.showPreco("", false);
		jogador_on.addProp(terreno_on);
		jogador_on.debita(terreno_on.getPreco()); 
		banco+= terreno_on.getPreco(); 
		terreno_on.setProprietario(jogador_on.getCor()); 
		bot.showTerrenoStats(terreno_on.getProprietario());
		bot.showPlayerStats(jogador_on.getSaldo(), jogador_on.getCor()); 
		jogadaComoProp(); 
	}
	
	public void desativaBotoes() { 
		bot.showComprarTerreno(false);
		bot.showPreco("", false);
		bot.showHipotecar(false);
		bot.showAdcCasa(false);
		terreno_on = null; 
		bot.setReady(false);
		bot.showProprietario(false); 
	}
	public void rodada() {
		bot.showRolarDados(false);
		bot.showEncerrarJog(true); 
		d1Ant = d.getDnum()[0]; 
		d2Ant = d.getDnum()[1]; 
		desativaBotoes(); 
		
		if (jogador_on.getPrisao() == false) { 
			rodadaNormal(); 
		}
		else { 
			rodadaPrisao(); 
		}
	}
	
	public void jogadaComoProp() { 
			//exibir os botoes que permitem ao jogador acrescentar casas etc ...
		
		
	}
	public void jogadaComoComprador() { 
		bot.showComprarTerreno(true);
		bot.showPreco(Integer.toString(terreno_on.getPreco()), true); 
	}
	
	public void jogadaComoPagador() { 
		//tem q pagar pro proprietario do terreno de acordo com as regras =
		//tem q verificar o tipo do terreno e como o pagamento deve ser efetuado
		
		bot.showComprarTerreno(false);
	}
	
	public void rodadaNormal() {	
			position_on = (jogador_on.getPosition() + (d.getSoma())) % 40; 
			jogador_on.moveTo(position_on);
			tab.repaint(); 
			terreno_on = cartas.get(position_on);
			
			if(position_on == 10 || position_on == 30) { 
				vaiPreso(); 
			}
			
			else if(position_on == 0 || position_on == 20 ) {
				if(position_on == 0) { 
					jogador_on.recebe(200); 
					banco -= 200; 
				}
				bot.showPlayerStats(jogador_on.getSaldo(), jogador_on.getCor()); 
			}
				
			else if(position_on == 24 || position_on == 18) { 
				if(position_on == 24)  //checar se esse eh o valor do imposto de renda 
				{
					jogador_on.debita(200); 
					banco+=200; 
				}
				else
				{
					jogador_on.recebe(200); 
					banco-=200; 
				}
			}
			
			else if(terreno_on == null ) //sorteReves
			{ 	
				sorte_on = Cartas.tiraSorteReves();
				Cartas.insereSorteReves(((SorteReves)sorte_on)); 
				terreno_on = sorte_on; 
				bot.setCartaImage(terreno_on.getImage()); 
				efetuaAcao(); 
			}
			
			else 
			{
				String p = terreno_on.getProprietario(); 
				bot.showTerrenoStats(p); 
				bot.setCartaImage(terreno_on.getImage());
				
				if (p.equals("-")) {  
					jogadaComoComprador(); 
				}
				else {
					if (p.equals(jogador_on.getCor())){ 
						jogadaComoProp(); 
					}
					else { 
						jogadaComoPagador(); 
					}
				}
			}
	}
	
	public void vaiPreso() {
		jogador_on.setPrisao(true);
		jogador_on.moveTo(10);
		terreno_on = null; 
		tab.repaint(); 
	}
	
	
	public void rodadaPrisao() { 
		int i;
		jogador_on = tab.getJogador(player_on);
		if (d.getDnum()[0] == d.getDnum()[1]) { 
			i = jogador_on.nullNumTurnPrisao();
			jogador_on.setPrisao(false);
			rodadaNormal();
			
		}	
		else {
			i = jogador_on.getNumTurnPrisao() + 1;
		}
		
		if(i == 3) {
			jogador_on.debita(50);  
			banco += 50;
			jogador_on.setPrisao(false);
		}
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
			if(((SorteReves)sorte_on).getTipoAcao().equals("sorte"))
				jogador_on.recebe(((SorteReves)sorte_on).getAcao()); 
			else 
				jogador_on.debita(((SorteReves)sorte_on).getAcao()); 
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
