import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Pino  extends JPanel {
	private Image i=null;
	static int player_num = 0;  

	public Pino() {		
		if(player_num <6) { 
			try {
			   i=ImageIO.read(new File("images/pinos/pin" + Integer.toString(player_num) + ".png"));
			}
			catch(IOException e) {
			   System.out.println(e.getMessage());
			   System.exit(1);
			}
			player_num++; 
			
		} 

		else { 
			System.out.print("Todos os jogadores já escolheram pinos");
		}

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gd2=(Graphics2D) g;
		gd2.drawImage (i,0,0,null);
	}
}