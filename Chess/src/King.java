import java.awt.Color;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class King extends GamePiece{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;
	private int xLoc,yLoc;
	private Tile[][] tileArray;

	public King(ImageIcon wSprite, ImageIcon bSprite, Color color, Tile[][] tileArray){
		this.tileArray = tileArray;
		this.color = color;
		
		if (color == Color.white){
			setIcon(wSprite);
		} else {
			setIcon(bSprite);
		}
	}

	@Override
	public void moveSet(int x, int y) {
		tileArray[x][y].setBackground(Color.blue);
		
		try {
			if(getColor() == Color.white){
				if(!tileArray[x+1][y].isBlackCheckSpace()){
					if(tileArray[x+1][y].getGamePiece() == null){
						tileArray[x+1][y].setBackground(Color.green);
					} 
					else if(tileArray[x+1][y].getGamePiece().getColor() != getColor()){
						tileArray[x+1][y].setBackground(Color.yellow);
					}
				}
			}
			else if(getColor() == Color.black){
				if(!tileArray[x+1][y].isWhiteCheckSpace()){
					if(tileArray[x+1][y].getGamePiece() == null){
						tileArray[x+1][y].setBackground(Color.green);
					} 
					else if(tileArray[x+1][y].getGamePiece().getColor() != getColor()){
						tileArray[x+1][y].setBackground(Color.yellow);
					}
				}
			}
			
			} catch(ArrayIndexOutOfBoundsException ex) {
			
		}
		
		try {
			if(getColor() == Color.white){
				if(!tileArray[x-1][y].isBlackCheckSpace()){
					if(tileArray[x-1][y].getGamePiece() == null){
						tileArray[x-1][y].setBackground(Color.green);
					} 
					else if(tileArray[x-1][y].getGamePiece().getColor() != getColor()){
						tileArray[x-1][y].setBackground(Color.yellow);
					}
				}
			}
			else if (getColor() == Color.black){
				if(!tileArray[x-1][y].isWhiteCheckSpace()){
					if(tileArray[x-1][y].getGamePiece() == null){
						tileArray[x-1][y].setBackground(Color.green);
					} 
					else if(tileArray[x-1][y].getGamePiece().getColor() != getColor()){
						tileArray[x-1][y].setBackground(Color.yellow);
					}
				}
			}
			
		} catch(ArrayIndexOutOfBoundsException ex) {
		}
		
		try {
			if(getColor() == Color.white){
				if(!tileArray[x][y+1].isBlackCheckSpace()){
					if(tileArray[x][y+1].getGamePiece() == null){
						tileArray[x][y+1].setBackground(Color.green);
					} 
					else if(tileArray[x][y+1].getGamePiece().getColor() != getColor()){
						tileArray[x][y+1].setBackground(Color.yellow);
					}
				}
			}
			else if (getColor() == Color.black){
				if(!tileArray[x][y+1].isWhiteCheckSpace()){
					if(tileArray[x][y+1].getGamePiece() == null){
						tileArray[x][y+1].setBackground(Color.green);
					} 
					else if(tileArray[x][y+1].getGamePiece().getColor() != getColor()){
						tileArray[x][y+1].setBackground(Color.yellow);
					}
				}
			}
			
		} catch(ArrayIndexOutOfBoundsException ex){
		}
		
		
		
		///IF THIS BLOCK WORKS FOR BOTH PIECES, YOU'RE REALLY ON TO SOMETHING\\\\\
		
		try {
			if(getColor() == Color.white){
				if(!tileArray[x][y-1].isBlackCheckSpace()){
					if(tileArray[x][y-1].getGamePiece() == null){
						tileArray[x][y-1].setBackground(Color.green);
					}
					else if(tileArray[x][y-1].getGamePiece().getColor() != getColor()){
						tileArray[x][y-1].setBackground(Color.yellow);
					}
				}
			}
			else if(getColor() == Color.black) {
				if(!tileArray[x][y-1].isWhiteCheckSpace()){
					if(tileArray[x][y-1].getGamePiece() == null){
						tileArray[x][y-1].setBackground(Color.green);
					}
					else if(tileArray[x][y-1].getGamePiece().getColor() != getColor()){
						tileArray[x][y-1].setBackground(Color.yellow);
					}
				}
			}

			} catch(ArrayIndexOutOfBoundsException ex){
		}
		
		////OH YEAH BEBEH SUCK MY ASS FGT BLZ MY CHRONIX/////////////
		
		try {
			if(getColor() == Color.white){
				if(!tileArray[x+1][y+1].isBlackCheckSpace()){
					if(tileArray[x+1][y+1].getGamePiece() == null){
						tileArray[x+1][y+1].setBackground(Color.green);
					} 
					else if(tileArray[x+1][y+1].getGamePiece().getColor() != getColor()){
						tileArray[x+1][y+1].setBackground(Color.yellow);
					}
				}
			}
			else if(getColor() == Color.black) {
				if(!tileArray[x+1][y+1].isWhiteCheckSpace()){
					if(tileArray[x+1][y+1].getGamePiece() == null){
						tileArray[x+1][y+1].setBackground(Color.green);
					} 
					else if(tileArray[x+1][y+1].getGamePiece().getColor() != getColor()){
						tileArray[x+1][y+1].setBackground(Color.yellow);
					}
				}
			}
	
			} catch (ArrayIndexOutOfBoundsException ex){
		}
		
		try {
			if(getColor() == Color.white){
				if(!tileArray[x+1][y-1].isBlackCheckSpace()){
					if(tileArray[x+1][y-1].getGamePiece() == null){
						tileArray[x+1][y-1].setBackground(Color.green);
					} 
					else if(tileArray[x+1][y-1].getGamePiece().getColor() != getColor()){
						tileArray[x+1][y-1].setBackground(Color.yellow);
					}
				}
			}
			else if(getColor() == Color.black) {
				if(!tileArray[x+1][y-1].isWhiteCheckSpace()){
					if(tileArray[x+1][y-1].getGamePiece() == null){
						tileArray[x+1][y-1].setBackground(Color.green);
					} 
					else if(tileArray[x+1][y-1].getGamePiece().getColor() != getColor()){
						tileArray[x+1][y-1].setBackground(Color.yellow);
					}
				}
			}
	
			} catch (ArrayIndexOutOfBoundsException ex) {
		}
		
		try {
			if(getColor() == Color.white){
				if(!tileArray[x-1][y-1].isBlackCheckSpace()){
					if(tileArray[x-1][y-1].getGamePiece() == null){
						tileArray[x-1][y-1].setBackground(Color.green);
					} 
					else if(tileArray[x-1][y-1].getGamePiece().getColor() != getColor()){
						tileArray[x-1][y-1].setBackground(Color.yellow);
					}
				}
			}
			else if(getColor() == Color.black) {
				if(!tileArray[x-1][y-1].isWhiteCheckSpace()){
					if(tileArray[x-1][y-1].getGamePiece() == null){
						tileArray[x-1][y-1].setBackground(Color.green);
					} 
					else if(tileArray[x-1][y-1].getGamePiece().getColor() != getColor()){
						tileArray[x-1][y-1].setBackground(Color.yellow);
					}
				}
			}
		
			} catch (ArrayIndexOutOfBoundsException ex){
		}
		
		try {
			if(getColor() == Color.white){
				if(!tileArray[x-1][y+1].isBlackCheckSpace()){
					if(tileArray[x-1][y+1].getGamePiece() == null){
						tileArray[x-1][y+1].setBackground(Color.green);
					} 
					else if(tileArray[x-1][y+1].getGamePiece().getColor() != getColor()){
						tileArray[x-1][y+1].setBackground(Color.yellow);
					}
				}
			}
			else if(getColor() == Color.black) {
				if(!tileArray[x-1][y+1].isWhiteCheckSpace()){
					if(tileArray[x-1][y+1].getGamePiece() == null){
						tileArray[x-1][y+1].setBackground(Color.green);
					} 
					else if(tileArray[x-1][y+1].getGamePiece().getColor() != getColor()){
						tileArray[x-1][y+1].setBackground(Color.yellow);
					}
				}
			}
			
				
			
			} catch (ArrayIndexOutOfBoundsException ex){
		}
		
	}
	
	@Override
	public void setCheckTiles(int x, int y){
		
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
	public boolean check(int x, int y) {
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
