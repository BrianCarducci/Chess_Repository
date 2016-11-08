import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Board extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 2000, HEIGHT = 2000;
	private Color blackPiece = Color.black, whitePiece = Color.white, whiteTile = Color.white,
			blackTile = Color.darkGray;
	private ImageIcon bPawn, bKnight, bRook, bBishop, bQueen, bKing,
				  		wPawn, wKnight, wRook, wBishop, wQueen, wKing;
	private JPanel panel;
	private JLayeredPane layeredPane;
	private static boolean whiteInCheck, blackInCheck;
	static Tile tileArray[][];
	
	static boolean firstClick = true;
	
	public Board(){
		super("Chess");
		this.setVisible(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		wPawn = new ImageIcon("Images/small_w_pawn.png");
		wKnight = new ImageIcon("Images/white_knight_small.png");
		wBishop = new ImageIcon("Images/white_bishop_small.png");
		wRook = new ImageIcon("Images/white_rook_small.png");
		wKing = new ImageIcon("Images/white_king_small.jpg");
		wQueen = new ImageIcon("Images/white_queen_small.png");
		
		bPawn = new ImageIcon("Images/black_pawn_small.png");
		bKnight = new ImageIcon("Images/black_knight_small.png");
		bBishop = new ImageIcon("Images/black_bishop_small.png");
		bRook = new ImageIcon("Images/black_rook_small.png");
		bQueen = new ImageIcon("Images/black_queen_small.png");
		bKing = new ImageIcon("Images/black_king_small.png");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(8,8));
		panel.setVisible(true);

		tileArray = new Tile[8][8];

		
		//////////////////////////CODE BELOW ADDS TILES TO A 2D ARRAY THEN ADD TO BOARD\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		boolean flag = true;
		int j = 0;
		for(int i = 0; i < 8; i++){
			if(i == 0){
				tileArray[0][0] = new Tile(whiteTile, new Rook(null, bRook, blackPiece));
				tileArray[0][0].setName("0,0");
				tileArray[0][1] = new Tile(blackTile, new Knight(null, bKnight, blackPiece));
				tileArray[0][1].setName("0,1");
				tileArray[0][2] = new Tile(whiteTile, new Bishop(null, bBishop, blackPiece));
				tileArray[0][2].setName("0,2");
				tileArray[0][3] = new Tile(blackTile, new Queen(null, bQueen, blackPiece));
				tileArray[0][3].setName("0,3");
				tileArray[0][4] = new Tile(whiteTile, new King(null, bKing, blackPiece));
				tileArray[0][4].setName("0,4");
				tileArray[0][5] = new Tile(blackTile, new Bishop(null, bBishop, blackPiece));
				tileArray[0][5].setName("0,5");
				tileArray[0][6] = new Tile(whiteTile, new Knight(null, bKnight, blackPiece));
				tileArray[0][6].setName("0,6");
				tileArray[0][7] = new Tile(blackTile, new Rook(null, bRook, blackPiece));
				tileArray[0][7].setName("0,7");
			}
			
			if(i == 1){
				tileArray[1][0] = new Tile(blackTile, new Pawn(null, bPawn, blackPiece));
				tileArray[1][0].setName("1,0");
				tileArray[1][1] = new Tile(whiteTile, new Pawn(null, bPawn, blackPiece));
				tileArray[1][1].setName("1,1");
				tileArray[1][2] = new Tile(blackTile, new Pawn(null, bPawn, blackPiece));
				tileArray[1][2].setName("1,2");
				tileArray[1][3] = new Tile(whiteTile, new Pawn(null, bPawn, blackPiece));
				tileArray[1][3].setName("1,3");
				tileArray[1][4] = new Tile(blackTile, new Pawn(null, bPawn, blackPiece));
				tileArray[1][4].setName("1,4");
				tileArray[1][5] = new Tile(whiteTile, new Pawn(null, bPawn, blackPiece));
				tileArray[1][5].setName("1,5");
				tileArray[1][6] = new Tile(blackTile, new Pawn(null, bPawn, blackPiece));
				tileArray[1][6].setName("1,6");
				tileArray[1][7] = new Tile(whiteTile, new Pawn(null, bPawn, blackPiece));
				tileArray[1][7].setName("1,7");
			}
			
			
			if(i > 1 && i < 6){
					
				if(flag){
					tileArray[i][0] = new Tile(whiteTile, null);
					tileArray[i][0].setName(Integer.toString(i) + ",0");
					tileArray[i][1] = new Tile(blackTile, null);
					tileArray[i][1].setName(Integer.toString(i) + ",1");
					tileArray[i][2] = new Tile(whiteTile, null);
					tileArray[i][2].setName(Integer.toString(i) + ",2");
					tileArray[i][3] = new Tile(blackTile, null);
					tileArray[i][3].setName(Integer.toString(i) + ",3");
					tileArray[i][4] = new Tile(whiteTile, null);
					tileArray[i][4].setName(Integer.toString(i) + ",4");
					tileArray[i][5] = new Tile(blackTile, null);
					tileArray[i][5].setName(Integer.toString(i) + ",5");
					tileArray[i][6] = new Tile(whiteTile, null);
					tileArray[i][6].setName(Integer.toString(i) + ",6");
					tileArray[i][7] = new Tile(blackTile, null);
					tileArray[i][7].setName(Integer.toString(i) + ",7");
					} else {
						tileArray[i][0] = new Tile(blackTile, null);
						tileArray[i][0].setName(Integer.toString(i) + ",0");
						tileArray[i][1] = new Tile(whiteTile, null);
						tileArray[i][1].setName(Integer.toString(i) + ",1");
						tileArray[i][2] = new Tile(blackTile, null);
						tileArray[i][2].setName(Integer.toString(i) + ",2");
						tileArray[i][3] = new Tile(whiteTile, null);
						tileArray[i][3].setName(Integer.toString(i) + ",3");
						tileArray[i][4] = new Tile(blackTile, null);
						tileArray[i][4].setName(Integer.toString(i) + ",4");
						tileArray[i][5] = new Tile(whiteTile, null);
						tileArray[i][5].setName(Integer.toString(i) + ",5");
						tileArray[i][6] = new Tile(blackTile, null);
						tileArray[i][6].setName(Integer.toString(i) + ",6");
						tileArray[i][7] = new Tile(whiteTile, null);
						tileArray[i][7].setName(Integer.toString(i) + ",7");
							
						}
					}
			
			if(i == 6){
				tileArray[i][0] = new Tile(whiteTile, new Pawn(wPawn, null, whitePiece));
				tileArray[i][0].setName("6,0");
				tileArray[i][1] = new Tile(blackTile, new Pawn(wPawn, null, whitePiece));
				tileArray[i][1].setName("6,1");
				tileArray[i][2] = new Tile(whiteTile, new Pawn(wPawn, null, whitePiece));
				tileArray[i][2].setName("6,2");
				tileArray[i][3] = new Tile(blackTile, new Pawn(wPawn, null, whitePiece));
				tileArray[i][3].setName("6,3");
				tileArray[i][4] = new Tile(whiteTile, new Pawn(wPawn, null, whitePiece));
				tileArray[i][4].setName("6,4");
				tileArray[i][5] = new Tile(blackTile, new Pawn(wPawn, null, whitePiece));
				tileArray[i][5].setName("6,5");
				tileArray[i][6] = new Tile(whiteTile, new Pawn(wPawn, null, whitePiece));
				tileArray[i][6].setName("6,6");
				tileArray[i][7] = new Tile(blackTile, new Pawn(wPawn, null, whitePiece));
				tileArray[i][7].setName("6,7");
			}
				
			if(i == 7){
				tileArray[i][0] = new Tile(blackTile, new Rook(wRook, null, whitePiece));
				tileArray[i][0].setName("7,0");
				tileArray[i][1] = new Tile(whiteTile, new Knight(wKnight, null, whitePiece));
				tileArray[i][1].setName("7,1");
				tileArray[i][2] = new Tile(blackTile, new Bishop(wBishop, null, whitePiece));
				tileArray[i][2].setName("7,2");
				tileArray[i][3] = new Tile(whiteTile, new Queen(wQueen, null, whitePiece));
				tileArray[i][3].setName("7,3");
				tileArray[i][4] = new Tile(blackTile, new King(wKing, null, whitePiece));
				tileArray[i][4].setName("7,4");
				tileArray[i][5] = new Tile(whiteTile, new Bishop(wBishop, null, whitePiece));
				tileArray[i][5].setName("7,5");
				tileArray[i][6] = new Tile(blackTile, new Knight(wKnight, null, whitePiece));
				tileArray[i][6].setName("7,6");
				tileArray[i][7] = new Tile(whiteTile, new Rook(wRook, null, whitePiece));
				tileArray[i][7].setName("7,7");
			}
			flag = !flag;
			}

		for(int r = 0; r < 8; r++){
			for(int g = 0; g < 8; g++){
				panel.add(tileArray[r][g]);
			}
		}
		add(panel);
		this.pack();
	}
	

	
	public void setUp(){
		
	}
	
	public static void main(String[] args){
		new Board();
	}

}
