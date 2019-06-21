package Cartas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import regras.Jogador;

public class CartaCompanhia extends Cartas{
	private int multiplicador; 
	private int hipoteca; 
	private String nome = new String(); 
	private BufferedImage i ; 
	private int pos; 
	
	private CartaCompanhia(String n, int hip, int mult, int p ) { 
		super(); 
		nome = n; 
		hipoteca = hip; 
		multiplicador = mult; 
		try {
			   i=ImageIO.read(new File("images/companhias/company" + n + ".png"));
			}
		catch(IOException e){
			   System.out.println(e.getMessage());
			   System.exit(1);
			}
		pos = p; 
	
		cartas.add(pos, this); 
	}
	
	public static void inicializaCompanhias() { 
			CartaCompanhia c ; 
			c = new CartaCompanhia("1", 100 , 50, 6 );
			//inicializa todas as cartas de companhia hardcoded 
		
	}
	
	public int getMultiplicador() {
		return multiplicador;
	}

	public void setMultiplicador(int multiplicador) {
		this.multiplicador = multiplicador;
	}

	public int getHipoteca() {
		return hipoteca;
	}

	public void setHipoteca(int hipoteca) {
		this.hipoteca = hipoteca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BufferedImage getI() {
		return i;
	}

	public void setI(BufferedImage i) {
		this.i = i;
	}
}
