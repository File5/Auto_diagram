package mobi.mpk.flowchart;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class DrawerSimple extends JFrame {
	public DrawerSimple(Block function){
		super("Block");
        JPanel cp = new JPanel(new BorderLayout());
        cp.setOpaque(true);
        cp.setBackground(Color.white);
        setContentPane(cp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        cp.add(new Component(function, cp), BorderLayout.CENTER);
    
		
        
        setSize(1000, 2000);
      setLocationRelativeTo(null);
        
     
    	
        
    }

}
