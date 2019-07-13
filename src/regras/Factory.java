package regras;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;

import javax.swing.JPanel;

import Cartas.*;
import gui.PNBotoes;
import gui.PNHistorico;
import gui.PNTabuleiro;

public class Factory {
	private static Factory fac = null; 
	private PNTabuleiro tab = PNTabuleiro.getPNTabuleiro(); 
	private PNBotoes bot = PNBotoes.getPNBotoes();
	private int numJogadores;
	private PNHistorico hist = PNHistorico.getHist(); 
	private Fachada fa;
	private static ArrayList<Jogador> players;
	private ArrayList<Cartas> cards = Cartas.getCartas();
	private Queue <SorteReves> listaSR = Cartas.getSorteReves();
	private static int d1,d2;
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
		for(int i = 0; i < numJogadores; i++)
		{ 
			j = new Jogador(i); 
			tab.addJogador(j);
		}
	} 
	
	
	//Load Game
	private Factory(File loadJogo) throws IOException { 
		BufferedReader reader = new BufferedReader(new FileReader(loadJogo));
		String line;
		String[] parts;
		
		line = reader.readLine();
		parts = line.split(":");
		numJogadores = Integer.parseInt(parts[1]);
		
		players = new ArrayList<Jogador>(numJogadores);
		
		line = reader.readLine();
		parts = line.split(":");
		int currentPlayer = Integer.parseInt(parts[1]);
		
		line = reader.readLine();
		parts = line.split(":");
		int posCurrentPlayer = Integer.parseInt(parts[1]);
		
		line = reader.readLine();
		parts = line.split(":");
		int saldoBanco = Integer.parseInt(parts[1]);
		
		line = reader.readLine();
		parts = line.split(":");
		int rodada = Integer.parseInt(parts[1]);
		
		line = reader.readLine();
		parts = line.split(":");
		d1 = Integer.parseInt(parts[1]);
		
		line = reader.readLine();
		parts = line.split(":");
		d2 = Integer.parseInt(parts[1]);
		
		for(int i = 0; i < numJogadores; i++) {
			int saldo, pos, indice, coordX, coordY, numTurnPrisao, offset, numProp;
			boolean passeLivre, prisao;
			String cor;
			
			line = reader.readLine();
			parts = line.split(":");
			indice = Integer.parseInt(parts[1]);
			
			line = reader.readLine();
			parts = line.split(":");
			cor = parts[1];
			
			line = reader.readLine();
			parts = line.split(":");
			pos = Integer.parseInt(parts[1]);
			
			line = reader.readLine();
			parts = line.split(":");
			saldo = Integer.parseInt(parts[1]);
			
			line = reader.readLine();
			parts = line.split(":");
			prisao = Boolean.parseBoolean(parts[1]);
			
			line = reader.readLine();
			parts = line.split(":");
			passeLivre = Boolean.parseBoolean(parts[1]);
			
			line = reader.readLine();
			parts = line.split(":");
			coordX = Integer.parseInt(parts[1]);
			
			line = reader.readLine();
			parts = line.split(":");
			coordY = Integer.parseInt(parts[1]);
			
			line = reader.readLine();
			parts = line.split(":");
			offset = Integer.parseInt(parts[1]);
			
			line = reader.readLine();
			parts = line.split(":");
			numTurnPrisao = Integer.parseInt(parts[1]);
			
			line = reader.readLine();
			parts = line.split(":");
			numProp = Integer.parseInt(parts[1]);
			ArrayList<Cartas> cardPlayer = new ArrayList<Cartas>();
			
			for(int k = 0; k < numProp; k++) {
				String tipo, nome, corTer;
				int posTer, preco, casas, valorCasa, valorHotel, mult, index;
				int[] aluguel = new int[6];
				
				line = reader.readLine();
				parts = line.split(":");
				tipo = parts[1];
				
				if(tipo.equals("terreno")) {
					
					line = reader.readLine();
					parts = line.split(":");
					nome = parts[1];
					
					line = reader.readLine();
					parts = line.split(":");
					corTer = parts[1];
					
					line = reader.readLine();
					parts = line.split(":");
					preco = Integer.parseInt(parts[1]);
					
					line = reader.readLine();
					parts = line.split(":");
					posTer = Integer.parseInt(parts[1]);
					
					line = reader.readLine();
					parts = line.split(":");
					String[] aux = parts[1].split("\\s");
					
					for(int e = 0; e < 6; e++) {
						aluguel[e] = Integer.parseInt(aux[e]);
					}
					
					line = reader.readLine();
					parts = line.split(":");
					casas = Integer.parseInt(parts[1]);
					
					line = reader.readLine();
					parts = line.split(":");
					valorCasa = Integer.parseInt(parts[1]);
					
					line = reader.readLine();
					parts = line.split(":");
					valorHotel = Integer.parseInt(parts[1]);
					
					cardPlayer.add(cards.get(posTer));
				}
				
				else if(tipo.equals("companhia")) {
					line = reader.readLine();
					parts = line.split(":");
					nome = parts[1];
					
					line = reader.readLine();
					parts = line.split(":");
					index = Integer.parseInt(parts[1]);
					
					line = reader.readLine();
					parts = line.split(":");
					preco = Integer.parseInt(parts[1]);
					
					line = reader.readLine();
					parts = line.split(":");
					posTer = Integer.parseInt(parts[1]);
					
					line = reader.readLine();
					parts = line.split(":");
					mult = Integer.parseInt(parts[1]);
					
					cardPlayer.add(cards.get(posTer));
				}
				players.add(new Jogador(indice, saldo, prisao, pos, numTurnPrisao, coordX, coordY, passeLivre, cardPlayer));
			}
			
			
		}
		reader.close();
			
		}
	
	public static Factory startFactory(File loadJogo) throws IOException { 
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
	public static ArrayList<Jogador> getPlayers(){
		return players;
	}
}
