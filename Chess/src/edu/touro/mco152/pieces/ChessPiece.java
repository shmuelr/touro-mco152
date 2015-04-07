package edu.touro.mco152.pieces;


public class ChessPiece {
	public static enum PieceColor {
		BLACK, WHITE
		}
	
	
			public static enum Type{
			PAWN('P',1), KNIGHT('N', 2.5), BISHOP('B',3), ROOK('R',5), KING('K',0), QUEEN('Q',9);
			char representation;
			double value;
			Type(char representation, double value){
			this.representation = representation;
			this.value = value;
		}
	}
	
			
			
	protected final PieceColor color;
	private final Type type;
	private final char pieceChar;
	
	
	public ChessPiece(Type type, PieceColor color){
		this.type = type;
		this.color = color;
		pieceChar = isWhite() ? 
				Character.toUpperCase(type.representation) : 
					Character.toLowerCase(type.representation);
		}
	 public static ChessPiece getPiece(Type type, PieceColor color){
		 return new ChessPiece(type, color);
		 }

	/**
	 * creates black pieces
	 */
	
	public PieceColor getColor()
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
		return Character.toString(pieceChar);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ChessPiece){
			return obj.toString().equals(this.toString());
		}
		return false;
	}
}
