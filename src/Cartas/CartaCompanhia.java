package Cartas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class CartaCompanhia extends Cartas{
	private int multiplicador; 
	private int hipoteca; 
	private String nome = new String(); 
	private int pos; 

	private CartaCompanhia(String n, int hip, int mult, int p, int vc ) { 
		super(); 
		nome = n; 
		hipoteca = hip; 
		multiplicador = mult; 
		preco = vc;
		
		try {
			   i=ImageIO.read(new File("images/companhias/company" + n + ".png"));
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
			new CartaCompanhia("1", 100 , 50, 5, 200);
			new CartaCompanhia("2", 100 , 50, 7, 200);
			new CartaCompanhia("3", 75, 40, 15, 150);
			new CartaCompanhia("4", 75, 40, 25, 150);
			new CartaCompanhia("5", 100 , 50, 32, 200);
			new CartaCompanhia("6", 100 , 50, 35, 200);
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
	
}
