package edu.touro.mco152;

import edu.touro.mco152.pieces.ChessPiece;
import edu.touro.mco152.pieces.ChessPiece.PieceColor;
import edu.touro.mco152.pieces.ChessPiece.Type;

public class GameLogic {
	

	public static final int MOVE_SUCCESS = 1;
	public static final int MOVE_ERROR_NO_SOURCE_PIECE = -1;
	public static final int MOVE_ERROR_NO_DESTINATION_PIECE = -2;
	public static final int MOVE_ERROR_PIECE_IN_DESTINATION = -3;
	public static final int MOVE_ERROR_INVALID_MOVE = -4;
	public static final int MOVE_ERROR_INVALID_POSITION = -5;
	public final int DEFAULT_BOARD_SIZE;
	private Board gameBoard;
	private ChessPiece[][]pieces;
	
	public GameLogic(Board inputBoard) {
		gameBoard=inputBoard;
		DEFAULT_BOARD_SIZE= gameBoard.getSize();
		pieces = gameBoard.getPiecePositions();
	}
	
	public double getBoardStrength(PieceColor color){
		double strength = 0;
		
		for (int i = 0; i < DEFAULT_BOARD_SIZE; i++){
			for (int j = 0; j < DEFAULT_BOARD_SIZE; j++){
				if(pieces[i][j] != null && pieces[i][j].getColor() == color)
				{
					strength += getValueOfPieceAtPosition(Position.buildPostionFromXYCoords(i, j));
					
					
				}
			}
		}
		
		return strength;
	}
	
	// Move to Game Logic
	private double getValueOfPieceAtPosition(Position position)
	{
		double value = 0;
		
		if(pieces[position.getX()][position.getY()].getType() == Type.PAWN){

			if(areMultiplePawnsOnColumn(position)){
				value =  ChessPiece.PAWN_VALUE -.5;
			}else{
				value =  ChessPiece.PAWN_VALUE;
			}
				
		}else{	
			
			value = pieces[position.getX()][position.getY()].getValue();
		}
		
		return value;
	}
	
	// Move to Game Logic
	private boolean areMultiplePawnsOnColumn(Position position){
		int amtOfPawns = 0;
		final int COLUMN = position.getX();
		
		ChessPiece piece = pieces[position.getX()][position.getY()];	       
		
		for (int y = 0; y < DEFAULT_BOARD_SIZE; y++){
			
			// Continue if it is null
			if(pieces[COLUMN][y] == null) continue;
			
			if(pieces[COLUMN][y].getType() == Type.PAWN && pieces[COLUMN][y].getColor() == piece.getColor())
			{
				amtOfPawns ++;
			}
			
		}
		
		return amtOfPawns > 1;
	}
	
	// Move to Game Logic
		public int movePiece(char x1, int y1, char x2, int y2){
			
			return movePiece(Position.buildPostionFromChessCoords(x1, y1), Position.buildPostionFromChessCoords(x2, y2));
		}

		// Move to Game Logic
		private boolean isValidPostion(Position position){
			return ( position.getX() >= 0 && position.getY() < Board.DEFAULT_BOARD_SIZE);
		}
		
		// Move to Game Logic
		private boolean isPositionOccupied(Position position){
			return pieces[position.getX()][position.getY()] != null;
		}
		
