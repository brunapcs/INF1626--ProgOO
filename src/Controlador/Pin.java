package Controlador;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.BufferedImage; 
import java.util.Random;

public class Pin extends JLabel {
	private BufferedImage i=null;
	static int player_num = 0;  
	static public int padding = 5; 
	private Coordenadas cord = new Coordenadas(); 
	private int pin_position = 0;
	
	private Random num1 = new Random();
	private int offset = num1.nextInt(10) + 1;
	
	public Pin() {		
		if(player_num <6) { 
			try {
			   i=ImageIO.read(new File("images/pinos/pin" + Integer.toString(player_num) + ".png"));
			}
			catch(IOException e){
			   System.out.println(e.getMessage());
			   System.exit(1);
			}
			player_num++; 	
		} 
		else { 
			System.out.print("Todos os jogadores ja escolheram pinos");
		}
		
		ImageIcon image = new ImageIcon(i); 
		this.setIcon(image); 
		setBounds(600+padding, 600+padding, 25 , 35); 
	
	}
	
	public void moveTo(int pos) { 
		pin_position = pos; 
		setBounds(cord.x[pos]+offset, cord.y[pos]-offset, 25 , 35); 
		
	}
	
	public int getPosition() { 
		return pin_position; 
	}
}