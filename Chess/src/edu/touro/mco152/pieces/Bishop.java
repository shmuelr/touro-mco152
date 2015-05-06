package edu.touro.mco152.pieces;

import edu.touro.mco152.game.Position;


public class Bishop extends AbstractChessPiece {

	
	
	private Bishop(PieceColor color, char pieceChar){
		super(PieceConstants.BISHOP_VALUE, color, pieceChar);
	}
	
	public static Bishop buildBishop(PieceColor color){

		char pieceChar = 
				color == PieceColor.WHITE ? 
				Character.toUpperCase(PieceConstants.BISHOP_CHAR) : 
			    Character.toLowerCase(PieceConstants.BISHOP_CHAR);
		
		return  new Bishop(color, pieceChar);
	}
	

	@Override
	public boolean isValidMove(Position from, Position to) {
		// TODO Auto-generated method stub
		return false;
	}

	
}