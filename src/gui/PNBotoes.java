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




public class PNBotoes extends JPanel implements  ActionListener{
	private static PNBotoes botoes = null;
	private JLabel player_turn = new JLabel();
	private JLabel rodada = new JLabel(); 
	private JLabel status = new JLabel("---------   Status -----------------------"); 
	private JLabel dinheiro = new JLabel("Dinheiro:$"); 
	private JLabel proprietario = new JLabel("");
	private JLabel preco = new JLabel("");
	private JLabel terreno_onCasa = new JLabel(""); 
	
	private JButton vender = null;
	private JButton rolar_dados = null; 
	private JButton comprar_terreno = null;
	private ArrayList<JButton> adc_casa = new ArrayList<JButton>();
	private ArrayList<JButton> vender_casa = new ArrayList<JButton>();
	private JButton adc_hotel = null; 
	private JButton encerrar_jogada = null;

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
		
		adc_hotel = new JButton("Adcionar Hotel"); 
		encerrar_jogada = new JButton("Encerrar Jogada"); 
		vender = new JButton("Vender"); 
		JLabel props = new JLabel("Lista de Propriedades:"); 
		JLabel addCasa_lbl = new JLabel ("Adcionar Casa em Cor:");
		
		rolar_dados.setVisible(false);
		encerrar_jogada.setVisible(false);
		comprar_terreno.setVisible(false);
		addCasa_lbl.setVisible(false);
		
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
		add(addCasa_lbl); 
		
		for(int i=0; i<8; i++) { 
			JButton b = new JButton();
			adc_casa.add(b); 
			adc_casa.get(i).setVisible(false);
			add(adc_casa.get(i));
			adc_casa.get(i).addActionListener(this);

			JButton c = new JButton();
			vender_casa.add(c); 
			vender_casa.get(i).setVisible(false);
			add(vender_casa.get(i));
			vender_casa.get(i).addActionListener(this);
		}

		add(status); 
		add(preco); 
		add(comprar_terreno); 
		add(adc_hotel); 
		add(proprietario); 
		add(terreno_onCasa);
		add(Box.createVerticalGlue());
		add(encerrar_jogada);
		
		propList.addActionListener(this);
		rolar_dados.addActionListener(this);
		encerrar_jogada.addActionListener(this);
		comprar_terreno.addActionListener(this);
		vender.addActionListener(this);
		
		rodada.setText("Rodada:"); 
		player_turn.setText("Jogador da vez:");
		cheatFrame(); 
	}

	public static PNBotoes getPNBotoes() { 
		if (botoes == null)
			botoes = new PNBotoes(); 
		return botoes; 
	}
	
	public void showAdcCasa(boolean v, int i, String cor) {
		adc_casa.get(i).setVisible(v); 
		adc_casa.get(i).setText(cor);
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

	public void showProprietario(boolean v) { 
		proprietario.setVisible(false);
	}

	public void showCasas( int casas ) { 
		terreno_onCasa.setText("Casas:" + Integer.toString(casas)); 
		terreno_onCasa.setVisible(true); 
	}
	public void hideCasas() {
		terreno_onCasa.setVisible(false);
	}
	
	public void showProprietario(String prop ) { 
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
	
	public void showMaxCasa() {
		JOptionPane.showMessageDialog(null, 
	               "Esta compra não pode ser efetuada."
	               + "Você já possui o número máximo de casas neste terreno.", 
	                "Eita", 
	                JOptionPane.WARNING_MESSAGE);
	}
	
	public void showNaoHaSaldo() {
		JOptionPane.showMessageDialog(null, 
	               "Esta compra não pode ser efetuada."
	               + "Você não possui saldo o suficiente.", 
	                "Faltou!", 
	                JOptionPane.WARNING_MESSAGE);
		
	}
	public void showHotel() {
		JOptionPane.showMessageDialog(null, 
	               "Parabéns, você acaba de adcionar um hotel! Você atingiu o número máximo de casas para este terreno.", 
	                "Hotel!", 
	                JOptionPane.WARNING_MESSAGE);
		
	}

	
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    	Graphics2D g2d = (Graphics2D) g;
	    	if( ready == true) { 
	    	g2d.drawImage(i, 0 , 450, 130, 200 , null);
	    	}
	}
	public void adcCasa(String cor) { 
		Fachada.getFachada().getPropListCor(cor); 
	}
	public void venderCasa(String cor) { 
		Fachada.getFachada().getPropListCor(cor); 
	}
	
	public void adcCasaFrame(ArrayList<String> terr) {
		JFrame jp = new JFrame(); 
		JPanel p = new JPanel(); 
		JComboBox<String> terrList = new JComboBox();
		
		ActionListener casasActList = new ActionListener(){//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e){
            		String parts[];
            		String s = (String) terrList.getSelectedItem();//get the selected item
            		parts= ((String) terrList.getSelectedItem()).split(" ");
            		Fachada.getFachada().addCasa(parts[0]);
                }
            };
		for(int i =0; i<terr.size(); i++) { 
			terrList.addItem(terr.get(i)); 
		}
		
		JButton addCasa = new JButton("Adcionar Casa"); 
		addCasa.addActionListener(casasActList);
		p.add(terrList); 
		p.add(addCasa); 
		jp.getContentPane().add(p); 
		jp.setBounds(500, 500, 300, 100);
		jp.setVisible(true);
		jp.setTitle("Adcionar Casa");
	}
	
	public void venderCasaFrame(ArrayList<String> terr) {
		JFrame jp = new JFrame(); 
		JPanel p = new JPanel(); 
		JComboBox<String> terrList = new JComboBox();
		
		ActionListener casasActList = new ActionListener(){//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e){
            		String parts[];
            		String s = (String) terrList.getSelectedItem();//get the selected item
            		parts= ((String) terrList.getSelectedItem()).split(" ");

            		Fachada.getFachada().venderCasa(parts[0]);
                }
            };
		for(int i =0; i<terr.size(); i++) { 
			terrList.addItem(terr.get(i)); 
		}
	
		JButton vender = new JButton("Vender Casa"); 
		vender.addActionListener(casasActList);
		p.add(vender); 
		p.add(vender); 
		jp.getContentPane().add(p); 
		jp.setBounds(500, 500, 300, 100);
		jp.setVisible(true);
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
	    else {
	    	for (int i=0; i<8; i++) { 
	    		if (e.getSource() == adc_casa.get(i)) {  
	    			adcCasaFrame(Fachada.getFachada().getPropListCor(adc_casa.get(i).getText())); 
	    		}
	    		else if (e.getSource() == vender_casa.get(i))
	    			venderCasaFrame(Fachada.getFachada().getPropListCor(adc_casa.get(i).getText())); 
	    	}
	    }
	}
	private void cheatFrame() { 
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

	public void remAdcCasa(String nome) {
		for(int i =0; i<adc_casa.size(); i++) { 
			if(adc_casa.get(i).getText().equals(nome))
				adc_casa.get(i).setVisible(false);
		}
		
	}

	

	
	

	

}
