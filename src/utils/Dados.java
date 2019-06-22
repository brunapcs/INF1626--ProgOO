package utils;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class Dados{

	private  BufferedImage[] Dimages = new BufferedImage[2]; 
	private  int[] Dnum = new int[2] ; 
	private static Dados d = null; 
	private static Color background = null; 
	private boolean ready = false; 
	
	private Dados() { 
		try {
			Dimages[0] = ImageIO.read(new File("images/dados/die_face_1.png"));
			Dimages[1] = ImageIO.read(new File("images/dados/die_face_2.png"));
		}
		catch(IOException ex){
			   System.out.println(ex.getMessage());
			   System.exit(1);
		}
	}
	
	public static Dados getDados() { 
		if (d == null) { 
			d= new Dados(); 
		}
		return d; 
	}
	
	public void sortearDados() {  
		d.ready = true; 
	
		Random num1 = new Random();
		
		 Dnum[0] = num1.nextInt(6) + 1;
		 Dnum[1] = num1.nextInt(6) + 1;
		
		if((Dnum[0] > 0 && Dnum[0] < 7) && (Dnum[1] > 0 && Dnum[1] < 7)) {
			try {
				Dimages[0] = ImageIO.read(new File("images/dados/die_face_" + Integer.toString(Dnum[0]) + ".png"));
				Dimages[1] = ImageIO.read(new File("images/dados/die_face_" + Integer.toString(Dnum[1]) + ".png"));
			}
			catch(IOException ex){
				   System.out.println(ex.getMessage());
				   System.exit(1);
			}
		}
		
	}
	public int getSoma() { 
		return Dnum[0] + Dnum[1]; 
	}
	
	public int[] getDnum() { 
		return Dnum; 
	}
	
	public BufferedImage[] getDimages() { 
		return Dimages; 
	}

	public Color getBackground() { 
		return background; 
	}
	
	public void setCorDado(int player) { 
			int r =0, g=0, b =0; 
			
			switch(player){ 
				case 0: 
					r = 255;
					break; 
				case 1: 
					b = 255;
					break ;
				case 2: 
					r = 227; 
					g = 117; 
					break; 
				case 3: 
					r = 255; 
					g = 255; 
					break;
				case 4: 
					r = 162; 
					b = 255; 
					break; 
				case 5: 
					r = 167;
					g = 167; 
					b = 167; 
					break; 
			}
			background = new Color(r,g,b,255);
	}
	
	public void setReady(boolean b) { 
		ready = b; 
	}
	
	public boolean getReady() { 
		return ready; 
	}
}
	

