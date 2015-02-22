package edu.touro.mco152;

public class Pawn implements ChessPiece   {
	private PieceColor color;
	
	
	public Pawn() {
		this(PieceColor.WHITE);
	}
	
	public Pawn(PieceColor color)
	{
		this.color=color;
	}
	
	@Override
	public PieceColor getColor()
	{
		return color;
	}
	
	@Override
	public String toString() 
	{
		return color == PieceColor.WHITE ? "p" : "P";
	}

}
