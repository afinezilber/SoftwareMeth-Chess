/**
 * @author Ananth Rao
 * @author Allon Fineziber
 */

package util;

public class Scanner {
	
	public Scanner() {
		
	}
	
	public Position extractPosition(String input) {
		if(input.length() != 2) {
			return null;
		} else {
			try {
				int x = getMappedPos(input.substring(0,1));
				int y = Integer.parseInt(input.substring(1));
				y--;
				if(y < 0 || y > 7) {
					throw new Exception();
				}
				return new Position(x,y);
			} catch (Exception e) {
				return null;
			}
		}
	}
	
	public static int getMappedPos(String pos) throws NumberFormatException {
		switch(pos) {
		case "a":
			return 0;
		case "b":
			return 1;
		case "c":
			return 2;
		case "d":
			return 3;
		case "e":
			return 4;
		case "f":
			return 5;
		case "g":
			return 6;
		case "h":
			return 7;
		default:
			throw new NumberFormatException();
		}
	}
}
