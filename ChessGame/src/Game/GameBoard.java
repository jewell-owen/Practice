package Game;
/**
 * Class used to represent the game board for chess
 * 
 */
public class GameBoard {
	//possibly ask for user input to flip board so black
	//player can see or make java UI

	//row, column --> y,x
	public ChessPiece[][] board = new ChessPiece[8][8];
	
	//true for white, false for black
	public boolean playerTurn = true;
	
	public boolean whiteInCheck = false;
	public boolean blackInCheck = false;
	public boolean whiteInCheckMate = false;
	public boolean blackInCheckMate = false;

	
	//Constructor
	public GameBoard() {
		for (int i = 1; i < board.length-1; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new Empty(Color.__,i,j,this);
			}
		}
		//White assignments
		board[7][0] = new Rook(Color.Wh,7,0,this);
		board[7][1] = new Knight(Color.Wh,7,1,this);
		board[7][2] = new Bishop(Color.Wh,7,2,this);
		board[7][3] = new King(Color.Wh,7,3,this);
		board[7][4] = new Queen(Color.Wh,7,4,this);
		board[7][5] = new Bishop(Color.Wh,7,5,this);
		board[7][6] = new Knight(Color.Wh,7,6,this);
		board[7][7] = new Rook(Color.Wh,7,7,this);
		board[6][0] = new Pawn(Color.Wh,6,0,this);
		board[6][1] = new Pawn(Color.Wh,6,1,this);
		board[6][2] = new Pawn(Color.Wh,6,2,this);
		board[6][3] = new Pawn(Color.Wh,6,3,this);
		board[6][4] = new Pawn(Color.Wh,6,4,this);
		board[6][5] = new Pawn(Color.Wh,6,5,this);
		board[6][6] = new Pawn(Color.Wh,6,6,this);
		board[6][7] = new Pawn(Color.Wh,6,7,this);
		//Black assignments
		board[0][0] = new Rook(Color.Bl,0,0,this);
		board[0][1] = new Knight(Color.Bl,0,1,this);
		board[0][2] = new Bishop(Color.Bl,0,2,this);
		board[0][3] = new King(Color.Bl,0,3,this);
		board[0][4] = new Queen(Color.Bl,0,4,this);
		board[0][5] = new Bishop(Color.Bl,0,5,this);
		board[0][6] = new Knight(Color.Bl,0,6,this);
		board[0][7] = new Rook(Color.Bl,0,7,this);
		board[1][0] = new Pawn(Color.Bl,1,0,this);
		board[1][1] = new Pawn(Color.Bl,1,1,this);
		board[1][2] = new Pawn(Color.Bl,1,2,this);
		board[1][3] = new Pawn(Color.Bl,1,3,this);
		board[1][4] = new Pawn(Color.Bl,1,4,this);
		board[1][5] = new Pawn(Color.Bl,1,5,this);
		board[1][6] = new Pawn(Color.Bl,1,6,this);
		board[1][7] = new Pawn(Color.Bl,1,7,this);
	}
	//Methods
	/**
	 * Prints the current state of the board
	 */
	public void printBoard(){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j].color + "_" + board[i][j].getType() + " ");
			}
			System.out.println("");
		}
	}
	
	public int getWhiteKingY() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((board[i][j].getType() == Type.K) && (board[i][j].getColor() == Color.Wh)) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public int getWhiteKingX() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((board[i][j].getType() == Type.K) && (board[i][j].getColor() == Color.Wh)) {
					return j;
				}
			}
		}
		return -1;		
	}
	
	public int getBlackKingY() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((board[i][j].getType() == Type.K) && (board[i][j].getColor() == Color.Bl)) {
					return i;
				}
			}
		}
		return -1;		
	}
	
	public int getBlackKingX() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((board[i][j].getType() == Type.K) && (board[i][j].getColor() == Color.Bl)) {
					return j;
				}
			}
		}
		return -1;
	}
	
	public void switchPlayerTurn() {
		if (playerTurn == true) {
			playerTurn = false;
		}
		else {
			playerTurn = true;
		}
	}
}
