package auto_BSA;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Component extends JPanel{
	private Block function;
	
	 public Component(Block function) {
		 this.function = function;
	     setOpaque(true);
	 }
  
	 @Override
	    protected void paintComponent(Graphics g) {
		 Graphics2D g2d = (Graphics2D)g;
		 g2d.setRenderingHint ( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
		 g2d.setColor(Color.black);
		 Block.breakinthelaw = 1;
		 Coords c = new Coords(getWidth()/2,50);
/*
		 Block b6[] = new Block[2];
		 b6[0]= new Statement("�� ���� ��");
		 b6[1]= new Statement("�� ���� ��");
		 Block b5[] = new Block[1];
		 b5[0]= new DoWhileCycle(b6,"���");
//		 b5[1]= new SelectorBlock(b6,"���",b6);
//		 b5[2]= new SelectorBlock(b6,"���",b6);
		 Block b4[] = new Block[1];
		 b4[0]= new DoWhileCycle(b5,"���");
		// b4[1]= new SelectorBlock(b6,"���",b6);
		 
		 Block b2[] = new Block[2];
	     b2[0]= new Statement("�� ���� ��");
	     b2[1]= new SelectorBlock(b6,"���",b6);
	     
	   
	     
	     Block b1[] = new Block[3];
	     b1[0]= new DoWhileCycle(b4,"���");
	     b1[1]=  new Statement("�� ���� ��");
	    b1[2]=   new Statement("�� ���� ��");
	     Block b3[] = {new ForCycle(b1,"���"), new Statement("�� ���� ��")};
		 Function fun = new Function(b3, "");
*/	

	     function.paint(c, g2d,true);
	  
	 }
	
}
