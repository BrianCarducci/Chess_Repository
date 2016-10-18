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
				if(firstTile.getGamePiece() == null){
					System.out.println("you clicked an empty box ya goof!");
				} else {
					for(int i = 0; i < 8; i++) {
						for(int j = 0; j < 8; j++) {
							if(Board.tileArray[i][j].getName().equals(firstTile.getName())) { 
								firstTile = Board.tileArray[i][j];
								x = i;
								y = j;
								System.out.println("in names for loop");
								break;
							}
						}
					}
						
						
////////////////////////////////////////////////////PAWN IMPLEMENTATION\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
					
					} if(getGamePiece() instanceof Pawn){
						System.out.println("iz a pawn");
						int r;
						int n;
						try{
							if(getGamePiece().getColor() == Color.black){
								r = 1;
								n = 2;
							} else {
								r = -1;
								n = -2;
							}
						
						if(getGamePiece().getFirstMove()){
							System.out.println("iz firstmove");
							firstTile.setBackground(Color.blue);
							firstTile.repaint();
							
							System.out.println("truuu");
							if(Board.tileArray[x+r][y].getGamePiece() == null){
								Board.tileArray[x+r][y].setBackground(Color.green);
							} 
							if(Board.tileArray[x+n][y].getGamePiece() == null){
								if(Board.tileArray[x+r][y].getGamePiece() == null){
								Board.tileArray[x+n][y].setBackground(Color.green);
								} else {
									
								}
							} 
							if(Board.tileArray[x+r][y+r].getGamePiece() != null){
								if(Board.tileArray[x+r][y+r].getGamePiece().getColor() != Board.tileArray[x][y].getGamePiece().getColor()){
								Board.tileArray[x+r][y+r].setBackground(Color.yellow);
								}
							}
							if(Board.tileArray[x+r][y-r].getGamePiece() != null){
								if(Board.tileArray[x+r][y-r].getGamePiece().getColor() != Board.tileArray[x][y].getGamePiece().getColor()){
									Board.tileArray[x+r][y+r].setBackground(Color.yellow);
								}
							}
						} else {
							
							System.out.println("iz not first move");
							firstTile.setBackground(Color.blue);
							firstTile.repaint();
							if(Board.tileArray[x+r][y].getGamePiece() == null){
								Board.tileArray[x+r][y].setBackground(Color.green);
							} 
							if(Board.tileArray[x+r][y-r].getGamePiece() != null){
								if(Board.tileArray[x+r][y-r].getGamePiece().getColor() != Board.tileArray[x][y].getGamePiece().getColor()){
									Board.tileArray[x+r][y-r].setBackground(Color.yellow);
								}
							}
							if(Board.tileArray[x+r][y+r].getGamePiece() != null){
								if(Board.tileArray[x+r][y+r].getGamePiece().getColor() != Board.tileArray[x][y].getGamePiece().getColor()){
								Board.tileArray[x+r][y+r].setBackground(Color.yellow);
								System.out.println("checking for enemies");
							}
						}
						}
						
						//firstTile.getGamePiece().setFirstMove(false);
						//Board.firstClick = false;
						} catch (ArrayIndexOutOfBoundsException a){
							System.out.println("caught");
							Board.tileArray[x][y].setBackground(Color.blue);
						}
						
						
/////////////////////////////////////////////////////KNIGHT IMPLEMENTATION\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
					
					} else if(getGamePiece() instanceof Knight){
						try{
						System.out.println("iz a knight");
						firstTile.setBackground(Color.blue);
						firstTile.repaint();
						if(Board.tileArray[x+2][y+1].getGamePiece() == null){
							Board.tileArray[x+2][y+1].setBackground(Color.green);
						} else if(Board.tileArray[x+2][y+1].getGamePiece() != null){
							if(Board.tileArray[x+2][y+1].getGamePiece().getColor() != Board.tileArray[x][y].getGamePiece().getColor()){
								Board.tileArray[x+2][y+1].setBackground(Color.yellow);
								//System.out.println(Board.tileArray[x+2][y+1].getGamePiece().getColor() + ", " + Board.tileArray[x][y].getGamePiece().getColor());
							}
						}
						} catch(ArrayIndexOutOfBoundsException a){
								System.out.println("caught");
							}
						
						try{
						if(Board.tileArray[x+2][y-1].getGamePiece() == null){
							
							Board.tileArray[x+2][y-1].setBackground(Color.green);
						} else if(Board.tileArray[x+2][y-1].getGamePiece() != null){
							if(Board.tileArray[x+2][y-1].getGamePiece().getColor() != Board.tileArray[x][y].getGamePiece().getColor()){
								Board.tileArray[x+2][y-1].setBackground(Color.yellow);
								//System.out.println(Board.tileArray[x+2][y+1].getGamePiece().getColor() + ", " + Board.tileArray[x][y].getGamePiece().getColor());
							}
						}
						} catch(ArrayIndexOutOfBoundsException a){
							System.out.println("caught");
						}
						
						try{
						if(Board.tileArray[x-2][y-1].getGamePiece() == null){
							Board.tileArray[x-2][y-1].setBackground(Color.green);
						} else if(Board.tileArray[x-2][y-1].getGamePiece() != null){
							if(Board.tileArray[x-2][y-1].getGamePiece().getColor() != Board.tileArray[x][y].getGamePiece().getColor()){
								Board.tileArray[x-2][y-1].setBackground(Color.yellow);
								//System.out.println(Board.tileArray[x-2][y+1].getGamePiece().getColor() + ", " + Board.tileArray[x][y].getGamePiece().getColor());
							}
						}
						} catch(ArrayIndexOutOfBoundsException a){
							System.out.println("caught");
						}
						
						try{
						if(Board.tileArray[x-2][y+1].getGamePiece() == null){
							Board.tileArray[x-2][y+1].setBackground(Color.green);
						} else if(Board.tileArray[x-2][y+1].getGamePiece() != null){
							if(Board.tileArray[x-2][y+1].getGamePiece().getColor() != Board.tileArray[x][y].getGamePiece().getColor()){
								Board.tileArray[x-2][y+1].setBackground(Color.yellow);
								//System.out.println(Board.tileArray[x-2][y+1].getGamePiece().getColor() + ", " + Board.tileArray[x][y].getGamePiece().getColor());
						
							}
						}
						} catch(ArrayIndexOutOfBoundsException a){
							System.out.println("caught");
						}
						
						try{
						if(Board.tileArray[x+1][y-2].getGamePiece() == null){
							Board.tileArray[x+1][y-2].setBackground(Color.green);
						} else if(Board.tileArray[x+1][y-2].getGamePiece() != null){
							if(Board.tileArray[x+1][y-2].getGamePiece().getColor() != Board.tileArray[x][y].getGamePiece().getColor()){
								Board.tileArray[x+1][y-2].setBackground(Color.yellow);
								//System.out.println(Board.tileArray[x-2][y+1].getGamePiece().getColor() + ", " + Board.tileArray[x][y].getGamePiece().getColor());
							
							}
						}
						} catch(ArrayIndexOutOfBoundsException a){
							System.out.println("caught");
						}
						
						try{
						if(Board.tileArray[x+1][y+2].getGamePiece() == null){
							Board.tileArray[x+1][y+2].setBackground(Color.green);
						} else if(Board.tileArray[x+1][y+2].getGamePiece() != null){
							if(Board.tileArray[x+1][y+2].getGamePiece().getColor() != Board.tileArray[x][y].getGamePiece().getColor()){
								Board.tileArray[x+1][y+2].setBackground(Color.yellow);
								//System.out.println(Board.tileArray[x-2][y+2].getGamePiece().getColor() + ", " + Board.tileArray[x][y].getGamePiece().getColor());
							
							}
						}
						} catch(ArrayIndexOutOfBoundsException a){
							System.out.println("caught");
						}
						
						try{
						if(Board.tileArray[x-1][y-2].getGamePiece() == null){
							Board.tileArray[x-1][y-2].setBackground(Color.green);
						} else if(Board.tileArray[x-1][y-2].getGamePiece() != null){
							if(Board.tileArray[x-1][y-2].getGamePiece().getColor() != Board.tileArray[x][y].getGamePiece().getColor()){
								Board.tileArray[x-1][y-2].setBackground(Color.yellow);
								//System.out.println(Board.tileArray[x-1][y-2].getGamePiece().getColor() + ", " + Board.tileArray[x][y].getGamePiece().getColor());
							
							}
						}
						} catch(ArrayIndexOutOfBoundsException a){
							System.out.println("caught");
						}
						
						try{
						if(Board.tileArray[x-1][y+2].getGamePiece() == null){
							Board.tileArray[x-1][y+2].setBackground(Color.green);
						} else if(Board.tileArray[x-1][y+2].getGamePiece() != null){
							if(Board.tileArray[x-1][y+2].getGamePiece().getColor() != Board.tileArray[x][y].getGamePiece().getColor()){
								Board.tileArray[x-1][y+2].setBackground(Color.yellow);
								System.out.println(Board.tileArray[x-1][y+2].getGamePiece().getColor() + ", " + Board.tileArray[x][y].getGamePiece().getColor());
							
							}
						}
						} catch(ArrayIndexOutOfBoundsException a){
							System.out.println("caught");
						}
						
////////////////////////////////////////////////////BISHOP IMPLEMENTATION\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\						
						
					} else if(getGamePiece() instanceof Bishop){
						int i = x;
						int j = y;
						Board.tileArray[x][y].setBackground(Color.blue);
						try{
							while(Board.tileArray[i+1][j+1].getGamePiece() == null){
								Board.tileArray[i+1][j+1].setBackground(Color.green);
								i++;
								j++;
							}
							
							if(getGamePiece().getColor() != Board.tileArray[i+1][j+1].getGamePiece().getColor()){
								Board.tileArray[i+1][j+1].setBackground(Color.yellow);
							}
							i = x;
							j = y;							
						} catch (ArrayIndexOutOfBoundsException ex) {
							i = x;
							j = y;	
						}
						try{
							while(Board.tileArray[i+1][j-1].getGamePiece() == null){
								Board.tileArray[i+1][j-1].setBackground(Color.green);
								i++;
								j--;
							}
							if(getGamePiece().getColor() != Board.tileArray[i+1][j-1].getGamePiece().getColor()){
								Board.tileArray[i+1][j-1].setBackground(Color.yellow);
							}
							i = x;
							j = y;	
						} catch (ArrayIndexOutOfBoundsException ex){
							i = x;
							j = y;	
						}
						try{
							while(Board.tileArray[i-1][j-1].getGamePiece() == null){
								Board.tileArray[i-1][j-1].setBackground(Color.green);
								i--;
								j--;
							}
							if(getGamePiece().getColor() != Board.tileArray[i-1][j-1].getGamePiece().getColor()){
								Board.tileArray[i-1][j-1].setBackground(Color.yellow);
							}
							i = x;
							j = y;	
						} catch (ArrayIndexOutOfBoundsException ex){
							i = x;
							j = y;	
						}
						try{
							while(Board.tileArray[i-1][j+1].getGamePiece() == null){
								Board.tileArray[i-1][j+1].setBackground(Color.green);
								i--;
								j++;
							}
							if(getGamePiece().getColor() != Board.tileArray[i-1][j+1].getGamePiece().getColor()){
								Board.tileArray[i-1][j+1].setBackground(Color.yellow);
							}
							i = x;
							j = y;	
						} catch (ArrayIndexOutOfBoundsException ex){
							i = x;
							j = y;	
						}
						for (int q = 0; q < 8; q++){
							for (int w = 0; w < 8; w++){
								Board.tileArray[q][w].repaint();
							}
						}
					
					}
					
