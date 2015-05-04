package edu.touro.mco152;

public class Game {

	private Board board;
	
	public Game(){
		
		board = new Board();
		
		startGame();
	}
	
	private void startGame(){
		
		board.setupBoard();
		
	}
}
