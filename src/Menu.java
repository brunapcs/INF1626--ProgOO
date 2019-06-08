import java.awt.*;
import javax.swing.*;
 
public class Menu extends JFrame {
	   public final int LARG_DEFAULT=1000;
	   public final int ALT_DEFAULT=800;
	   
	   private FlowLayout layout;      
	   private Container container;    
	    
	   public static Tabuleiro tab_p = null; 
	   public static info_Panel info_p =  null; 
	   public static Menu menu =  null;
	   
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
		   setResizable(false); 
		   
	   }
	   
	   
	   private void setTab()
	    {
		   	tab_p = new Tabuleiro(); 
	        tab_p.setPreferredSize(new Dimension(800,800));
	        getContentPane().add(tab_p);
	    }
	    
	    private void setInfo()
	    {
	    	info_p = new info_Panel(); 
	        info_p.setPreferredSize(new Dimension(200, 600));
	        info_p.setBorder(BorderFactory.createTitledBorder("Controles"));
	        getContentPane().add(info_p);
	    }
	
	    public static Tabuleiro getTab() { 
			   return tab_p; 
		   }
		   
	    public static info_Panel getInfoP(){
			   return info_p;
		   }
		   
	    public static Menu getMenu() { 
	    	return menu; 
	    }
	    
	   public static void main(String args[]) {
		   menu = new Menu("Banco Imobiliário");
	   }
	}


