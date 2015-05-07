package edu.touro.mco152.pieces;

public class Pawn extends ChessPiece{

	private final static char CHAR_REPRESENTATION = 'P';
	public static double VALUE 	= 1.0;		
	
	public Pawn(PieceColor color){	
		super(color,CHAR_REPRESENTATION,VALUE);
	}

	
}
