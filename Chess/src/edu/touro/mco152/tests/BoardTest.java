package edu.touro.mco152.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.touro.mco152.Board;
import edu.touro.mco152.pieces.ChessPiece;
import edu.touro.mco152.pieces.ChessPiece.PieceColor;
import edu.touro.mco152.pieces.ChessPiece.Type;

public class BoardTest {

	@Test
	public void testBoard() {
		Board board = new Board();
		assertTrue(board != null);
	}
	
	@Test
	public void testBoardSize() {
		Board board = new Board();
		board.setupBoard();
		assertEquals(32, board.getAmtOfPieces());
	}

	@Test
	public void testSizeCountWhenAddPieceToBoard() {
		Board board = new Board();
		int boardSize = board.getAmtOfPieces();
		board.addPieceToBoard(ChessPiece.getPiece(Type.PAWN,PieceColor.BLACK), 'a', 1);
		assertEquals(boardSize+1, board.getAmtOfPieces());
	}
	
	@Test
	public void testCountTotalBlackPieces(){
		Board board = new Board();
		board.setupBoard();
		assertEquals(16, board.getAmtOfPiecesByColor(PieceColor.BLACK));
	}
	
	@Test
	public void testCountTotalWhitePieces(){
		Board board = new Board();
		board.setupBoard();
		assertEquals(16, board.getAmtOfPiecesByColor(PieceColor.WHITE));
	}
	
	
	@Test
	public void testCountSpecificPieces(){
		Board board = new Board();
		board.setupBoard();
		assertEquals(2, board.getAmtOfSpecificPiece(ChessPiece.getPiece(Type.BISHOP, PieceColor.BLACK)));
	}
	
	
	@Test
	public void testBoardPrintWhenAddPieceToBoard() {
		Board board = new Board();
		
		board.addPieceToBoard(ChessPiece.getPiece(Type.PAWN,PieceColor.BLACK), 'a', 2);
		
		String boardPrintOut = board.printBoard();
		String excpectedOutPut = 
				"  abcdefgh\n"
				+ "8 ........\n"
				+ "7 ........\n"
				+ "6 ........\n"
				+ "5 ........\n"
				+ "4 ........\n"
				+ "3 ........\n"
				+ "2 p.......\n"
				+ "1 ........\n";
		
		assertTrue(boardPrintOut.equals(excpectedOutPut));
	}
	
	@Test
	public void testAddPieceToBoardWithConflict() {
		Board board = new Board();
		board.addPieceToBoard(ChessPiece.getPiece(Type.PAWN,PieceColor.BLACK), 'a', 1);
		assertFalse(board.addPieceToBoard(ChessPiece.getPiece(Type.PAWN,PieceColor.BLACK), 'a', 1));
	}
	
	@Test
	public void testRemovePieceFromBoard() {
		Board board = new Board();
		board.addPieceToBoard(ChessPiece.getPiece(Type.PAWN,PieceColor.BLACK), 'a', 1);
		assertTrue(board.removePieceFromBoard('a', 1));
	}
	
	@Test
	public void testRemoveNonExistantPieceFromBoard() {
		Board board = new Board();
		assertFalse(board.removePieceFromBoard('a', 1));
	}

	@Test
	public void testPrintBoard() {
		Board board = new Board();
		board.setupBoard();
		String boardPrintOut = board.printBoard();
		String excpectedOutPut = 
				"  abcdefgh\n"
				+ "8 rnbqkbnr\n"
				+ "7 pppppppp\n"
				+ "6 ........\n"
				+ "5 ........\n"
				+ "4 ........\n"
				+ "3 ........\n"
				+ "2 PPPPPPPP\n"
				+ "1 RNBQKBNR\n";
		System.out.println(boardPrintOut);
		assertTrue(boardPrintOut.equals(excpectedOutPut));
	}

}
