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
import Game.Type;

class QueenTest {
	// game1.printBoard();
	//BISHOP TESTS--------------------------------------
	// Can Move Tests------------------------------------------------
	// move a white queen all 4 directions
	@Test
	public void Test1() {
		GameBoard game1 = new GameBoard();
		game1.board[3][3] = new Queen(Color.Wh, 3, 3, game1);
		Queen moveQueen = (Queen) game1.board[3][3];
		assertEquals(true, moveQueen.canMove(1, 5));
		assertEquals(true, moveQueen.canMove(1, 1));
		assertEquals(true, moveQueen.canMove(5, 1));
		assertEquals(true, moveQueen.canMove(5, 5));
		assertEquals(false, moveQueen.canMove(5, 4));
		assertEquals(false, moveQueen.canMove(6, 6));
	}

	// move a black bishop all 4 directions
	@Test
	public void Test2() {
		GameBoard game1 = new GameBoard();
		game1.board[3][4] = new Queen(Color.Bl, 3, 4, game1);
		Queen moveQueen = (Queen) game1.board[3][4];
		game1.playerTurn = false;
		assertEquals(true, moveQueen.canMove(6, 7));
		assertEquals(true, moveQueen.canMove(6, 1));
		assertEquals(true, moveQueen.canMove(2, 5));
		assertEquals(true, moveQueen.canMove(2, 3));
		assertEquals(false, moveQueen.canMove(1, 6));
		assertEquals(false, moveQueen.canMove(1, 2));
		assertEquals(false, moveQueen.canMove(7, 0));
	}

	// Move a white queen 4 spaces to take a black bishop
	// Move a black queen 2 spaces to take a white knight
	// can not move white queen past black bishop
	// can not move black queen past white knight
	@Test
	public void Test3() {
		GameBoard game1 = new GameBoard();
		game1.board[1][0] = new Empty(Color.__, 1, 0, game1);
		game1.board[6][7] = new Empty(Color.__, 6, 7, game1);
		game1.board[3][7] = new Bishop(Color.Bl, 3, 7, game1);
		game1.board[2][0] = new Knight(Color.Wh, 2, 0, game1);
		game1.board[7][7] = new Queen(Color.Wh, 7, 7, game1);
		game1.board[0][0] = new Queen(Color.Bl, 0, 0, game1);
		Queen moveQueen = (Queen) game1.board[7][7];
		assertEquals(true, moveQueen.canMove(3, 7));
		assertEquals(false, moveQueen.canMove(2, 7));
		game1.playerTurn = false;
		moveQueen = (Queen) game1.board[0][0];
		assertEquals(true, moveQueen.canMove(2, 0));
		assertEquals(false, moveQueen.canMove(3, 0));
	}

	// White queen takes black pawn 1 to the right
	// White queen moves left 4 spaces
	// Black queen can't moves 2 left because black knight
	// Black queen captures white queen 3 to right
	@Test
	public void Test4() {
		GameBoard game1 = new GameBoard();
		game1.board[4][6] = new Queen(Color.Wh, 4, 6, game1);
		game1.board[2][2] = new Queen(Color.Bl, 2, 2, game1);
		game1.board[4][7] = new Pawn(Color.Bl, 4, 7, game1);
		Queen moveQueen = (Queen) game1.board[4][6];
		assertEquals(true, moveQueen.canMove(4, 7));
		assertEquals(true, moveQueen.canMove(4, 2));
		moveQueen = (Queen) game1.board[2][2];
		game1.playerTurn = false;
		game1.board[2][5] = new Queen(Color.Wh, 2, 5, game1);
		game1.board[2][0] = new Knight(Color.Bl, 2, 0, game1);
		assertEquals(true, moveQueen.canMove(2, 5));
		assertEquals(false, moveQueen.canMove(2, 0));
	}
	
	// MovePiece Tests------------------------------------------------
	// move starting pawns and rooks
	@Test
	public void Test5() {
		GameBoard game1 = new GameBoard();
		Pawn whitePawn = (Pawn) game1.board[6][4];
		Pawn blackPawn = (Pawn) game1.board[1][4];
		Queen whiteQueen = (Queen) game1.board[7][4];
		Queen blackQueen = (Queen) game1.board[0][4];
		assertEquals(true, whitePawn.movePiece(5, 4));
		assertEquals(true, blackPawn.movePiece(3, 4));
		assertEquals(true, whiteQueen.movePiece(6, 4));
		assertEquals(true, blackQueen.movePiece(2, 4));
		assertEquals(true, whiteQueen.movePiece(5, 5));
		assertEquals(true, blackQueen.movePiece(3, 5));
		assertEquals(true, whiteQueen.movePiece(3, 5));
		
	}
}
