package edu.touro.mco152.pieces;

import edu.touro.mco152.game.BoardUtils;
import edu.touro.mco152.game.Position;


public class King extends AbstractChessPiece {

	
	
	private King(PieceColor color, char pieceChar){
		super(PieceConstants.KING_VALUE, color, pieceChar);
	}
	
	public static King buildKing(PieceColor color){

		char pieceChar = 
				color == PieceColor.WHITE ? 
				Character.toUpperCase(PieceConstants.KING_CHAR) : 
			    Character.toLowerCase(PieceConstants.KING_CHAR);
		
		return  new King(color, pieceChar);
	}
	

	@Override
	public boolean isValidMove(Position from, Position to) {
		// A King can only move one space in any direction
		return (BoardUtils.absDistanceBetweenTwoPoints(from.getX(),to.getX()) <= 1
				&& BoardUtils.absDistanceBetweenTwoPoints(from.getY(),to.getY()) <= 1);
	}

	
}