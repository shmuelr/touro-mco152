package edu.touro.mco152;

import edu.touro.mco152.pieces.Bishop;
import edu.touro.mco152.pieces.ChessPiece;
import edu.touro.mco152.pieces.ChessPiece.PieceColor;
import edu.touro.mco152.pieces.King;
import edu.touro.mco152.pieces.Knight;
import edu.touro.mco152.pieces.Pawn;
import edu.touro.mco152.pieces.Queen;
import edu.touro.mco152.pieces.Rook;

public class GameLogic {

	public static final int MOVE_SUCCESS = 1;
	public static final int MOVE_ERROR_NO_SOURCE_PIECE = -1;
	public static final int MOVE_ERROR_NO_DESTINATION_PIECE = -2;
	public static final int MOVE_ERROR_PIECE_IN_DESTINATION = -3;
	public static final int MOVE_ERROR_INVALID_MOVE = -4;
	public static final int MOVE_ERROR_INVALID_POSITION = -5;
	public final int DEFAULT_BOARD_SIZE;
	private Board gameBoard;
	private ChessPiece[][] pieces;

	public GameLogic(Board inputBoard) {
		gameBoard = inputBoard;
		DEFAULT_BOARD_SIZE = gameBoard.getSize();
		pieces = gameBoard.getPiecePositions();
	}

	public double getBoardStrength(PieceColor color) {
		double strength = 0;

		for (int i = 0; i < DEFAULT_BOARD_SIZE; i++) {
			for (int j = 0; j < DEFAULT_BOARD_SIZE; j++) {
				if (pieces[i][j] != null && pieces[i][j].getColor() == color) {
					strength += getValueOfPieceAtPosition(Position
							.buildPostionFromXYCoords(i, j));

				}
			}
		}

		return strength;
	}

	private double getValueOfPieceAtPosition(Position position) {
		ChessPiece pieceBox = pieces[position.getX()][position.getY()];
		if (pieceBox.getClass() == Pawn.class && areMultiplePawnsOnColumn(position))
			return pieceBox.getValue() - .5;
		 else
			return pieceBox.getValue();
	}

	private boolean areMultiplePawnsOnColumn(Position position) {
		int amtOfPawns = 0;
		final int COLUMN = position.getX();

		ChessPiece piece = pieces[position.getX()][position.getY()];

		for (int y = 0; y < DEFAULT_BOARD_SIZE; y++) {

			// Continue if it is null
			if (pieces[COLUMN][y] == null)
				continue;

			if (pieces[COLUMN][y].getClass() == Pawn.class
					&& pieces[COLUMN][y].getColor() == piece.getColor()) {
				amtOfPawns++;
			}

		}

		return amtOfPawns > 1;
	}

	public int movePiece(char x1, int y1, char x2, int y2) {

		return movePiece(Position.buildPostionFromChessCoords(x1, y1),
				Position.buildPostionFromChessCoords(x2, y2));
	}

	private boolean isValidPostion(Position position) {
		return (position.getX() >= 0 && position.getY() < Board.DEFAULT_BOARD_SIZE);
	}

	private boolean isPositionOccupied(Position position) {
		return pieces[position.getX()][position.getY()] != null;
	}

	private int movePiece(Position from, Position to) {

		// First check if the locations are valid so we don't crash the program
		// if the user gives us bad coordinates
		if (!isValidPostion(from) || !isValidPostion(to))
			return MOVE_ERROR_INVALID_POSITION;

		// Then check if there exists a piece that should be move
		if (!isPositionOccupied(from))
			return MOVE_ERROR_NO_SOURCE_PIECE;

		// Next check if there is a user's piece already in that location
		if (isPositionOccupied(to)
				&& (pieces[from.getX()][from.getY()].getColor() == pieces[to
						.getX()][to.getY()].getColor()))
			return MOVE_ERROR_PIECE_IN_DESTINATION;

		// Last check if the move is valid for the selected piece
		if (!isValidMove(from, to))
			return MOVE_ERROR_INVALID_MOVE;

		pieces[to.getX()][to.getY()] = pieces[from.getX()][from.getY()];
		pieces[from.getX()][from.getY()] = null;

		return MOVE_SUCCESS;
	}

	/**
	 * Method to determine if the attempted move is a valid move or not
	 * 
	 * returns a boolean whether the move is valid
	 * 
	 * this method should have serious tests
	 */

