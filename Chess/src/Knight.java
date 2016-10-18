import java.awt.Color;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Knight extends GamePiece{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ImageIcon wSprite, bSprite;
	private Color color;
	private boolean putInCheck = false;
	//private int x,y;

	public Knight(ImageIcon wSprite, ImageIcon bSprite, Color color){
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
		int x = 0;
		int y = 0;
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				if(Board.tileArray[i][j].getGamePiece() == this){
					System.out.println("knight found!");
					x = i;
					y = j;
					break;
					}
				}
			}
		try {
			if(Board.tileArray[x+1][y+2].getGamePiece() instanceof King && Board.tileArray[x+1][y+2].getGamePiece().getColor()
					!= this.getColor()){
				putInCheck = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex){
		}
		
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
