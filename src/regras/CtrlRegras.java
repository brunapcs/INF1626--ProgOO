package regras;

import java.util.*;
import Cartas.CartaCompanhia;
import Cartas.CartaTerreno;
import Cartas.Cartas;
import Cartas.SorteReves;
import gui.PNBotoes;
import gui.PNTabuleiro;
import utils.Dados;
import gui.*; 

class CtrlRegras implements Observable {
	List<Observer> observers = new ArrayList<Observer>();
	private Dados d = null;
	private PNTabuleiro tab = null;
	private PNBotoes bot = null;
	private PNHistorico hist; 
	private int numTurn;
	private int player_on;
	private int d1Ant;
	private int d2Ant;
	private int banco;
	private int numPlayers;
	private int position_on;
	private int rodada;
	private ArrayList<Cartas> cartas = Cartas.getCartas();
	private SorteReves sorte_on;
	private Jogador jogador_on;
	private Cartas terreno_on;
	private int player_ant=-1; 
	private  ArrayList<Jogador>falidos = new ArrayList<Jogador>(); 
	private int divida = 0; 
	private Jogador prop = null;
	
	//Novo Jogo
	public CtrlRegras() {
		tab = PNTabuleiro.getPNTabuleiro();
		bot = PNBotoes.getPNBotoes();
		hist = PNHistorico.getHist(); 
		d = Dados.getDados();
		numTurn = 0;
		player_on = 0;
		d1Ant = 1;
		d2Ant = 0;
		banco = 50000;
		position_on = 0;
		rodada = 0;
		sorte_on = null;
		jogador_on = tab.getJogador(0);
		numPlayers = tab.getSizeJogadores(); 
		terreno_on = null;
		d.setCorDado(jogador_on.getCor());
		
	}
	
	//Load Jogo
	public CtrlRegras(int jog_on ,int pos, int terr_on, int banco_saldo, int d1A, int d2A, int rodadas) {
		tab = PNTabuleiro.getPNTabuleiro();
		d = Dados.getDados();
		player_on = jog_on;
		jogador_on = tab.getJogador(player_on); 
		d1Ant = d1A;
		d2Ant = d2A;
		banco = banco_saldo;
		position_on = pos;
		rodada = rodadas;
		jogador_on = tab.getJogador(jog_on);
		numPlayers = tab.getSizeJogadores(); 
		terreno_on = cartas.get(position_on);
		bot.loadAndShowPropList(jogador_on.getPropList());
		 
	}
	
	// **** Private Funcs ***** 
	private void recebe(Jogador p, int qtd) { 
		p.recebe(qtd);
		hist.addTransaction(p.getCor(),qtd, "recebeu"); 
		reloadJogadorStats(); 
	}
	
	private int debita(Jogador p, int deb) { 
		if(p == null ) { 
			hist.addTransaction("Todos os Jogadores", deb,"foram debitados"); 
			for(int i=0; i<numPlayers; i++) { 
				if (i != player_on) {
					p= tab.getJogador(i); 
					p.debita(deb);
				}
			}
			reloadJogadorStats(); 
		}
		else {
			if(verificaSaldo(jogador_on, deb)) {
				p.debita(deb);
				hist.addTransaction(jogador_on.getCor(), deb, "foi debitado");
			}
			else { 
					bot.showEncerrarJog(false);
					if(verificaVender()==false) {
						int s = jogador_on.getSaldo();
						declararFalencia(jogador_on); 
						return s; 
					}
					else{ 
						bot.showVender(true);
						divida = deb;
						return 0; 
					}
				}
			}
		return deb;
	}
	public boolean verificaFalencia() { 
		if (divida > jogador_on.getSaldo()) {
			if(verificaVender() == false) {
				if( prop != null) { 
					recebe(prop, jogador_on.getSaldo()); 
				}
				declararFalencia(jogador_on); 
				return true; 
			}
			else { 
				bot.showVender(true);
				return false; 
			}
		}
		else { 
			recebe(prop, divida); 
			debita(jogador_on, divida); 
			bot.showEncerrarJog(true); 
			divida =0; 
			prop = null; 
		}
		return false; 
		
	}
	
	public void declararFalencia(Jogador p) { 
		tab.remJogador(p); 
		bot.showFaliu(jogador_on.getCor()); 
		falidos.add(p); 
		encerraJogada();
		reloadJogadorStats(); 
		bot.showEncerrarJog(true);
		if (falidos.size()== numPlayers-1){
			bot.showVencedor();
			terminarJogo(); 
		}
		divida = 0; 
		prop = null; 
	}
	
	private boolean verificaSaldo(Jogador p, int deb) { 
		if (p.getSaldo()< deb)
			return false; 
		else return true; 
	}
	