	private boolean isValidMove(Position from, Position to) {
		ChessPiece pieceToMove = pieces[from.getX()][from.getY()];
		if (pieceToMove.getClass() == King.class) {

			// A King can only move one space in any direction
			if (absDistanceBetweenTwoPoints(from.getX(), to.getX()) > 1
					|| absDistanceBetweenTwoPoints(from.getY(), to.getY()) > 1)
				return false;

		} else if (pieceToMove.getClass() == Rook.class) {

			// A Rook can only move horizontally or vertically
			if (!isStreight(from, to))
				return false;

			/**
			 * TODO - Implement castling over here
			 * https://en.wikipedia.org/wiki/Castling Castling is an edge case,
			 * maybe just check by hand?
			 */

			// this method automatically picks right points to check
			if (existsPieceBetweenTwoPoints(from, to))
				return false;

		} else if (pieceToMove.getClass() == Bishop.class) {

			// Should be pretty simple to implement
			// Just need to verify that the positions are on the same diagonal
			// and that there are no pieces in between
			if (! (isDiagonal(to,from)))
				return false;
			if (existsPieceBetweenTwoPoints(to,from))
				return false;
		} else if (pieceToMove.getClass() == Queen.class) {

			// Need to verify that the pieces are either on the same row, column
			// or diagonal
			// Need to make sure there are no pieces in between.
			if (! ( isDiagonal(to, from) || isStreight(to, from) )  )
				return false;
			if (existsPieceBetweenTwoPoints(to, from))
				return false;

		} else if (pieceToMove.getClass() == Pawn.class) {

			// Usually it can only move on space forward
			// Except:
			// First move can move 2 spaces forward
			// Can kill an enemy piece by moving diagonal
			// En Passant https://en.wikipedia.org/wiki/En_passant this will be
			// tricky... ugh
			// - we may have to keep a history of piece moves for this..
			// - truth is we should have a history of moves anyways so that we
			// can print out the result at the end of the game
			// - Where should the history be kept? In the board class? In
			// application class? Is it related to the board? I guess it is..
			// The current board is really just a history of the board moves. It
			// may make sense to store the moves with the board
			// There should probably be a Move class to make it easy to store
			// this data. We can use a List<Move> to keep track of this.

		} else if (pieceToMove.getClass() == Knight.class) {

			// Moves in a unique pattern and jumps over pieces in the way
			// Should be pretty easy to implement

		}

		return true;
	}

	private int absDistanceBetweenTwoPoints(int x1, int x2) {
		return Math.abs(x1 - x2);
	}

	private boolean existsPieceBetweenTwoPoints(Position p1, Position p2) {
		int x1 = p1.getX(), y1 = p1.getY(), x2 = p2.getX(), y2 = p2.getY();
		if (x1 == x2)
			for (int i = Math.min(y1, y2) + 1; i < Math.max(y1, y2); i++) {
				if (pieces[x1][i] != null)
					return true;
			}
		if (y1 == y2)
			for (int i = Math.min(x1, x2) + 1; i < Math.max(x1, x2); i++) {
				if (pieces[i][y1] != null)
					return true;
			}
		if (Math.abs(y1 - y2) == Math.abs(x1 - x2)) {
			int[] slopeArray = getSlopeArray(p1, p2);
			boolean p1IsLower = (y1 < y2);
			for (int x = x1, y = y1; (p1IsLower) ? y1 < y2 : y1 > y2; x += slopeArray[0], y += slopeArray[1])
				if (pieces[x][y] != null)
					return true;
		}
		return false;
	}

	// this method returns an array to help iterate diagonal checks.
	private int[] getSlopeArray(Position p1, Position p2) {
		int[] slopeArray = new int[2];
		slopeArray[0] = (p1.getX() < p2.getX()) ? 1 : -1;
		slopeArray[1] = (p1.getY() < p2.getY()) ? 1 : -1;
		return slopeArray;
	}

	public boolean isDiagonal(Position p1, Position p2) {
		return (Math.abs( p1.getY() - p2.getY() ) == Math.abs( p1.getX()- p2.getX() ) );
	}
 
	private boolean isStreight(Position p1, Position p2) {
		return (p1.getX() == p2.getX() || p1.getY() == p2.getY());
	}

	/**
	 * TODO
	 * 
	 * Create a method to determine if a square is threatened by the other
	 * player. This is useful for castling, the king in general, and if we ever
	 * decide to implement a AI :). It may be very easy, just cycle through the
	 * enemy pieces and check if they can move to the given square
	 * 
	 */

	private boolean isSquareThreatedBy(PieceColor color, int x, int y) {

		return false;
	}

}
