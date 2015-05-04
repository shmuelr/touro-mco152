package edu.touro.mco152;



import java.awt.Window.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.touro.mco152.pieces.Bishop;
import edu.touro.mco152.pieces.ChessPiece;
import edu.touro.mco152.pieces.ChessPiece.PieceColor;
import edu.touro.mco152.pieces.King;
import edu.touro.mco152.pieces.Knight;
import edu.touro.mco152.pieces.Pawn;
import edu.touro.mco152.pieces.Queen;
import edu.touro.mco152.pieces.Rook;

public class Board {

	public static final int MAX_PIECE_COUNT = 32;
	public static final int DEFAULT_BOARD_SIZE = 8;
	
	public final ChessPiece[][] pieces = new ChessPiece[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
	

	public static final int MOVE_SUCCESS = 1;
	public static final int MOVE_ERROR_NO_SOURCE_PIECE = -1;
	public static final int MOVE_ERROR_NO_DESTINATION_PIECE = -2;
	public static final int MOVE_ERROR_PIECE_IN_DESTINATION = -3;
	public static final int MOVE_ERROR_INVALID_MOVE = -4;
	public static final int MOVE_ERROR_INVALID_POSITION = -5;
	
	public Board() 
	{
		
	}
	public void setupBoard()
	{
		setUpBoard("RNBQKBNR"+
			"PPPPPPPP"+
			"........"+
			"........"+
			"........"+
			"........"+
			"pppppppp"+
			"rnbqkbnr");
	}
	
	public void setUpBoard(String s) {
		int length = s.length()-1;
		for (int i=0;i< DEFAULT_BOARD_SIZE;i++)
		for (int j=DEFAULT_BOARD_SIZE-1;j>=0;j--)
		pieces[j][i]= generatePiece(s.charAt(length--));		
		
	}
	
	public ChessPiece generatePiece(char c) {
		
		switch(c) {
			case 'P': return new Pawn(PieceColor.WHITE);
			case 'p': return new Pawn(PieceColor.BLACK);
			case 'R': return new Rook(PieceColor.WHITE);
			case 'r': return new Rook(PieceColor.BLACK);
			case 'N': return new Knight(PieceColor.WHITE);
			case 'n': return new Knight(PieceColor.BLACK);
			case 'B': return new Bishop(PieceColor.WHITE);
			case 'b': return new Bishop(PieceColor.BLACK);
			case 'K': return new King(PieceColor.WHITE);
			case 'k': return new King(PieceColor.BLACK);
			case 'Q': return new Queen(PieceColor.WHITE);
			case 'q': return new Queen(PieceColor.BLACK);
			default: return null;
		}
	}
	
	private List<ChessPiece> getListOfPieces(){
		List<ChessPiece> chessPieces = new ArrayList<>(MAX_PIECE_COUNT);
		
		for (int i = 0; i < DEFAULT_BOARD_SIZE; i++){
			for (int j = 0; j < DEFAULT_BOARD_SIZE; j++){
				if(pieces[i][j] != null){
					chessPieces.add(pieces[i][j]);
				}
			}
		}
		
		return chessPieces;
	}
	
	public List<ChessPiece> getListOfPieces(PieceColor color)
	{
		
		List<ChessPiece> chessPieces = getListOfPieces();
		List<ChessPiece> chessPiecesByColor = new ArrayList<>(MAX_PIECE_COUNT/2);
		
			for (ChessPiece piece : chessPieces){
				if(piece.getColor() == color){
					chessPiecesByColor.add(piece);
				}
			}
			
		Collections.sort(chessPiecesByColor);
			
		return chessPiecesByColor;
	}	
	
	public int getAmtOfPieces(){
		return getListOfPieces().size();
	}
	
	public int getAmtOfPiecesByColor(PieceColor color){
		return getListOfPieces(color).size();
	}
	
	public int getAmtOfSpecificPiece(ChessPiece chessPiece){
		int count = 0;
		for (ChessPiece piece : getListOfPieces()){
			if (piece.equals(chessPiece)){
				count++;
			}
		}
		return count;
	}

	public ChessPiece getPiece(char x, int y)
	{
		return getPiece(Position.buildPostionFromChessCoords(x, y));
	}
	
	public ChessPiece getPiece(Position position)
	{
		return pieces[position.getX()][position.getY()];
	}	
	
	public void movePiece(Position from, Position to){		
		
		pieces[to.getX()][to.getY()] = pieces[from.getX()][from.getY()];
		pieces[from.getX()][from.getY()] = null;	
	}
	
	public boolean areSameColor(Position first, Position second){
		
		return (pieces[first.getX()][first.getY()].getColor() == pieces[second.getX()][second.getY()].getColor());
	}		
	
	// Move to Game Logic
	private int absDistanceBetweenTwoPoints(int x1, int x2)
	{
		return Math.abs(x1-x2);
	}
	
	// Move to Game Logic
	private boolean existsPieceOnColumnBetweenTwoPoints(int x, int y1, int y2)
	{	
		// Look from one space ahead so that it ignores the rook itself (hence the +1)
		for (int i = Math.min(y1, y2)+1; i < Math.max(y1, y2); i++){
			if (pieces[x][i] !=null) return true;
		}
		return false;
	}
	
	// Move to Game Logic
	private boolean existsPieceOnRowBetweenTwoPoints(int y, int x1, int x2)
	{
		// Look from one space ahead so that it ignores the rook itself (hence the +1)
		for (int i =  Math.min(x1, x2)+1; i < Math.max(x1, x2); i++){
			if (pieces[i][y]!=null) return true;
		}
		return false;
	}	
	
	
	/**
	 * TODO
	 * 
	 * Create a method to determine if a square is threatened by the other player. This is useful for castling, the king in general, and if we ever decide to implement a AI :).
	 * It may be very easy, just cycle through the enemy pieces and check if they can move to the given square
	 * 
	 */
	// Move to Game Logic
	private boolean isSquareThreatedBy(PieceColor color, int x, int y){
		
		return false;
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
	
	
	
	
	
	public String printBoard() {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("  abcdefgh\n");

		for(int y = 0; y < DEFAULT_BOARD_SIZE; y++){
			stringBuilder.append(DEFAULT_BOARD_SIZE - y);
			stringBuilder.append(" ");
			
			for(int x = 0; x< DEFAULT_BOARD_SIZE; x++){
				
				if(pieces[x][y]!=null){
					stringBuilder.append(pieces[x][y].toString());
				}else{
					stringBuilder.append('.');
				}
				
			}
			stringBuilder.append("\n");
		}
		
		
		return stringBuilder.toString();
	}

}
