package edu.touro.mco152.tests;

import static org.junit.Assert.*;

import java.awt.GraphicsDevice.WindowTranslucency;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.touro.mco152.Board;
import edu.touro.mco152.GameLogic;
import edu.touro.mco152.pieces.ChessPiece;
import edu.touro.mco152.pieces.*;
import edu.touro.mco152.pieces.ChessPiece.*;

public class BoardTest {
	

	@Test
	public void testCreateBoard() {
		Board board = new Board();
		assertTrue(board != null);
	}
	

	@Test
	public void testBoardGetListPiecesForColor() {
		Board board = new Board();
		board.setupBoard();
		List<ChessPiece> listOfBlackPieces = board.getListOfPieces(PieceColor.BLACK);
		assertTrue(listOfBlackPieces.size() == 16);
	}
	
	@Test
	public void testBoardGetSortedListPiecesForColor() {
		Board board = new Board();
		board.setupBoard();
		List<ChessPiece> listOfBlackPieces = board.getListOfPieces(PieceColor.BLACK);
		
		// The King should be first because it has the lowest value
		assertTrue(listOfBlackPieces.get(0).equals(new King(PieceColor.BLACK)));
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
		board.addPieceToBoard(new Pawn(PieceColor.BLACK), 'a', 1);
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
		assertEquals(2, board.getAmtOfSpecificPiece(new Bishop(PieceColor.BLACK)));
	}
	
	@Test
	public void testGetPiece(){
		Board board = new Board();
		board.setupBoard();

		assertEquals(new Bishop(PieceColor.BLACK), board.getPiece('c', 8));
	}
	
	@Test
	public void testBoardPrintWhenAddPieceToBoard() {
		Board board = new Board();
		
		board.addPieceToBoard(new Pawn (PieceColor.BLACK), 'a', 2);
		
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
		board.addPieceToBoard(new Pawn(PieceColor.BLACK), 'a', 1);
		assertFalse(board.addPieceToBoard(new Pawn (PieceColor.BLACK), 'a', 1));
	}
	
	@Test
	public void testRemovePieceFromBoard() {
		Board board = new Board();
		board.addPieceToBoard(new Pawn(PieceColor.BLACK), 'a', 1);
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
