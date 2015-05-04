package edu.touro.mco152;

import java.util.HashMap;
import java.util.Map;

public class Position {

	
	private static final Map<Integer, Position> positions = new HashMap<Integer, Position>();
	private int x,y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Position(){
		
	}
	
	
	public static Position buildPostionFromChessCoords(char charX, int initialY){
		
		int x = Character.toLowerCase(charX) - 'a';
		int y = Board.DEFAULT_BOARD_SIZE - initialY;
		
		return getPostion(x, y);
	}
	
	public static Position buildPostionFromXYCoords(int x, int y) {
		return getPostion(x, y);
	}
	
	private static Position getPostion(int x, int y){
		if(positions.containsKey(getHashKey(x, y))){
			return positions.get(getHashKey(x, y));
		}else{
			Position p = new Position(x, y);
			positions.put(getHashKey(x, y), p);
			return p;
		}
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
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
		return getHashKey(x, y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Position){
			return ((Position) obj).x == x &&  ((Position) obj).y == y;
		}
		return false;
	}

	private static Integer getHashKey(int x, int y){
		return (x * 3) + (y * 17);
	}


}
