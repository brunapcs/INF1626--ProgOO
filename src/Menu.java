import java.awt.*;
import javax.swing.*;
 
public class Menu extends JFrame {
	   public final int LARG_DEFAULT=1000;
	   public final int ALT_DEFAULT=800;
	   
	   private FlowLayout layout;      

	   private Container container;    
	    
	   
	   public Menu() {

	   }
	   
	   public Menu(String name) { 
		   setTitle(name);
		   setDefaultCloseOperation(EXIT_ON_CLOSE);
		   
		   setLayout(new FlowLayout());
	       
		   setTab();
	       setInfo();
		   
		   setLocation(100, 0);
	       setSize(1200, 800); 
		   setVisible(true);
	   }
	   
	   
	   private void setTab()
	    {
	        JPanel jp = new Tabuleiro(); 
	        jp.setPreferredSize(new Dimension(800,800));
	        getContentPane().add(jp);
	    }
	    
	    private void setInfo()
	    {
	        JPanel jp =  new info_Panel();
	        jp.setPreferredSize(new Dimension(200, 600));
	        jp.setBorder(BorderFactory.createTitledBorder("Controles"));
	        getContentPane().add(jp);
	    }
	
	   
	   public static void main(String args[]) {
		   Menu p=new Menu("Banco Imobiliário");
	   }
	}



/* ***
int sl=screenSize.width;
int sa=screenSize.height;
int x=sl/2-LARG_DEFAULT/2;
int y=sa/2-ALT_DEFAULT/2;	  
*** */ 