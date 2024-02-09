package Game;

/**
 * Represents an empty space on the chess board
 */
public class Empty extends ChessPiece {

	// Constructor
	public Empty(Color clr,int starty,int startx,GameBoard board) {
		super(clr,starty,startx,board);
		type = Type.E;

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
		return false;
	}
	
	@Override
	public boolean movePiece(int nextY, int nextX) {
		return false;
	}
}
