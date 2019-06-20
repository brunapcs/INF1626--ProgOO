package menuIni;
import javax.swing.*;
import gui.FRJogo;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuInicial extends JFrame {

    public MenuInicial() {

        initUI();
    }

    private void initUI() {

        JButton start = new JButton("start"); 
        start.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) { 
				 setVisible(false); 
				 FRJogo jogo = new FRJogo (6); 
				 //jogo.novoJogo; 
				 //ou load jogo
			}
		});
        
        add(start); 
        setTitle("menu");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true); 
        
    }
}