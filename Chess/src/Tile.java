import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class Tile extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;
	private GamePiece gamePiece;
	private static Boolean firstClick = true;
	private static int x, y;
	private static Tile firstTile, secondTile;
	private Tile[][] tileArray;
	private static boolean whiteMove = true;
	private boolean whiteCheckSpace, blackCheckSpace;
	
	public Tile(Color color, GamePiece gamePiece, boolean whiteCheckSpace, boolean blackCheckSpace, Tile[][] tileArray){
		this.color = color;
		this.setOpaque(true);
		this.setBackground(color);
		this.gamePiece = gamePiece;
		this.whiteCheckSpace = whiteCheckSpace;
		this.blackCheckSpace = blackCheckSpace;
		this.tileArray = tileArray;
		
		try{
			this.add(gamePiece);
		} catch(NullPointerException e){}

		this.addMouseListener(new MouseEvents());
	}
	
	
	public GamePiece getGamePiece(){
		return gamePiece;
	}
	
	public boolean getFirstClick(){
		return firstClick;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setGamePiece(GamePiece newPiece){
		gamePiece = newPiece;
	}
	
	public void setBlackCheckSpace(boolean checkSpace){
		blackCheckSpace = checkSpace;
	}
	
	public void setWhiteCheckSpace(boolean checkSpace){
		whiteCheckSpace = checkSpace;
	}
	
	public boolean isBlackCheckSpace(){
		return blackCheckSpace;
	}
	
	public boolean isWhiteCheckSpace(){
		return whiteCheckSpace;
	}
	
//	public boolean isCheckSpace(){
//		return checkSpace;
//	}
	
	private class MouseEvents implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e){
			
			firstTile = (Tile) e.getSource();
			if (firstClick) {
				if (firstTile.getGamePiece() == null) {
					
				}
				else if (whiteMove && getGamePiece().getColor() == Color.white || !whiteMove && getGamePiece().getColor() == Color.black){
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							if (tileArray[i][j] == e.getSource()) { 
								firstTile = tileArray[i][j];
								x = i;
								y = j;
								break;
							}
						}
					}
					
					//Retrieves and displays the move set of the clicked piece
					getGamePiece().moveSet(x, y);
					firstClick = false;
			}
			

//////////////////////////////////////////////////////CODE BELOW HANDELS SECOND CLICK\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
						
						
				} else {
					
				secondTile = (Tile) e.getSource();
				
				if (secondTile.getBackground() == Color.green) {
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							tileArray[i][j].setBackground(tileArray[i][j].getColor());
							if (tileArray[i][j].getGamePiece() != null) {
							}
						}
					}
					secondTile.setGamePiece(tileArray[x][y].getGamePiece());
					secondTile.add(tileArray[x][y].getGamePiece());
					secondTile.getGamePiece().setFirstMove(false);
					secondTile.repaint();
					tileArray[x][y].remove(tileArray[x][y].getGamePiece());
					tileArray[x][y].setGamePiece(null);
					tileArray[x][y].repaint();
					whiteMove = !whiteMove;
					System.out.println("green spot selected");
					
				} else if (secondTile.getBackground() == Color.yellow) {
					
					secondTile.remove(secondTile.getGamePiece());
					secondTile.setGamePiece(tileArray[x][y].getGamePiece());
					secondTile.add(tileArray[x][y].getGamePiece());
					tileArray[x][y].getGamePiece().setFirstMove(false);
					tileArray[x][y].remove(firstTile.getGamePiece());
					tileArray[x][y].setGamePiece(null);
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							tileArray[i][j].setBackground(tileArray[i][j].getColor());
							tileArray[i][j].repaint();
						}
					}
					
					//Switches Player turn
					whiteMove = !whiteMove;
					
					
		} else if (secondTile.getBackground() == Color.white || secondTile.getBackground() == Color.darkGray || secondTile.getBackground() == Color.blue){
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					tileArray[i][j].setBackground(tileArray[i][j].getColor());
				}
			}
		}
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (tileArray[i][j] == secondTile) {
							x = i;
							y = j;
							System.out.println("second click loc: (" + x + ", " + y + ")");
							break;
						}
					}
				}
				
//				for (int i = 0; i < 8; i++) {
//					for (int j = 0; j < 8; j++) {
//						if (tileArray[i][j].getGamePiece() != null) {
//							tileArray[i][j].setBlackCheckSpace(false);
//							tileArray[i][j].setWhiteCheckSpace(false);
//						}
//					}
//				} 
				
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (tileArray[i][j].getGamePiece() != null) {
							tileArray[i][j].getGamePiece().setCheckTiles(x, y);
						}
					}
				}
				
		
				firstClick = true;
				}
		}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!firstClick){
					Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED); 
					setBorder(border);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setBorder(null);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {

			}
			
			@Override
			public void mouseReleased(MouseEvent e) {

			}
		}

}


		
		
	
