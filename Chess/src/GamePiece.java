import java.awt.Color;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JLabel;

public abstract class GamePiece extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public abstract void move();
	public abstract boolean isTaken();
	public abstract Point getSquare();
	public abstract boolean check();
	public abstract boolean checkMate();
	public abstract Color getColor();
//	public abstract int getX();
//	public abstract int getY();
	public abstract boolean getFirstMove();
	public abstract void setFirstMove(boolean b);
	public abstract Image getImage();

}
