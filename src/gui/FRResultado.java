package gui;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import regras.Jogador;

public class FRResultado extends JFrame{
	JPanel result = new JPanel(); 
	ArrayList<JLabel> tabela = new ArrayList<JLabel>(); 
	JLabel colocacao = new JLabel("Colocação:"); 
	
	public FRResultado(ArrayList<Jogador>ordem){ 
	
		result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));
		result.add(colocacao);
		for(int i =0; i<ordem.size(); i++) { 
			tabela.add(new JLabel(ordem.get(i).getCor()));
			result.add(tabela.get(i)); 
		}
	 
	  getContentPane().add(result); 
	  setVisible(true);
	  setBounds(500, 400, 300, 200);
	 
	}

}
