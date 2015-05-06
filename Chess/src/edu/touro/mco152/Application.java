package edu.touro.mco152;

import java.util.Scanner;

import edu.touro.mco152.game.Game;

public class Application {

	public static void main(String[] args) {
		Game game = Game.buildNewGame();
		
		System.out.println("Welcome to the chess game.\n\nYou can move pieces by typing move a3 d4.\nType 's' to dispay the board strength.\nType exit to exit the game.\n\nEnjoy!\n");
		System.out.println(game.printBoard());
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		String output;
		while(game.isPlaying()){
			
			output = game.proccessUserInput(input);
			
			System.out.println(output);

			input = scanner.nextLine();
		}
		
		scanner.close();
	}

	

}
