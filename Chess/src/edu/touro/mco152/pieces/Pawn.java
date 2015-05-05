package edu.touro.mco152.pieces;

import edu.touro.mco152.Position;

public class Pawn extends ChessPieceAbsClass {

	
	
	private Pawn(){
		// Lock down default constructor
	}
	
	public static Pawn buildPawn(PieceColor color){
		Pawn pawn = new Pawn();
		pawn.color = color;
		
		pawn.pieceChar = pawn.isWhite() ? 
				Character.toUpperCase(PieceConstants.PAWN_CHAR) : 
					Character.toLowerCase(PieceConstants.PAWN_CHAR);
		
		return pawn;
	}
	
	
	
	@Override
	public boolean canJumpOverPieces() {
		return false;
	}

	@Override
	public boolean isValidMove(Position from, Position to) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
