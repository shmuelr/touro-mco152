package edu.touro.mco152.pieces;

import edu.touro.mco152.Position;

public class Pawn extends ChessPiece{

	private final static char CHAR_REPRESENTATION = 'P';
	public static double VALUE 	= 1.0;		
	
	public Pawn(PieceColor color){	
		super(color,CHAR_REPRESENTATION,VALUE);
	}
	
	public boolean isValidMove(Position from, Position to){
		
		
		return true;
		
	}
	
}
