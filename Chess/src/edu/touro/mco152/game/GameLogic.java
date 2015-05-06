package edu.touro.mco152.game;

import edu.touro.mco152.game.Game.Constants;
import edu.touro.mco152.pieces.AbstractChessPiece;
import edu.touro.mco152.pieces.Knight;
import edu.touro.mco152.pieces.Pawn;
import edu.touro.mco152.pieces.PieceColor;
import edu.touro.mco152.pieces.PieceConstants;

class GameLogic {

	// Move to Game Logic
	public double getBoardStrength(Board board, PieceColor color) {
		double strength = 0;

		AbstractChessPiece chessPiece;
		
		for (int i = 0; i < Game.Constants.DEFAULT_BOARD_SIZE; i++) {
			for (int j = 0; j < Game.Constants.DEFAULT_BOARD_SIZE; j++) {
				
				chessPiece = board.getPieceAtPostion(Position.buildPostionFromXYCoords(i, j));
				
				if (chessPiece != null &&chessPiece.getColor() == color) {
					strength += getValueOfPieceAtPosition(board,
							Position.buildPostionFromXYCoords(i, j));

				}
			}
		}

		return strength;
	}

	private double getValueOfPieceAtPosition(Board board, Position position) {
		double value = 0;

		AbstractChessPiece piece = board.getPieceAtPostion(position);
		
		if (piece instanceof Pawn) {

			if (areMultiplePawnsOnColumn(board, position)) {
				value = PieceConstants.PAWN_VALUE - .5;
			} else {
				value = PieceConstants.PAWN_VALUE;
			}

		} else {

			value = piece.getValue();
		}

		return value;
	}

	private boolean areMultiplePawnsOnColumn(Board board,	Position position) {
		int amtOfPawns = 0;
		final int COLUMN = position.getX();

		AbstractChessPiece piece = board.getPieceAtPostion(position);
		AbstractChessPiece tempPiece;

		for (int y = 0; y < Game.Constants.DEFAULT_BOARD_SIZE; y++) {

			tempPiece = board.getPieceAtPostion(Position.buildPostionFromXYCoords(COLUMN, y));
			
			// Continue if it is null
			if (tempPiece == null)
				continue;

			if (tempPiece instanceof Pawn
					&& tempPiece.getColor() == piece.getColor()) {
				amtOfPawns++;
			}

		}

		return amtOfPawns > 1;
	}

	public int checkMove(Board gameBoard, Position from, Position to) {

		// First check if the locations are valid so we don't crash the program
		// if the user gives us bad coordinates
		if (!isValidPostion(from) || !isValidPostion(to))
			return Constants.MOVE_ERROR_INVALID_POSITION;

		// Then check if there exists a piece that should be move
		if (!isPositionOccupied(gameBoard, from))
			return Constants.MOVE_ERROR_NO_SOURCE_PIECE;

		// Next check if there is a user's piece already in that location
		if (isPositionOccupied(gameBoard, to)
				&& (gameBoard.getPieceAtPostion(from).getColor() == gameBoard
						.getPieceAtPostion(to).getColor()))
			return Constants.MOVE_ERROR_PIECE_IN_DESTINATION;

		// Last check if the move is valid for the selected piece
		if (!isValidMove(gameBoard, from, to))
			return Constants.MOVE_ERROR_INVALID_MOVE;

		return Constants.MOVE_VALID;
	}

	

	private boolean isValidPostion(Position position) {
		return (position.getX() >= 0
				&& position.getX() < Constants.DEFAULT_BOARD_SIZE
				&& position.getY() >= 0 && position.getY() < Constants.DEFAULT_BOARD_SIZE);

	}

	private boolean isPositionOccupied(Board board, Position position) {
		return board.existsPieceAtPosition(position);
	}

	
	private boolean isValidMove(Board board, Position from, Position to) {
		// TODO Auto-generated method stub
		AbstractChessPiece pieceToMove = board.getPieceAtPostion(from);
		
		if(!pieceToMove.isValidMove(from, to)) 
			return false;
		
		// Only a knight can jump over pieces
		if(!(pieceToMove instanceof Knight) && existsPieceOnPath(board, from, to))
			return false;
		
		
		return true;
		
		
	}

	private boolean existsPieceOnPath(Board board, Position from, Position to) {

		if(from.getX() == to.getX()){
			if (existsPieceOnColumnBetweenTwoPoints(board, from.getX(), from.getY(), to.getY())) return false;
		}
		// If y's are equal we are moving across that y axis ie moving across a row
		if (from.getY() == to.getY()){
			if (existsPieceOnRowBetweenTwoPoints(board, from.getY(), from.getX(), to.getX())) return false;
		}
		
		return false;
	}

	private boolean existsPieceOnColumnBetweenTwoPoints(Board board, int x, int y1, int y2)	{	
			// Look from one space ahead so that it ignores the rook itself (hence the +1)
			for (int i = Math.min(y1, y2)+1; i < Math.max(y1, y2); i++){
				if (board.existsPieceAtPosition(Position.buildPostionFromXYCoords(x, i))) return true;
			}
			return false;
	}

	private boolean existsPieceOnRowBetweenTwoPoints(Board board, int y, int x1, int x2) {
			// Look from one space ahead so that it ignores the rook itself (hence the +1)
			for (int i =  Math.min(x1, x2)+1; i < Math.max(x1, x2); i++){
				if (board.existsPieceAtPosition(Position.buildPostionFromXYCoords(i, y))) return true;
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
