import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Board extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 2000, HEIGHT = 2000;
	private Color blackPiece = Color.black, whitePiece = Color.white, whiteTile = Color.white,
			blackTile = Color.darkGray;
	private ImageIcon bPawn, bKnight, bRook, bBishop, bQueen, bKing,
				  		wPawn, wKnight, wRook, wBishop, wQueen, wKing;
	private JPanel panel;
	private Tile tileArray[][];
	
	static boolean firstClick = true;
	
	public Board(){
		super("Chess");
		this.setVisible(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		wPawn = new ImageIcon("../Images/small_w_pawn.png");
		wKnight = new ImageIcon("../Images/white_knight_small.png");
		wBishop = new ImageIcon("../Images/white_bishop_small.png");
		wRook = new ImageIcon("../Images/white_rook_small.png");
		wKing = new ImageIcon("../Images/white_king_small.jpg");
		wQueen = new ImageIcon("../Images/white_queen_small.png");
		
		bPawn = new ImageIcon("../Images/black_pawn_small.png");
		bKnight = new ImageIcon("../Images/black_knight_small.png");
		bBishop = new ImageIcon("../Images/black_bishop_small.png");
		bRook = new ImageIcon("../Images/black_rook_small.png");
		bQueen = new ImageIcon("../Images/black_queen_small.png");
		bKing = new ImageIcon("../Images/black_king_small.png");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(8,8));
		panel.setVisible(true);

		tileArray = new Tile[8][8];

		
		//////////////////////////CODE BELOW ADDS TILES TO A 2D ARRAY THEN ADD TO BOARD\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		boolean flag = true;
		for(int i = 0; i < 8; i++){
			if(i == 0){
				tileArray[0][0] = new Tile(whiteTile, new Rook(null, bRook, blackPiece, tileArray), false, false, tileArray);
				tileArray[0][1] = new Tile(blackTile, new Knight(null, bKnight, blackPiece, tileArray), false, false, tileArray);
				tileArray[0][2] = new Tile(whiteTile, new Bishop(null, bBishop, blackPiece, tileArray), false, false, tileArray);
				tileArray[0][3] = new Tile(blackTile, new Queen(null, bQueen, blackPiece, tileArray), false, false, tileArray);
				tileArray[0][4] = new Tile(whiteTile, new King(null, bKing, blackPiece, tileArray), false, false, tileArray);
				tileArray[0][5] = new Tile(blackTile, new Bishop(null, bBishop, blackPiece, tileArray), false, false, tileArray);
				tileArray[0][6] = new Tile(whiteTile, new Knight(null, bKnight, blackPiece, tileArray), false, false, tileArray);
				tileArray[0][7] = new Tile(blackTile, new Rook(null, bRook, blackPiece, tileArray), false, false, tileArray);
			}
			
			if(i == 1){
				tileArray[1][0] = new Tile(blackTile, new Pawn(null, bPawn, blackPiece, tileArray), false, false, tileArray);
				tileArray[1][1] = new Tile(whiteTile, new Pawn(null, bPawn, blackPiece, tileArray), false, false, tileArray);
				tileArray[1][2] = new Tile(blackTile, new Pawn(null, bPawn, blackPiece, tileArray), false, false, tileArray);
				tileArray[1][3] = new Tile(whiteTile, new Pawn(null, bPawn, blackPiece, tileArray), false, false, tileArray);
				tileArray[1][4] = new Tile(blackTile, new Pawn(null, bPawn, blackPiece, tileArray), false, false, tileArray);
				tileArray[1][5] = new Tile(whiteTile, new Pawn(null, bPawn, blackPiece, tileArray), false, false, tileArray);
				tileArray[1][6] = new Tile(blackTile, new Pawn(null, bPawn, blackPiece, tileArray), false, false, tileArray);
				tileArray[1][7] = new Tile(whiteTile, new Pawn(null, bPawn, blackPiece, tileArray), false, false, tileArray);
			}
			
			if(i > 1 && i < 6){
				if(flag){
					tileArray[i][0] = new Tile(whiteTile, null, false, false, tileArray);
					tileArray[i][1] = new Tile(blackTile, null, false, false, tileArray);
					tileArray[i][2] = new Tile(whiteTile, null, false, false, tileArray);
					tileArray[i][3] = new Tile(blackTile, null, false, false, tileArray);
					tileArray[i][4] = new Tile(whiteTile, null, false, false, tileArray);
					tileArray[i][5] = new Tile(blackTile, null, false, false, tileArray);
					tileArray[i][6] = new Tile(whiteTile, null, false, false, tileArray);
					tileArray[i][7] = new Tile(blackTile, null, false, false, tileArray);
					} else {
						tileArray[i][0] = new Tile(blackTile, null, false, false, tileArray);
						tileArray[i][1] = new Tile(whiteTile, null, false, false, tileArray);
						tileArray[i][2] = new Tile(blackTile, null, false, false, tileArray);
						tileArray[i][3] = new Tile(whiteTile, null, false, false, tileArray);
						tileArray[i][4] = new Tile(blackTile, null, false, false, tileArray);
						tileArray[i][5] = new Tile(whiteTile, null, false, false, tileArray);
						tileArray[i][6] = new Tile(blackTile, null, false, false, tileArray);
						tileArray[i][7] = new Tile(whiteTile, null, false, false, tileArray);
						}
					}
			
			if(i == 6){
				tileArray[i][0] = new Tile(whiteTile, new Pawn(wPawn, null, whitePiece, tileArray), false, false, tileArray);
				tileArray[i][1] = new Tile(blackTile, new Pawn(wPawn, null, whitePiece, tileArray), false, false, tileArray);
				tileArray[i][2] = new Tile(whiteTile, new Pawn(wPawn, null, whitePiece, tileArray), false, false, tileArray);
				tileArray[i][3] = new Tile(blackTile, new Pawn(wPawn, null, whitePiece, tileArray), false, false, tileArray);
				tileArray[i][4] = new Tile(whiteTile, new Pawn(wPawn, null, whitePiece, tileArray), true, false, tileArray);
				tileArray[i][5] = new Tile(blackTile, new Pawn(wPawn, null, whitePiece, tileArray), false, false, tileArray);
				tileArray[i][6] = new Tile(whiteTile, new Pawn(wPawn, null, whitePiece, tileArray), false, false, tileArray);
				tileArray[i][7] = new Tile(blackTile, new Pawn(wPawn, null, whitePiece, tileArray), false, false, tileArray);
			}
				
			if(i == 7){
				tileArray[i][0] = new Tile(blackTile, new Rook(wRook, null, whitePiece, tileArray), false, false, tileArray);
				tileArray[i][1] = new Tile(whiteTile, new Knight(wKnight, null, whitePiece, tileArray), false, false, tileArray);
				tileArray[i][2] = new Tile(blackTile, new Bishop(wBishop, null, whitePiece, tileArray), false, false, tileArray);
				tileArray[i][3] = new Tile(whiteTile, new Queen(wQueen, null, whitePiece, tileArray), false, false, tileArray);
				tileArray[i][4] = new Tile(blackTile, new King(wKing, null, whitePiece, tileArray), false, false, tileArray);
				tileArray[i][5] = new Tile(whiteTile, new Bishop(wBishop, null, whitePiece, tileArray), false, false, tileArray);
				tileArray[i][6] = new Tile(blackTile, new Knight(wKnight, null, whitePiece, tileArray), false, false, tileArray);
				tileArray[i][7] = new Tile(whiteTile, new Rook(wRook, null, whitePiece, tileArray), false, false, tileArray);
			}
			flag = !flag;
			}

		for(int r = 0; r < 8; r++){
			for(int g = 0; g < 8; g++){
				panel.add(tileArray[r][g]);
			}
		}
		add(panel);
		pack();
	}
	
	
	public static void main(String[] args){
		new Board();
	}

}
