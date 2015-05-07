package edu.touro.mco152.pieces;


public class Knight extends ChessPiece{

	private final static char CHAR_REPRESENTATION = 'N';
	public static double VALUE 	= 2.5;		
	
	public Knight(PieceColor color){	
		super(color,CHAR_REPRESENTATION,VALUE);
    }

	
}
