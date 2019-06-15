package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Acoes.*;

public class Botoes extends JPanel {
	JLabel player_turn = new JLabel();
	JButton compar = new JButton("Comprar"); 
	JButton vender = new JButton ("Vender"); 
	JButton passar = new JButton("Passar"); 
	
	public Botoes(){
		JButton rolar_dados = new JButton("rolar dado");
		add(rolar_dados); 
	
		add(player_turn); 
		player_turn.setText("Jogador da rodada: vermelho" );
	
		rolar_dados.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) { 
				Controler.getDados().sortearDados(); 
			}
		}); 
		
		
		setBounds(700,0, 200,200);
		setVisible(true);
	}
	
	
	public void showPlayerOn(int i) { 
		String jogador = ""; 
		switch(i){
		case 0: 
			jogador = "vermelho"; 
			break; 
		case 1: 
			jogador = "azul"; 
			break; 
		case 2:
			jogador = "laranja"; 
			break; 
		case 3: 
			jogador = "amarelo"; 
			break; 
		case 4: 
			jogador = "roxo"; 
			break; 
		case 5: 
			 jogador = "cinza"; 
			 break; 
		}
		player_turn.setText("Jogador da rodada:" + jogador);
	}
}
