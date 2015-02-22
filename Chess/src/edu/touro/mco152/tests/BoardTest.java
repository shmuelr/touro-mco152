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
		assertEquals(16, board.getAmtOfPieces());
	}

	@Test
	public void testAddPieceToBoard() {
		Board board = new Board();
		int boardSize = board.getAmtOfPieces();
		board.addPieceToBoard(new Pawn());
		assertEquals(boardSize+1, board.getAmtOfPieces());
	}

	@Test
	public void testPrintBoard() {
		Board board = new Board();
		String boardPrintOut = board.printBoard();
		String excpectedOutPut = 
				"Printing complete board:\n"
				+ "  abcdefgh\n"
				+ "1 ........\n"
				+ "2 pppppppp\n"
				+ "3 ........\n"
				+ "4 ........\n"
				+ "5 ........\n"
				+ "6 ........\n"
				+ "7 PPPPPPPP\n"
				+ "8 ........\n";
		
		assertTrue(boardPrintOut.equals(excpectedOutPut));
	}

}
