package edu.touro.mco152;

public class BoardUtils {

	public static int absDistanceBetweenTwoPoints(int x1, int x2) {
		return Math.abs(x1-x2);
	}
	

	public static boolean existsPieceBetweenTwoPoints(Position p1, Position p2, Board board) {
		int x1 = p1.getX(), y1 = p1.getY(), x2 = p2.getX(), y2 = p2.getY();
		if (x1 == x2)
			for (int i = Math.min(y1, y2) + 1; i < Math.max(y1, y2); i++) {
				if (board.getPiece(x1,i) != null)
					return true;
			}
		else if (y1 == y2)
			for (int i = Math.min(x1, x2) + 1; i < Math.max(x1, x2); i++) {
				if (board.getPiece(i,y1) != null)
					return true;
			}
		else if (isDiagonal(p1,p2)) {
			int[] slopeArray = getSlopeArray(p1, p2);
			int tempX = x1+slopeArray[0], tempY= y1+slopeArray[1];
			//should be do while
			while (tempY!=y2) {
				 tempX += slopeArray[0];
				 tempY += slopeArray[1];
				if (board.getPiece(tempX,tempY) != null)
					return true;
			}
		}
		return false;
	}

	// this method returns an array to help iterate diagonal checks.
	public static int[] getSlopeArray(Position p1, Position p2) {
		int[] slopeArray = new int[2];
		slopeArray[0] = (p1.getX() < p2.getX()) ? 1 : -1;
		slopeArray[1] = (p1.getY() < p2.getY()) ? 1 : -1;
		return slopeArray;
	}

	public static boolean isDiagonal(Position p1, Position p2) {
		return (Math.abs( p1.getY() - p2.getY() ) == Math.abs( p1.getX()- p2.getX() ) );
	}
 
	public static boolean isStraight(Position p1, Position p2) {
		return (p1.getX() == p2.getX() || p1.getY() == p2.getY());
	}

}
