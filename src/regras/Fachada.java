package regras;

import utils.Dados;

public class Fachada {
	CtrlRegras ctrl;
	static Fachada f=null;
	
	private Fachada() {
		ctrl=new CtrlRegras();
	}
	
	public static Fachada getFachada() {
		if(f==null)
			f=new Fachada();
		return f;	
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
		ctrl.nextPlayer();
		
	}

	public void comprarTerreno() {
		ctrl.comprarTerreno(); 
	}
}
