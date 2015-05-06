package edu.touro.mco152.pieces;

import edu.touro.mco152.game.Position;


public class Knight extends AbstractChessPiece {

	
	
	private Knight(PieceColor color, char pieceChar){
		super(PieceConstants.KNIGHT_VALUE, color, pieceChar);
	}
	
	public static Knight buildKnight(PieceColor color){

		char pieceChar = 
				color == PieceColor.WHITE ? 
				Character.toUpperCase(PieceConstants.KNIGHT_CHAR) : 
			    Character.toLowerCase(PieceConstants.KNIGHT_CHAR);
		
		return  new Knight(color, pieceChar);
	}
	

	@Override
	public boolean isValidMove(Position from, Position to) {
		// TODO Auto-generated method stub
		return false;
	}

	
}