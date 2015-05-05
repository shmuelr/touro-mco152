package edu.touro.mco152.pieces;


public class Knight extends ChessPieceAbsClass {

	
	
	private Knight(){
		// Lock down default constructor
	}
	
	public static Knight buildPawn(PieceColor color){
		Knight piece = new Knight();
		piece.color = color;
		
		piece.pieceChar = piece.isWhite() ? 
				Character.toUpperCase(PieceConstants.PAWN_CHAR) : 
					Character.toLowerCase(PieceConstants.PAWN_CHAR);
		
		return piece;
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