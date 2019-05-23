
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;


public class info_Panel extends JPanel {

	public info_Panel(){
		this.setBounds(1000, 0, 200 , 200);
		JButton rolar_dados = new JButton("rolar dado");
		add(rolar_dados); 
		revalidate(); 
		repaint();
	}
	
}
