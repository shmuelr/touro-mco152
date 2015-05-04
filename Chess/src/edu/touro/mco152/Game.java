package edu.touro.mco152;

import edu.touro.mco152.pieces.ChessPiece;


public class Game {


	public static final int MOVE_SUCCESS = 1;
	public static final int MOVE_ERROR_NO_SOURCE_PIECE = -1;
	public static final int MOVE_ERROR_NO_DESTINATION_PIECE = -2;
	public static final int MOVE_ERROR_PIECE_IN_DESTINATION = -3;
	public static final int MOVE_ERROR_INVALID_MOVE = -4;
	public static final int MOVE_ERROR_INVALID_POSITION = -5;
	
	private Board board;
	
	public Game(){
		
		board = new Board();
		
		startGame();
	}
	
	private void startGame(){
		
		board.setupBoard();
		
	}	
 	
	private int movePiece(Position from, Position to){
		
		
		if(!board.isValidPostion(from) || !board.isValidPostion(to)) 
			return MOVE_ERROR_INVALID_POSITION;
		
		// Then check if there exists a piece that should be move
		if(!board.isPositionOccupied(from)) 
			return MOVE_ERROR_NO_SOURCE_PIECE;
				
		// Next check if there is a user's piece already in that location
		if(board.isPositionOccupied(to) && board.areSameColor(from, to)) 
			return MOVE_ERROR_PIECE_IN_DESTINATION;
				
		// Last check if the move is valid for the selected piece
		//if(!board.isValidMove(from, to)) return MOVE_ERROR_INVALID_MOVE;

        board.movePiece(from, to);
        return MOVE_SUCCESS;
	}
	
	private boolean isValidMove(ChessPiece piece, Position to) {		
		
		
      return false;
	}
}
