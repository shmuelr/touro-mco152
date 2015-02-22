package edu.touro.mco152;

import java.awt.Point;

public interface ChessPiece {
	public static enum PieceColor {
		BLACK, WHITE
	}
	
	public PieceColor getColor();
	
	public Point getPosition();

}
