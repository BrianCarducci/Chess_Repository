import java.awt.Color;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Queen extends GamePiece{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;
	private Tile[][] tileArray;

	public Queen(ImageIcon wSprite, ImageIcon bSprite, Color color, Tile[][] tileArray){
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
		int i = x;
		int j = y;
		tileArray[x][y].setBackground(Color.blue);
		try{
			while(tileArray[i+1][j+1].getGamePiece() == null){
				tileArray[i+1][j+1].setBackground(Color.green);
				i++;
				j++;
			}
			
			if(getColor() != tileArray[i+1][j+1].getGamePiece().getColor()){
				tileArray[i+1][j+1].setBackground(Color.yellow);
			}
			i = x;
			j = y;							
		} catch (ArrayIndexOutOfBoundsException ex) {
			i = x;
			j = y;	
		}
		try{
			while(tileArray[i+1][j-1].getGamePiece() == null){
				tileArray[i+1][j-1].setBackground(Color.green);
				i++;
				j--;
			}
			if(getColor() != tileArray[i+1][j-1].getGamePiece().getColor()){
				tileArray[i+1][j-1].setBackground(Color.yellow);
			}
			i = x;
			j = y;	
		} catch (ArrayIndexOutOfBoundsException ex){
			i = x;
			j = y;	
		}
		try{
			while(tileArray[i-1][j-1].getGamePiece() == null){
				tileArray[i-1][j-1].setBackground(Color.green);
				i--;
				j--;
			}
			if(getColor() != tileArray[i-1][j-1].getGamePiece().getColor()){
				tileArray[i-1][j-1].setBackground(Color.yellow);
			}
			i = x;
			j = y;	
		} catch (ArrayIndexOutOfBoundsException ex){
			i = x;
			j = y;	
		}
		try{
			while(tileArray[i-1][j+1].getGamePiece() == null){
				tileArray[i-1][j+1].setBackground(Color.green);
				i--;
				j++;
			}
			if(getColor() != tileArray[i-1][j+1].getGamePiece().getColor()){
				tileArray[i-1][j+1].setBackground(Color.yellow);
			}
			i = x;
			j = y;	
		} catch (ArrayIndexOutOfBoundsException ex){
			i = x;
			j = y;	
		}
		try{
			while(tileArray[i+1][j].getGamePiece() == null){
				tileArray[i+1][j].setBackground(Color.green);
				i++;
			}
			if(getColor() != tileArray[i+1][j].getGamePiece().getColor()){
				tileArray[i+1][j].setBackground(Color.yellow);
			}
			i = x;
		} catch (ArrayIndexOutOfBoundsException ex){
			i = x;
		}
		try{
			while(tileArray[i-1][j].getGamePiece() == null){
				tileArray[i-1][j].setBackground(Color.green);
				i--;
			}
			if(getColor() != tileArray[i-1][j].getGamePiece().getColor()){
				tileArray[i-1][j].setBackground(Color.yellow);
			}
			i = x;
		} catch (ArrayIndexOutOfBoundsException ex){
			i = x;
		}
		try{
			while(tileArray[i][j+1].getGamePiece() == null){
				tileArray[i][j+1].setBackground(Color.green);
				j++;
			}
			if(getColor() != tileArray[i][j+1].getGamePiece().getColor()){
				tileArray[i][j+1].setBackground(Color.yellow);
			}
			j = y;
		} catch (ArrayIndexOutOfBoundsException ex){
			j = y;
		}
		try{
			while(tileArray[i][j-1].getGamePiece() == null){
				tileArray[i][j-1].setBackground(Color.green);
				j--;
				System.out.println(j);
			}
			if(getColor() != tileArray[i][j-1].getGamePiece().getColor()){
				tileArray[i][j-1].setBackground(Color.yellow);
			}
			j = y;
		} catch (ArrayIndexOutOfBoundsException ex){
			j = y;
		}
		
		for (int q = 0; q < 8; q++){
			for (int w = 0; w < 8; w++){
				tileArray[q][w].repaint();
			}
		}
		
	}
	
	@Override
	public void setCheckTiles(int x, int y) {
		
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
