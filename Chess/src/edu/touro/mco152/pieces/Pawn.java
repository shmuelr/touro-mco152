package edu.touro.mco152.pieces;

import edu.touro.mco152.Position;

public class Pawn implements ChessPieceInterface {

	private char pieceChar;
	private PieceColor color;
	
	private Pawn(){
		// Lock down default constructor
	}
	
	public static Pawn buildPawn(PieceColor color){
		Pawn pawn = new Pawn();
		pawn.color = color;
		
		return pawn;
	}
	
	
	@Override
	public boolean canJumpOverPieces() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValidMove(Position from, Position to) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char getCharacter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isWhite() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBlack() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compareTo(ChessPiece that) {
		// TODO Auto-generated method stub
		return 0;
	}

}
