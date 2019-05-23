import java.awt.*;
import javax.swing.*;
 
public class Menu extends JFrame {
	   public final int LARG_DEFAULT=600;
	   public final int ALT_DEFAULT=600;
	   Tabuleiro tab = new Tabuleiro(); 
	   info_Panel info = new info_Panel(); 
	   
	   public Menu() {
		   setTitle("Banco Imobiliário");
		   
		   Toolkit tk=Toolkit.getDefaultToolkit();
		   Dimension screenSize=tk.getScreenSize();
		    
		   setBounds(0,0,LARG_DEFAULT,ALT_DEFAULT);
		   setSize(screenSize.width , screenSize.height);
		   
		   setDefaultCloseOperation(EXIT_ON_CLOSE);  
		   
		   add(tab);
		   add(info); 
		   
		   setVisible(true);
		
	   }
	   
	   
	   public static void main(String args[]) {
		   Menu p=new Menu();
	   }
	}



/* ***
int sl=screenSize.width;
int sa=screenSize.height;
int x=sl/2-LARG_DEFAULT/2;
int y=sa/2-ALT_DEFAULT/2;	  
*** */ 