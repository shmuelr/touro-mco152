package edu.touro.mco152.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.touro.mco152.Board;
import edu.touro.mco152.GameLogic;
import edu.touro.mco152.Position;
import edu.touro.mco152.pieces.*;
import edu.touro.mco152.pieces.ChessPiece.PieceColor;

public class GameLogicTest {
	@Test
	public void testMovingKing() {
		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		board.addPieceToBoard(new King(PieceColor.BLACK), 'd', 2);
		assertTrue(testLogic.movePiece('d', 2, 'd', 3) == testLogic.MOVE_SUCCESS);
	}

	@Test
	public void testMovingKingError() {
		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		board.addPieceToBoard(new King(PieceColor.BLACK), 'd', 2);
		assertTrue(testLogic.movePiece('d', 2, 'd', 4) == testLogic.MOVE_ERROR_INVALID_MOVE);
	}

	@Test
	public void testMovingQueenStreight() {
		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		board.addPieceToBoard(new Queen(PieceColor.BLACK), 'd', 2);
		assertTrue(testLogic.movePiece('d', 2, 'd', 3) == testLogic.MOVE_SUCCESS);
	}
	
	
	//isn't working, can't figure out why. isDiagonal works fine.
	@Test
	public void testMovingQueenDiagonal() {
		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		board.addPieceToBoard(new Queen(PieceColor.BLACK), 'd', 2);
		assertTrue(testLogic.movePiece('d', 2, 'e', 3) == testLogic.MOVE_SUCCESS);
	}
	
	@Test
	public void isDiagonalTest()
	{
		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		Position p1 = new Position(0,0);
		Position p2 = new Position(7,7);
		assertTrue(testLogic.isDiagonal(p1, p2));
		assertTrue(testLogic.isDiagonal(p2, p1));
	}
	

	@Test
	public void testMovingBishop() {

		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		board.addPieceToBoard(new Bishop(PieceColor.BLACK), 'd', 2);
		assertTrue(testLogic.movePiece('d', 2, 'e', 3) == testLogic.MOVE_SUCCESS);
	}

	@Test
	public void testMovingKNIGHT() {
		// TODO fill in
	}

	@Test
	public void testMovingRook() {
		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		board.addPieceToBoard(new Rook(PieceColor.BLACK), 'd', 2);
		assertTrue(testLogic.movePiece('d', 2, 'd', 6) == testLogic.MOVE_SUCCESS);
	}

	@Test
	public void testMovingRook2() {
		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		board.addPieceToBoard(new Rook(PieceColor.BLACK), 'd', 2);
		board.addPieceToBoard(new Pawn(PieceColor.WHITE), 'd', 6);
		assertTrue(testLogic.movePiece('d', 2, 'd', 6) == testLogic.MOVE_SUCCESS);
	}

	@Test
	public void testMovingRookError() {
		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		board.addPieceToBoard(new Rook(PieceColor.BLACK), 'd', 2);
		assertTrue(testLogic.movePiece('d', 2, 'a', 6) == testLogic.MOVE_ERROR_INVALID_MOVE);
	}

	@Test
	public void testMovingRookError2() {
		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		board.addPieceToBoard(new Rook(PieceColor.BLACK), 'd', 2);
		board.addPieceToBoard(new Pawn(PieceColor.BLACK), 'd', 3);
		assertTrue(testLogic.movePiece('d', 2, 'd', 6) == testLogic.MOVE_ERROR_INVALID_MOVE);
	}

	@Test
	public void testMovingRookError3() {
		Board board = new Board();
		GameLogic testLogic = new GameLogic(board);
		board.addPieceToBoard(new Rook(PieceColor.BLACK), 'd', 2);
		board.addPieceToBoard(new Pawn(PieceColor.WHITE), 'd', 5);
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
		assertTrue(testLogic.getBoardStrength(PieceColor.WHITE) == testLogic
				.getBoardStrength(PieceColor.BLACK));
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

}
