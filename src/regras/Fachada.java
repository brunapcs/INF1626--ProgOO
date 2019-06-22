package regras;

import java.io.File;

import utils.Dados;

public class Fachada {
	CtrlRegras ctrl;
	static Fachada f=null;
	private String statusJogo = new String(); 
	
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
			f=new Fachada(  jog_on , pos,  terr_on,  banco_saldo,  d1A,  d2A,  rodadas, status);
		return f;	
	}
	
	private Fachada( int jog_on ,int pos, int terr_on, int banco_saldo, int d1A, int d2A, int rodadas, String status) {
		statusJogo = status; 
		
		ctrl=new CtrlRegras(  jog_on , pos,  terr_on,  banco_saldo,  d1A,  d2A,  rodadas);
		
		if( status.equals("esperaJogada")){
			esperaJogada(); 
		}
		else if(status.equals("jogando")) { 
			jogando(); 
		}
	}
	
	public void esperaJogada() { 
		ctrl.desativaBotoes();
		ctrl.desativaDados();
		ctrl.ativaRolarDados();
	}
	public void jogando() { 
		ctrl.rodada(); 
	}
	
	public void register(Observer o) {
		ctrl.addObserver(o);
	}

	public void rolarDados() {
		ctrl.rolarDados();
		ctrl.rodada(); 
	}
	 
	public void encerrarJogada() { 
		ctrl.desativaBotoes();
		ctrl.desativaDados();
		ctrl.nextPlayer();
	}

	public void comprarTerreno() {
		ctrl.comprarTerreno(); 
	}
}
