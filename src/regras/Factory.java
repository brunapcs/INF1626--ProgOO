package regras;

import regras.*; 
import utils.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

import javax.swing.JPanel;

import Cartas.*;
import gui.PNBotoes;
import gui.PNHistorico;
import gui.PNTabuleiro;


public class Factory {
	private static Factory fac = null; 
	private PNTabuleiro tab; 
	private PNBotoes bot;
	private int numJogadores ;
	private PNHistorico hist; 
	private Fachada fa; 
	
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
		hist = PNHistorico.getHist(); 
		
		fa = Fachada.getFachada(); 
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
		BufferedReader reader;
		try{
			reader = new BufferedReader(new FileReader(loadJogo));
			String jogo = "";
			try 
			{
			    StringBuilder sb = new StringBuilder();
			    String line = reader.readLine();
			    while (line != null) 
			    {
			        sb.append(line);
			        sb.append("\n");
			        line = reader.readLine();
			    }
			    jogo = sb.toString();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			} 
			finally 
			{
			    try {
					reader.close();
			    }
			    catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			System.out.print(jogo);
			
		}
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	
	public static Factory startFactory(File loadJogo) { 
		if (fac ==null) { 
			fac = new Factory(loadJogo); 
		}
		return fac; 
	}
	
	//
	public String getJogoInfo() { 
		return fa.getJogoInfo(); 
	}
	
	public JPanel getTab() { 
		return tab; 
	}
	public JPanel getBot() { 
		return bot; 
	}

	public JPanel getHist() { 
		return hist; 
	}
	public void terminarJogo() {
		fa.terminarJogo(); 
	}
	

}
