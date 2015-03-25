package edu.touro.mco152;



import java.util.ArrayList;
import java.util.List;

import edu.touro.mco152.pieces.ChessPiece;
import edu.touro.mco152.pieces.ChessPiece.PieceColor;
import edu.touro.mco152.pieces.ChessPiece.Type;

public class Board {

	private static final int MAX_PIECE_COUNT = 32;
	private static final int DEFAULT_BOARD_SIZE = 8;
	
	private final ChessPiece[][] pieces = new ChessPiece[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
	
	public static final int SUCCESS = 1;
	public static final int ERROR_NO_SOURCE_PIECE = -1;
	public static final int ERROR_NO_DESTINATION_PIECE = -2;
	public static final int ERROR_PIECE_IN_DESTINATION = -3;
	
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
			case 'P': return ChessPiece.getPiece(Type.PAWN,PieceColor.WHITE);
			case 'p': return ChessPiece.getPiece(Type.PAWN,PieceColor.BLACK);
			case 'R': return ChessPiece.getPiece(Type.ROOK,PieceColor.WHITE);
			case 'r': return ChessPiece.getPiece(Type.ROOK,PieceColor.BLACK);
			case 'N': return ChessPiece.getPiece(Type.KNIGHT,PieceColor.WHITE);
			case 'n': return ChessPiece.getPiece(Type.KNIGHT,PieceColor.BLACK);
			case 'B': return ChessPiece.getPiece(Type.BISHOP,PieceColor.WHITE);
			case 'b': return ChessPiece.getPiece(Type.BISHOP,PieceColor.BLACK);
			case 'K': return ChessPiece.getPiece(Type.KING,PieceColor.WHITE);
			case 'k': return ChessPiece.getPiece(Type.KING,PieceColor.BLACK);
			case 'Q': return ChessPiece.getPiece(Type.QUEEN,PieceColor.WHITE);
			case 'q': return ChessPiece.getPiece(Type.QUEEN,PieceColor.BLACK);
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
	
	public int getAmtOfPieces(){
		return getListOfPieces().size();
	}
	
	public int getAmtOfPiecesByColor(PieceColor color){
		int count = 0;
		for (ChessPiece piece : getListOfPieces()){
			if (piece.getColor() == color){
				count++;
			}
		}
		return count;
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

	
	
	
	public int movePiece(char x1, int y1, char x2, int y2){
		System.out.println(x1+" "+y1);
		System.out.println(x2+" "+y2);
		
		return movePiece(
				Character.toLowerCase(x1) - 'a',
				DEFAULT_BOARD_SIZE - y1,
				Character.toLowerCase(x2) - 'a',
				DEFAULT_BOARD_SIZE - y2);
	}
	
	
	private int movePiece(int x1, int y1, int x2, int y2){
		System.out.println(x1+" "+y1);
		System.out.println(x2+" "+y2);
		
		if(pieces[x1][y1] == null) return ERROR_NO_SOURCE_PIECE;
		if(pieces[x2][y2] != null) return ERROR_PIECE_IN_DESTINATION;
		
		pieces[x2][y2] = pieces[x1][y1];
		pieces[x1][y1] = null;
		
		return SUCCESS;
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
