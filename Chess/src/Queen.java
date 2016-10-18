import java.awt.Color;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Queen extends GamePiece{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon wSprite, bSprite;
	private Color color;

	public Queen(ImageIcon wSprite, ImageIcon bSprite, Color color){
		this.wSprite = wSprite;
		this.bSprite = bSprite;
		this.color = color;
		
		if (color == Color.white){
			setIcon(wSprite);
		} else {
			setIcon(bSprite);
		}
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isTaken() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Point getSquare() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean check() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkMate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public boolean getFirstMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFirstMove(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