///////////////////////////////////////////ROOK IMPLEMENTATION\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
					
					else if(getGamePiece() instanceof Rook){
						firstTile.setBackground(Color.blue);
						int i = x;
						int j = y;
						try{
							while(Board.tileArray[i+1][j].getGamePiece() == null){
								Board.tileArray[i+1][j].setBackground(Color.green);
								i++;
							}
							if(getGamePiece().getColor() != Board.tileArray[i+1][j].getGamePiece().getColor()){
								Board.tileArray[i+1][j].setBackground(Color.yellow);
							}
							i = x;
						} catch (ArrayIndexOutOfBoundsException ex){
							i = x;
						}
						try{
							while(Board.tileArray[i-1][j].getGamePiece() == null){
								Board.tileArray[i-1][j].setBackground(Color.green);
								i--;
							}
							if(getGamePiece().getColor() != Board.tileArray[i-1][j].getGamePiece().getColor()){
								Board.tileArray[i-1][j].setBackground(Color.yellow);
							}
							i = x;
						} catch (ArrayIndexOutOfBoundsException ex){
							i = x;
						}
						try{
							while(Board.tileArray[i][j+1].getGamePiece() == null){
								Board.tileArray[i][j+1].setBackground(Color.green);
								j++;
							}
							if(getGamePiece().getColor() != Board.tileArray[i][j+1].getGamePiece().getColor()){
								Board.tileArray[i][j+1].setBackground(Color.yellow);
							}
							j = y;
						} catch (ArrayIndexOutOfBoundsException ex){
							j = y;
						}
						try{
							while(Board.tileArray[i][j-1].getGamePiece() == null){
								Board.tileArray[i][j-1].setBackground(Color.green);
								j--;
								System.out.println(j);
							}
							if(getGamePiece().getColor() != Board.tileArray[i][j-1].getGamePiece().getColor()){
								Board.tileArray[i][j-1].setBackground(Color.yellow);
							}
							j = y;
						} catch (ArrayIndexOutOfBoundsException ex){
							j = y;
						}
						for (int q = 0; q < 8; q++){
							for (int w = 0; w < 8; w++){
								Board.tileArray[q][w].repaint();
							}
						}
						
					}
					
