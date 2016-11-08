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
	private Tile[][] board;
	boolean firstMove;
	
	public Pawn(ImageIcon wSprite, ImageIcon bSprite, Color color){
		super();
		board = Board.tileArray;
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
	public void moveSet(int x, int y) {
		
		int r;
		int n;
		try{
			if(getColor() == Color.black){
				r = 1;
				n = 2;
			} else {
				r = -1;
				n = -2;
			}
		
		if(getFirstMove()){
			System.out.println("iz firstmove");
			board[x][y].setBackground(Color.blue);
			board[x][y].repaint();
			
			System.out.println("truuu");
			if(board[x+r][y].getGamePiece() == null){
				board[x+r][y].setBackground(Color.green);
			} 
			if(board[x+n][y].getGamePiece() == null){
				if(board[x+r][y].getGamePiece() == null){
				board[x+n][y].setBackground(Color.green);
				} else {
					
				}
			} 
			if(board[x+r][y+r].getGamePiece() != null){
				if(board[x+r][y+r].getGamePiece().getColor() != board[x][y].getGamePiece().getColor()){
				board[x+r][y+r].setBackground(Color.yellow);
				}
			}
			if(board[x+r][y-r].getGamePiece() != null){
				if(board[x+r][y-r].getGamePiece().getColor() != board[x][y].getGamePiece().getColor()){
					board[x+r][y+r].setBackground(Color.yellow);
				}
			}
		
		} else {
			
			System.out.println("iz not first move");
			board[x][y].setBackground(Color.blue);
			board[x][y].repaint();
			if(board[x+r][y].getGamePiece() == null){
				board[x+r][y].setBackground(Color.green);
			} 
			if(board[x+r][y-r].getGamePiece() != null){
				if(board[x+r][y-r].getGamePiece().getColor() != board[x][y].getGamePiece().getColor()){
					board[x+r][y-r].setBackground(Color.yellow);
				}
			}
			if(board[x+r][y+r].getGamePiece() != null){
				if(board[x+r][y+r].getGamePiece().getColor() != board[x][y].getGamePiece().getColor()){
				board[x+r][y+r].setBackground(Color.yellow);
				System.out.println("checking for enemies");
			}
		}
		}
		
		//firstTile.getGamePiece().setFirstMove(false);
		//Board.firstClick = false;
		} catch (ArrayIndexOutOfBoundsException a){
			System.out.println("caught");
			board[x][y].setBackground(Color.blue);
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