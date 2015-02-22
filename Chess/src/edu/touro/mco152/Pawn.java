package edu.touro.mco152;

public class Pawn implements ChessPiece   {
	private PieceColor color;
	public Pawn() {
		this.color=PieceColor.WHITE;
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

}
