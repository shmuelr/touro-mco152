package edu.touro.mco152.pieces;

import edu.touro.mco152.game.Position;

public abstract class AbstractChessPiece implements Comparable<AbstractChessPiece>{

	private char pieceChar;
	private PieceColor color;
	
	
	private double value;
	private boolean wasMoved = false;
	
	public AbstractChessPiece(double value, PieceColor color, char pieceChar) {
		this.value = value;
		this.color = color;
		this.pieceChar = pieceChar;
	}
	
	public abstract boolean  isValidMove(Position from, Position to);
	
	
	
	public boolean wasMoved() {
		return wasMoved;
	}
	public void setMoved() {
		this.wasMoved = true;
	}

	public double getValue() {
		return value;
	}


	public char getCharacter() {
		return pieceChar;
	}

	public PieceColor getColor() {
		return color;
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
	
	// Not sure if this will be good. Should pawns be equal to each other?
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof AbstractChessPiece){
			return obj.toString().equals(this.toString());
		}
		return false;
	}


	
	@Override
	public int compareTo(AbstractChessPiece that) 
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
