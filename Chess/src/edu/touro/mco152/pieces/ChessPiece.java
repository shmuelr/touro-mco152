package edu.touro.mco152.pieces;


public class ChessPiece implements Comparable<ChessPiece>{
	
	
	public static enum PieceColor {
		BLACK, WHITE
	}
	
	private double value;
	private char represenation;
			
	protected final PieceColor color;
	
	
	public ChessPiece(PieceColor color){
		this.color = color;
	}

	
	public PieceColor getColor()
	{
		return color;
	}
	
	public void setValue(double set) {
		value = set;
	}
	
	public double getValue()
	{
		return value;
	}
	
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
		return Character.toString(this.represenation);
		}
	
	public void setRepresentationAndValue() {
	
	if (this.getClass()==Queen.class) {
		represenation='q';
		value=9;
	}
	else if (this.getClass()==King.class) {
		represenation='k';
		value=0;
	}
	else if (this.getClass()==Knight.class) { 
		represenation='n';
		value = 2.5;
	}
	else if (this.getClass()==Rook.class) {
		represenation='r';
		value=5;
	}
	else if (this.getClass()==Bishop.class) {
		represenation='b';
		value=3;
	}
	else if (this.getClass()==Pawn.class) {
		this.represenation='p';
		value=1;
	}
	else {
		this.represenation=' ';
	}
	if (this.isWhite())
		this.represenation = Character.toUpperCase(this.represenation);
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
