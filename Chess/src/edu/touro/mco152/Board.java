package edu.touro.mco152;


import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import edu.touro.mco152.pieces.ChessPiece;
import edu.touro.mco152.pieces.Pawn;
import edu.touro.mco152.pieces.ChessPiece.PieceColor;

public class Board {

	private static final int MAX_PIECE_COUNT = 32;
	private static final int DEFAULT_BOARD_SIZE = 8;
	
	private final ChessPiece[][] pieces = new ChessPiece[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
	
	public Board() 
	{
		
	}
	
	public void setupBoard() 
	{
		addPawnsToBoard();
	}
	
	public int getAmtOfPieces(){
		int count = 0;
		
		for (int i = 0; i < DEFAULT_BOARD_SIZE; i++){
			for (int j = 0; j < DEFAULT_BOARD_SIZE; j++){
				if(pieces[i][j] != null){
					count++;
				}
			}
		}
		
		return count;
	}
	
	// This method allows the user to add a piece to the board using the standard
	// chess coordinate system (ie a,1  e,3)
	public boolean addPieceToBoard(ChessPiece piece, char x, int y)
	{
		return addPieceToBoard(piece, 
				Character.toLowerCase(x) - 'a',
				DEFAULT_BOARD_SIZE - y);
	}
	
	// This method allows the user to add a piece to the board using the standard
	// chess coordinate system (ie a,1  e,3)
	public boolean removePieceFromBoard(char x, int y)
	{
		return removePieceFromBoard(
				Character.toLowerCase(x) - 'a',
				DEFAULT_BOARD_SIZE - y);
	}
	
	// Using XY coordinates is private because the player must use the chess coordinate system
	private boolean addPieceToBoard(ChessPiece piece, int x, int y)
	{
		if(pieces[x][y] == null){
			pieces[x][y] = piece;
			return true;
		}else{
			return false;
		}
	}
	
	// Using XY coordinates is private because the player must use the chess coordinate system
	private boolean removePieceFromBoard(int x, int y)
	{
		if(pieces[x][y] != null){
			pieces[x][y] = null;
			return true;
		}else{
			return false;
		}
	}
	
	
	
	private void addPawnsToBoard(){
		
		for(int i = 0; i < DEFAULT_BOARD_SIZE; i++){
			pieces[i][1] = new Pawn(PieceColor.WHITE);
		}
		
		for(int i = 0; i < DEFAULT_BOARD_SIZE; i++){
			pieces[i][6] = new Pawn(PieceColor.BLACK);
		}
			
	}
	
	
	public String printBoard() {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Printing complete board:\n");
		stringBuilder.append("  abcdefgh\n");

		for(int i = 0; i < DEFAULT_BOARD_SIZE; i++){
			stringBuilder.append(DEFAULT_BOARD_SIZE - i);
			stringBuilder.append(" ");
			
			for(int j = 0; j< DEFAULT_BOARD_SIZE; j++){
				
				// I'm not sure why I have to reverse i and j to get it to print out correctly
				// Need to investigate
				if(pieces[j][i]!=null){
					stringBuilder.append(pieces[j][i].toString());
				}else{
					stringBuilder.append('.');
				}
				
			}
			stringBuilder.append("\n");
		}
		
		
		return stringBuilder.toString();
	}

}
