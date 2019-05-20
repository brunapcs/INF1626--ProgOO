import java.awt.*;
import javax.swing.*;

public class Menu extends JFrame {
	   public final int LARG_DEFAULT=600;
	   public final int ALT_DEFAULT=600;
		
	   public Menu() {
		   setTitle("Banco Imobiliário");
		   Toolkit tk=Toolkit.getDefaultToolkit();
		   Dimension screenSize=tk.getScreenSize();
		   int sl=screenSize.width;
		   int sa=screenSize.height;
		   int x=sl/2-LARG_DEFAULT/2;
		   int y=sa/2-ALT_DEFAULT/2;	  
		   setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		   setSize(sl-1210 , sa-330);
		   setDefaultCloseOperation(EXIT_ON_CLOSE);  
		   getContentPane().add(new Tabuleiro());
		   setVisible(true);
	   }
	   
	   public static void main(String args[]) {
		   Menu p=new Menu();
	   }
	}