	private void mover(Jogador p, int pos) { 
		p.moveTo(pos);
		tab.repaint();
		if (p == jogador_on) {
			position_on = pos; 
			terreno_on = cartas.get(pos); 
		}
	}
	private boolean verificaVender() { 
		if( jogador_on.getPropriedades().size()>0) { 
			bot.showVender(true); 
			return true;
		}
		else 
			bot.showVender(false); 
		return false; 
	}
	private boolean verificaLiberdade() {
		if(jogador_on.getLiberdade() == true) { 
			bot.showLiberdade(); 
			jogador_on.setLiberdade(false);
			return true; 
		}
		return false;
	}
	
	private void reloadJogadorStats() { 
		bot.setSaldo(jogador_on.getSaldo()); 
		bot.setJogadorOn(jogador_on.getCor()); 
		bot.loadAndShowPropList(jogador_on.getPropList()); 
		verificaVender(); 
		if(jogador_on.getPrisao()) 
			bot.showPrisao(true);
		else 
			bot.showPrisao(false);
		
	}
	public void vaiPreso() {
		jogador_on.setPrisao(true);
		mover(jogador_on, 10);
		tab.repaint();
		reloadJogadorStats(); 
		encerraJogada(); 
	}
	
	private void incCorTerreno() { 
		String corTerreno = ((CartaTerreno)terreno_on).getCor(); 
		int num=0; 
		if(corTerreno.equals("Rosa"))
			num=0; 
		else if(corTerreno.equals("Azul")) 
			num =1; 
		else if(corTerreno.equals("Vinho")) 
			num=2; 
		else if(corTerreno.equals("Laranja"))
			num=3; 
		else if(corTerreno.equals("Vermelho")) 
			num=4; 
		else if(corTerreno.equals("Amarelo")) 
			num=5;
		else if(corTerreno.equals("Verde")) 
			num=6; 
		else if(corTerreno.equals("Roxo")) 
			num=7;
		
		jogador_on.incQtdCasasCor(num);
	}
	//efetua acao de sorte reves 
	private void efetuaAcao() {
		String a = ((SorteReves) sorte_on).getTipo();
		if (a.equals("prisao")) {
			if (jogador_on.getLiberdade() == false)
				vaiPreso();
			else
				jogador_on.setLiberdade(false);	
		} 
		else if (a.equals("liberdade")) {
			jogador_on.setLiberdade(true);
		} 
		else if (a.equals("ponto de partida")) {
			mover(jogador_on, 0); 
		} 
		else if(a.equals("aposta")) { 
			System.out.print("aposta");
			debita(null, 50);
			recebe(jogador_on, numPlayers*50); 
		}
		else{
			if (((SorteReves) sorte_on).getTipoAcao().equals("sorte"))
				recebe(jogador_on , ((SorteReves) sorte_on).getAcao() );
			else
				debita(jogador_on, ((SorteReves)sorte_on).getAcao());
		}
		
	}
	
	//verifica se jogador possui todas casas de uma cor e esta habilitado a adc hotel
		private void VerificaHotel() {
			if(jogador_on.getQtdCasasCor(0) == 3 || jogador_on.getQtdCasasCor(1) == 3 || jogador_on.getQtdCasasCor(2) == 3 || jogador_on.getQtdCasasCor(3) == 2 ||
					jogador_on.getQtdCasasCor(4) == 2 || jogador_on.getQtdCasasCor(5) == 3 || jogador_on.getQtdCasasCor(6) == 4 || jogador_on.getQtdCasasCor(7) == 2) {
					bot.showAdcCasa(true);
			}
			ArrayList<Cartas> aux = jogador_on.getPropriedades();
			
			for(int i = 0; i < aux.size(); i++) {
				if( aux.get(i).getTipo().equals("terreno")){
					CartaTerreno ctAux = (CartaTerreno)aux.get(i);
						if(ctAux.getNumCasas() == 4) {
							bot.showAdcHotel(true);
					}
				}
			}
		}
		
	//verifica se jogador possui todas propriedades de uma cor e esta habilitado a adc casas
		public void VerificaPropriedades() {
			int aux[] = new int[] {3,3,3,2,2,3,4,2};	//vetor da qtd de todas as cores
			String[] arrayCor = {"Rosa","Azul","Vinho","Laranja","Vermelho","Amarelo","Verde","Roxo"};
			ArrayList<Cartas> listAux;
			
			for(int i = 0; i < 8; i++) {
				if(jogador_on.getQtdCasasCor(i) == aux[i]) {
					for(int j = 0; j < aux[i]; j++) {
						listAux = jogador_on.getPropriedadesCor(arrayCor[i]);
						CartaTerreno ct = (CartaTerreno)listAux.get(j);
						bot.addShowCasa(listAux.get(j).getNome(), ct.getPos(), ct.getCasa()); 
					}
				}
			}
		}
		
