package gui;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PNHistorico extends JPanel {
	private static PNHistorico hist=null; 
	private static ArrayList<JLabel>tudo = new ArrayList<JLabel>();
	
	private PNHistorico() { 
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setVisible(true); 
	}
	public static PNHistorico getHist() { 
		if (hist == null) { 
			hist = new PNHistorico();
		}
		return hist; 
	}
	public void addTransaction(String cor, int qtd, String operacao) {
		JLabel j = new JLabel( cor +" " + operacao +" $" + Integer.toString(qtd) ); 
		tudo.add(j);
		add(j); 
	}
	public void limpaHistorico() { 
		for(int i=0; i< tudo.size(); i++) { 
			tudo.get(i).setVisible(false);
		}
		tudo.clear();
		this.removeAll();
		this.revalidate();
	}
	
}
