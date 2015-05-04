package edu.touro.mco152.pieces;

import edu.touro.mco152.Position;

public interface ChessPieceInterface {

	public boolean	canJumpOverPieces();
	public boolean  isValidMove(Position from, Position to);
	
	public double 	getValue();
	public char		getCharacter();
	public boolean 	isWhite();
	public boolean	isBlack();
	
	public boolean	equals(Object obj);
	public int 		compareTo(ChessPiece that);
	public int 		hashCode();
	
	
}