	// ***************************************** // 
	//********** BUTTON ACTIVATED ***************// 
		
	public void rolarDados() {
			d.sortearDados();
			tab.repaint();
	}
	public void rolarDados(int d1, int d2) {
		d.sortearDados(d1, d2);
		tab.repaint();
	}
	public void comprarTerreno() {
		if (jogador_on.getSaldo()> terreno_on.getPreco()){
			bot.showComprarTerreno(false);
			bot.showPreco("", false);
			jogador_on.addProp(terreno_on);
			debita(jogador_on, terreno_on.getPreco() );
			banco += terreno_on.getPreco();
			terreno_on.setProprietario(jogador_on.getCor());
			terreno_on.setPropIndex(player_on);
			bot.showTerrenoStats(terreno_on.getProprietario());
			
			if(terreno_on.getTipo().equals("terreno")) { 
				incCorTerreno(); 
			}
		}
		else { 
			bot.showFaltaDin();
		}
		reloadJogadorStats(); 
	}
	public void venderProp(Jogador jogador, String propName) {
		if (jogador == null )
			jogador = jogador_on; 
		Cartas prop = jogador.findPropriedade(propName); 
		jogador.remProp(prop);
		
		if(prop.getTipo().equals("companhia")) { //venda de companhia 
			System.out.print(Integer.toString(prop.getPreco())); 
			recebe(jogador, prop.getPreco() * 90/100 );
			banco -= prop.getPreco() * 90/100; 
		}
		else{ 									//venda de terreno 
			CartaTerreno terr = (CartaTerreno)prop; 
			recebe(jogador, (prop.getPreco() + terr.getAluguel(terr.getNumCasas())) * 90/100);
			banco -= (terr.getPreco() + terr.getAluguel(terr.getNumCasas())) * 90/100; 
		}
		
		bot.zeraPropList();
		verificaVender(); 
		prop.setProprietario("-");
		prop.setPropIndex(-1);
		if( terreno_on != null)
			bot.showTerrenoStats(terreno_on.getProprietario());
		reloadJogadorStats(); 
		if(divida > 0){
			verificaFalencia(); 
		}
	}
	
	public void desativaDados() {
		d.setReady(false);
		tab.repaint();
	}
	public void ativaRolarDados() { 
		bot.showRolarDados(true);
	}
	
	public void showPropCard(String propName) {
		tab.desenhaCarta(propName); 
	}
	
	public void addCasaInTerreno(Integer pos) {
		CartaTerreno terreno = ((CartaTerreno)cartas.get(pos)); 
		terreno.addCasa();
		debita(jogador_on, terreno.getCasa());
		banco += terreno.getCasa();
	}
	
	//********* GERENCIAMENTO DE RODADAS ************// 
	
	
	public void nextPlayer() {
		player_ant = player_on; 
		if (d1Ant != d2Ant || numTurn >=3) {
			player_on++;
			if (player_on == tab.getSizeJogadores()) {
				player_on = 0;
			}
			numTurn = 0; 
		} 
		else {
			numTurn++; 
		}
		jogador_on = tab.getJogador(player_on);
		reloadJogadorStats(); 
		d.setCorDado(jogador_on.getCor());
	}
	
	
	public void rodada() {
		
		desativaBotoes();
		bot.showRolarDados(false);
		bot.showEncerrarJog(true);
		VerificaPropriedades(); 
		d1Ant = d.getDnum()[0];
		d2Ant = d.getDnum()[1];
		boolean p = true; 
		
		if(player_ant == player_on){
			numTurn++; 
			if(numTurn >= 3 && d1Ant == d2Ant) { 
				if(verificaLiberdade() == false) {
					vaiPreso();
					p = false;
				}
			}
		
		}
		if (jogador_on.getPrisao() == false) {
			rodadaNormal();
		} 
		else {
			if (p) {
				rodadaPrisao();
				}
		}	
	}
	
	
	public void rodadaPrisao(){
		//show turnos na prisao
		if (jogador_on.getNumTurnPrisao() >= 3) {
			debita(jogador_on, 50); 
			bot.showLiberdade();
			banco += 50;
			jogador_on.setPrisao(false);
			rodadaNormal(); 
		}
		else if(d.getDnum()[0]== d.getDnum()[1]) { 
			bot.showLiberdade();
			jogador_on.setPrisao(false); 
			numTurn = 3; 
			rodadaNormal(); 
		}
		else {
			jogador_on.addNumTurnPrisao(); 
		}
		
		reloadJogadorStats(); 
	}
	
