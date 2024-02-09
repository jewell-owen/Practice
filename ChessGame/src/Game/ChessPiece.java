package Game;
/**
 * Represents a generic chess piece
 */
public abstract class ChessPiece {
	//Variables
	protected Type type;
	protected Color color;
	protected int y;
	protected int x;
	protected GameBoard pieceBoard;
	
	//Constructor
	public ChessPiece(Color clr,int starty,int startx,GameBoard board) {
		color = clr;
		y = starty;
		x = startx;
		pieceBoard = board;
	}
	
	//Methods
	/**
	 * 
	 * @return type of chess piece its called on
	 */
	public Type getType() {
		return type;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public GameBoard getBoard() {
		return pieceBoard;
	}
	
	/**
	 * Checks if a piece can move to the new specified location
	 * piece.canMove()
	 * @param newX  The new x location of the piece (0-7)
	 * @param newY  The new y location of the piece (0-7)
	 * @return false if can't move, true if can move
	 */
	abstract boolean canMove(int newY, int newX);
	
	//if not in check do regular stuff below
	//call canMove()
	//replace old spot with new empty
	//replace new spot with new piece (newY,newX)
	//update playerTurn
	//if (pawn) set the pawns first turn to false
	public abstract boolean movePiece(int nextY, int nextX);
	
}