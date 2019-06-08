import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.BufferedImage; 

public class Pin extends JLabel {
	private BufferedImage i=null;
	static int player_num = 0;  
	static public int position = 0; 
	
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
			System.out.print("Todos os jogadores j� escolheram pinos");
		}
		
		ImageIcon image = new ImageIcon(i); 
		this.setIcon(image); 
		setBounds(500+position,500, 25 , 38 ); 
	
	}
}