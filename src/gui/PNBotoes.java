package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Observable;

import javax.swing.*;
import javax.swing.border.Border;

import regras.Fachada;
import regras.Observer;




public class PNBotoes extends JPanel implements Observer, ActionListener{
	private static PNBotoes botoes = null;
	
	private JLabel player_turn = new JLabel();
	private JLabel rodada = new JLabel(); 
	private JLabel status = new JLabel("---------   Status -----------------------"); 
	private JLabel dinheiro = new JLabel("Dinheiro:$"); 
	private JLabel proprietario = new JLabel("");
	private JLabel preco = new JLabel(""); 
	
	private JButton compar = null;
	private JButton vender = null;
	private JButton passar = null; 
	private JButton rolar_dados = null; 
	private JButton comprar_terreno = null;
	private JButton adc_casa = null; 
	private JButton hipotecar = null; 
	private JButton adc_hotel = null; 
	private JButton encerrar_jogada = null; 
	
	private boolean ready = false; 
	private Fachada fac = null; 
	private BufferedImage i = null; 
	
	
	
	private PNBotoes() { 
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//setSize(200,700); 
		

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
		add(dinheiro); 
		add(Box.createVerticalGlue());
		add(status); 
		add(Box.createHorizontalGlue());
		add(preco); 
		add(comprar_terreno); 
		add(adc_casa); 
		add(hipotecar); 
		add(adc_hotel); 
		add(proprietario); 
		add(Box.createVerticalGlue());
		add(encerrar_jogada);
		
		 
		rodada.setText("Rodada: 0"); 
		player_turn.setText("Jogador da vez: Vermelho" );
		
		rolar_dados.addActionListener(this);
		encerrar_jogada.addActionListener(this);
		comprar_terreno.addActionListener(this);
		
	}
	public static PNBotoes getPNBotoes() { 
		if (botoes == null)
			botoes = new PNBotoes(); 
		return botoes; 
	}
	
	public void showRolarDados(boolean v) { 
		rolar_dados.setVisible(v);
	}
	
	public void showEncerrarJog(boolean v) { 
		if (v == false) { 
			rolar_dados.setVisible(true); 
		}
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
	public void showProprietario(boolean v) { 
		proprietario.setVisible(false);
	}

	public void showPlayerStats(int saldo, String cor) {
		dinheiro.setText("Dinheiro: $ " + Integer.toString(saldo));
		player_turn.setText("Jogador da rodada:" + cor );
		dinheiro.setVisible(true);
		player_turn.setVisible(true);
	}
	
	public void showTerrenoStats(String prop ) { 
		proprietario.setText("Proprietario: " + prop); 
		proprietario.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
	    if(e.getSource() == rolar_dados) { 
	    	Fachada.getFachada().rolarDados();
	    }
	    if(e.getSource() == encerrar_jogada) {
	    	rolar_dados.setVisible(true); 
	    	encerrar_jogada.setVisible(false);
	    	ready = false; 
	    	Fachada.getFachada().encerrarJogada(); 
	    }
	    if (e.getSource() == comprar_terreno){ 
	    	Fachada.getFachada().comprarTerreno(); 
	    }
	}
	public void setCartaImage(BufferedImage carta) { 
		i = carta; 
		ready = true; 
		repaint(); 
	}

	protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    	Graphics2D g2d = (Graphics2D) g;
		    	if( ready == true) { 
		    	g2d.drawImage(i, 0 , 450, 130, 200 , null);
		    	}
	}
	@Override
	public void notify(regras.Observable o) {
		// TODO Auto-generated method stub
		
	}
	public void setReady(boolean b) {
		ready = b ; 
		
	}
	public void showPreco(String p, boolean b) {
		preco.setText("Preco:" + p);
		preco.setVisible(b); 
	}
	
	


}
