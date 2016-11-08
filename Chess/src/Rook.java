import java.awt.Color;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Rook extends GamePiece{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon wSprite, bSprite;
	private Color color;
	private Tile[][] board;

	public Rook(ImageIcon wSprite, ImageIcon bSprite, Color color){
		board = Board.tileArray;
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
	public void moveSet(int x, int y) {
		board[x][y].setBackground(Color.blue);
		int i = x;
		int j = y;
		try{
			while(board[i+1][j].getGamePiece() == null){
				board[i+1][j].setBackground(Color.green);
				i++;
			}
			if(getColor() != board[i+1][j].getGamePiece().getColor()){
				board[i+1][j].setBackground(Color.yellow);
			}
			i = x;
		} catch (ArrayIndexOutOfBoundsException ex){
			i = x;
		}
		try{
			while(board[i-1][j].getGamePiece() == null){
				board[i-1][j].setBackground(Color.green);
				i--;
			}
			if(getColor() != board[i-1][j].getGamePiece().getColor()){
				board[i-1][j].setBackground(Color.yellow);
			}
			i = x;
		} catch (ArrayIndexOutOfBoundsException ex){
			i = x;
		}
		try{
			while(board[i][j+1].getGamePiece() == null){
				board[i][j+1].setBackground(Color.green);
				j++;
			}
			if(getColor() != board[i][j+1].getGamePiece().getColor()){
				board[i][j+1].setBackground(Color.yellow);
			}
			j = y;
		} catch (ArrayIndexOutOfBoundsException ex){
			j = y;
		}
		try{
			while(board[i][j-1].getGamePiece() == null){
				board[i][j-1].setBackground(Color.green);
				j--;
				System.out.println(j);
			}
			if(getColor() != board[i][j-1].getGamePiece().getColor()){
				board[i][j-1].setBackground(Color.yellow);
			}
			j = y;
		} catch (ArrayIndexOutOfBoundsException ex){
			j = y;
		}
		for (int q = 0; q < 8; q++){
			for (int w = 0; w < 8; w++){
				board[q][w].repaint();
			}
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
