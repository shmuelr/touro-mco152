package edu.touro.mco152;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import edu.touro.mco152.pieces.ChessPiece;
import edu.touro.mco152.pieces.ChessPiece.PieceColor;
import edu.touro.mco152.pieces.ChessPiece.Type;

public class Board {

	public static final int MAX_PIECE_COUNT = 32;
	public static final int DEFAULT_BOARD_SIZE = 8;
	
	private final ChessPiece[][] pieces = new ChessPiece[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
	

	public Board() 
	{
		
	}
	public int getSize() {
		return DEFAULT_BOARD_SIZE;
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
			case 'P': return ChessPiece.buildNewPiece(Type.PAWN,PieceColor.WHITE);
			case 'p': return ChessPiece.buildNewPiece(Type.PAWN,PieceColor.BLACK);
			case 'R': return ChessPiece.buildNewPiece(Type.ROOK,PieceColor.WHITE);
			case 'r': return ChessPiece.buildNewPiece(Type.ROOK,PieceColor.BLACK);
			case 'N': return ChessPiece.buildNewPiece(Type.KNIGHT,PieceColor.WHITE);
			case 'n': return ChessPiece.buildNewPiece(Type.KNIGHT,PieceColor.BLACK);
			case 'B': return ChessPiece.buildNewPiece(Type.BISHOP,PieceColor.WHITE);
			case 'b': return ChessPiece.buildNewPiece(Type.BISHOP,PieceColor.BLACK);
			case 'K': return ChessPiece.buildNewPiece(Type.KING,PieceColor.WHITE);
			case 'k': return ChessPiece.buildNewPiece(Type.KING,PieceColor.BLACK);
			case 'Q': return ChessPiece.buildNewPiece(Type.QUEEN,PieceColor.WHITE);
			case 'q': return ChessPiece.buildNewPiece(Type.QUEEN,PieceColor.BLACK);
			default: return null;
		}
	}
	
	public ChessPiece[][] getPiecePositions() {
		return pieces;
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
	
	private ChessPiece getPiece(Position position)
	{
		return pieces[position.getX()][position.getY()];
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
