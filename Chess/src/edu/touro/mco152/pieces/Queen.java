package edu.touro.mco152.pieces;


public class Queen extends ChessPiece{

	private final static char CHAR_REPRESENTATION = 'Q';
	public static double VALUE 	= 9.0;		
	
	public Queen(PieceColor color){	
		super(color,CHAR_REPRESENTATION,VALUE);
	}

	
}
