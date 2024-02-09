package Game;

public class Pawn extends ChessPiece {

	protected boolean firstMove = true;
	
	// Constructor
	public Pawn(Color clr,int starty,int startx,GameBoard board) {
			super(clr,starty,startx,board);
			type = Type.P;
			
		}

	// Methods
	/**
	 * Checks if a piece can move to the new specified location
	 * @param piece The piece that wants to move
	 * @param newX  The new x location of the piece (0-7)
	 * @param newY  The new y location of the piece (0-7)
	 * @return false if can't move, true if can move
	 */
	@Override
	public boolean canMove(int newY, int newX) {
		//Must implement whiteInCheck and blackInCheck global variables in GameBoard
		//Then implement possible helper methods and if statements for inCheck() in can move method
		//possibly implement helper methods to simplify code
		Pawn piece = this;
		ChessPiece[][] pieceBoard = piece.getBoard().board;
		Color pieceColor = piece.getColor();
		//@To-do still need to check if the movement will place own king in check 
		//ex. moving a pawn out of the way means the enemy queen threatens the king
		//this means you can't move the pawn
		//@To-do can't make a regular move if own king in check
		//must make a move to ensure that king is protected
		//if piece moving is white
		if (pieceColor == Color.Wh) {
			//if its white's turn
			if (piece.getBoard().playerTurn == true) {
				//if new space empty
				if (pieceBoard[newY][newX].getType() == Type.E) {
					//if its first move for pawn
					if (firstMove == true) {
						if (((y-newY) == 2) || ((y-newY) == 1) && (newX == x)) {
							return true;
						}
					}
					else {
						if (((y-newY) == 1) && (newX == x)) {
							return true;
						}
					}
				}
				//new space is occupied so much check if canTake()
				else {
					//need to check if can take the piece
					//if piece to capture is opposite color
					if (pieceBoard[newY][newX].getColor() == Color.Bl) {
						//check if pawn canTake()
						if (((y - newY) == 1) && (((newX-x) == 1) || (newX-x == -1))){
							return true;
						}	
					}
				}
			}
		}
		else if (pieceColor == Color.Bl) {
			//if its black's turn
			if (piece.getBoard().playerTurn == false) {
				//if new space empty
				if (pieceBoard[newY][newX].getType() == Type.E) {
					//if its first move for pawn
					if (firstMove == true) {
						if (((newY - y) == 2) || ((newY - y) == 1) && (newX == x)) {
							return true;
						}
					}
					else {
						if (((newY - y) == 1) && (newX == x)) {
							return true;
						}
					}
				}
				else {
					//need to check if can take the piece
					//if piece to capture is opposite color
					if (pieceBoard[newY][newX].getColor() == Color.Wh) {
						//check if pawn canTake()
						if (((newY - y) == 1) && (((newX-x) == 1) || (newX-x == -1))){
							return true;
						}	
					}
				}
			}
		}
		return false;
	}
	
