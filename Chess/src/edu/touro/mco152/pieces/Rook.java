package edu.touro.mco152.pieces;

import edu.touro.mco152.game.Position;


public class Rook extends AbstractChessPiece {

	
	
	private Rook(PieceColor color, char pieceChar){
		super(PieceConstants.ROOK_VALUE, color, pieceChar);
	}
	
	public static Rook buildRook(PieceColor color){

		char pieceChar = 
				color == PieceColor.WHITE ? 
				Character.toUpperCase(PieceConstants.ROOK_CHAR) : 
			    Character.toLowerCase(PieceConstants.ROOK_CHAR);
		
		return  new Rook(color, pieceChar);
	}
	

	@Override
	public boolean isValidMove(Position from, Position to) {
		// A Rook can only move horizontally or vertically
		if(from.getX() != to.getX() && from.getY() != to.getY())
			return false;
		
		return true;
	}

	
}