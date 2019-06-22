package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.*;

import menuIni.MenuInicial;
import utils.Dados; 

public class FRJogo extends JFrame{
	  final int LARG_DEFAULT=1200;
	  final int ALT_DEFAULT=850;
	
	   public FRJogo(int num) {
		    setLayout(new FlowLayout());
		    Toolkit tk=Toolkit.getDefaultToolkit();
			Dimension screenSize=tk.getScreenSize();
			int sl=screenSize.width;
			int sa=screenSize.height;
			int x=sl/2-LARG_DEFAULT/2;
			int y=sa/2-ALT_DEFAULT/2;
			setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			PNBotoes bot = PNBotoes.getPNBotoes(); 
			PNTabuleiro tab = PNTabuleiro.getPNTabuleiro(); 
			tab.addJogadores(num); // retirar daqui depois 
			
			tab.setPreferredSize(new Dimension(700,700));	
			bot.setPreferredSize(new Dimension(400,700));	
			bot.setBorder(BorderFactory.createTitledBorder("Controles"));
			
			getContentPane().add(tab);
			getContentPane().add(bot);
			
			pack(); 
			setTitle("Banco Imobiliario");
			setVisible(true); 
	   }  
	   
	   public static void main(String args[]) {
		    Factory fac = Factory.startFactory(); 
		    MenuInicial menuIni = new MenuInicial();
			
		
		}
	   
	  
}
