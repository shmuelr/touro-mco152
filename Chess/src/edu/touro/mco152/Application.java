package edu.touro.mco152;

import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import edu.touro.mco152.pieces.ChessPiece;
import edu.touro.mco152.pieces.ChessPiece.PieceColor;

public class Application {

	public static void main(String[] args) {
		/*Board board = new Board();
		board.setupBoard();
		
		System.out.println("Welcome to the chess game.\n\nYou can move pieces by typing move a3 d4.\nType 's' to dispay the board strength.\nType exit to exit the game.\n\nEnjoy!\n");
		System.out.println(board.printBoard());
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		
		while(!input.equals("exit")){
			
			if (input.startsWith("move")){
				String[] instruction = input.split(" ");
				//int result =
				/*board.movePiece(instruction[1].charAt(0), 
						Character.getNumericValue(instruction[1].charAt(1)),
						instruction[2].charAt(0),
						Character.getNumericValue(instruction[2].charAt(1))
						);*/
				
				//printMessageForMoveResult(result);

				/*
			}else if(input.equals("s")){
				
				System.out.println("Black board strength = "+board.getBoardStrength(PieceColor.BLACK));
				for(ChessPiece p :board.getListOfPieces(PieceColor.BLACK))System.out.print(p);
				System.out.println(" ");
				
				
				System.out.println("White board strength = "+board.getBoardStrength(PieceColor.WHITE));
				for(ChessPiece p :board.getListOfPieces(PieceColor.WHITE))System.out.print(p);
				System.out.println(" ");
				
				
			}
			
			
			
			
			System.out.println(board.printBoard());
			input = scanner.nextLine();
		}
		
	}

	private static void printMessageForMoveResult(int result) {
		
		if(result == Board.MOVE_ERROR_NO_SOURCE_PIECE){
			System.out.println("Error: no piece in the source position");
		}else if(result == Board.MOVE_ERROR_PIECE_IN_DESTINATION){
			System.out.println("Error: destination occupied");
		}else if(result == Board.MOVE_ERROR_INVALID_MOVE){
			System.out.println("Error: invalid move");
		}else if(result == Board.MOVE_ERROR_INVALID_POSITION){
			System.out.println("Error: invalid position");
		}
		
		
	}*/
	}

}
