/**
 * @author Ananth Rao
 * @author Allon Fineziber
 */

package util;

public class Position {
	public int x, y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Position) {
			Position other = (Position)o;
			return (x == other.x && y == other.y);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "x=" + x + ", y=" + y;
	}
}
