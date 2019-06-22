package gui;

import regras.*; 
import utils.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

import Cartas.*;


public class Factory {
	private static Factory fac = null; 
	
	private Factory()  {
		Fachada fa = Fachada.getFachada(); 
		PNBotoes bot = PNBotoes.getPNBotoes(); 
		PNTabuleiro tab = PNTabuleiro.getPNTabuleiro(); 
		ArrayList<Cartas> cartas = Cartas.getCartas();
		Queue<SorteReves> deck = Cartas.getSorteReves(); 
		
	}
	
	public static Factory startFactory() { 
		if( fac == null) { 
			fac = new Factory() ; 
		}
		return fac; 
	}

}
