package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

import Cartas.CartaCompanhia;
import Cartas.CartaTerreno;
import Cartas.Cartas;
import Cartas.SorteReves;
import regras.*;
import utils.Dados; 

public class PNBotoes extends JPanel implements Observer, ActionListener{
	private static PNBotoes botoes = null;
	
	private JLabel player_turn = new JLabel();
	private JLabel rodada = new JLabel(); 
	private JLabel status = new JLabel("--------- Status --------"); 
	private JLabel dinheiro = new JLabel("Dinheiro:$"); 
	private JLabel proprietario = new JLabel("");
	
	private JButton compar = null;
	private JButton vender = null;
	private JButton passar = null; 
	private JButton rolar_dados = null; 
	private JButton comprar_terreno = null;
	private JButton adc_casa = null; 
	private JButton hipotecar = null; 
	private JButton adc_hotel = null; 
	private JButton encerrar_jogada = null; 
	
	private Cartas carta = null; 
	private boolean ready = false; 
	private Fachada fac = null; 
	private Jogador jogador = null; 
	
	
	
	private PNBotoes() { 
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		rolar_dados = new JButton("Rolar Dado");
		comprar_terreno = new JButton("Comprar Terreno"); 
		adc_casa = new JButton("Adcionar Casa"); 
		hipotecar = new JButton("Hipotecar"); 
		adc_hotel = new JButton("Adcionar Hotel"); 
		encerrar_jogada = new JButton("Encerrar Jogada"); 
		
		comprar_terreno.setVisible(false); 
		adc_casa.setVisible(false);
		hipotecar.setVisible(false);
		adc_hotel.setVisible(false);
		
		
		add(rolar_dados); 
		add(rodada);
		add(player_turn); 
		add(status); 
		add(dinheiro); 
		add(comprar_terreno); 
		add(adc_casa); 
		add(hipotecar); 
		add(adc_hotel); 
		add(proprietario); 
		add(encerrar_jogada);
		 
		rodada.setText("Rodada: 0"); 
		player_turn.setText("Jogador da vez: Vermelho" );
		
		
		rolar_dados.addActionListener(this);
	}
	public static PNBotoes getPNBotoes() { 
		if (botoes == null)
			botoes = new PNBotoes(); 
		return botoes; 
	}
	
	public void showDados(boolean v) { 
		rolar_dados.setVisible(v);
	}
	
	public void showEncerrarJog(boolean v) { 
		encerrar_jogada.setVisible(v);
	}
	
	public void showAdcHotel(boolean v) {
		adc_hotel.setVisible(v); 
	}
	public void showComprarTerreno(boolean v) { 
		comprar_terreno.setVisible(v); 
	}
	public void showAdcCasa(boolean v) { 
		adc_casa.setVisible(v);
		
	}
	public void showHipotecar(boolean v) { 
		hipotecar.setVisible(v);
	}

	public void showPlayerStats(Jogador jogador_on) {
		jogador = jogador_on; 
		dinheiro.setText("Dinheiro: $ " + Integer.toString(jogador.getSaldo()));
		player_turn.setText("Jogador da rodada:" + jogador.getCor());
	}
	
	public void showTerrenoStats(Cartas carta_on ) { 
		//verifica se o jogador eh proprietario 
		ready = true; 
		carta = carta_on; 
		proprietario.setText("Proprietario:" + carta.getProprietario()); 
	}
	
	public void actionPerformed(ActionEvent e) {
	    if(e.getSource() == rolar_dados) { 
	    	Fachada.getFachada().rolarDados();
	    }
	}

	protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    	Graphics2D g2d = (Graphics2D) g;
		    	if( ready == true) { 
		    	g2d.drawImage(carta.getImage(), 100,100, 100, 100, null);
		    	}
	}
	
	@Override
	public void notify(Observable o) {
		// TODO Auto-generated method stub
	}

}
