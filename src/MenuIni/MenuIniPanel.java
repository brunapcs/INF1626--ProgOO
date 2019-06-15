package MenuIni;

import javax.swing.*;
import java.awt.event.*;
import Controlador.*; 

public class MenuIniPanel extends JPanel
{	private JRadioButton j2,j3,j4,j5,j6;
	private RadioButtonHandler handler; 
	private ButtonGroup b = new ButtonGroup();
	MenuIniPanel(){ 
		
		JButton comecar = new JButton ("comeÁar jogo"); 
		this.setLayout(null);
		JLabel l = new JLabel("Selecione o numero de jogadores");
		j2 = new JRadioButton("2 jogadores", false);
		j3 = new JRadioButton("3 jogadores", false);
		j4 = new JRadioButton("4 jogadores", false);
		j5 = new JRadioButton("5 jogadores", false);
		j6 = new JRadioButton("6 jogadores", false);
		
		b.add(j2); b.add(j3); b.add(j4); b.add(j5); b.add(j6);
		
		j2.setBounds(0,0,250,30);
		j3.setBounds(0,50,250,30);
		j4.setBounds(0,100,250,30);
		j5.setBounds(0,150,250,30);
		j6.setBounds(0,200,250,30);
		comecar.setBounds(130,100,250,50);
		
		j2.addItemListener(handler);
		j3.addItemListener(handler);
		j4.addItemListener(handler);
		j5.addItemListener(handler);
		j6.addItemListener(handler);
		
		this.add(comecar);
		this.add(j2);
		this.add(j3);
		this.add(j4);
		this.add(j5);
		this.add(j6);
		
		
		comecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if(j2.isSelected()) {
				loop(2); 
			}
			else if(j3.isSelected()) {
				loop(3); 
			}
			else if(j4.isSelected()) {
				loop(4); 
			}
			else if(j5.isSelected()) {
				loop(5); 
			}
			else if(j6.isSelected()) {
				loop(6); 
			}
			else {
				System.exit(0);;
			}
			Controler.setJogoVisible(true); 
			Controler.setMenuIniVisible(false);
			}
		}); 
	}
	
	void loop (int lim) { 
		for(int j = 0; j < lim; j++) {
			Controler.getTab_p().addJogador();
		}
	}
	
	private class RadioButtonHandler implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			
		}
	}
}

	
	
	
