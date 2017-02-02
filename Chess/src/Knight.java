import java.awt.Color;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Knight extends GamePiece{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;
	private Tile[][] tileArray;
	//private int x,y;

	public Knight(ImageIcon wSprite, ImageIcon bSprite, Color color, Tile[][] tileArray){
		this.color = color;
		this.tileArray = tileArray;
		
		if(color == Color.white){
			setIcon(wSprite);
		} else {
			setIcon(bSprite);
		}
	}

	@Override
	public void moveSet(int x, int y) {
		try{
			System.out.println("iz a knight");
			tileArray[x][y].setBackground(Color.blue);
			tileArray[x][y].repaint();
			if(tileArray[x+2][y+1].getGamePiece() == null){
				tileArray[x+2][y+1].setBackground(Color.green);
			} else if(tileArray[x+2][y+1].getGamePiece() != null){
				if(tileArray[x+2][y+1].getGamePiece().getColor() != tileArray[x][y].getGamePiece().getColor()){
					tileArray[x+2][y+1].setBackground(Color.yellow);
					//System.out.println(tileArray[x+2][y+1].getGamePiece().getColor() + ", " + tileArray[x][y].getGamePiece().getColor());
				}
			}
			} catch(ArrayIndexOutOfBoundsException a){
					System.out.println("caught");
				}
			
			try{
			if(tileArray[x+2][y-1].getGamePiece() == null){
				
				tileArray[x+2][y-1].setBackground(Color.green);
			} else if(tileArray[x+2][y-1].getGamePiece() != null){
				if(tileArray[x+2][y-1].getGamePiece().getColor() != tileArray[x][y].getGamePiece().getColor()){
					tileArray[x+2][y-1].setBackground(Color.yellow);
					//System.out.println(tileArray[x+2][y+1].getGamePiece().getColor() + ", " + tileArray[x][y].getGamePiece().getColor());
				}
			}
			} catch(ArrayIndexOutOfBoundsException a){
				System.out.println("caught");
			}
			
			try{
			if(tileArray[x-2][y-1].getGamePiece() == null){
				tileArray[x-2][y-1].setBackground(Color.green);
			} else if(tileArray[x-2][y-1].getGamePiece() != null){
				if(tileArray[x-2][y-1].getGamePiece().getColor() != tileArray[x][y].getGamePiece().getColor()){
					tileArray[x-2][y-1].setBackground(Color.yellow);
					//System.out.println(tileArray[x-2][y+1].getGamePiece().getColor() + ", " + tileArray[x][y].getGamePiece().getColor());
				}
			}
			} catch(ArrayIndexOutOfBoundsException a){
				System.out.println("caught");
			}
			
			try{
			if(tileArray[x-2][y+1].getGamePiece() == null){
				tileArray[x-2][y+1].setBackground(Color.green);
			} else if(tileArray[x-2][y+1].getGamePiece() != null){
				if(tileArray[x-2][y+1].getGamePiece().getColor() != tileArray[x][y].getGamePiece().getColor()){
					tileArray[x-2][y+1].setBackground(Color.yellow);
					//System.out.println(tileArray[x-2][y+1].getGamePiece().getColor() + ", " + tileArray[x][y].getGamePiece().getColor());
			
				}
			}
			} catch(ArrayIndexOutOfBoundsException a){
				System.out.println("caught");
			}
			
			try{
			if(tileArray[x+1][y-2].getGamePiece() == null){
				tileArray[x+1][y-2].setBackground(Color.green);
			} else if(tileArray[x+1][y-2].getGamePiece() != null){
				if(tileArray[x+1][y-2].getGamePiece().getColor() != tileArray[x][y].getGamePiece().getColor()){
					tileArray[x+1][y-2].setBackground(Color.yellow);
					//System.out.println(tileArray[x-2][y+1].getGamePiece().getColor() + ", " + tileArray[x][y].getGamePiece().getColor());
				
				}
			}
			} catch(ArrayIndexOutOfBoundsException a){
				System.out.println("caught");
			}
			
			try{
			if(tileArray[x+1][y+2].getGamePiece() == null){
				tileArray[x+1][y+2].setBackground(Color.green);
			} else if(tileArray[x+1][y+2].getGamePiece() != null){
				if(tileArray[x+1][y+2].getGamePiece().getColor() != tileArray[x][y].getGamePiece().getColor()){
					tileArray[x+1][y+2].setBackground(Color.yellow);
					//System.out.println(tileArray[x-2][y+2].getGamePiece().getColor() + ", " + tileArray[x][y].getGamePiece().getColor());
				
				}
			}
			} catch(ArrayIndexOutOfBoundsException a){
				System.out.println("caught");
			}
			
			try{
			if(tileArray[x-1][y-2].getGamePiece() == null){
				tileArray[x-1][y-2].setBackground(Color.green);
			} else if(tileArray[x-1][y-2].getGamePiece() != null){
				if(tileArray[x-1][y-2].getGamePiece().getColor() != tileArray[x][y].getGamePiece().getColor()){
					tileArray[x-1][y-2].setBackground(Color.yellow);
					//System.out.println(tileArray[x-1][y-2].getGamePiece().getColor() + ", " + tileArray[x][y].getGamePiece().getColor());
				
				}
			}
			} catch(ArrayIndexOutOfBoundsException a){
				System.out.println("caught");
			}
			
			try{
			if(tileArray[x-1][y+2].getGamePiece() == null){
				tileArray[x-1][y+2].setBackground(Color.green);
			} else if(tileArray[x-1][y+2].getGamePiece() != null){
				if(tileArray[x-1][y+2].getGamePiece().getColor() != tileArray[x][y].getGamePiece().getColor()){
					tileArray[x-1][y+2].setBackground(Color.yellow);
					System.out.println(tileArray[x-1][y+2].getGamePiece().getColor() + ", " + tileArray[x][y].getGamePiece().getColor());
				
				}
			}
			} catch(ArrayIndexOutOfBoundsException a){
				System.out.println("caught");
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
	public void setCheckTiles(int x, int y){
		
		if (getColor() == Color.white) {
			try {
				tileArray[x+2][y+1].setWhiteCheckSpace(true);
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				tileArray[x+2][y-1].setWhiteCheckSpace(true);
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				tileArray[x-2][y+1].setWhiteCheckSpace(true);
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				tileArray[x-2][y-1].setWhiteCheckSpace(true);
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				tileArray[x+1][y+2].setWhiteCheckSpace(true);
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				tileArray[x+1][y-2].setWhiteCheckSpace(true);
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				tileArray[x-1][y+2].setWhiteCheckSpace(true);
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				tileArray[x-1][y-2].setWhiteCheckSpace(true);
			} catch (ArrayIndexOutOfBoundsException e) {}
		}
		else {
			try {
				tileArray[x+2][y+1].setBlackCheckSpace(true);
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				tileArray[x+2][y-1].setBlackCheckSpace(true);
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				tileArray[x-2][y+1].setBlackCheckSpace(true);
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				tileArray[x-2][y-1].setBlackCheckSpace(true);
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				tileArray[x+1][y+2].setBlackCheckSpace(true);
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				tileArray[x+1][y-2].setBlackCheckSpace(true);
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				tileArray[x-1][y+2].setBlackCheckSpace(true);
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				tileArray[x-1][y-2].setBlackCheckSpace(true);
			} catch (ArrayIndexOutOfBoundsException e) {}
		}
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

	@Override
	public boolean check(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
