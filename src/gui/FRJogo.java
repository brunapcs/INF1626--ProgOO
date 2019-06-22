package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

import MenuIni.MenuInicial; 

public class FRJogo extends JFrame{
	  final int LARG_DEFAULT=1200;
	  final int ALT_DEFAULT=850;
	
	   public FRJogo(int num) {
		    setLayout(new FlowLayout());
		    Toolkit tk=Toolkit.getDefaultToolkit();
			Dimension screenSize=tk.getScreenSize();
			
			JMenuBar menu = new JMenuBar();
			JMenu salvamento = new JMenu("Salvar jogo");
	        menu.add(salvamento);
	        salvamento.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        	}
	        });
	        setJMenuBar(menu);
			
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
			bot.setPreferredSize(new Dimension(300,300));	
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
	   
	  private void saveGame(File f) throws IOException {
		  FileOutputStream fileStream = new FileOutputStream(f);   
	      ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
	      
	      objectStream.writeObject(MenuInicial.Monopoly);
	      objectStream.close();
	      fileStream.close();
	  
	  }
}
