package Game;

public class Queen extends ChessPiece {

	// Constructor
	public Queen(Color clr,int starty,int startx,GameBoard board) {
			super(clr,starty,startx,board);
			type = Type.Q;
			
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
		Queen piece = this;
		ChessPiece[][] pieceBoard = piece.getBoard().board;
		Color pieceColor = piece.getColor();
		// if piece is white
		if (pieceColor == Color.Wh) {
			// if its white's turn
			if (piece.getBoard().playerTurn == false) {
				return false;
			}
			// check that piece at new space is not same color
			if (pieceBoard[newY][newX].getColor() == Color.Wh) {
				return false;
			}
		}
		// if piece is black
		else if (pieceColor == Color.Bl) {
			// if its black's turn
			if (piece.getBoard().playerTurn == true) {
				return false;
			}
			if (pieceBoard[newY][newX].getColor() == Color.Bl) {
				return false;
			}
		}
		// movement checking
		//rook logic
		if (x == newX) {
			// new space is the same space the piece is already on
			if (y == newY) {
				return false;
			}
			int high = 0;
			int low = 0;
			if (y > newY) {
				high = y;
				low = newY;
			} else if (y < newY) {
				high = newY;
				low = y;
			}
			// check nothing in the way
			for (int i = low + 1; i < high; i++) {
				if (pieceBoard[i][x].getType() != Type.E) {
					return false;
				}
			}
			return true;
		} 
		else if (y == newY) {
			int high = 0;
			int low = 0;
			if (x > newX) {
				high = x;
				low = newX;
			} 
			else if (x < newX) {
				high = newX;
				low = x;
			}
			// check nothing in the way
			for (int i = low + 1; i < high; i++) {
				if (pieceBoard[y][i].getType() != Type.E) {
					return false;
				}
			}
			return true;
		}
		// bishop logic
		int highY = 0, highX = 0, lowY = 0, lowX = 0;
		if (newY > y) {
			highY = newY;
			lowY = y;
			if (newX > x) {
				highX = newX;
				lowX = x;
				// check nothing in the way
				int j = lowX + 1;
				for (int i = lowY + 1; i < highY; i++) {
					if (j >= highX) {
						return false;
					}
					if (pieceBoard[i][j].getType() != Type.E) {
						return false;
					}
					j++;
				}
			} 
			else if (newX < x) {
				highX = x;
				lowX = newX;
				// check nothing in the way
				int j = highX - 1;
				for (int i = lowY + 1; i < highY; i++) {
					if (j < lowX) {
						return false;
					}
					if (pieceBoard[i][j].getType() != Type.E) {
						return false;
					}
					j--;
				}
			}
		} 
		else if (newY < y) {
			highY = y;
			lowY = newY;
			if (newX > x) {
				highX = newX;
				lowX = x;
				int j = lowX + 1;
				for (int i = highY - 1; i > lowY; i--) {
					if (j >= highX) {
						return false;
					}
					if (pieceBoard[i][j].getType() != Type.E) {
						return false;
					}
					j++;
				}
			} 
			else if (newX < x) {
				highX = x;
				lowX = newX;
				// check nothing in the way
				int j = lowX + 1;
				for (int i = lowY + 1; i < highY; i++) {
					if (j >= highX) {
						return false;
					}
					if (pieceBoard[i][j].getType() != Type.E) {
						return false;
					}
					j++;
				}
			}
		}
		return true;
	}
	
	@Override
	public boolean movePiece(int nextY, int nextX) {
		Queen piece = this;
		int oldX = piece.x;
		int oldY = piece.y;
		ChessPiece[][] pieceBoard = piece.getBoard().board;
		GameBoard gameBoard = piece.getBoard();
		Color pieceColor = piece.getColor();
		if ((gameBoard.whiteInCheck == false) && (gameBoard.blackInCheck == false)) {
			if (piece.canMove(nextY, nextX) == true) {
				piece.getBoard().board[oldY][oldX] = new Empty(Color.__, oldY, oldX, gameBoard);
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
				piece.getBoard().switchPlayerTurn();
				return true;
			}
		}
		if (gameBoard.whiteInCheck == true) {
			// iterate through whole board
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
					piece.getBoard().board[nextY][nextX] = this;
					this.x = nextX;
					this.y = nextY;
					piece.getBoard().switchPlayerTurn();
					return true;
				}
			}
			if (pieceColor == Color.Bl) {
				if (piece.canMove(nextY, nextX) == true) {
					piece.getBoard().board[oldY][oldX] = new Empty(Color.__, oldY, oldX, gameBoard);
					piece.getBoard().board[nextY][nextX] = this;
					this.x = nextX;
					this.y = nextY;
					piece.getBoard().switchPlayerTurn();
					return true;
				}
			}
		}
		if (gameBoard.blackInCheck == true) {
			if (pieceColor == Color.Bl) {
				if (piece.canMove(nextY, nextX) == true) {
					piece.getBoard().board[nextY][nextX] = new Rook(pieceColor, nextY, nextX, gameBoard);
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
					piece.getBoard().board[nextY][nextX] = this;
					this.x = nextX;
					this.y = nextY;
					piece.getBoard().switchPlayerTurn();
					return true;
				}
			}
			if (pieceColor == Color.Wh) {
				if (piece.canMove(nextY, nextX) == true) {
					piece.getBoard().board[oldY][oldX] = new Empty(Color.__, oldY, oldX, gameBoard);
					piece.getBoard().board[nextY][nextX] = this;
					this.x = nextX;
					this.y = nextY;
					piece.getBoard().switchPlayerTurn();
					return true;
				}
			}
		}
		return false;
	}
}