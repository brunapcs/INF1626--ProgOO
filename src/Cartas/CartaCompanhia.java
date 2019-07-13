package Cartas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class CartaCompanhia extends Cartas{
	private int multiplicador; 
	private int hipoteca; 
	private int cartaNum; 
	private int pos; 

	private CartaCompanhia(int n, int hip, int mult, int p, int vc ) { 
		super(); 
		setNome(n); 
		cartaNum = n; 
		hipoteca = hip; 
		multiplicador = mult; 
		preco = vc;
		
		try {
			   i=ImageIO.read(new File("images/companhias/company" + Integer.toString(n) + ".png"));
			}
		catch(IOException e){
			   System.out.println(e.getMessage());
			   System.exit(1);
			}
		pos = p; 
		tipo = new String("companhia"); 
		cartas.set(pos, this); 
	}
	
	public static void inicializaCompanhias() { 
			new CartaCompanhia(1, 100 , 50, 5, 200);
			new CartaCompanhia(2, 100 , 50, 7, 200);
			new CartaCompanhia(3, 75, 40, 15, 150);
			new CartaCompanhia(4, 75, 40, 25, 150);
			new CartaCompanhia(5, 100 , 50, 32, 200);
			new CartaCompanhia(6, 100 , 50, 35, 200);
	}
	
	private void setNome(int n) { 
		switch (n) { 
		case 1: 
			nome = "Companhia Ferroviaria"; 
			break;
		case 2: 
			nome = "Companhia de Viacao"; 
			break; 
		case 3: 
			nome = "Companhia de Taxi"; 
			break;
		case 4:
			nome = "Companhia de Navegacao"; 
			break; 
		case 5: 
			nome = "Companhia de Aviacao"; 
			break; 
		case 6: 
			nome = "Companhia de Taxi Aereo"; 
			break; 
		}
	}

	
	public int getCartaNum() { 
		return cartaNum;
	}
	public int getMultiplicador() {
		return multiplicador;
	}


}
