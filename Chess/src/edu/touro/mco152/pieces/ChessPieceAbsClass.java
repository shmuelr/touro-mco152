package edu.touro.mco152.pieces;

import edu.touro.mco152.Position;

public abstract class ChessPieceAbsClass implements Comparable<ChessPieceAbsClass>{

	protected char pieceChar;
	protected PieceColor color;
	
	public abstract boolean	canJumpOverPieces();
	public abstract boolean  isValidMove(Position from, Position to);
	
	

	public double getValue() {
		return PieceConstants.PAWN_VALUE;
	}


	public char getCharacter() {
		return pieceChar;
	}


	public boolean isWhite() {
		return color.equals(PieceColor.WHITE);
	}


	public boolean isBlack() {
		return color.equals(PieceColor.BLACK);
	}


	@Override
	public String toString() 
	{
		return Character.toString(pieceChar);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ChessPiece){
			return obj.toString().equals(this.toString());
		}
		return false;
	}


	
	@Override
	public int compareTo(ChessPieceAbsClass that) 
	{
		final int LESS = -1;
	    final int EQUAL = 0;
	    final int GREATER = 1;
		
		if(this.getValue() > that.getValue()){
			return GREATER;
		}
		if (this.getValue() < that.getValue()){
			return LESS;
		}
		
		return EQUAL;
	}
	
}
