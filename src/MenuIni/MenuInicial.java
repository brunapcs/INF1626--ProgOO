package MenuIni;
import javax.imageio.ImageIO;
import javax.swing.*;
import gui.FRJogo;
import gui.PNTabuleiro;

import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuInicial extends JFrame {
	private JMenuItem j2,j3,j4,j5,j6;
	private ButtonGroup b = new ButtonGroup();
	private int i;
	public static FRJogo Monopoly;
    public MenuInicial() {

        initUI();
    }

    private void initUI() {
    	setTitle("Menu");
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        BufferedImage img = null;
        try {
			img = ImageIO.read(new File("images/GIFBackground.gif"));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
        Image rimg = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        JPanel panel = (JPanel) getContentPane();
        JLabel label = new JLabel(new ImageIcon(rimg));
        
        panel.add(label, java.awt.BorderLayout.CENTER);
        	
        JMenuBar menu = new JMenuBar();
 
        JMenu jogo = new JMenu("Opcoes de jogo");
        menu.add(jogo);
        
        JMenu Begin = new JMenu("Comecar novo jogo");
        JMenuItem Load = new JMenuItem("Carregar jogo");
        
        jogo.add(Begin);
        jogo.add(Load);
        
    	j2 = new JMenuItem("2 jogadores");
    	j3 = new JMenuItem("3 jogadores");
    	j4 = new JMenuItem("4 jogadores");
    	j5 = new JMenuItem("5 jogadores");
    	j6 = new JMenuItem("6 jogadores");
    	
    	Begin.add(j2);
    	Begin.add(j3);
    	Begin.add(j4);
    	Begin.add(j5);
    	Begin.add(j6);
    	
    	b.add(j2); b.add(j3); b.add(j4); b.add(j5); b.add(j6);
    	
    	setLocationRelativeTo(null);
    	setJMenuBar(menu);
    	setVisible(true);
    	
    	j2.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
			loop(2);
			setVisible(false); 
			Monopoly = new FRJogo(2); 
    		}
		});
    	
    	j3.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
			loop(3);
			setVisible(false); 
			Monopoly = new FRJogo(3); 
    		}
		});
    	
    	j4.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
			loop(4);
			setVisible(false); 
			Monopoly = new FRJogo(4); 
    		}
		});
    	
    	j5.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
			loop(5);
			setVisible(false); 
			Monopoly = new FRJogo(5); 
    		}
		});
    	
    	j6.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
			loop(6);
			setVisible(false); 
			Monopoly = new FRJogo(6); 
    		}
		});
    	
    	Load.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent a) {
    			JFileChooser fileChooser = new JFileChooser();
    		      int returnValue = fileChooser.showOpenDialog(null);
    		      if (returnValue == JFileChooser.APPROVE_OPTION) {
    		        File selectedFile = fileChooser.getSelectedFile();
    		        try {
						java.awt.Desktop.getDesktop().open(selectedFile);
					} catch (IOException e) {
						e.printStackTrace();
					}
    		}
    		}
    	});
    }
    
    	void loop (int lim) {
    		for(int j = 0; j < lim; j++) {
    			PNTabuleiro.getPNTabuleiro().addJogadores(lim);
    			}
    	}  		
    	
}