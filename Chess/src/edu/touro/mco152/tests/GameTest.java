package edu.touro.mco152.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.touro.mco152.Game;
import edu.touro.mco152.pieces.ChessPiece.PieceColor;

public class GameTest {	
	

	@Test
	public void testStartGame() {

		Game game = new Game();
	    
	}
	
	@Test
	public void testBoardStrength() {
		Game game = new Game();		
		assertTrue(game.getBoardStrength(PieceColor.WHITE) == game.getBoardStrength(PieceColor.BLACK));
	}	
	
	@Test
	public void testBoardStrengthByValue() {
		Game game = new Game();	
		
		assertTrue(game.getBoardStrength(PieceColor.WHITE) == 38.0);
	}
	
	@Test
	public void testBoardStrengthPawnOverlap() {
		Game game = new Game();	
		game.movePiece('a', 2, 'b', 3);
		assertTrue(game.getBoardStrength(PieceColor.WHITE) == 37.0);
	}

}
