package edu.touro.mco152.pieces;


public class ChessPiece implements Comparable<ChessPiece>{
	
	public static double PAWN_VALUE 	= 1.0;
	public static double KNIGHT_VALUE 	= 2.5;
	public static double BISHOP_VALUE 	= 3.0;
	public static double ROOK_VALUE 	= 5.0;
	public static double QUEEN_VALUE 	= 9.0;
	public static double KING_VALUE 	= 0.0;
	
	
	public static enum Type{
		PAWN('P', PAWN_VALUE), KNIGHT('N', KNIGHT_VALUE), BISHOP('B', BISHOP_VALUE), ROOK('R', ROOK_VALUE), QUEEN('Q', QUEEN_VALUE), KING('K', KING_VALUE);
		
		private char representation;
		private double value;
		
		Type(char representation, double value){
			this.representation = representation;
			this.value = value;
		}
		
		public double getValue(){
			return value;
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
	
	 public static ChessPiece buildNewPiece(Type type, PieceColor color)
	 {
		 return new ChessPiece(type, color);
	 }

	
	public PieceColor getColor()
	{
		return color;
	}

	public Type getType() 
	{
		return type;
	}
	
	public double getValue()
	{
		return type.getValue();
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

	@Override
	public int compareTo(ChessPiece that) 
	{
		final int LESS = -1;
	    final int EQUAL = 0;
	    final int GREATER = 1;
		
		if(this.getValue() > that.getValue()){
			return GREATER;
		}
		if (this.getValue() < that.getValue()){
			return LESS;
		}
		
		return EQUAL;
	}


	
	
}
