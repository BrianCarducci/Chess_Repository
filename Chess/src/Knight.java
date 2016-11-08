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
	private Tile[][] board;
	//private int x,y;

	public Knight(ImageIcon wSprite, ImageIcon bSprite, Color color){
		board = Board.tileArray;
		this.wSprite = wSprite;
		this.bSprite = bSprite;
		this.color = color;
		
		if(color == Color.white){
			setIcon(wSprite);
		} else {
			setIcon(bSprite);
		}
	}

	//Method to check if a knight has put a king in check
	@Override
	public void moveSet(int x, int y) {
		try{
			System.out.println("iz a knight");
			board[x][y].setBackground(Color.blue);
			board[x][y].repaint();
			if(board[x+2][y+1].getGamePiece() == null){
				board[x+2][y+1].setBackground(Color.green);
			} else if(board[x+2][y+1].getGamePiece() != null){
				if(board[x+2][y+1].getGamePiece().getColor() != board[x][y].getGamePiece().getColor()){
					board[x+2][y+1].setBackground(Color.yellow);
					//System.out.println(board[x+2][y+1].getGamePiece().getColor() + ", " + board[x][y].getGamePiece().getColor());
				}
			}
			} catch(ArrayIndexOutOfBoundsException a){
					System.out.println("caught");
				}
			
			try{
			if(board[x+2][y-1].getGamePiece() == null){
				
				board[x+2][y-1].setBackground(Color.green);
			} else if(board[x+2][y-1].getGamePiece() != null){
				if(board[x+2][y-1].getGamePiece().getColor() != board[x][y].getGamePiece().getColor()){
					board[x+2][y-1].setBackground(Color.yellow);
					//System.out.println(board[x+2][y+1].getGamePiece().getColor() + ", " + board[x][y].getGamePiece().getColor());
				}
			}
			} catch(ArrayIndexOutOfBoundsException a){
				System.out.println("caught");
			}
			
			try{
			if(board[x-2][y-1].getGamePiece() == null){
				board[x-2][y-1].setBackground(Color.green);
			} else if(board[x-2][y-1].getGamePiece() != null){
				if(board[x-2][y-1].getGamePiece().getColor() != board[x][y].getGamePiece().getColor()){
					board[x-2][y-1].setBackground(Color.yellow);
					//System.out.println(board[x-2][y+1].getGamePiece().getColor() + ", " + board[x][y].getGamePiece().getColor());
				}
			}
			} catch(ArrayIndexOutOfBoundsException a){
				System.out.println("caught");
			}
			
			try{
			if(board[x-2][y+1].getGamePiece() == null){
				board[x-2][y+1].setBackground(Color.green);
			} else if(board[x-2][y+1].getGamePiece() != null){
				if(board[x-2][y+1].getGamePiece().getColor() != board[x][y].getGamePiece().getColor()){
					board[x-2][y+1].setBackground(Color.yellow);
					//System.out.println(board[x-2][y+1].getGamePiece().getColor() + ", " + board[x][y].getGamePiece().getColor());
			
				}
			}
			} catch(ArrayIndexOutOfBoundsException a){
				System.out.println("caught");
			}
			
			try{
			if(board[x+1][y-2].getGamePiece() == null){
				board[x+1][y-2].setBackground(Color.green);
			} else if(board[x+1][y-2].getGamePiece() != null){
				if(board[x+1][y-2].getGamePiece().getColor() != board[x][y].getGamePiece().getColor()){
					board[x+1][y-2].setBackground(Color.yellow);
					//System.out.println(board[x-2][y+1].getGamePiece().getColor() + ", " + board[x][y].getGamePiece().getColor());
				
				}
			}
			} catch(ArrayIndexOutOfBoundsException a){
				System.out.println("caught");
			}
			
			try{
			if(board[x+1][y+2].getGamePiece() == null){
				board[x+1][y+2].setBackground(Color.green);
			} else if(board[x+1][y+2].getGamePiece() != null){
				if(board[x+1][y+2].getGamePiece().getColor() != board[x][y].getGamePiece().getColor()){
					board[x+1][y+2].setBackground(Color.yellow);
					//System.out.println(board[x-2][y+2].getGamePiece().getColor() + ", " + board[x][y].getGamePiece().getColor());
				
				}
			}
			} catch(ArrayIndexOutOfBoundsException a){
				System.out.println("caught");
			}
			
			try{
			if(board[x-1][y-2].getGamePiece() == null){
				board[x-1][y-2].setBackground(Color.green);
			} else if(board[x-1][y-2].getGamePiece() != null){
				if(board[x-1][y-2].getGamePiece().getColor() != board[x][y].getGamePiece().getColor()){
					board[x-1][y-2].setBackground(Color.yellow);
					//System.out.println(board[x-1][y-2].getGamePiece().getColor() + ", " + board[x][y].getGamePiece().getColor());
				
				}
			}
			} catch(ArrayIndexOutOfBoundsException a){
				System.out.println("caught");
			}
			
			try{
			if(board[x-1][y+2].getGamePiece() == null){
				board[x-1][y+2].setBackground(Color.green);
			} else if(board[x-1][y+2].getGamePiece() != null){
				if(board[x-1][y+2].getGamePiece().getColor() != board[x][y].getGamePiece().getColor()){
					board[x-1][y+2].setBackground(Color.yellow);
					System.out.println(board[x-1][y+2].getGamePiece().getColor() + ", " + board[x][y].getGamePiece().getColor());
				
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
	public boolean check(int x, int y) throws ArrayIndexOutOfBoundsException {
		boolean check = false;
		
		try {
			if (board[x+2][y+1].getGamePiece() instanceof King && board[x+2][y+1].getGamePiece().getColor() != this.getColor()) {
				check = true;
			}
		} catch (ArrayIndexOutOfBoundsException e){}
		
		try { 
			if (board[x+2][y+1].getGamePiece() instanceof King && board[x+2][y-1].getGamePiece().getColor() != this.getColor()) {
				check = true;
			}
		} catch (ArrayIndexOutOfBoundsException e){}
		
		try {
			if (board[x+2][y+1].getGamePiece() instanceof King && board[x-2][y+1].getGamePiece().getColor() != this.getColor()) {
				check = true;
			}
		} catch (ArrayIndexOutOfBoundsException e){}
		
		try {
			if (board[x+2][y+1].getGamePiece() instanceof King && board[x-2][y-1].getGamePiece().getColor() != this.getColor()) {
				check = true;
			}
		} catch (ArrayIndexOutOfBoundsException e){}
		
		try {
			if (board[x+2][y+1].getGamePiece() instanceof King && board[x+1][y-2].getGamePiece().getColor() != this.getColor()) {
				check = true;
			}
		} catch (ArrayIndexOutOfBoundsException e){}
		
		try {
			if (board[x+2][y+1].getGamePiece() instanceof King && board[x+1][y+2].getGamePiece().getColor() != this.getColor()) {
				check = true;
			}
		} catch (ArrayIndexOutOfBoundsException e){}
		
		try {
			if (board[x+2][y+1].getGamePiece() instanceof King && board[x-1][y+2].getGamePiece().getColor() != this.getColor()) {
				check = true;
			}
		} catch (ArrayIndexOutOfBoundsException e){}
		
		try {
			if (board[x+2][y+1].getGamePiece() instanceof King && board[x-2][y-1].getGamePiece().getColor() != this.getColor()) {
				check = true;
			}
		} catch (ArrayIndexOutOfBoundsException e){}
		
		if(check){
			System.out.println("KING IS IN CHECK BY KNIGHT!");
		}
		
		return check;
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
