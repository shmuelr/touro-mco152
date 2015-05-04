package edu.touro.mco152;

import java.awt.Window.Type;

import edu.touro.mco152.pieces.ChessPiece;
import edu.touro.mco152.pieces.ChessPiece.PieceColor;
import edu.touro.mco152.pieces.Pawn;


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
		if(!isValidMove(board.getPiece(from), to)) return MOVE_ERROR_INVALID_MOVE;

        board.movePiece(from, to);
        return MOVE_SUCCESS;
	}
	
	private boolean isValidMove(ChessPiece piece, Position to) {		
		
		
      return false;
	}
	
	// Move to Game Logic
    private double getValueOfPieceAtPosition(Position position)
    {
			double value = 0;
			ChessPiece piece = board.getPiece(position);
			
			if(piece.getClass() == Pawn.class){

				if(areMultiplePawnsOnColumn(position, piece.getColor() )){
					value =  piece.getValue() -.5;
				}
					
			}else{	
				
				value = piece.getValue();
			}
			
			return value;
	}
		
    // Move to Game Logic
    private boolean areMultiplePawnsOnColumn(Position position, PieceColor color){
			int amtOfPawns = 0;
			final int COLUMN = position.getX();			
			
			for (int y = 0; y < Board.DEFAULT_BOARD_SIZE; y++){
				
				position.setX(COLUMN);
				position.setY(y);
				
				// Continue if it is null
				if(board.getPiece(position) == null) continue;
				
				if(board.getPiece(position).getClass() == Pawn.class && board.getPiece(position).getColor() == color)
				{
					amtOfPawns ++;
				}
				
			}
			
			return amtOfPawns > 1;
	}
    
    
	// Move to Game Logic
	public double getBoardStrength(PieceColor color){
		double strength = 0;
		Position currenPiecePos;
		
		for (int i = 0; i <  Board.DEFAULT_BOARD_SIZE;; i++){
			for (int j = 0; j <  Board.DEFAULT_BOARD_SIZE;; j++){
				
				if(currenPiecePos==null)currenPiecePos = new P
				
				if(pieces[i][j] != null && pieces[i][j].getColor() == color)
				{
					strength += getValueOfPieceAtPosition(Position.buildPostionFromXYCoords(i, j));					
					
				}
			}
		}
		
		return strength;
	}
		
}