	public void rodadaNormal() {
		position_on = (jogador_on.getPosition() + (d.getSoma())) % 40;
		mover(jogador_on, position_on); 

		if (position_on == 30) { 
			if(verificaLiberdade() == false ){
				vaiPreso(); 
				nextPlayer(); 
			}
			else{ 
				encerraJogada(); 
				nextPlayer(); 
			}
		}
		else if (position_on == 0 || position_on == 20 || position_on == 10 ) { //cantos livres 
			if (position_on == 0) {
				recebe(jogador_on, 200); 
				banco -= 200;
			} 
		}
		else if (position_on == 24 || position_on == 18) { //posicoes de Pagamento
			if (position_on == 24) 
			{
				debita(jogador_on, 200); 
				banco += 200;
			} else {
				jogador_on.recebe(200);
				banco -= 200;
			}
		}
		else if (terreno_on == null) // sorteReves
		{
			sorte_on = Cartas.tiraSorteReves();
			Cartas.insereSorteReves(((SorteReves) sorte_on));
			terreno_on = sorte_on;
			bot.setCartaImage(terreno_on.getImage());
			efetuaAcao();
		}
		else 							//terrenos 
		{  
			String p = terreno_on.getProprietario();
			bot.showTerrenoStats(p);
			bot.setCartaImage(terreno_on.getImage());

			if (p.equals("-")) {   //terreno sem proprietario 
				jogadaComoComprador();
			}
			else {
				if (p.equals(jogador_on.getCor())== false) //terreno com proprietario
					jogadaComoPagador();
			}
		}
		reloadJogadorStats();
	}


	public void jogadaComoComprador() {
		bot.showComprarTerreno(true);
		bot.showPreco(Integer.toString(terreno_on.getPreco()), true);
	}

	public void jogadaComoPagador() {	
		int pagamento =0;
		 prop = tab.getJogador(terreno_on.getProprietarioIndex()); 
		
		if( terreno_on.getTipo().equals("terreno")){ 
			CartaTerreno ct = (CartaTerreno) terreno_on;
			pagamento = ct.getAluguel(ct.getNumCasas()); 
		}
		else if(terreno_on.getTipo().equals("companhia")) {
			CartaCompanhia cc = (CartaCompanhia) terreno_on;
			pagamento = cc.getMultiplicador() * d.getSoma(); 
		}
		
		recebe(prop, debita(jogador_on,pagamento) ); 
		reloadJogadorStats(); 
	}
	
	public void encerraJogada() { 
		desativaBotoes();
		desativaDados();
	}
	
	public void desativaBotoes() {
		bot.showComprarTerreno(false);
		bot.showPreco("", false);
		bot.showAdcCasa(false);
		terreno_on = null;
		bot.setReady(false);
		bot.showProprietario(false);
		bot.removeBotoesCasas(); 
		bot.zeraPropList(); 
		bot.showVender(false);
		bot.showPrisao(false);
		hist.limpaHistorico();
		divida =0; 
		prop= null;
	}
	
	// **** SALVAMENTO DO JOGO *******
	public String salvarJogo() {
		String jogo = new String(); 
		
		jogo += "numPlayers= " + Integer.toString(numPlayers) + "\n"; 
		jogo += "player_on= " + Integer.toString(player_on)+ "\n"; 
		
		return jogo;
	}
	
	// ****** OBSERVER **********
	@Override
	public Object get() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	public void calculaPontuacao() { 
		ArrayList<Jogador>jog = tab.getJogadoresList(); 
		
		for(int i =0; i<jog.size(); i++) { 
			for(int j =0; j < jog.get(i).getPropriedades().size(); j++) { 
				venderProp(jog.get(i), jog.get(i).getPropriedades().get(j).getNome()); 
			}
		}
	}

	public void terminarJogo() {
		ArrayList<Jogador>ordem = tab.getJogadoresList(); 
		Jogador aux; 
		calculaPontuacao(); 
		
		 for(int i = 0; i<ordem.size(); i++){
		        for(int j = 0; j<ordem.size()-1; j++){
		            if( ordem.get(i).getSaldo() < ordem.get(j + 1).getSaldo()){
		                aux = ordem.get(j);
		                ordem.set(j, ordem.get(j+1)); 
		                ordem.set(j+1, aux);
		            }
		        }
		    }
		 for(int i =falidos.size()-1; i>=0; i--) { 
			 ordem.add(falidos.get(i));
		 }
		
		new FRResultado(ordem); 
	}

	public void cheatSaldo(Integer i) {
		jogador_on.cheatSaldo(i);	
		reloadJogadorStats();
	}


	

}
