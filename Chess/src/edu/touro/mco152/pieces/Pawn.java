package edu.touro.mco152.pieces;

import java.awt.Point;

import edu.touro.mco152.pieces.ChessPiece.PieceColor;

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
