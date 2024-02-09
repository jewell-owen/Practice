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

class BishopTest {
	// game1.printBoard();
	// Can Move Tests------------------------------------------------
	// move a white bishop all 4 directions
	@Test
	public void Test1() {
		GameBoard game1 = new GameBoard();
		game1.board[3][3] = new Bishop(Color.Wh, 3, 3, game1);
		Bishop moveBishop = (Bishop) game1.board[3][3];
		assertEquals(true, moveBishop.canMove(1, 5));
		assertEquals(true, moveBishop.canMove(1, 1));
		assertEquals(true, moveBishop.canMove(5, 1));
		assertEquals(false, moveBishop.canMove(5, 4));
		assertEquals(false, moveBishop.canMove(6, 6));
		assertEquals(true, moveBishop.canMove(5, 5));
	}
	
	// move a black bishop all 4 directions
	@Test
	public void Test2() {
		GameBoard game1 = new GameBoard();
		game1.board[3][4] = new Bishop(Color.Bl, 3, 4, game1);
		Bishop moveBishop = (Bishop) game1.board[3][4];
		game1.playerTurn = false;
		assertEquals(true, moveBishop.canMove(6, 7));
		assertEquals(true, moveBishop.canMove(6, 1));
		assertEquals(true, moveBishop.canMove(2, 5));
		assertEquals(true, moveBishop.canMove(2, 3));
		assertEquals(false, moveBishop.canMove(1, 6));
		assertEquals(false, moveBishop.canMove(1, 2));
		assertEquals(false, moveBishop.canMove(7, 0));
	}
	
	// MovePiece Tests------------------------------------------------
	// move starting pawns and white bishop
	@Test
	public void Test3() {
		GameBoard game1 = new GameBoard();
		Pawn leftWhitePawn = (Pawn) game1.board[6][4];
		Pawn rightWhitePawn = (Pawn) game1.board[6][6];
		Bishop rightWhiteBishop = (Bishop) game1.board[7][5];
		assertEquals(true, leftWhitePawn.movePiece(5, 4));
		game1.playerTurn = true;
		assertEquals(true, rightWhitePawn.movePiece(5, 6));
		game1.playerTurn = true;
		assertEquals(true, rightWhiteBishop.movePiece(6, 6));
	}

	// move and capture with bishops
	@Test
	public void Test4() {
		GameBoard game1 = new GameBoard();
		Pawn leftWhitePawn = (Pawn) game1.board[6][4];
		Pawn rightWhitePawn = (Pawn) game1.board[6][6];
		Bishop rightWhiteBishop = (Bishop) game1.board[7][5];
		Pawn leftBlackPawn = (Pawn) game1.board[1][1];
		Pawn rightBlackPawn = (Pawn) game1.board[1][3];
		Bishop leftBlackBishop = (Bishop) game1.board[0][2];
		assertEquals(true, leftWhitePawn.movePiece(5, 4));
		assertEquals(true, leftBlackPawn.movePiece(2, 1));
		assertEquals(true, rightWhitePawn.movePiece(5, 6));
		assertEquals(true, rightBlackPawn.movePiece(2, 3));
		assertEquals(true, rightWhiteBishop.movePiece(6,6));
		assertEquals(true, leftBlackBishop.movePiece(1,1));
		assertEquals(true, rightWhiteBishop.movePiece(1,1));
		game1.printBoard();
		
	}
}
