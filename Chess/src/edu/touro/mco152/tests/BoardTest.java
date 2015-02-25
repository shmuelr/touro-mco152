package edu.touro.mco152.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.touro.mco152.Board;
import edu.touro.mco152.Pawn;

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
		assertEquals(16, board.getAmtOfPieces());
	}

	@Test
	public void testSizeCountWhenAddPieceToBoard() {
		Board board = new Board();
		int boardSize = board.getAmtOfPieces();
		board.addPieceToBoard(new Pawn(), 'a', 1);
		assertEquals(boardSize+1, board.getAmtOfPieces());
	}
	
	@Test
	public void testBoardPrintWhenAddPieceToBoard() {
		Board board = new Board();
		
		board.addPieceToBoard(new Pawn(), 'a', 1);
		
		String boardPrintOut = board.printBoard();
		String excpectedOutPut = 
				"Printing complete board:\n"
				+ "  abcdefgh\n"
				+ "8 ........\n"
				+ "7 ........\n"
				+ "6 ........\n"
				+ "5 ........\n"
				+ "4 ........\n"
				+ "3 ........\n"
				+ "2 ........\n"
				+ "1 p.......\n";
		System.out.println(boardPrintOut);
		assertTrue(boardPrintOut.equals(excpectedOutPut));
	}
	
	@Test
	public void testAddPieceToBoardWithConflict() {
		Board board = new Board();
		int boardSize = board.getAmtOfPieces();
		board.addPieceToBoard(new Pawn(), 'a', 1);
		assertFalse(board.addPieceToBoard(new Pawn(), 'a', 1));
	}
	
	@Test
	public void testRemovePieceFromBoard() {
		Board board = new Board();
		board.addPieceToBoard(new Pawn(), 'a', 1);
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
				"Printing complete board:\n"
				+ "  abcdefgh\n"
				+ "8 ........\n"
				+ "7 pppppppp\n"
				+ "6 ........\n"
				+ "5 ........\n"
				+ "4 ........\n"
				+ "3 ........\n"
				+ "2 PPPPPPPP\n"
				+ "1 ........\n";
		
		assertTrue(boardPrintOut.equals(excpectedOutPut));
	}

}