///////////////////////////////////////////QUEEN IMPLEMENTATION\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
					
					if(getGamePiece() instanceof Queen){
						int i = x;
						int j = y;
						Board.tileArray[x][y].setBackground(Color.blue);
						try{
							while(Board.tileArray[i+1][j+1].getGamePiece() == null){
								Board.tileArray[i+1][j+1].setBackground(Color.green);
								i++;
								j++;
							}
							
							if(getGamePiece().getColor() != Board.tileArray[i+1][j+1].getGamePiece().getColor()){
								Board.tileArray[i+1][j+1].setBackground(Color.yellow);
							}
							i = x;
							j = y;							
						} catch (ArrayIndexOutOfBoundsException ex) {
							i = x;
							j = y;	
						}
						try{
							while(Board.tileArray[i+1][j-1].getGamePiece() == null){
								Board.tileArray[i+1][j-1].setBackground(Color.green);
								i++;
								j--;
							}
							if(getGamePiece().getColor() != Board.tileArray[i+1][j-1].getGamePiece().getColor()){
								Board.tileArray[i+1][j-1].setBackground(Color.yellow);
							}
							i = x;
							j = y;	
						} catch (ArrayIndexOutOfBoundsException ex){
							i = x;
							j = y;	
						}
						try{
							while(Board.tileArray[i-1][j-1].getGamePiece() == null){
								Board.tileArray[i-1][j-1].setBackground(Color.green);
								i--;
								j--;
							}
							if(getGamePiece().getColor() != Board.tileArray[i-1][j-1].getGamePiece().getColor()){
								Board.tileArray[i-1][j-1].setBackground(Color.yellow);
							}
							i = x;
							j = y;	
						} catch (ArrayIndexOutOfBoundsException ex){
							i = x;
							j = y;	
						}
						try{
							while(Board.tileArray[i-1][j+1].getGamePiece() == null){
								Board.tileArray[i-1][j+1].setBackground(Color.green);
								i--;
								j++;
							}
							if(getGamePiece().getColor() != Board.tileArray[i-1][j+1].getGamePiece().getColor()){
								Board.tileArray[i-1][j+1].setBackground(Color.yellow);
							}
							i = x;
							j = y;	
						} catch (ArrayIndexOutOfBoundsException ex){
							i = x;
							j = y;	
						}
						try{
							while(Board.tileArray[i+1][j].getGamePiece() == null){
								Board.tileArray[i+1][j].setBackground(Color.green);
								i++;
							}
							if(getGamePiece().getColor() != Board.tileArray[i+1][j].getGamePiece().getColor()){
								Board.tileArray[i+1][j].setBackground(Color.yellow);
							}
							i = x;
						} catch (ArrayIndexOutOfBoundsException ex){
							i = x;
						}
						try{
							while(Board.tileArray[i-1][j].getGamePiece() == null){
								Board.tileArray[i-1][j].setBackground(Color.green);
								i--;
							}
							if(getGamePiece().getColor() != Board.tileArray[i-1][j].getGamePiece().getColor()){
								Board.tileArray[i-1][j].setBackground(Color.yellow);
							}
							i = x;
						} catch (ArrayIndexOutOfBoundsException ex){
							i = x;
						}
						try{
							while(Board.tileArray[i][j+1].getGamePiece() == null){
								Board.tileArray[i][j+1].setBackground(Color.green);
								j++;
							}
							if(getGamePiece().getColor() != Board.tileArray[i][j+1].getGamePiece().getColor()){
								Board.tileArray[i][j+1].setBackground(Color.yellow);
							}
							j = y;
						} catch (ArrayIndexOutOfBoundsException ex){
							j = y;
						}
						try{
							while(Board.tileArray[i][j-1].getGamePiece() == null){
								Board.tileArray[i][j-1].setBackground(Color.green);
								j--;
								System.out.println(j);
							}
							if(getGamePiece().getColor() != Board.tileArray[i][j-1].getGamePiece().getColor()){
								Board.tileArray[i][j-1].setBackground(Color.yellow);
							}
							j = y;
						} catch (ArrayIndexOutOfBoundsException ex){
							j = y;
						}
						
						for (int q = 0; q < 8; q++){
							for (int w = 0; w < 8; w++){
								Board.tileArray[q][w].repaint();
							}
						}
						
					}
					
