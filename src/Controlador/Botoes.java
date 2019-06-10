package Controlador;


import javax.swing.*;

import Acoes.*;

public class Botoes extends JPanel {

	public Botoes(){
		JButton rolar_dados = new JButton("rolar dado");
		add(rolar_dados); 
	
		JLabel player_turn = new JLabel("Jogador da rodada:");
		add(player_turn); 
		
		rolar_dados.addActionListener(new RolarDados());
	}
	
}
