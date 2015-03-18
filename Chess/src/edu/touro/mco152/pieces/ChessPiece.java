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

	
	public static ChessPiece getBlackPawn(){
		ChessPiece blackPawn = new ChessPiece('P', PieceColor.BLACK);
		return blackPawn;
	}
	
	public static ChessPiece getBlackKnight(){
		ChessPiece whitePawn = new ChessPiece('N', PieceColor.BLACK);
		return whitePawn;
	}
	public static ChessPiece getBlackBishop(){
		ChessPiece whitePawn = new ChessPiece('B', PieceColor.BLACK);
		return whitePawn;
	}
	public static ChessPiece getBlackRook(){
		ChessPiece whitePawn = new ChessPiece('R', PieceColor.BLACK);
		return whitePawn;
	}
	public static ChessPiece getBlackKing(){
		ChessPiece whitePawn = new ChessPiece('K', PieceColor.BLACK);
		return whitePawn;
	}
	public static ChessPiece getBlackQueen(){
		ChessPiece whitePawn = new ChessPiece('Q', PieceColor.BLACK);
		return whitePawn;
	}
	
	
	
	
	public static ChessPiece getWhitePawn(){
		ChessPiece whitePawn = new ChessPiece('P', PieceColor.WHITE);
		return whitePawn;
	}
	
	public static ChessPiece getWhiteKnight(){
		ChessPiece whitePawn = new ChessPiece('N', PieceColor.WHITE);
		return whitePawn;
	}
	public static ChessPiece getWhiteBishop(){
		ChessPiece whitePawn = new ChessPiece('B', PieceColor.WHITE);
		return whitePawn;
	}
	public static ChessPiece getWhiteRook(){
		ChessPiece whitePawn = new ChessPiece('R', PieceColor.WHITE);
		return whitePawn;
	}
	public static ChessPiece getWhiteKing(){
		ChessPiece whitePawn = new ChessPiece('K', PieceColor.WHITE);
		return whitePawn;
	}
	public static ChessPiece getWhiteQueen(){
		ChessPiece whitePawn = new ChessPiece('Q', PieceColor.WHITE);
		return whitePawn;
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
