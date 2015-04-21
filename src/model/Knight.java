/**
 * @author Ananth Rao
 * @author Allon Fineziber
 */

package model;

import java.util.LinkedList;

import util.Position;

public class Knight extends Piece{

	public Knight(boolean w, Position start) {
		currPos = start;
		symbol = "N";
		this.setWhite(w);

		if (w == true){
			this.symbol = "w" + this.symbol;
		}
		else{
			this.symbol = "b" + this.symbol;
		}
	}

	public boolean canMove(Position nextPos, boolean isEmpty) {

		int oldX = currPos.x;
		int oldY = currPos.y;
		int newX = nextPos.x;
		int newY = nextPos.y;

		int diffX;
		int diffY;

		diffX = Math.abs(newX - oldX);
		diffY = Math.abs(newY - oldY);

		if (diffX == 2 && diffY == 1){
			return true;
		}
		else if (diffX == 1 && diffY == 2) {
			return true;
		}

		return false;
	}

	@Override
	public LinkedList<Position> pathToSquare(Position square, boolean isEmpty) {
		// TODO Auto-generated method stub
		if(canMove(square, isEmpty)) {
			LinkedList<Position> retList = new LinkedList<Position>();
			retList.add(currPos);
			return retList;
		}
		return null;
	}
}
