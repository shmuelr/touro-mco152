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
		
		
		if(!isValidPostion(from) || !isValidPostion(to)) 
			return MOVE_ERROR_INVALID_POSITION;
		
		// Then check if there exists a piece that should be move
		if(!isPositionOccupied(from)) 
			return MOVE_ERROR_NO_SOURCE_PIECE;
				
		// Next check if there is a user's piece already in that location
		if(isPositionOccupied(to) && board.areSameColor(from, to)) 
			return MOVE_ERROR_PIECE_IN_DESTINATION;
				
		// Last check if the move is valid for the selected piece
		if(!isValidMove(board.getPiece(from), to)) return MOVE_ERROR_INVALID_MOVE;

        board.movePiece(from, to);
        return MOVE_SUCCESS;
	}
	
	private boolean isValidMove(ChessPiece piece, Position to, Position from) {		
		
		
		return BoardUtils.existsPieceBetweenTwoPoints(to, from, board);
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
    private double getValueOfPieceAtPosition(Position position)
    {
			
			ChessPiece piece = board.getPiece(position);
			double value = piece.getValue();
			
			if(piece.getClass() == Pawn.class){

				if(areMultiplePawnsOnColumn(position, piece.getColor() )){
					value =  piece.getValue() -.5;
				}									
			}
			
			return value;
	}
    
	// Move to Game Logic
	public double getBoardStrength(PieceColor color){
		double strength = 0;
		Position currenPiecePos = new Position();
		
		for (int x = 0; x <  Board.DEFAULT_BOARD_SIZE; x++){
			for (int y = 0; y <  Board.DEFAULT_BOARD_SIZE; y++){
				currenPiecePos.setX(x);
				currenPiecePos.setY(y);
				
				if(board.getPiece(currenPiecePos) != null && board.getPiece(currenPiecePos).getColor() == color)
				{
					strength += getValueOfPieceAtPosition(currenPiecePos);	
				}
				
			}
		}		
		
		System.out.println(strength);
		return strength;
	}
		
    public boolean isPositionOccupied(Position position){
			return board.getPiece(position) != null;
    }
    
    public void movePiece(char x1, int y1, char x2, int y2){
		
 	   movePiece(Position.buildPostionFromChessCoords(x1, y1), Position.buildPostionFromChessCoords(x2, y2));
 	}

 	public boolean isValidPostion(Position position){
 		return ( position.getX() >= 0 && position.getY() < Board.DEFAULT_BOARD_SIZE);
 	}	
		
}
