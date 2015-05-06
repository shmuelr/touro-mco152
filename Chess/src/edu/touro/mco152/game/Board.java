package edu.touro.mco152.game;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.management.RuntimeErrorException;

import edu.touro.mco152.pieces.AbstractChessPiece;
import edu.touro.mco152.pieces.Bishop;
import edu.touro.mco152.pieces.King;
import edu.touro.mco152.pieces.Knight;
import edu.touro.mco152.pieces.Pawn;
import edu.touro.mco152.pieces.PieceColor;
import edu.touro.mco152.pieces.PieceConstants;
import edu.touro.mco152.pieces.Queen;
import edu.touro.mco152.pieces.Rook;

class Board {

	
	
	private final AbstractChessPiece[][] pieces = new AbstractChessPiece[Game.Constants.DEFAULT_BOARD_SIZE][Game.Constants.DEFAULT_BOARD_SIZE];
	

	
	
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
		for (int i=0;i< Game.Constants.DEFAULT_BOARD_SIZE;i++)
		for (int j=Game.Constants.DEFAULT_BOARD_SIZE-1;j>=0;j--)
		pieces[j][i]= generatePiece(s.charAt(length--));
	}
	
	public AbstractChessPiece generatePiece(char c) {
		
		switch(c) {
			case 'P': return Pawn.buildPawn(PieceColor.WHITE);
			case 'p': return Pawn.buildPawn(PieceColor.BLACK);
			
			case 'R': return Rook.buildRook(PieceColor.WHITE);
			case 'r': return Rook.buildRook(PieceColor.BLACK);
			
			case 'N': return Knight.buildKnight(PieceColor.WHITE);
			case 'n': return Knight.buildKnight(PieceColor.BLACK);
			
			case 'B': return Bishop.buildBishop(PieceColor.WHITE);
			case 'b': return Bishop.buildBishop(PieceColor.BLACK);
			
			case 'K': return King.buildKing(PieceColor.WHITE);
			case 'k': return King.buildKing(PieceColor.BLACK);
			
			case 'Q': return Queen.buildQueen(PieceColor.WHITE);
			case 'q': return Queen.buildQueen(PieceColor.BLACK);
			
			case '.': return null;
			
			default: throw new RuntimeErrorException(new Error("Char "+ c +" has not be implemented?"));
		}
	}
	
	private List<AbstractChessPiece> getListOfPieces(){
		List<AbstractChessPiece> chessPieces = new ArrayList<>(Game.Constants.MAX_PIECE_COUNT);
		
		for (int i = 0; i < Game.Constants.DEFAULT_BOARD_SIZE; i++){
			for (int j = 0; j < Game.Constants.DEFAULT_BOARD_SIZE; j++){
				if(pieces[i][j] != null){
					chessPieces.add(pieces[i][j]);
				}
			}
		}
		
		return chessPieces;
	}
	
	public List<AbstractChessPiece> getListOfPieces(PieceColor color)
	{
		
		List<AbstractChessPiece> chessPieces = getListOfPieces();
		List<AbstractChessPiece> chessPiecesByColor = new ArrayList<>(Game.Constants.MAX_PIECE_COUNT/2);
		
			for (AbstractChessPiece piece : chessPieces){
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
	
	public int getAmtOfSpecificPiece(AbstractChessPiece chessPiece){
		int count = 0;
		for (AbstractChessPiece piece : getListOfPieces()){
			if (piece.equals(chessPiece)){
				count++;
			}
		}
		return count;
	}

	public AbstractChessPiece getPiece(char x, int y)
	{
		return getPiece(Position.buildPostionFromChessCoords(x, y));
	}
	
	private AbstractChessPiece getPiece(Position position)
	{
		return pieces[position.getX()][position.getY()];
	}
	
	

	
	
	
	
	public void movePiece(Position from, Position to){
		
		pieces[to.getX()][to.getY()] = pieces[from.getX()][from.getY()];
		pieces[from.getX()][from.getY()] = null;
		
		pieces[to.getX()][to.getY()].setMoved();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public String printBoard() {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("  abcdefgh\n");

		for(int y = 0; y < Game.Constants.DEFAULT_BOARD_SIZE; y++){
			stringBuilder.append(Game.Constants.DEFAULT_BOARD_SIZE - y);
			stringBuilder.append(" ");
			
			for(int x = 0; x< Game.Constants.DEFAULT_BOARD_SIZE; x++){
				
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
	public AbstractChessPiece getPieceAtPostion(Position position) {
		return pieces[position.getX()][position.getY()];
	}
	public boolean existsPieceAtPosition(Position position) {
		return getPieceAtPostion(position) != null;
	}

}
