package edu.touro.mco152;


import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import edu.touro.mco152.ChessPiece.PieceColor;

public class Board {

	private static final int MAX_PIECE_COUNT = 32;
	
	List<ChessPiece> listOfPieces = new ArrayList<ChessPiece>(MAX_PIECE_COUNT);
	
	public Board() 
	{
		setupBoard();
	}
	
	
	public void addPieceToBoard(ChessPiece piece)
	{
		listOfPieces.add(piece);
	}
	
	private void setupBoard() 
	{
		addPawns(listOfPieces);
	}
	
	private void addPawns(List<ChessPiece> listOfPieces){
		
		for(int i = 0; i < 8; i++){
			listOfPieces.add(new Pawn(PieceColor.WHITE, new Point(i, 1) ) );
		}
		
		for(int i = 0; i < 8; i++){
			listOfPieces.add(new Pawn(PieceColor.BLACK, new Point(i, 6) ) );
		}
			
	}
	
	
	public String printBoard() {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Printing complete board:\n");
		stringBuilder.append("  abcdefgh\n");
		boolean isPieceHere = false;
		for(int i = 0; i < 8; i++){
			stringBuilder.append(i+1);
			stringBuilder.append(" ");
			for(int j = 0; j< 8; j++){
				for(ChessPiece piece : listOfPieces){
					if(piece.getPosition().x == j && piece.getPosition().y == i){
						isPieceHere = true;
						stringBuilder.append(piece.toString());
					}
				}
				
				if(!isPieceHere){
					stringBuilder.append('.');
				}
				isPieceHere = false;
				
			}
			stringBuilder.append("\n");
		}
		
		
		return stringBuilder.toString();
	}

}
