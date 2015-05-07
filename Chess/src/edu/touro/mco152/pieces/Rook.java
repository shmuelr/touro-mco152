package edu.touro.mco152.pieces;


public class Rook extends ChessPiece{

	private final static char CHAR_REPRESENTATION = 'R';
	public static double VALUE 	= 5.0;		
	
	public Rook(PieceColor color){	
		super(color,CHAR_REPRESENTATION,VALUE);
	}


}
