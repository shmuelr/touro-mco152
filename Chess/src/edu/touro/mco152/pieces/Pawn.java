package edu.touro.mco152.pieces;

import edu.touro.mco152.game.Position;



public class Pawn extends AbstractChessPiece {

	
	
	private Pawn(PieceColor color, char pieceChar){
		super(PieceConstants.PAWN_VALUE, color, pieceChar);
	}
	
	public static Pawn buildPawn(PieceColor color){
	
		
		char pieceChar = 
				color == PieceColor.WHITE ? 
				Character.toUpperCase(PieceConstants.PAWN_CHAR) : 
				Character.toLowerCase(PieceConstants.PAWN_CHAR);
		
		return  new Pawn(color, pieceChar);
	}
	

	@Override
	public boolean isValidMove(Position from, Position to) {

		
		return true;
	}

	
}
