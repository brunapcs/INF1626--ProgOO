package Cartas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList; 
import java.util.Queue;

import javax.imageio.ImageIO;

import java.util.Collections;

public class SorteReves extends Cartas{

	
	private BufferedImage i;
	private int acao;  //se acao = 0 a carta eh uma carta de liberdade da prisao
	private String tipo;
	private SorteReves(int num, String tp, int a){ 
		super(); 
		acao = a;
		tipo = tp;
		try {
			   i=ImageIO.read(new File("images/sorteReves/chance" + Integer.toString(num) + ".png"));
			}
			catch(IOException e){
			   System.out.println(e.getMessage());
			   System.exit(1);
			}
		deck.add(this); 
		
	}
	
	static void inicializaSorteReves(){
			new SorteReves(1, "lucro",25); 
			new SorteReves(2,"lucro",150);
			new SorteReves(3,"lucro",80);
			new SorteReves(4,"lucro",200);
			new SorteReves(5,"lucro",50);
			new SorteReves(6,"lucro",50);
			new SorteReves(7,"lucro",100);
			new SorteReves(8,"lucro",100);
			new SorteReves(9,"liberdade",0);
			new SorteReves(10,"ponto de partida",0);
			new SorteReves(11,"aposta",50);
			new SorteReves(12,"lucro",45);
			new SorteReves(13,"lucro",100);
			new SorteReves(14,"lucro",100);
			new SorteReves(15,"lucro",20);
			
			new SorteReves(16,"prejuizo", -15);
			new SorteReves(17,"prejuizo", -25);
			new SorteReves(18,"prejuizo", -45);
			new SorteReves(19,"prejuizo", -30);
			new SorteReves(20,"prejuizo", -100);
			new SorteReves(21,"prejuizo", -100);
			new SorteReves(22,"prejuizo", -40);
			new SorteReves(23,"prisao", 0);
			new SorteReves(24,"prejuizo", -30);
			new SorteReves(25,"prejuizo", -50);
			new SorteReves(26,"prejuizo", -25);
			new SorteReves(27,"prejuizo", -30);
			new SorteReves(28,"prejuizo", -45);
			new SorteReves(29,"prejuizo", -50);
			new SorteReves(30,"prejuizo", -50);
	}

	public BufferedImage getI() {
		return i;
	}

	public void setI(BufferedImage i) {
		this.i = i;
	}
	
	public int getAcao() {
		return acao;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setAcao(int acao) {
		this.acao = acao;
	}
	
	
	
}
