package MenuIni;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;



public class MenuInicial extends JFrame {
		
	
		public MenuInicial(){ 
			
			
			MenuIniPanel panel = new MenuIniPanel(); 
			getContentPane().add(panel); 
			
			setSize(1000,1000); 
			setVisible(true); 
		} 
		
		public void setMenuIniVisible(boolean b){ 
			setVisible(b); 
		}
	
}


	
