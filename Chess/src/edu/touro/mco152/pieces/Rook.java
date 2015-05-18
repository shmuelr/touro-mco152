package edu.touro.mco152.pieces;

import edu.touro.mco152.BoardUtils;
import edu.touro.mco152.Position;


public class Rook extends ChessPiece{

	private final static char CHAR_REPRESENTATION = 'R';
	public static double VALUE 	= 5.0;		
	
	public Rook(PieceColor color){	
		super(color,CHAR_REPRESENTATION,VALUE);
	}
	
	public boolean isValidMove(Position to, Position from) {
		return (BoardUtils.isStraight(to,from));
	}


}
