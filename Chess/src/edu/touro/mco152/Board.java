package edu.touro.mco152;



import edu.touro.mco152.pieces.ChessPiece;
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
		addRooksToBoard();
		addKnitesToBoard();
		addBishopsToBoard();
		addQueensToBoard();
		addKingsToBoard();
	}
	
	private void addKingsToBoard() {
		addPieceToBoard(ChessPiece.getBlackKing(), 'e', 8);
		addPieceToBoard(ChessPiece.getWhiteKing(), 'e', 1);
	}

	private void addQueensToBoard() {
		addPieceToBoard(ChessPiece.getBlackQueen(), 'd', 8);
		addPieceToBoard(ChessPiece.getWhiteQueen(), 'd', 1);
	}

	private void addBishopsToBoard() {
		addPieceToBoard(ChessPiece.getBlackBishop(), 'c', 8);
		addPieceToBoard(ChessPiece.getBlackBishop(), 'f', 8);
		addPieceToBoard(ChessPiece.getWhiteBishop(), 'c', 1);
		addPieceToBoard(ChessPiece.getWhiteBishop(), 'f', 1);
	}

	private void addKnitesToBoard() {
		addPieceToBoard(ChessPiece.getBlackKnight(), 'b', 8);
		addPieceToBoard(ChessPiece.getBlackKnight(), 'g', 8);
		addPieceToBoard(ChessPiece.getWhiteKnight(), 'b', 1);
		addPieceToBoard(ChessPiece.getWhiteKnight(), 'g', 1);
	}

	private void addRooksToBoard() {
		addPieceToBoard(ChessPiece.getBlackRook(), 'a', 8);
		addPieceToBoard(ChessPiece.getBlackRook(), 'h', 8);
		addPieceToBoard(ChessPiece.getWhiteRook(), 'a', 1);
		addPieceToBoard(ChessPiece.getWhiteRook(), 'h', 1);
	}

	private void addPawnsToBoard(){
		
		
		for(int x = 0; x < DEFAULT_BOARD_SIZE; x++){
			pieces[x][1] = ChessPiece.getBlackPawn();
		}
		
		for(int x = 0; x < DEFAULT_BOARD_SIZE; x++){
			pieces[x][6] = ChessPiece.getWhitePawn();
		}
			
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
	
	
	
	
	
	public String printBoard() {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Printing complete board:\n");
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
