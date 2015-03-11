package edu.touro.mco152;

public class Application {

	public static void main(String[] args) {
		Board board = new Board();
		board.setupBoard();
		System.out.println(board.printBoard());
		
	}

}
