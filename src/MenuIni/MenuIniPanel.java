package MenuIni;

import javax.swing.*;
import java.awt.event.*;
import Controlador.*; 

public class MenuIniPanel extends JPanel
{	
	MenuIniPanel(){ 
		JButton add_player = new JButton ("adcionar jogador");
		JButton comecar = new JButton ("começar jogo"); 
		
		add_player.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{	
			  Controler.getTab_p().addJogador();
			}
		  });
		
		comecar.addActionListener( new ActionListener(){ 
			public void actionPerformed(ActionEvent e) { 
				Controler.setJogoVisible(true); 
				Controler.setMenuIniVisible(false); 
			}
		}); 
		add(add_player); 
		add(comecar); 
	} 
}

	
	
	