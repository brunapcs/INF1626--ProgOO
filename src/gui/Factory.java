package gui;

import regras.*; 
import utils.*; 
import menuIni.*; 

public class Factory {
	private static Factory fac = null; 
	
	private Factory() {
		Fachada fa = Fachada.getFachada(); 
		PNBotoes bot = PNBotoes.getPNBotoes(); 
		PNTabuleiro tab = PNTabuleiro.getPNTabuleiro(); 
		
	}
	public static Factory startFactory() { 
		if( fac == null) { 
			fac = new Factory() ; 
		}
		return fac; 
	}

}
