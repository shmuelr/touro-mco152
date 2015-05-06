package edu.touro.mco152.pieces;

import edu.touro.mco152.game.Position;


public class Queen extends AbstractChessPiece {

	
	
	private Queen(PieceColor color, char pieceChar){
		super(PieceConstants.QUEEN_VALUE, color, pieceChar);
	}
	
	public static Queen buildQueen(PieceColor color){

		char pieceChar = 
				color == PieceColor.WHITE ? 
				Character.toUpperCase(PieceConstants.QUEEN_CHAR) : 
			    Character.toLowerCase(PieceConstants.QUEEN_CHAR);
		
		return  new Queen(color, pieceChar);
	}
	

	@Override
	public boolean isValidMove(Position from, Position to) {
		// TODO Auto-generated method stub
		return false;
	}

	
}