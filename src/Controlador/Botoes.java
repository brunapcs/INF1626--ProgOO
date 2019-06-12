package Controlador;


import javax.swing.*;

import Acoes.*;

public class Botoes extends JPanel {
	JLabel player_turn = new JLabel();
	
	public Botoes(){
		JButton rolar_dados = new JButton("rolar dado");
		add(rolar_dados); 
	
		add(player_turn); 
		player_turn.setText("Jogador da rodada:" + Integer.toString(Controler.getPlayerOn()));
	
		rolar_dados.addActionListener(new RolarDados());
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
