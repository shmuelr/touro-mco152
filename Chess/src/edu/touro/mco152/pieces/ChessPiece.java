package edu.touro.mco152.pieces;

import edu.touro.mco152.Position;


public abstract class ChessPiece implements Comparable<ChessPiece>{
	

	
	public static enum PieceColor {
		BLACK, WHITE
	}		
			
	protected PieceColor color;
	protected final char pieceChar;	
	protected double value;
	
	public ChessPiece(PieceColor color, char charRepresent, double value){
		
		this.color = color;
		pieceChar = isWhite() ? 
				Character.toUpperCase(charRepresent) : 
					Character.toLowerCase(charRepresent);
	    this.value = value;
	}	
	 
	public abstract boolean isValidMove(Position from, Position to);
	
	public PieceColor getColor(){
		return color;
	}	
	
	public double getValue(){
		return value;
	};
	
	public boolean isWhite(){
		return color == PieceColor.WHITE;
	}
	
	public boolean isBlack(){
		return color == PieceColor.BLACK;
	}
	
	
	/**
	 * Using toString() like this will enable us to easily print the board.
	 * Each piece will know its color and label and then toString() will print either upper or lowercase
	 */	
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
	public int compareTo(ChessPiece that) 
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