		// Move to Game Logic
		private int movePiece(Position from, Position to){
			
			// First check if the locations are valid so we don't crash the program if the user gives us bad coordinates
			if(!isValidPostion(from) || !isValidPostion(to)) 
				return MOVE_ERROR_INVALID_POSITION;
			
			// Then check if there exists a piece that should be move
			if(!isPositionOccupied(from)) 
				return MOVE_ERROR_NO_SOURCE_PIECE;
			
			// Next check if there is a user's piece already in that location
			if(isPositionOccupied(to) 
					&& (pieces[from.getX()][from.getY()].getColor() == pieces[to.getX()][to.getY()].getColor())) 
				return MOVE_ERROR_PIECE_IN_DESTINATION;
			
			// Last check if the move is valid for the selected piece
			if(!isValidMove(from, to)) return MOVE_ERROR_INVALID_MOVE;
			
			
			pieces[to.getX()][to.getY()] = pieces[from.getX()][from.getY()];
			pieces[from.getX()][from.getY()] = null;
			
			return MOVE_SUCCESS;
		}
		/**
		 * Method to determine if the attempted move is a valid move or not
		 * 
		 * returns a boolean whether the move is valid
		 * 
		 * this method should have serious tests 
		 */
		// Move to Game Logic
		private boolean isValidMove(Position from, Position to) {
			ChessPiece pieceToMove = pieces[from.getX()][from.getY()];
			if(pieceToMove.getType() == Type.KING){
				
				// A King can only move one space in any direction
				if(absDistanceBetweenTwoPoints(from.getX(),to.getX()) > 1 || absDistanceBetweenTwoPoints(from.getY(),to.getY()) > 1) return false;
				
			}else if (pieceToMove.getType() == Type.ROOK){
				
				// A Rook can only move horizontally or vertically
				if(from.getX() != to.getX() && from.getY() != to.getY()) return false;
				
				/**
				 * TODO - Implement castling over here
				 * https://en.wikipedia.org/wiki/Castling
				 * Castling is an edge case, maybe just check by hand?
				 */

				// A Rook cannot jump over another piece
				// If x's are equal we are moving along that x axis ie moving up or down a column
				if(from.getX() == to.getX()){
					if (existsPieceOnColumnBetweenTwoPoints(from.getX(), from.getY(), to.getY())) return false;
				}
				// If y's are equal we are moving across that y axis ie moving across a row
				if (from.getY() == to.getY()){
					if (existsPieceOnRowBetweenTwoPoints(from.getY(), from.getX(), to.getX())) return false;
				}
				
			}else if (pieceToMove.getType() == Type.BISHOP){
				
				// Should be pretty simple to implement
				// Just need to verify that the positions are on the same diagonal and that there are no pieces in between
				
			}else if (pieceToMove.getType() == Type.QUEEN){
				
				// Need to verify that the pieces are either on the same row, column or diagonal
				// Need to make sure there are no pieces in between.
				
			}else if (pieceToMove.getType() == Type.PAWN){
				
				// Usually it can only move on space forward
				// Except:
				//		First move can move 2 spaces forward
				//		Can kill an enemy piece by moving diagonal
				//		En Passant https://en.wikipedia.org/wiki/En_passant this will be tricky... ugh
				//			- we may have to keep a history of piece moves for this..
				//				- truth is we should have a history of moves anyways so that we can print out the result at the end of the game
				//				- Where should the history be kept? In the board class? In application class? Is it related to the board? I guess it is..
				//				  The current board is really just a history of the board moves. It may make sense to store the moves with the board
				//				  There should probably be a Move class to make it easy to store this data. We can use a List<Move> to keep track of this.
				
			}else if (pieceToMove.getType() == Type.KNIGHT){
				
				// Moves in a unique pattern and jumps over pieces in the way
				// Should be pretty easy to implement
				
			}
			
			return true;
		}
		
		// Move to Game Logic
		private int absDistanceBetweenTwoPoints(int x1, int x2)
		{
			return Math.abs(x1-x2);
		}
		// Move to Game Logic
		private boolean existsPieceOnColumnBetweenTwoPoints(int x, int y1, int y2)
		{	
			// Look from one space ahead so that it ignores the rook itself (hence the +1)
			for (int i = Math.min(y1, y2)+1; i < Math.max(y1, y2); i++){
				if (pieces[x][i] !=null) return true;
			}
			return false;
		}
		// Move to Game Logic
		private boolean existsPieceOnRowBetweenTwoPoints(int y, int x1, int x2)
		{
			// Look from one space ahead so that it ignores the rook itself (hence the +1)
			for (int i =  Math.min(x1, x2)+1; i < Math.max(x1, x2); i++){
				if (pieces[i][y]!=null) return true;
			}
			return false;
		}
		
		/**
		 * TODO
		 * 
		 * Create a method to determine if a square is threatened by the other player. This is useful for castling, the king in general, and if we ever decide to implement a AI :).
		 * It may be very easy, just cycle through the enemy pieces and check if they can move to the given square
		 * 
		 */
		// Move to Game Logic
		private boolean isSquareThreatedBy(PieceColor color, int x, int y){
			
			return false;
		}

}