///////////////////////////////////////////KING IMPLEMENTATION\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
					
					if(getGamePiece() instanceof King){
						int i = x;
						int j = y;
						Board.tileArray[x][y].setBackground(Color.blue);
						
						
						try {
						if(Board.tileArray[x+1][y].getGamePiece() == null){
							Board.tileArray[x+1][y].setBackground(Color.green);
						} else if(Board.tileArray[x+1][y].getGamePiece().getColor() != firstTile.getGamePiece().getColor()){
							Board.tileArray[x+1][y].setBackground(Color.yellow);
						}
						} catch(ArrayIndexOutOfBoundsException ex){
							
						}
						
						try {
						if(Board.tileArray[x-1][y].getGamePiece() == null){
							Board.tileArray[x-1][y].setBackground(Color.green);
						} else if(Board.tileArray[x-1][y].getGamePiece().getColor() != firstTile.getGamePiece().getColor()){
							Board.tileArray[x-1][y].setBackground(Color.yellow);
						}
						} catch(ArrayIndexOutOfBoundsException ex){
							
						}
						
						try {
						if(Board.tileArray[x][y+1].getGamePiece() == null){
							Board.tileArray[x][y+1].setBackground(Color.green);
						} else if(Board.tileArray[x][y+1].getGamePiece().getColor() != firstTile.getGamePiece().getColor()){
							Board.tileArray[x][y+1].setBackground(Color.yellow);
						}
						} catch(ArrayIndexOutOfBoundsException ex){
							
						}
						
						try {
						if(Board.tileArray[x][y-1].getGamePiece() == null){
							Board.tileArray[x][y-1].setBackground(Color.green);
						} else if(Board.tileArray[x][y-1].getGamePiece().getColor() != firstTile.getGamePiece().getColor()){
							Board.tileArray[x][y-1].setBackground(Color.yellow);
						}
						} catch(ArrayIndexOutOfBoundsException ex){
							
						}
						
						try {
						if(Board.tileArray[x+1][y+1].getGamePiece() == null){
							Board.tileArray[x+1][y+1].setBackground(Color.green);
						} else if(Board.tileArray[x+1][y+1].getGamePiece().getColor() != firstTile.getGamePiece().getColor()){
							Board.tileArray[x+1][y+1].setBackground(Color.yellow);
						}
						} catch (ArrayIndexOutOfBoundsException ex){
							
						}
						
						try {
						if(Board.tileArray[x+1][y-1].getGamePiece() == null){
							Board.tileArray[x+1][y-1].setBackground(Color.green);
						} else if(Board.tileArray[x+1][y-1].getGamePiece().getColor() != firstTile.getGamePiece().getColor()){
							Board.tileArray[x+1][y-1].setBackground(Color.yellow);
						}
						} catch (ArrayIndexOutOfBoundsException ex) {
							
						}
						
						try {
						if(Board.tileArray[x-1][y-1].getGamePiece() == null){
							Board.tileArray[x-1][y-1].setBackground(Color.green);
						} else if(Board.tileArray[x-1][y-1].getGamePiece().getColor() != firstTile.getGamePiece().getColor()){
							Board.tileArray[x-1][y-1].setBackground(Color.yellow);
						}
						} catch(ArrayIndexOutOfBoundsException ex){
							
						}
						
						try {
						if(Board.tileArray[x-1][y+1].getGamePiece() == null){
							Board.tileArray[x-1][y+1].setBackground(Color.green);
						} else if(Board.tileArray[x-1][y+1].getGamePiece().getColor() != firstTile.getGamePiece().getColor()){
							Board.tileArray[x-1][y+1].setBackground(Color.yellow);
						}
						} catch(ArrayIndexOutOfBoundsException ex){
							
						}
					}

						System.out.println("right before");
						firstClick = false;
						System.out.println("right after " + firstClick);
			

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
					
					
					
					
				
					
		} else if(secondTile.getBackground() == Color.white || secondTile.getBackground() == Color.darkGray || secondTile.getBackground() == Color.blue){
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					Board.tileArray[i][j].setBackground(Board.tileArray[i][j].getColor());
				}
			}
		}
				int kingX;
				int kingY;
				
				for(int i = 0; i < 8; i++){
					for(int j = 0; j < 8; j++){
						if(Board.tileArray[i][j].getGamePiece() instanceof King){
							kingX = i;
							kingY = j;
							System.out.println("kingX: " + kingX + "kingY: " + kingY);
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


		
		
	
