package mobi.mpk.flowchart;

import java.awt.FontMetrics;
import java.awt.Graphics2D;

public abstract class Block {
	public static Integer breakinthelaw = 1;
	
	final int HALFOFNORMALLENGHT = 50, HALFOFNORMALHIGHT = 25,
			THEBIGGESTLENGHT = 14;
	String line;

	public Block() {
	}

	// if nextlinedraw -> drawing next line
	public abstract void paint(Coords Coord, Graphics2D g2d,
			boolean nextlinedraw);

	public void nextArrow(Coords Coord, Graphics2D g2d) {
		g2d.drawLine(Coord.getX(), Coord.getY() + 25, Coord.getX(),
				Coord.getY() + 25 + 20);
		// g2d.drawLine(Coord.getX(), Coord.getY()+25+20, Coord.getX()-2,
		// Coord.getY()+25+18);
		// g2d.drawLine(Coord.getX(), Coord.getY()+25+20, Coord.getX()+2,
		// Coord.getY()+25+18);
	}

	public static void drawCenteredString(Graphics2D g, String s, int w, int h) {
		FontMetrics fm = g.getFontMetrics();
		int x = w - fm.stringWidth(s) / 2;
		int y = h + fm.getAscent() / 2;
		g.drawString(s, x, y);
	}

	public static void drawCenteredLines(Graphics2D g, String s, int w, int h) {
		int BLOCK_HEIGHT = 50;
		h -= BLOCK_HEIGHT / 2;
		String[] lines = s.split("\n");
		int lineCount = lines.length;
		FontMetrics fm = g.getFontMetrics();
		h -= fm.getAscent() / 2;
		int liney = (BLOCK_HEIGHT + fm.getAscent()) / (lineCount + 1); // +
																		// g.getFontMetrics().getDescent()
		for (int i = 0; i < lineCount; i++) {
			int y = h + (i + 1) * liney;
			// FOR DEBUG g.drawLine(w - 50, y, w + 50, y);
			drawCenteredString(g, lines[i], w, y);
		}
	}

	// if you see that method do not touch it...
	public abstract int getwidth(Coords Coord);

	// returns ifs counts
	public abstract int isIf();

	public int isBreak() {
		return 0;
	}

	public abstract int getCyclesMargin();

	public int breakMargin() {
		return 0;
	}

	public boolean isThereABreakInBody() {

		return false;
	}

	public boolean isThereAContinueInBody() {

		return false;
	}

	public boolean isThereAContinueInElseBody() {

		return false;
	}

	public abstract boolean isThereABreakInElseBody();

	public int continueMargin() {
		return 0;
	}

	public int isContinue() {
		return 0;
	}
	public int isReturn(){
		return 0;
	}

	public boolean isThereAReturnInBody() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isThereAReturnInElseBody() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setNoRet() {
		// TODO Auto-generated method stub
		
	}
	public void countingofbody(Coords Coord){
		if(Coord.getextremeLX() < Component.theleftest &&Coord.getextremeLX()>0){
			Component.theleftest = Coord.getextremeLX();
		}	
//		if(Coord.getX()< Component.theleftest &&Coord.getX()>0){
//			Component.theleftest = Coord.getX();
//		}
		if(Coord.getextremeRX() > Component.therightest && Coord.getextremeRX()>0){
			Component.therightest = Coord.getextremeRX();
		}
		
	}
}
