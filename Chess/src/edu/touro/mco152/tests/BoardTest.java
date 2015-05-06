package edu.touro.mco152.tests;

import static org.junit.Assert.*;

import java.awt.GraphicsDevice.WindowTranslucency;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.touro.mco152.Board;
import edu.touro.mco152.GameLogic;
import edu.touro.mco152.pieces.ChessPiece;
import edu.touro.mco152.pieces.ChessPiece.PieceColor;
import edu.touro.mco152.pieces.ChessPiece.Type;

public class BoardTest {
	

	@Test
	public void testCreateBoard() {
		Board board = new Board();
		assertTrue(board != null);
	}
	
	@Test
	public void testMovingKing() {
		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		board.addPieceToBoard(ChessPiece.buildNewPiece(Type.KING, PieceColor.BLACK), 'd',2);
		assertTrue(testLogic.movePiece('d', 2, 'd', 3) == testLogic.MOVE_SUCCESS);
	}
	
	@Test
	public void testMovingKingError() {
		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		board.addPieceToBoard(ChessPiece.buildNewPiece(Type.KING, PieceColor.BLACK), 'd',2);
		assertTrue(testLogic.movePiece('d', 2, 'd', 4) == testLogic.MOVE_ERROR_INVALID_MOVE);
	}
	
	@Test
	public void testMovingQueen() {
		//TODO fill in
	}
	
	@Test
	public void testMovingBishop() {
		//TODO fill in
	}
	@Test
	public void testMovingKnight() {
		//TODO fill in
	}
	
	@Test
	public void testMovingRook() {
		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		board.addPieceToBoard(ChessPiece.buildNewPiece(Type.ROOK, PieceColor.BLACK), 'd',2);
		assertTrue(testLogic.movePiece('d', 2, 'd', 6) == testLogic.MOVE_SUCCESS);
	}
	
	@Test
	public void testMovingRook2() {
		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		board.addPieceToBoard(ChessPiece.buildNewPiece(Type.ROOK, PieceColor.BLACK), 'd',2);
		board.addPieceToBoard(ChessPiece.buildNewPiece(Type.PAWN, PieceColor.WHITE), 'd',6);
		assertTrue(testLogic.movePiece('d', 2, 'd', 6) == testLogic.MOVE_SUCCESS);
	}
	
	@Test
	public void testMovingRookError() {
		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		board.addPieceToBoard(ChessPiece.buildNewPiece(Type.ROOK, PieceColor.BLACK), 'd',2);
		assertTrue(testLogic.movePiece('d', 2, 'a', 6) == testLogic.MOVE_ERROR_INVALID_MOVE);
	}
	
	@Test
	public void testMovingRookError2() {
		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		board.addPieceToBoard(ChessPiece.buildNewPiece(Type.ROOK, PieceColor.BLACK), 'd',2);
		board.addPieceToBoard(ChessPiece.buildNewPiece(Type.PAWN, PieceColor.BLACK), 'd',3);
		assertTrue(testLogic.movePiece('d', 2, 'd', 6) == testLogic.MOVE_ERROR_INVALID_MOVE);
	}
	
	@Test
	public void testMovingRookError3() {
		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		board.addPieceToBoard(ChessPiece.buildNewPiece(Type.ROOK, PieceColor.BLACK), 'd',2);
		board.addPieceToBoard(ChessPiece.buildNewPiece(Type.PAWN, PieceColor.WHITE), 'd',5);
		assertTrue(testLogic.movePiece('d', 2, 'd', 6) == testLogic.MOVE_ERROR_INVALID_MOVE);
	}
	
	@Test
	public void testMovingPawn() {
		Board board = new Board();
		board.setupBoard();
		GameLogic testLogic = new GameLogic(board);
		assertTrue(testLogic.movePiece('a', 2, 'a', 3) == testLogic.MOVE_SUCCESS);
	}
	
	@Test
	public void testMovingPawnDoubleSpace() {
		Board board = new Board();
		board.setupBoard();
		GameLogic testLogic = new GameLogic(board);
		assertTrue(testLogic.movePiece('a', 2, 'a', 4) == testLogic.MOVE_SUCCESS);
	}
	
	@Test
	public void testMovingPawnNoDoubleSpace() {
		Board board = new Board();
		board.setupBoard();
		GameLogic testLogic = new GameLogic(board);
		testLogic.movePiece('a', 2, 'a', 3);
		assertTrue(testLogic.movePiece('a', 3, 'a', 5) == testLogic.MOVE_ERROR_INVALID_MOVE);
	}
	
	@Test
	public void testBoardStrength() {
		Board board = new Board();
		board.setupBoard();
		GameLogic testLogic = new GameLogic(board);
		assertTrue(testLogic.getBoardStrength(PieceColor.WHITE) == testLogic.getBoardStrength(PieceColor.BLACK));
	}
	
	
	@Test
	public void testBoardStrengthByValue() {
		Board board = new Board();
		board.setupBoard();
		GameLogic testLogic = new GameLogic(board);
		assertTrue(testLogic.getBoardStrength(PieceColor.WHITE) == 38.0);
	}
	
	@Test
	public void testBoardStrengthPawnOverlap() {
		Board board = new Board();
		board.setupBoard();
		GameLogic testLogic = new GameLogic(board);
		testLogic.movePiece('a', 2, 'b', 3);
		assertTrue(testLogic.getBoardStrength(PieceColor.WHITE) == 37.0);
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
		
		// The king should be first because it has the lowest value
		assertTrue(listOfBlackPieces.get(0).equals(ChessPiece.buildNewPiece(Type.KING, PieceColor.BLACK)));
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
		board.addPieceToBoard(ChessPiece.buildNewPiece(Type.PAWN,PieceColor.BLACK), 'a', 1);
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
		assertEquals(2, board.getAmtOfSpecificPiece(ChessPiece.buildNewPiece(Type.BISHOP, PieceColor.BLACK)));
	}
	
	@Test
	public void testGetPiece(){
		Board board = new Board();
		board.setupBoard();

		assertEquals(ChessPiece.buildNewPiece(Type.BISHOP, PieceColor.BLACK), board.getPiece('c', 8));
	}
	
	@Test
	public void testBoardPrintWhenAddPieceToBoard() {
		Board board = new Board();
		
		board.addPieceToBoard(ChessPiece.buildNewPiece(Type.PAWN,PieceColor.BLACK), 'a', 2);
		
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
		board.addPieceToBoard(ChessPiece.buildNewPiece(Type.PAWN,PieceColor.BLACK), 'a', 1);
		assertFalse(board.addPieceToBoard(ChessPiece.buildNewPiece(Type.PAWN,PieceColor.BLACK), 'a', 1));
	}
	
	@Test
	public void testRemovePieceFromBoard() {
		Board board = new Board();
		board.addPieceToBoard(ChessPiece.buildNewPiece(Type.PAWN,PieceColor.BLACK), 'a', 1);
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
