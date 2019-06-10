package Controlador;
import javax.swing.*;
import java.awt.*;
 
public class Jogo extends JFrame {
	 
	   
	   public Jogo() {
		   setTitle("Banco Imobiliario");
		   setDefaultCloseOperation(EXIT_ON_CLOSE);
		   
		   setLayout(new FlowLayout());
		   
		   
		   setTab();
	       setInfo();
		   
		   setLocation(100, 0);
	       setSize(1200, 800); 
		   setVisible(false);
		   setResizable(true); 
		  
	   }  
	   
	   private void setTab()
	    {
		   	Tabuleiro tab_p = Controler.getTab_p() ; 
	        tab_p.setPreferredSize(new Dimension(800,800));
	        getContentPane().add(tab_p);
	    }
	    
	    private void setInfo()
	    {
	    	Botoes botoes_p = Controler.getBotoes_p() ; 
	    	botoes_p.setPreferredSize(new Dimension(200, 600));
	    	botoes_p.setBorder(BorderFactory.createTitledBorder("Controles"));
	        getContentPane().add(botoes_p);
	    }
}


