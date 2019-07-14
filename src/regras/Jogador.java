package regras;

import utils.Coordenadas;
import java.io.*;
import javax.imageio.*;

import Cartas.CartaCompanhia;
import Cartas.CartaTerreno;
import Cartas.Cartas;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Jogador {
	private BufferedImage i=null;
	private int pin_position = 0;
	private int saldo = 2458; 
	private boolean prisao = false; 
	private Coordenadas cord = new Coordenadas(); 
	private Random num = new Random();
	private int offset = num.nextInt(15) +1; 
	private ArrayList<Cartas>propriedades ; 
	private String cor;  
	private boolean liberdade = false ; 
	private int numTurnPrisao=0; 
	private int [][] QtdTerrenosCor= new int[8][2]; 
	private int index;

	/* Construtor para Jogador em um Novo Jogo*/
	public Jogador(int num) {	
		index =num;
		loadImage(index); 
		setCor(index); 
		initQtdTerrCor();
		propriedades = new ArrayList<Cartas>();
	}
	
	/* Construtor para Jogador em um jogo antigo carregado */
	public Jogador(int num, int din, boolean preso, int pos, int turnPrisao, int coordX, int coordY, boolean lib, ArrayList<Cartas> props) { 
		index = num;
		loadImage(index); 
		setCor(index); 
		saldo = din; 
		prisao = preso; 
		pin_position = pos; 
		numTurnPrisao = turnPrisao; 
		coordX = cord.x[pin_position];
		coordY = cord.y[pin_position];
		liberdade = lib; 
		propriedades = props;
		initQtdTerrCor();
		checaQtdTerrCorr();
	}
	
	void loadImage(int num) { 
		try {
			   i=ImageIO.read(new File("images/pinos/pin" + Integer.toString(num) + ".png"));
			}
			catch(IOException e){
			   System.out.println(e.getMessage());
			   System.exit(1);
			}
	}
	private void setCor(int i) { 
	
		switch(i){
			case 0: 
				cor = new String("vermelho") ; 
				break; 
			case 1: 
				cor = new String("azul"); 
				break; 
			case 2:
				cor = new String("laranja"); 
				break; 
			case 3: 
				cor = new String("amarelo"); 
				break; 
			case 4: 
				cor = new String("roxo"); 
				break; 
			case 5: 
				 cor = new String( "cinza"); 
				 break; 
			}
	}
	
	void checaQtdTerrCorr() {
		for(int i=0; i<propriedades.size(); i++) { 
			if(propriedades.get(i).getTipo().equals("terreno")) { 
				addTerrenoCor(((CartaTerreno)propriedades.get(i)).getCorIndex()); 
			}
		}
	}
	
	/*
	 * Preenche matriz com quantidade de casas de uma cor 
	 * que o jogador possui. 
	 * Linha se refere a cor em questao 
	 * Coluna 0 se refere a quantidade que ele possui
	 * Coluna 1 se refere a quantidade maximas de casas de uma cor
	 * max[] representa a qtd de terrenos de uma cor
	 */
	private void initQtdTerrCor() { 
		int max[] = { 3 , 3 , 3 , 4 , 2 , 2 , 2 , 2 } ; 
		for(int i =0; i <8; i++) {  
				QtdTerrenosCor[i][0]= 0 ; 
				QtdTerrenosCor[i][1]= max[i] ; 			
		}
	}
	
	public void addProp(Cartas terreno) {
		propriedades.add(terreno); 
		if (terreno.getTipo().equals("terreno"))
			addTerrenoCor(((CartaTerreno)terreno).getCorIndex());  
	}
	
	public void remProp(Cartas terreno) { 
		propriedades.remove(terreno);
		if (terreno.getTipo().equals("terreno"))
			removeTerrenoCor(((CartaTerreno)terreno).getCorIndex()); 
	}
	
	private void addTerrenoCor(int i) {
		QtdTerrenosCor[i][0]++;
	}
	private void removeTerrenoCor(int i) {
		QtdTerrenosCor[i][0]--;
	}
	
	public Cartas findPropriedade(String propName) {
		for(int i =0; i < propriedades.size(); i++) { 
			if(propriedades.get(i).getNome().equals(propName)) { 
				return propriedades.get(i); 
			}
		}
		return null; 
	}
	
	public boolean verificaCasa(int i) { 
		if( QtdTerrenosCor[i][0] == QtdTerrenosCor[i][1])
			return true;
		return false; 
	}
	
	/*
	 * Retorna array com nome de todas propriedades que jogador possui
	 */
	public ArrayList<String> getPropList() { 

		ArrayList<String>nomesProps = new ArrayList<String>(); 
		 
		 for(int i=0 ; i< propriedades.size(); i++) { 
				 nomesProps.add(propriedades.get(i).getNome()); 
		 }
		return nomesProps; 
	}
	
	public void moveTo(int pos) { 
		pin_position = pos; 
	}
	
	public boolean verificaProp(Cartas terreno) { 
		return propriedades.contains(terreno); 
	}

	public void debita(int p) { 
		saldo -= (p); 
	}
	public void recebe(int p) { 
		saldo += p; 
	}
	
	public void resetNumTurnPrisao() {
		numTurnPrisao = 0 ; 
	}

	public void addNumTurnPrisao() {
		numTurnPrisao++; 
	}
	public void cheatSaldo(int i) { 
		saldo = i; 
	}
	
	/**** Setters and Getters ******/
	
	public boolean getLiberdade() {
		return liberdade; 
	}
	public void setLiberdade(boolean b) { 
		liberdade = b; 
	}
	public int getNumTurnPrisao() {
		return numTurnPrisao;
	}
	public ArrayList<Cartas> getPropriedades() {
		return propriedades; 
	}
	public int getSaldo() { 
		return saldo; 
	}
	public int getPosition() {
		return pin_position;
	}
	public int getPosX() { 
		return cord.x[pin_position]; 
	}
	public int getPosY() { 
		return cord.y[pin_position]; 
	}
	public int getOffset() {
		return offset;
	}	public void setPrisao(boolean p) { 
		prisao = p; 
	}
	public boolean getPrisao() {
		return prisao;
	}
	public String getCor() { 
		return cor; 
	}
	public BufferedImage getJogadorImage() { 
		return i; 
	}
	
}
