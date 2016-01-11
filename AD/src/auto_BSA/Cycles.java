package auto_BSA;

import java.awt.Graphics2D;

public class Cycles extends FunBlock{
	
	public Cycles(Block[] body,String line){
		super(body,line);
	}
	@Override
	public void paint( Coords Coord, Graphics2D g2d,boolean nextlinedraw) {
			
	}
	@Override
	public void drawbody(Coords Coord,Graphics2D g2d) {
		 for(int i = 0 ; i<body.length ; i++) {
			 if(i!=(body.length-1)) {
			 body[i].paint(Coord,g2d,true); 
			 Coord.setY(Coord.getY()+50+20);
			 Coord.setY(Coord.getextremeDY()+25);
			 Coord.setextremeDY(Coord.getextremeDY()+50);
			 
			 }else {
			 body[i].paint(Coord,g2d,false);	 
			 //Coord.setextremeDY(Coord.getextremeDY()-20);
			 }
		 }	 
	}
	@Override
	public int getwidth(Coords Coord) {
		int sum=0;
 		for (int i = 0; i < body.length; i++) {
 			if(body[i].getwidth(Coord)>sum)
 			sum=body[i].getwidth(Coord);
 			
 		}
 		return sum;
	  }
	 public void returning(Coords Coord,Coords retCoord,Graphics2D g2d){

		  Coord.setextremeRX(Coord.getextremeRX()+getcyc()+getwidth(Coord));
		  Coord.setinvestedCol(0);
		  Coord.setextremeLX(Coord.getextremeLX()-getcyc());
		  Coord.setextremeDY(Coord.getextremeDY()+5);
		  //������ ����� ����
		  g2d.drawLine(Coord.getX(),Coord.getextremeDY(),Coord.getX(),Coord.getextremeDY()-5);
		  //�����
		  g2d.drawLine(Coord.getX(),Coord.getextremeDY(),Coord.getextremeLX(),Coord.getextremeDY());
		  //�����
		  g2d.drawLine(Coord.getextremeLX(),Coord.getextremeDY(),Coord.getextremeLX(),retCoord.getY());
		  
		  Coord.setextremeDY(Coord.getextremeDY()+5);
		//������ � ����� �����
		  g2d.drawLine(Coord.getextremeLX(),retCoord.getY(),retCoord.getextremeLX(),retCoord.getY());
		//������ �� ����� ����� 
		  g2d.drawLine(retCoord.getextremeRX(),retCoord.getY(),Coord.getextremeRX(),retCoord.getY());
		//���� 
		  g2d.drawLine(Coord.getextremeRX(),retCoord.getY(),Coord.getextremeRX(),Coord.getextremeDY());	
		//����� 
		  g2d.drawLine(Coord.getextremeRX(),Coord.getextremeDY(),Coord.getX(),Coord.getextremeDY());	
		//����
		  g2d.drawLine(Coord.getX(),Coord.getextremeDY(),Coord.getX(),Coord.getextremeDY()+10);
		  
		  Coord.setextremeDY(Coord.getextremeDY()+10);
		  Coord.setextremeLX(Coord.getextremeLX()+getcyc());
		  Coord.setextremeRX(Coord.getX()+50);
		 // retCoord.setextremeDY(Coord.getextremeDY());
		//  Coord.setextremeRX(Coord.getextremeRX()-50+getcyc());
	  }

	 @Override
		public int getcyc() {
			int sum = 8;
			for (int i = 0; i < body.length; i++) {
	 			sum+=body[i].getcyc();
	 		}
			return sum;
		}
}