package edu.touro.mco152;

public class Position {

	private final int x,y;
	
	private Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public static Position buildPostionFromChessCoords(char charX, int initialY){
		
		int x = Character.toLowerCase(charX) - 'a';
		int y = Board.DEFAULT_BOARD_SIZE - initialY;
		
		return new Position(x, y);
	}
	
	public static Position buildPostionFromXYCoords(int x, int y) {
		return new Position(x, y);
	}
	
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	
	@Override
	public int hashCode() {
		// A simple hash implementation
		return (x * 3) + (y * 17);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Position){
			return ((Position) obj).x == x &&  ((Position) obj).y == y;
		}
		return false;
	}



}
