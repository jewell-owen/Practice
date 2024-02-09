package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Game.Bishop;
import Game.Color;
import Game.Empty;
import Game.GameBoard;
import Game.Knight;
import Game.Pawn;
import Game.Queen;
import Game.Rook;

class KnightTest {
	//game1.printBoard();
	// Can Move Tests------------------------------------------------
	// move a white knight up 2 spaces, left and right 1
	// move a black rook down 2 spaces, left and right 1
	@Test
	public void Test1() {
		GameBoard game1 = new GameBoard();
		Knight moveKnight = (Knight) game1.board[7][1];
		assertEquals(true, moveKnight.canMove(5, 0));
		assertEquals(true, moveKnight.canMove(5, 2));
		moveKnight = (Knight) game1.board[0][6];
		game1.playerTurn = false;
		assertEquals(true, moveKnight.canMove(2, 5));
		assertEquals(true, moveKnight.canMove(2, 7));
	}
	
	// white knight captures either black pawn
	// white knight moves backwards, 2 different ways
	// black knight captures white pawn and both white knights
	@Test
	public void Test2() {
		GameBoard game1 = new GameBoard();
		game1.board[3][6] = new Knight(Color.Wh, 3, 6, game1);
		Knight moveKnight = (Knight) game1.board[3][6];
		assertEquals(true, moveKnight.canMove(1, 5));
		assertEquals(true, moveKnight.canMove(1, 7));
		assertEquals(true, moveKnight.canMove(4, 4));
		assertEquals(true, moveKnight.canMove(5, 5));
		game1.board[5][5] = new Knight(Color.Bl, 5, 5, game1);
		moveKnight = (Knight) game1.board[5][5];
		game1.playerTurn = false;
		assertEquals(true, moveKnight.canMove(6, 7));
		assertEquals(true, moveKnight.canMove(7, 6));
		assertEquals(true, moveKnight.canMove(3, 6));
		}
	
		// MovePiece Tests------------------------------------------------
		// move starting pawns and white bishop
		@Test
		public void Test3() {
			GameBoard game1 = new GameBoard();
			Knight leftWhiteKnight = (Knight) game1.board[7][1];
			Knight rightWhiteKnight = (Knight) game1.board[7][6];
			Knight leftBlackKnight = (Knight) game1.board[0][1];
			Knight rightBlackKnight = (Knight) game1.board[0][6];
			assertEquals(true, leftWhiteKnight.movePiece(5, 2));
			assertEquals(true, leftBlackKnight.movePiece(2, 2));
			assertEquals(true, rightWhiteKnight.movePiece(5, 5));
			assertEquals(true, rightBlackKnight.movePiece(2, 5));
			assertEquals(true, rightWhiteKnight.movePiece(3, 4));
			assertEquals(true, leftBlackKnight.movePiece(4, 3));
			assertEquals(true, rightWhiteKnight.movePiece(1, 5));
			assertEquals(true, leftBlackKnight.movePiece(6, 2));
		}

}
