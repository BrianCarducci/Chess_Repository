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
	private Board board;
	private Tile tile = this;
	private static Boolean firstClick = true;
	private static int x, y;
	private static Tile firstTile, secondTile;
	private static boolean whiteMove = true;
	private boolean check;
	
	public Tile(Color color, GamePiece gamePiece){
		this.color = color;
		//this.isOccupied = isOccupied;
		this.setOpaque(true);
		this.setBackground(color);
		this.gamePiece = gamePiece;
		
		try{
			this.add(gamePiece);
		} catch(NullPointerException e){
			
		}

		this.addMouseListener(new MouseEvents());
	}
	
	
	public GamePiece getGamePiece(){
		return gamePiece;
	}
	
	public void setGamePiece(GamePiece newPiece){
		gamePiece = newPiece;
	}
	
	public boolean getFirstClick(){
		return firstClick;
	}
	
	public Color getColor(){
		return color;
	}
	
	private class MouseEvents implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e){
			
			System.out.println(firstClick);
			firstTile = (Tile)e.getSource();
			System.out.println(firstClick);
			if(firstClick){
				if (firstTile.getGamePiece() == null){
					
				}
				else if (whiteMove && getGamePiece().getColor() == Color.white || !whiteMove && getGamePiece().getColor() == Color.black){
					for(int i = 0; i < 8; i++) {
						for(int j = 0; j < 8; j++) {
							if(Board.tileArray[i][j] == e.getSource()) { 
								firstTile = Board.tileArray[i][j];
								x = i;
								y = j;
								System.out.println("in names for loop");
								break;
							}
						}
					}
					
					//Retrieves and displays the move set of the clicked piece
					getGamePiece().moveSet(x, y);
					
					firstClick = false;
					System.out.println("right after " + firstClick);
			}
			

///////////////////////////////////////////CODE BELOW HANDELS SECOND CLICK\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
						
						
				} else {
				secondTile = (Tile) e.getSource();
				if(secondTile.getBackground() == Color.green){
					for(int i = 0; i < 8; i++){
						for(int j = 0; j < 8; j++){
							Board.tileArray[i][j].setBackground(Board.tileArray[i][j].getColor());
						}
					}
					secondTile.setGamePiece(Board.tileArray[x][y].getGamePiece());
					secondTile.add(Board.tileArray[x][y].getGamePiece());
					secondTile.getGamePiece().setFirstMove(false);
					secondTile.repaint();
					Board.tileArray[x][y].remove(Board.tileArray[x][y].getGamePiece());
					Board.tileArray[x][y].setGamePiece(null);
					Board.tileArray[x][y].repaint();
					whiteMove = !whiteMove;
					System.out.println("green spot selected");
					
				} else if(secondTile.getBackground() == Color.yellow){
					
					secondTile.remove(secondTile.getGamePiece());
					secondTile.setGamePiece(Board.tileArray[x][y].getGamePiece());
					secondTile.add(Board.tileArray[x][y].getGamePiece());
					Board.tileArray[x][y].getGamePiece().setFirstMove(false);
					Board.tileArray[x][y].remove(firstTile.getGamePiece());
					Board.tileArray[x][y].setGamePiece(null);
					for(int i = 0; i < 8; i++){
						for(int j = 0; j < 8; j++){
							Board.tileArray[i][j].setBackground(Board.tileArray[i][j].getColor());
							Board.tileArray[i][j].repaint();
						}
					}
					
					//Switches Player turn
					whiteMove = !whiteMove;
					
					
		} else if(secondTile.getBackground() == Color.white || secondTile.getBackground() == Color.darkGray || secondTile.getBackground() == Color.blue){
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					Board.tileArray[i][j].setBackground(Board.tileArray[i][j].getColor());
				}
			}
		}		
				
				//ALGORITHM FOR CHECKING FOR CHECK/CHECKMATE
				for(int i = 0; i < 8; i++){
					for (int j = 0; j < 8; j++){
						if (Board.tileArray[i][j].getGamePiece() != null && whiteMove && Board.tileArray[i][j].getColor() == Color.BLACK){
							Board.tileArray[i][j].getGamePiece().check(i, j);
						}
						else if (Board.tileArray[i][j].getGamePiece() != null && !whiteMove && Board.tileArray[i][j].getColor() == Color.WHITE){
							Board.tileArray[i][j].getGamePiece().check(i, j);
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


		
		
	
