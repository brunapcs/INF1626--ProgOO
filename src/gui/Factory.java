package gui;

import regras.*; 
import utils.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

import javax.swing.JPanel;

import Cartas.*;


public class Factory {
	private static Factory fac = null; 
	private PNTabuleiro tab; 
	private PNBotoes bot;
	private int numJogadores ;
	
	//Inicializa Novo Jogo
	public static Factory startFactory(int num) { 
		if( fac == null) { 
			fac = new Factory(num) ; 
		}
		return fac; 
	}
	
	private Factory(int num)  {
		numJogadores = num; 
		tab = PNTabuleiro.getPNTabuleiro(); 
		bot = PNBotoes.getPNBotoes();
		inicializaJogadores(); 
		ArrayList<Cartas> cartas = Cartas.getCartas();
		Queue<SorteReves> deck = Cartas.getSorteReves();
		
		Fachada fa = Fachada.getFachada(); 
	}
	
	private void inicializaJogadores(){ 
		Jogador j ; 
		for(int i =0; i< numJogadores; i++)
		{ 
			j = new Jogador(i); 
			tab.addJogador(j);
		}
	} 
	
	
	//Inicializa Jogo Antigo
	private Factory(File loadJogo) { 
		//faz a leitura do arquivo e instancia cada parada de acordo com as informacoes q precisam 
		//tab -> numero de jogadores, posicao de cada jogador, dinheiro, propriedades, prisao, 
	}
	
	public static Factory startFactory(File loadJogo) { 
		if (fac ==null) { 
			fac = new Factory(loadJogo); 
		}
		return fac; 
	}
	
	public JPanel getTab() { 
		return tab; 
	}
	public JPanel getBot() { 
		return bot; 
	}
	

}
