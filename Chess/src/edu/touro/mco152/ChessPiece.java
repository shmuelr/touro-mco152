package edu.touro.mco152;

import java.awt.Point;

public abstract class ChessPiece {
	public static enum PieceColor {
		BLACK, WHITE
	}
	
	protected PieceColor color;
	protected Point position;
	protected String pieceLabel = ".";
	
	public ChessPiece(String pieceLabel){
		this.pieceLabel = pieceLabel;
	}

	public PieceColor getColor()
	{
		return color;
	}

	public Point getPosition() 
	{
		return position;
	}

	/**
	 * Using toString() like this will enable us to easily print the board.
	 * Each piece will know its color and label and then toString() will print either upper or lowercase
	 */
	
	@Override
	public String toString() 
	{
		return color == PieceColor.WHITE ? pieceLabel.toLowerCase() : pieceLabel.toUpperCase();
	}
	
}
