package edu.touro.mco152;

import java.util.Scanner;

import edu.touro.mco152.game.Game;

public class Application {

	public static void main(String[] args) {
		Game game = Game.buildNewGame();
		
		System.out.println(Game.Constants.GAME_INSTRUCTIONS);
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
