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

class RookTest {
	//game1.printBoard();
	// Can Move Tests------------------------------------------------
	// move a white rook up 1 space
	// move a black rook down 1 space
	@Test
	public void Test1() {
		GameBoard game1 = new GameBoard();
		Rook moveRook = (Rook) game1.board[7][0];
		assertEquals(false, moveRook.canMove(6,0));
		game1.board[6][0] = new Empty(Color.__,6,0,game1);
		moveRook = (Rook) game1.board[7][0];
		assertEquals(true, moveRook.canMove(6,0));
		game1.playerTurn = false;
		moveRook = (Rook) game1.board[0][7];
		assertEquals(false, moveRook.canMove(1,7));
		game1.board[1][7] = new Empty(Color.__,1,7,game1);
		assertEquals(true, moveRook.canMove(1,7));
	}
	
	// move a white rook up 3 spaces to empty
	// move a black rook down 3 spaces to empty
	@Test
	public void Test2() {
		GameBoard game1 = new GameBoard();
		game1.board[6][0] = new Empty(Color.__, 6, 0, game1);
		Rook moveRook = (Rook) game1.board[7][0];
		assertEquals(true, moveRook.canMove(6, 0));
		game1.board[1][7] = new Empty(Color.__, 1, 7, game1);
		moveRook = (Rook) game1.board[0][7];
		game1.playerTurn = false;
		assertEquals(true, moveRook.canMove(1, 7));
	}
	
	//Move a white rook 4 spaces to take a black bishop
	//Move a black rook 2 spaces to take a white knight
	//can not move white rook past black bishop
	//can not move black root past white knight
	@Test
	public void Test3() {
		GameBoard game1 = new GameBoard();
		game1.board[1][0] = new Empty(Color.__, 1, 0, game1);
		game1.board[6][7] = new Empty(Color.__, 6, 7, game1);
		game1.board[3][7] = new Bishop(Color.Bl, 3, 7, game1);
		game1.board[2][0] = new Knight(Color.Wh, 2, 0, game1);
		Rook moveRook = (Rook) game1.board[7][7];
		assertEquals(true, moveRook.canMove(3,7));
		assertEquals(false, moveRook.canMove(2,7));
		game1.playerTurn = false;
		moveRook = (Rook) game1.board[0][0];
		assertEquals(true, moveRook.canMove(2,0));
		assertEquals(false, moveRook.canMove(3,0));
	}
	
	//White rook takes black pawn 1 to the right
	//White rook moves left 4 spaces
	//Black rook can't moves 2 left because black knight
	//Black rook captures white queen 3 to right
	@Test
	public void Test4() {
		GameBoard game1 = new GameBoard();
		game1.board[4][6] = new Rook(Color.Wh, 4, 6, game1);
		game1.board[2][2] = new Rook(Color.Bl, 2, 2, game1);
		game1.board[4][7] = new Pawn(Color.Bl, 4, 7, game1);
		Rook moveRook = (Rook) game1.board[4][6];
		assertEquals(true, moveRook.canMove(4,7));
		assertEquals(true, moveRook.canMove(4,2));
		moveRook = (Rook) game1.board[2][2];
		game1.playerTurn = false;
		game1.board[2][5] = new Queen(Color.Wh, 2, 5, game1);
		game1.board[2][0] = new Knight(Color.Bl, 2, 0, game1);
		assertEquals(true, moveRook.canMove(2,5));
		assertEquals(false, moveRook.canMove(2,0));
	}
	
	// MovePiece Tests------------------------------------------------
	// move starting pawns and rooks
	@Test
	public void Test5() {
		GameBoard game1 = new GameBoard();
		Pawn whitePawn = (Pawn) game1.board[6][7];
		Pawn blackPawn = (Pawn) game1.board[1][6];
		Rook whiteRook = (Rook) game1.board[7][7];
		Rook blackRook = (Rook) game1.board[0][7];
		assertEquals(true, whitePawn.movePiece(4, 7));
		assertEquals(true, blackPawn.movePiece(3, 6));
		assertEquals(true, whitePawn.movePiece(3, 6));
		Pawn whitePawn2 = (Pawn) game1.board[6][6];
		Pawn blackPawn2 = (Pawn) game1.board[1][7];
		assertEquals(true, blackPawn2.movePiece(3, 7));
		assertEquals(true, whitePawn2.movePiece(4, 6));
		assertEquals(true, blackPawn2.movePiece(4, 6));
		assertEquals(true, whiteRook.movePiece(3, 7));
		assertEquals(true, blackRook.movePiece(3, 7));
		assertEquals(true, game1.board[3][7].getType() == Type.R);
		assertEquals(true, game1.board[3][7].getColor() == Color.Bl);
	}
}
