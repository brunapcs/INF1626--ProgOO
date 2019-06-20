package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

import regras.*; 

public class PNBotoes extends JPanel implements Observer, ActionListener{
	private static PNBotoes botoes = null;
	
	private JLabel player_turn = new JLabel();
	private JLabel rodada = new JLabel(); 
	private JLabel status = new JLabel("--------- Status --------"); 
	private JLabel dinheiro = new JLabel("Dinheiro:$"); 
	private JButton compar = null;
	private JButton vender = null;
	private JButton passar = null; 
	private JButton rolar_dados = null; 
	private Fachada fac = null; 
	
	private PNBotoes() { 
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		rolar_dados = new JButton("Rolar Dado");
	
		add(rolar_dados); 
		add(rodada);
		add(player_turn); 
		add(status); 
		add(dinheiro); 
		 
		rodada.setText("Rodada: 0"); 
		player_turn.setText("Jogador da vez: Vermelho" );
		
		rolar_dados.addActionListener(this);
	}

	public static PNBotoes getPNBotoes() { 
		if (botoes == null)
			botoes = new PNBotoes(); 
		return botoes; 
	}
	
	
	public void actionPerformed(ActionEvent e) {
	    if(e.getSource() == rolar_dados) { 
	    	Fachada.getFachada().rolarDados();
	    }
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

	@Override
	public void notify(Observable o) {
		// TODO Auto-generated method stub
	}

	public void showPlayerStats(int saldo) {
		dinheiro.setText("Dinheiro: $ " + Integer.toString(saldo)); 
	}
}