	//every time a piece is moved iterate through whole board
	//check if black pieces can move to white king spot
	//check if white pieces can move to black king spot
	//for pawns must check if they have reached far side and ask for user input
	//to determine if pawn should become queen, bishop, rook, or knight
	/**
	 * Return false if move not executed
	 * Return true if move executed
	 */
	@Override
	public boolean movePiece(int nextY, int nextX) {
		Pawn piece = this;
		int oldX = piece.x;
		int oldY = piece.y;
		ChessPiece[][] pieceBoard = piece.getBoard().board;
		GameBoard gameBoard = piece.getBoard();
		Color pieceColor = piece.getColor();
		if ((gameBoard.whiteInCheck == false) && (gameBoard.blackInCheck == false)) {
			if (piece.canMove(nextY,nextX) == true) {
				piece.getBoard().board[oldY][oldX] = new Empty(Color.__,oldY,oldX,gameBoard);
				piece.getBoard().board[nextY][nextX] = this;
				this.x = nextX;
				this.y = nextY;
				if (pieceColor == Color.Wh) {
					if (pieceBoard[nextY][nextX].canMove(gameBoard.getBlackKingY(), gameBoard.getBlackKingX())) {
						gameBoard.blackInCheck = true;
					}
				}
				if (pieceColor == Color.Bl) {
					if (pieceBoard[nextY][nextX].canMove(gameBoard.getWhiteKingY(), gameBoard.getWhiteKingX())) {
						gameBoard.whiteInCheck = true;
					}
				}
				if (piece.firstMove == false) {
					piece.firstMove = true;
				}
				piece.getBoard().switchPlayerTurn();
				return true;
			}
		}
		if (gameBoard.whiteInCheck == true) {
			//iterate through whole board
			// set aside any pieces that piece.canMove() to whites king
			// only allow move that after the move no piece.canMove() to whites king
			if (pieceColor == Color.Wh) {
				if (piece.canMove(nextY, nextX) == true) {
					piece.getBoard().board[nextY][nextX] = new Pawn(pieceColor, nextY, nextX, gameBoard);
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							int whiteKY = piece.getBoard().getWhiteKingY();
							int whiteKX = piece.getBoard().getWhiteKingX();
							if (piece.getBoard().board[i][j].canMove(whiteKY, whiteKX) == true) {
								piece.getBoard().board[nextY][nextX] = new Empty(Color.__, nextY, nextX, gameBoard);
								return false;
							}
						}
					}
					piece.getBoard().board[oldY][oldX] = new Empty(Color.__, oldY, oldX, gameBoard);
					if (piece.firstMove == false) {
						piece.firstMove = true;
					}
					piece.getBoard().switchPlayerTurn();
					piece.getBoard().board[nextY][nextX] = this;
					this.x = nextX;
					this.y = nextY;
					return true;
				}
			}
			if (pieceColor == Color.Bl) {
				if (piece.canMove(nextY,nextX) == true) {
					piece.getBoard().board[oldY][oldX] = new Empty(Color.__,oldY,oldX,gameBoard);
					piece.getBoard().board[nextY][nextX] = new Pawn(pieceColor,nextY,nextX,gameBoard);
					if (piece.firstMove == false) {
						piece.firstMove = true;
					}
					piece.getBoard().switchPlayerTurn();
					piece.getBoard().board[nextY][nextX] = this;
					this.x = nextX;
					this.y = nextY;
					return true;
				}
			}
		}
		if (gameBoard.blackInCheck == true) {
			if (pieceColor == Color.Bl) {
				if (piece.canMove(nextY, nextX) == true) {
					piece.getBoard().board[nextY][nextX] = new Pawn(pieceColor, nextY, nextX, gameBoard);
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							int blackKY = piece.getBoard().getBlackKingY();
							int blackKX = piece.getBoard().getBlackKingX();
							if (piece.getBoard().board[i][j].canMove(blackKY, blackKX) == true) {
								piece.getBoard().board[nextY][nextX] = new Empty(Color.__, nextY, nextX, gameBoard);
								return false;
							}
						}
					}
					piece.getBoard().board[oldY][oldX] = new Empty(Color.__, oldY, oldX, gameBoard);
					if (piece.firstMove == false) {
						piece.firstMove = true;
					}
					piece.getBoard().switchPlayerTurn();
					piece.getBoard().board[nextY][nextX] = this;
					this.x = nextX;
					this.y = nextY;
					return true;
				}
			}
			if (pieceColor == Color.Bl) {
				if (piece.canMove(nextY,nextX) == true) {
					piece.getBoard().board[oldY][oldX] = new Empty(Color.__,oldY,oldX,gameBoard);
					piece.getBoard().board[nextY][nextX] = new Pawn(pieceColor,nextY,nextX,gameBoard);
					if (piece.firstMove == false) {
						piece.firstMove = true;
					}
					piece.getBoard().switchPlayerTurn();
					piece.getBoard().board[nextY][nextX] = this;
					this.x = nextX;
					this.y = nextY;
					return true;
				}
			}
		}
		return false;
	}
}