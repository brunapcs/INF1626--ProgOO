package gui;

import regras.*; 
import utils.*;
import java.util.ArrayList;
import java.util.Queue; 


public class Factory {
	private static Factory fac = null; 
	
	private Factory()  {
		Fachada fa = Fachada.getFachada(); 
		PNBotoes bot = PNBotoes.getPNBotoes(); 
		PNTabuleiro tab = PNTabuleiro.getPNTabuleiro(); 
		ArrayList<CartaTerreno> ter = CartaTerreno.getTerrenos(); 
		ArrayList<CartaCompanhia> com = CartaCompanhia.getCompanhias(); 
		Queue<SorteReves> sorteRev =  SorteReves.getSorteReves(); 
	}
	
	public static Factory startFactory() { 
		if( fac == null) { 
			fac = new Factory() ; 
		}
		return fac; 
	}

}
