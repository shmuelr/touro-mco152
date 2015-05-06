package edu.touro.mco152.game;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import edu.touro.mco152.pieces.PieceColor;


public class Game {

	public static class Constants{
		
		public static final int MAX_PIECE_COUNT = 32;
		public static final int DEFAULT_BOARD_SIZE = 8;
		
		// If the move is valid (but not completed yet)
		public static final int MOVE_VALID = 2;
		
		// After the move is completed
		public static final int MOVE_SUCCESS = 1;
		
		public static final int MOVE_ERROR_NO_SOURCE_PIECE = -1;
		public static final int MOVE_ERROR_NO_DESTINATION_PIECE = -2;
		public static final int MOVE_ERROR_PIECE_IN_DESTINATION = -3;
		public static final int MOVE_ERROR_INVALID_MOVE = -4;
		public static final int MOVE_ERROR_INVALID_POSITION = -5;
		
		public static final String GAME_INSTRUCTIONS = 
				"Welcome to the chess game.\n\n"
				+ "You can move pieces by typing move a3 d4.\n"
				+ "Type 's' to dispay the board strength.\n"
				+ "Type exit to exit the game.\n\n"
				+ "Enjoy!\n";
		
		
	}
	
	
	 /**
	  * This class will control the entire game. It will contain a board, pieces, and logic.
	  */
	
	private Board gameBoard;
	private GameLogic gameLogic;
	
	private boolean isPlaying;
	
	
	private Game(){
		
	}
	
	public static Game buildNewGame(){
		Game game = new Game();
		Board board = new Board();
		board.setupBoard();
		game.gameBoard = board;
		
		game.gameLogic = new GameLogic();
		
		game.isPlaying = true;
		
		return game;
	}
	
	public boolean isPlaying() {
		return isPlaying;
	}
	
	public String proccessUserInput(String input){
		String[] tokens = input.split(" ");
		
		int resultCode = Integer.MIN_VALUE;
		String message = "Not finished yet";
		
		switch(tokens[0]){
		
		case "exit":
			break;
		
		case "move":
			
			Position from 	= Position.buildPostionFromChessCoords(tokens[1]);
			Position to		= Position.buildPostionFromChessCoords(tokens[2]);
			
			resultCode = gameLogic.checkMove(gameBoard, from, to);
			
			if(resultCode == Constants.MOVE_VALID) {
				gameBoard.movePiece(from, to);
				resultCode = Constants.MOVE_SUCCESS;
			}
					
			
			message = getMessageForResult(resultCode);
			
			break;
			
		case "s":
			
			message = "Black strength: "
			+ gameLogic.printPieces(gameBoard, PieceColor.BLACK)
			+ " :"
			+ gameLogic.getBoardStrength(gameBoard, PieceColor.BLACK)
			+"\n"
			+"White strength: "
			+ gameLogic.printPieces(gameBoard, PieceColor.WHITE)
			+ " :"
			+ gameLogic.getBoardStrength(gameBoard, PieceColor.WHITE)
			+"\n";
			
			break;
			
		
		}
		
		return message;
	}
	
	
	private String getMessageForResult(int result) {
		String message;
		
		switch (result){
		
		case Constants.MOVE_SUCCESS:
			message = "Move successful \n"+printBoard();
			break;
		case Constants.MOVE_ERROR_INVALID_MOVE:
			message = "Invalid move";
			break;
		case Constants.MOVE_ERROR_INVALID_POSITION:
			message = "Invalid position";
			break;
		case Constants.MOVE_ERROR_NO_DESTINATION_PIECE:
			message = "Error: no destination piece";
			break;
		case Constants.MOVE_ERROR_NO_SOURCE_PIECE:
			message = "Error: no piece selected";
			break;
		case Constants.MOVE_ERROR_PIECE_IN_DESTINATION:
			message = "Error: destination occupied";
			break;
			
			default:
				message = "No message found";
		
		}
		
		return message;
	}

	public String printBoard() {
		
		return gameBoard.printBoard();
	}

	

	
}
