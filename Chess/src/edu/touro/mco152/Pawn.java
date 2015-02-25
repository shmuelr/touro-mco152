package edu.touro.mco152;

import java.awt.Point;

public class Pawn extends ChessPiece   {
	
	
	public Pawn() 
	{
		this(PieceColor.WHITE);
	}
	
	public Pawn(PieceColor color)
	{
		super('P'); //Call super to set the label for a pawn.
		this.color=color;	
	}
	
	
	
	

	

}
