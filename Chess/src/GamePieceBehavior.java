import java.awt.Color;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public interface GamePieceBehavior {
	public abstract void move();
	public abstract boolean isTaken();
	public abstract Point getSquare();
	public abstract boolean check();
	public abstract boolean checkMate();
	public abstract Color getColor();
	public abstract int getX();
	public abstract int getY();
	public abstract ImageIcon getImage();
	public abstract PieceType getType();


}
