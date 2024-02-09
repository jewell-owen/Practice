package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Game.Color;
import Game.GameBoard;
import Game.Pawn;
import Game.Type;
import Game.Empty;

class PawnTest {
	//game1.printBoard();
	// Can Move Tests------------------------------------------------
	// move a white pawn up 1 space
	// move a black pawn down 1 space
	@Test
	public void Test1() {
		GameBoard game1 = new GameBoard();
		Pawn movePawn = (Pawn) game1.board[6][4];
		assertEquals(true, movePawn.canMove(5, 4));
		movePawn = (Pawn) game1.board[1][3];
		game1.playerTurn = false;
		assertEquals(true, movePawn.canMove(2, 3));
	}
	
	// move a white pawn up 2 spaces
	// move a black pawn down 2 spaces
	@Test
	public void Test2() {
		GameBoard game1 = new GameBoard();
		Pawn movePawn = (Pawn) game1.board[6][4];
		assertEquals(true, movePawn.canMove(4, 4));
		movePawn = (Pawn) game1.board[1][3];
		game1.playerTurn = false;
		assertEquals(true, movePawn.canMove(3, 3));

	}

	// white pawn can't move on black turn
	// black pawn can't move on white turn
	@Test
	public void Test3() {
		GameBoard game1 = new GameBoard();
		Pawn movePawn = (Pawn) game1.board[1][3];
		assertEquals(false, movePawn.canMove(2, 3));
		movePawn = (Pawn) game1.board[6][2];
		game1.playerTurn = false;
		assertEquals(false, movePawn.canMove(5, 2));

	}
	
	// white pawn takes left and right
	@Test
	public void Test4() {
		GameBoard game1 = new GameBoard();
		game1.board[5][3] = new Pawn(Color.Bl,5,3,game1);
		game1.board[5][5] = new Pawn(Color.Bl,5,5,game1);
		Pawn movePawn = (Pawn) game1.board[6][4];
		assertEquals(true, movePawn.canMove(5, 3));
		assertEquals(true, movePawn.canMove(5, 5));
	}

	// black pawn takes left and right
	@Test
	public void Test5() {
		GameBoard game1 = new GameBoard();
		game1.board[2][4] = new Pawn(Color.Wh,2,4,game1);
		game1.board[2][2] = new Pawn(Color.Wh,2,2,game1);
		Pawn movePawn = (Pawn) game1.board[1][3];
		game1.playerTurn = false;
		assertEquals(true, movePawn.canMove(2, 4));
		assertEquals(true, movePawn.canMove(2, 2));
	}
	
	
	// MovePiece Tests------------------------------------------------
	//move a white pawn up one space
	//move a white pawn up two spaces
	//try to move both white pawns forward two spaces after
	@Test
	public void Test6() {
		GameBoard game1 = new GameBoard();
		Pawn movePawn1 = (Pawn) game1.board[6][5];
		Pawn movePawn2 = (Pawn) game1.board[6][4];
		assertEquals(true, movePawn1.movePiece(4, 5));
		game1.playerTurn = true;
		assertEquals(true, movePawn2.movePiece(5, 4));
		assertEquals(true, game1.board[4][5].getType() == Type.P);
		assertEquals(true, game1.board[5][4].getType() == Type.P);
		assertEquals(false, movePawn1.movePiece(2, 5));
		assertEquals(false, movePawn2.movePiece(3, 4));
	}
}
