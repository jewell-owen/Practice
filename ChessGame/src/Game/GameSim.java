package Game;

import java.util.Scanner;

/**
 * Class used to simulate a game of chess
 * Board is [y][x]
 */
public class GameSim {

	public static void main(String args[]) {
		GameBoard game = new GameBoard();
		//game.printBoard();
		Scanner scnr = new Scanner(System.in);  // Create a Scanner object
		game.printBoard();
		System.out.println("");
	    System.out.println("Format: oldXoldY hit enter, newX,newY hit enter, and the top left corner is 0,0: ");
	    String oldInput;
	    String newInput;
		while (!game.whiteInCheckMate && !game.blackInCheckMate) {
			//white's turn
			if (game.playerTurn) {
				System.out.println("White player: Enter move");
				oldInput = scnr.nextLine();  // Read user input
				newInput = scnr.nextLine();  // Read user input
				int oldInputInt = 0;
				int newInputInt = 0;
				try {
		            oldInputInt = Integer.valueOf(oldInput);
		        } 
				catch (NumberFormatException e) {
		            System.out.println("Invalid input");
		            continue;
		        }
				try {
		            newInputInt = Integer.valueOf(newInput);
		        } 
				catch (NumberFormatException e) {
		            System.out.println("Invalid input");
		            continue;
		        }
				int inputOldX = oldInputInt / 10;
				int inputOldY = oldInputInt % 10;
				int inputNewX = newInputInt / 10;
				int inputNewY = newInputInt % 10;
				game.board[inputOldY][inputOldX].movePiece(inputNewY, inputNewX);
			}
			//black's turn
			else {
				System.out.println("Black player: Enter move");
				oldInput = scnr.nextLine();  // Read user input
				newInput = scnr.nextLine();  // Read user input
				int oldInputInt = 0;
				int newInputInt = 0;
				try {
		            oldInputInt = Integer.valueOf(oldInput);
		        } 
				catch (NumberFormatException e) {
		            System.out.println("Invalid input");
		            continue;
		        }
				try {
		            newInputInt = Integer.valueOf(newInput);
		        } 
				catch (NumberFormatException e) {
		            System.out.println("Invalid input");
		            continue;
		        }
				int inputOldX = oldInputInt / 10;
				int inputOldY = oldInputInt % 10;
				int inputNewX = newInputInt / 10;
				int inputNewY = newInputInt % 10;
				game.board[inputOldY][inputOldX].movePiece(inputNewY, inputNewX);
			}
			System.out.println("");
			game.printBoard();
			System.out.println("");
		}
	}
}
