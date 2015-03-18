package edu.touro.mco152;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Board board = new Board();
		board.setupBoard();
		
		System.out.println("Welcome to the chess game. You can move pieces by typeing move a3 d4. Type exit to exit the game. Enjoy!");
		System.out.println(board.printBoard());
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		
		while(!input.equals("exit")){
			
			if (input.startsWith("move")){
				String[] instruction = input.split(" ");
				int result =
				board.movePiece(instruction[1].charAt(0), 
						Character.getNumericValue(instruction[1].charAt(1)),
						instruction[2].charAt(0),
						Character.getNumericValue(instruction[2].charAt(1))
						);
				
				System.out.println("Result = "+result);
			}
			
			System.out.println(board.printBoard());
			input = scanner.nextLine();
		}
		
	}

}
