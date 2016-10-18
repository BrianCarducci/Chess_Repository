import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pawn extends GamePiece{
	
	private static final long serialVersionUID = -2766797591173892923L;
	private ImageIcon wSprite, bSprite;
	private Color color;
	boolean firstMove;
	
	public Pawn(ImageIcon wSprite, ImageIcon bSprite, Color color){
		super();
		firstMove = true;
		this.wSprite = wSprite;
		this.bSprite = bSprite;
		this.color = color;

		if(color == Color.white){
			setIcon(wSprite);
		} else {
			setIcon(bSprite);
		}
	}

	@Override
	public void move() {
	
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
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean getFirstMove(){
		return firstMove;
	}
	
	@Override
	public void setFirstMove(boolean b){
		firstMove = b;
	}
}