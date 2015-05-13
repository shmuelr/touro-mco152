package edu.touro.mco152.pieces;

import edu.touro.mco152.BoardUtils;
import edu.touro.mco152.Position;

public class King extends ChessPiece{

	
	private final static char CHAR_REPRESENTATION = 'K';
	public static double VALUE 	= 0.0;		
	
	public King(PieceColor color){	
		super(color,CHAR_REPRESENTATION,VALUE);
	}
	
	public boolean isValidMove(Position from, Position to){
		return(BoardUtils.absDistanceBetweenTwoPoints(from.getX(),to.getX())<=1&&
				BoardUtils.absDistanceBetweenTwoPoints(from.getY(),to.getY())<=1);
	}
}
