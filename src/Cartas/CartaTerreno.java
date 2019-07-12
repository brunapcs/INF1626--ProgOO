package Cartas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.imageio.ImageIO;

public class CartaTerreno extends Cartas {
	private int casaPreco;
	private int hotelPreco;

	private Vector<Integer> aluguel = new Vector<Integer>(6);
	private String cor = new String();
	private int casas = 0;
	private int hotel = 0;
	private boolean verHotel = false;

	private CartaTerreno(String n, int cas, int hot, int hip, int a, int b, int c, int d, int e, int f, int p,
			int custo, String Cor) {
		super();
		nome = n;
		preco = custo;
		casaPreco = cas;

		cor = Cor;
		aluguel.add(a);
		aluguel.add(b);
		aluguel.add(c);
		aluguel.add(d);
		aluguel.add(e);
		aluguel.add(f);
		pos = p;

		try {
			i = ImageIO.read(new File("images/territorios/" + n + ".png"));
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
			System.exit(1);
		}
		tipo = new String("terreno");
		cartas.set(pos, this);
	}

	public static void inicializaTerreno() {
		new CartaTerreno("Leblon", 50, 50, 50, 6, 30, 90, 270, 400, 500, 1, 100, "Rosa");
		new CartaTerreno("Rua Augusta", 100, 100, 90, 14, 70, 200, 550, 750, 950, 13, 180, "Vinho");
		new CartaTerreno("Morumbi", 200, 200, 200, 50, 200, 600, 1400, 1700, 2000, 19, 400, "Laranja");
		new CartaTerreno("Jardim Paulista", 150, 150, 140, 24, 120, 360, 850, 1025, 1200, 38, 280, "Roxo");
		new CartaTerreno("Jardim Europa", 100, 100, 70, 10, 50, 150, 450, 625, 750, 29, 140, "Amarelo");
		new CartaTerreno("Ipanema", 200, 200, 150, 26, 130, 390, 900, 1100, 1275, 36, 300, "Verde");
		new CartaTerreno("Interlagos", 200, 200, 175, 35, 175, 500, 1100, 1300, 1500, 17, 350, "Laranja");
		new CartaTerreno("Flamengo", 50, 50, 60, 8, 40, 10, 300, 450, 600, 21, 120, "Vermelho");
		new CartaTerreno("Copacabana", 150, 150, 130, 22, 110, 330, 800, 975, 1150, 31, 260, "Verde");
		new CartaTerreno("Brooklin", 150, 150, 130, 22, 110, 330, 800, 975, 1150, 39, 260, "Roxo");
		new CartaTerreno("Botafogo", 50, 50, 50, 6, 30, 90, 270, 400, 500, 23, 100, "Vermelho");
		new CartaTerreno("Av. Vieira Souto", 200, 200, 160, 28, 150, 450, 1000, 1200, 1400, 33, 320, "Verde");
		new CartaTerreno("Av. Reboucas", 150, 150, 110, 18, 90, 250, 700, 875, 1050, 8, 220, "Azul");
		new CartaTerreno("Av. Presidente Vargas", 50, 50, 30, 2, 10, 30, 90, 160, 250, 3, 60, "Rosa");
		new CartaTerreno("Av. Paulista", 100, 100, 70, 10, 50, 150, 450, 625, 750, 28, 140, "Amarelo");
		new CartaTerreno("Av. Pacaembu", 100, 100, 90, 14, 70, 200, 550, 750, 950, 14, 180, "Vinho");
		new CartaTerreno("Av. Europa", 100, 100, 100, 16, 80, 220, 600, 800, 1000, 11, 220, "Vinho");
		new CartaTerreno("Av. Nossa S. de Copacabana", 50, 50, 30, 4, 20, 60, 180, 320, 450, 4, 60, "Rosa");
		new CartaTerreno("Av. Brigadero Faria Lima", 150, 150, 120, 20, 100, 300, 750, 925, 1100, 6, 240, "Azul");
		new CartaTerreno("Av. Brasil", 100, 100, 80, 12, 60, 180, 500, 700, 900, 26, 160, "Amarelo");
		new CartaTerreno("Av. Atlantica", 200, 200, 150, 26, 130, 390, 900, 1100, 1275, 34, 300, "Verde");
		new CartaTerreno("Av. 9 de Julho", 150, 150, 110, 18, 90, 250, 700, 875, 1050, 9, 220, "Azul");
	}

	public String getCor() {
		return cor;
	}

	public int getCasaPreco() {
		return casaPreco;
	}

	public int getHotelPreco() {
		return hotelPreco;
	}

	public void setVerificaHotel(boolean v) {
		verHotel = v;
	}

	public void setNumCasas(int num) {
		casas = num;
	}

	public int getNumCasas() {
		return casas;
	}

	public void addCasa() {
		casas++;
	}

	public void remCasa() {
		casas--;
	}

	public int getAluguel(int numCasas) {
		return aluguel.elementAt(numCasas);
	}

	/* Busca index da cor de um terreno */
	public int getCorIndex() {
		switch (cor) {
		case "Rosa":
			return 0;
		case "Azul":
			return 1;
		case "Amarelo":
			return 2;
		case "Vinho":
			return 3;
		case "Verde":
			return 4;
		case "Laranja":
			return 5;
		case "Vermelho":
			return 6;
		case "Roxo":
			return 7;
		}
		return -1;
	}

	/* Busca nome da cor de um terreno atraves de index */
	public static String getCasaCor(int i) {
		switch (i) {
		case 0:
			return "Rosa";
		case 1:
			return "Azul";
		case 2:
			return "Amarelo";
		case 3:
			return "Vinho";
		case 4:
			return "Verde";
		case 5:
			return "Laranja";
		case 6:
			return "Vermelho";
		case 7:
			return "Roxo";
		}
		return " ";
	}
}
