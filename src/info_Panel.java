

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import Acoes.*;

public class info_Panel extends JPanel {

	public info_Panel(){
		
		JButton add_player = new JButton ("adcionar player");
		JButton rolar_dados = new JButton("rolar dado");
		add(rolar_dados); 
		add(add_player); 
		
		rolar_dados.addActionListener(new RolarDados());
		add_player.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
		      Menu.getTab().addPin();
		      Menu.getMenu().setVisible(true);
			}
		     });
		
		
	}
	
}
