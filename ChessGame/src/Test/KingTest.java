package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Game.Bishop;
import Game.Color;
import Game.Empty;
import Game.GameBoard;
import Game.King;
import Game.Knight;
import Game.Pawn;
import Game.Queen;
import Game.Rook;

class KingTest {
	// game1.printBoard();
	// Can Move Tests------------------------------------------------
	// move a white king all 8 directions
	// check can't move where already is
	@Test
	public void Test1() {
		GameBoard game1 = new GameBoard();
		game1.board[2][6] = new King(Color.Wh, 2, 6, game1);
		King moveKing = (King) game1.board[2][6];
		assertEquals(true, moveKing.canMove(1, 6));
		assertEquals(true, moveKing.canMove(1, 7));
		assertEquals(true, moveKing.canMove(2, 7));
		assertEquals(true, moveKing.canMove(3, 7));
		assertEquals(true, moveKing.canMove(3, 6));
		assertEquals(true, moveKing.canMove(3, 5));
		assertEquals(true, moveKing.canMove(2, 5));
		assertEquals(true, moveKing.canMove(1, 5));
		assertEquals(false, moveKing.canMove(2, 6));
	}
	
	// move a black king all 8 directions
	// check can't move where already is
	@Test
	public void Test2() {
		GameBoard game1 = new GameBoard();
		game1.board[5][6] = new King(Color.Bl, 5, 6, game1);
		King moveKing = (King) game1.board[5][6];
		game1.playerTurn = false;
		assertEquals(true, moveKing.canMove(6, 6));
		assertEquals(true, moveKing.canMove(6, 7));
		assertEquals(true, moveKing.canMove(5, 7));
		assertEquals(true, moveKing.canMove(4, 7));
		assertEquals(true, moveKing.canMove(4, 6));
		assertEquals(true, moveKing.canMove(4, 5));
		assertEquals(true, moveKing.canMove(5, 5));
		assertEquals(true, moveKing.canMove(6, 5));
		assertEquals(false, moveKing.canMove(5, 6));
	}

}
