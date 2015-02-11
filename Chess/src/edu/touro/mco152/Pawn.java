package edu.touro.mco152;

public class Pawn extends ChessPiece   {
	private PieceColor color;
	public Pawn() {
		this.color=PieceColor.WHITE;
	}
	
	public Pawn(PieceColor color)
	{
		this.color=color;
	}
	
	public PieceColor getColor()
	{
		return color;
	}

}
