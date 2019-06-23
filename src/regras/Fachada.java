package regras;

import java.io.File;

import utils.Dados;

public class Fachada {
	CtrlRegras ctrl;
	static Fachada f=null;
	
	//Novo Jogo
	public static Fachada getFachada() {
		if(f==null)
			f=new Fachada();
		return f;	
	}
	
	private Fachada() {
		ctrl=new CtrlRegras();
		esperaJogada(); 
	}
	
	//Jogo Antigo 
	public static Fachada getFachada( int jog_on ,int pos, int terr_on, int banco_saldo, int d1A, int d2A, int rodadas, String status) {
		if(f==null)
			f=new Fachada(  jog_on , pos,  terr_on,  banco_saldo,  d1A,  d2A,  rodadas);
		return f;	
	}

	private Fachada( int jog_on ,int pos, int terr_on, int banco_saldo, int d1A, int d2A, int rodadas) {
	
		ctrl=new CtrlRegras(  jog_on , pos,  terr_on,  banco_saldo,  d1A,  d2A,  rodadas);
		esperaJogada();
	}
	
	public void esperaJogada() { 
		ctrl.desativaBotoes();
		ctrl.desativaDados();
		ctrl.ativaRolarDados();
	}
	
	public void register(Observer o) {
		ctrl.addObserver(o);
	}

	public void rolarDados() {
		ctrl.rolarDados();
		ctrl.rodada(); 
	}
	public void cheat(Integer d1, Integer d2) {
		ctrl.rolarDados(d1,d2); 
		ctrl.rodada(); 
	}
	 
	public void encerrarJogada() { 
		ctrl.encerraJogada(); 
		ctrl.nextPlayer();
	}

	public void comprarTerreno() {
		ctrl.comprarTerreno(); 
	}
	
	public String getJogoInfo() { 
		return ctrl.salvarJogo(); 
	}

	public void addCasa(Integer pos) {
		ctrl.addCasaInTerreno(pos); 
	}

	public void showProp(String propName) {
		ctrl.showPropCard(propName); 
	}

	public void venderProp(String propName) {
		ctrl.venderProp(null, propName); 
		
	}

	public void terminarJogo() {
		ctrl.terminarJogo(); 
		
	}

	public void cheatSaldo(Integer i) {
		ctrl.cheatSaldo(i); 
		
	}

	
	
}
