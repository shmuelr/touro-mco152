package edu.touro.mco152.pieces;


public class Bishop extends ChessPiece{

	private final static char CHAR_REPRESENTATION = 'B';
	public static double VALUE 	= 3.0;		
	
	public Bishop(PieceColor color){	
		super(color,CHAR_REPRESENTATION,VALUE);
    }

	
}
