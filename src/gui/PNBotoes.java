package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
	
	
	private JButton vender = null;
	private JButton rolar_dados = null; 
	private JButton comprar_terreno = null;
	private JButton adc_casa = null;  
	private JButton adc_hotel = null; 
	private JButton encerrar_jogada = null;
	private ArrayList<JButton> casas = new ArrayList<JButton>(); 
	private ArrayList<Integer> terrenoPosition = new ArrayList<Integer>();
	private boolean ready = false; 
	private Fachada fac = null; 
	private BufferedImage i = null; 
	private JComboBox<String> propList = new JComboBox();
	private JLabel prisao = new JLabel("PRESO!"); 
	
	private JComboBox combo1 = new JComboBox();
	private JComboBox combo2 = new JComboBox();
	private JComboBox setSaldo = new JComboBox();
	private JButton cheatDados = new JButton("Trapaça!"); 
	private JButton cheatSaldo = new JButton("Set Saldo"); 
	
	private PNBotoes() { 
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        
		rolar_dados = new JButton("Rolar Dado");
		comprar_terreno = new JButton("Comprar Terreno"); 
		adc_casa = new JButton("Adcionar Casa"); 
		adc_hotel = new JButton("Adcionar Hotel"); 
		encerrar_jogada = new JButton("Encerrar Jogada"); 
		vender = new JButton("Vender"); 
		JLabel props = new JLabel("Lista de Propriedades:"); 
		
		rolar_dados.setVisible(false);
		encerrar_jogada.setVisible(false);
		comprar_terreno.setVisible(false);
		adc_casa.setVisible(false);
		adc_hotel.setVisible(false);
		vender.setVisible(false);
		prisao.setVisible(false);
		
		add(rolar_dados); 
		add(rodada);
		add(player_turn); 
		add(dinheiro);
		add(prisao); 
		add(props); 
		add(propList); 
		add(vender); 
		add(status); 
		add(preco); 
		add(comprar_terreno); 
		add(adc_casa); 
		add(adc_hotel); 
		add(proprietario); 
		add(Box.createVerticalGlue());
		add(encerrar_jogada);
		
		rodada.setText("Rodada: 0"); 
		player_turn.setText("Jogador da vez: Vermelho" );
		propList.addActionListener(this);
		rolar_dados.addActionListener(this);
		encerrar_jogada.addActionListener(this);
		comprar_terreno.addActionListener(this);
		vender.addActionListener(this);
		
		// JFRAME DE TRAPACA
		JFrame trapaca = new JFrame(); 
        JPanel trap = new JPanel(); 
		
		for(int i=1; i < 7; i++) { 
			combo1.addItem(i);
			combo2.addItem(i);
			setSaldo.addItem(i); 
		}
		trap.add(combo1); 
		trap.add(combo2);  
		trap.add(cheatDados);
		trap.add(setSaldo);
		trap.add(cheatSaldo); 
		cheatDados.addActionListener(this);
		cheatSaldo.addActionListener(this);
		trapaca.setBounds(1100, 500, 300, 100);
		trapaca.getContentPane().add(trap); 
		trapaca.setVisible(true);
		
	}
	
	public static PNBotoes getPNBotoes() { 
		if (botoes == null)
			botoes = new PNBotoes(); 
		return botoes; 
	}
	public void showLiberdade() { 
		JOptionPane.showMessageDialog(null, 
                "LIBERDADE!", 
                "CARTA PASSE LIVRE!", 
                JOptionPane.WARNING_MESSAGE);
	}
	public void showPrisao(boolean v) { 
		prisao.setVisible(v); 
	}
	
	public void showRolarDados(boolean v) { 
		rolar_dados.setVisible(v);
	}
	
	public void showEncerrarJog(boolean v) { 
		encerrar_jogada.setVisible(v);
	}
	public void loadAndShowPropList(ArrayList<String>props) { 
		for(int i =0; i<props.size(); i++) { 
			propList.addItem(props.get(i)); 
		}
	}
	public void zeraPropList() {
		propList.removeAllItems();
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
	public void showProprietario(boolean v) { 
		proprietario.setVisible(false);
	}

	public void showTerrenoStats(String prop ) { 
		proprietario.setText("Proprietario: " + prop); 
		proprietario.setVisible(true);
	}
	
	public void setCartaImage(BufferedImage carta) { 
		i = carta; 
		ready = true; 
		repaint(); 
	}

	public void setReady(boolean b) {
		ready = b ; 
	}
	public void showPreco(String p, boolean b) {
		preco.setText("Preco:" + p);
		preco.setVisible(b); 
	}
	public void addShowCasa(String nome, int pos, int casa) {
		JButton b = new JButton("Add casa em " + nome + "por $" + Integer.toString(casa));
		add(b); 
		casas.add(b); 
		b.addActionListener(this);
		terrenoPosition.add(pos); 	
	}
	
	public void removeBotoesCasas() {
		for(int i =0 ; i<casas.size(); i++) { 
			remove(casas.get(i));
		}
	}
	
	public void showVender(boolean b) {
		vender.setVisible(b);
	}

	public void setSaldo(int saldo) {
		dinheiro.setText("Dinheiro: $ " + Integer.toString(saldo));
		dinheiro.setVisible(true);
	}

	public void setJogadorOn(String cor) {
		player_turn.setText("Jogador da rodada:" + cor );
		player_turn.setVisible(true);
	}
	

	public void showFaliu(String cor) {
		JOptionPane.showMessageDialog(null, 
                "Jogador" + cor + "faliu ", 
                "Fim de Jogo para voce", 
                JOptionPane.WARNING_MESSAGE);
		
	}

	public void showFaltaDin() {
		JOptionPane.showMessageDialog(null, 
               "Voce nao possui saldo suficiente", 
                "Faltou!", 
                JOptionPane.WARNING_MESSAGE);
		
	}

	public void showVencedor() {
		
		JOptionPane.showMessageDialog(null, 
	               "Temos um vencedor!", 
	                "Fim de Jogo", 
	                JOptionPane.WARNING_MESSAGE);
	}

	@Override
	public void notify(regras.Observable o) {
		// TODO Auto-generated method stub
		
	}
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    	Graphics2D g2d = (Graphics2D) g;
	    	if( ready == true) { 
	    	g2d.drawImage(i, 0 , 450, 130, 200 , null);
	    	}
	}
	
	public void actionPerformed(ActionEvent e) {
	    if(e.getSource() == rolar_dados) { 
	    	Fachada.getFachada().rolarDados();
	    }
	    else if(e.getSource() == encerrar_jogada) {
	    	rolar_dados.setVisible(true); 
	    	encerrar_jogada.setVisible(false);
	    	ready = false; 
	    	Fachada.getFachada().encerrarJogada(); 
	    }
	    else if (e.getSource() == comprar_terreno){ 
	    	Fachada.getFachada().comprarTerreno(); 
	    }
	   
	    else if(e.getSource() == propList ) {
	        String propName = (String)propList.getSelectedItem();
	//        Fachada.getFachada().showProp(propName); 
	    }
	    else if(e.getSource()== vender){ 
	    	Fachada.getFachada().venderProp((String)propList.getSelectedItem());
	    }
	    else if(e.getSource()== cheatDados) { 
	    	Fachada.getFachada().cheat((Integer)combo1.getSelectedItem(), (Integer)combo2.getSelectedItem());
	    }
	    else if (e.getSource() == cheatSaldo) { 
	    	Fachada.getFachada().cheatSaldo((Integer)setSaldo.getSelectedItem()); 
	    }
	    
	   /* else {
		    for (int i=0 ; i< casas.size(); i++) { 
		    	if (e.getSource() == casas.get(i)) { 
		    		Fachada.getFachada().addCasa((Integer)terrenoPosition.get(i)); 
		    	}
		    }
		    }
	    */
	    
	    
	}

}
