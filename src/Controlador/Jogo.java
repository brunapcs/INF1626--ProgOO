package Controlador;
import javax.swing.*;

import Acoes.RolarDados;

import java.awt.*;
 
public class Jogo extends JFrame {
	 
	   
	   public Jogo() {
		   setTitle("Banco Imobiliario");
		   setDefaultCloseOperation(EXIT_ON_CLOSE);
		   setLayout(null); 
		  
		   setTab();
	       setInfo();
		   setDados(); 
		   
		   setLocation(100, 0);
	       setSize(1200, 800); 
		   setVisible(false);
		   setResizable(true);  
	   }  
	   
	   private void setTab()
	    {
		   	Tabuleiro tab_p = Controler.getTab_p(); 
	        getContentPane().add(tab_p);
	    }
	    
	    private void setInfo()
	    {
	    	Botoes botoes_p = Controler.getBotoes_p() ; 
	    	botoes_p.setBorder(BorderFactory.createTitledBorder("Controles"));
	        getContentPane().add(botoes_p);
	    }
	    
	    private void setDados()
	    {
	    	RolarDados dados = Controler.getDados(); 
	        getContentPane().add(dados);
	    }
}


