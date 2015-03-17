package edu.touro.mco152.pieces;


public class ChessPiece {
	public static enum PieceColor {
		BLACK, WHITE
	}
	
	protected final PieceColor color;
	protected final char pieceLabel;
	
	public ChessPiece(char pieceLabel, PieceColor color){
		this.pieceLabel = pieceLabel;
		this.color = color;
	}

	/**
	 * creates black pieces
	 */
	public static ChessPiece getBlackPawn(){
		ChessPiece blackPawn = new ChessPiece('P', PieceColor.BLACK);
		return blackPawn;
	}
	
	public static ChessPiece getBlackKnight(){
		ChessPiece blackKnight = new ChessPiece('N', PieceColor.BLACK);
		return blackKnight;
	}
	public static ChessPiece getBlackBishop(){
		ChessPiece blackBishop = new ChessPiece('B', PieceColor.BLACK);
		return blackBishop;
	}
	public static ChessPiece getBlackRook(){
		ChessPiece blackRook = new ChessPiece('R', PieceColor.BLACK);
		return blackRook;
	}
	public static ChessPiece getBlackKing(){
		ChessPiece blackKing = new ChessPiece('K', PieceColor.BLACK);
		return blackKing;
	}
	public static ChessPiece getBlackQueen(){
		ChessPiece blackQueen = new ChessPiece('Q', PieceColor.BLACK);
		return blackQueen;
	}
	
	/**
	 * creates white pieces
	 */
	
	public static ChessPiece getWhitePawn(){
		ChessPiece whitePawn = new ChessPiece('P', PieceColor.WHITE);
		return whitePawn;
	}
	
	public static ChessPiece getWhiteKnight(){
		ChessPiece whiteKnight = new ChessPiece('N', PieceColor.WHITE);
		return whiteKnight;
	}
	public static ChessPiece getWhiteBishop(){
		ChessPiece whiteBishop = new ChessPiece('B', PieceColor.WHITE);
		return whiteBishop;
	}
	public static ChessPiece getWhiteRook(){
		ChessPiece whiteRook = new ChessPiece('R', PieceColor.WHITE);
		return whiteRook;
	}
	public static ChessPiece getWhiteKing(){
		ChessPiece whiteKing = new ChessPiece('K', PieceColor.WHITE);
		return whiteKing;
	}
	public static ChessPiece getWhiteQueen(){
		ChessPiece whiteQueen = new ChessPiece('Q', PieceColor.WHITE);
		return whiteQueen;
	}
	
	
	
	private PieceColor getColor()
	{
		return color;
	}

	public boolean isWhite(){
		return color == PieceColor.WHITE;
	}
	
	public boolean isBlack(){
		return color == PieceColor.BLACK;
	}
	

	/**
	 * Using toString() like this will enable us to easily print the board.
	 * Each piece will know its color and label and then toString() will print either upper or lowercase
	 */
	
	@Override
	public String toString() 
	{
		return isWhite() ? 
				Character.toString(Character.toUpperCase(pieceLabel)) : 
					Character.toString(Character.toLowerCase(pieceLabel));
	}
	
}
