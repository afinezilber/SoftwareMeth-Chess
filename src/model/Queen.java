/**
 * @author Ananth Rao
 * @author Allon Fineziber
 */

package model;

import java.util.LinkedList;

import util.Position;

public class Queen extends Piece{


	public Queen(boolean w, Position start) {
		currPos = start;
		symbol = "Q";
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

		if (diffX == diffY){
			return true;
		}
		else if (diffX == 0 && diffY != 0) {
			return true;
		}
		else if (diffX != 0 && diffY == 0){
			return true;
		}

		return false;
	}
	
	@Override
	public LinkedList<Position> pathToSquare(Position square, boolean isEmpty) {
		// TODO Auto-generated method stub
		if(canMove(square, isEmpty)) {
			LinkedList<Position> retList = new LinkedList<Position>();
			int oldX = currPos.x;
			int oldY = currPos.y;
			int newX = square.x;
			int newY = square.y;

			int diffX = newX - oldX;
			int diffY = newY - oldY;
			
			if(diffX != 0) {
				while(diffX != 0) {
					retList.add(new Position(oldX, oldY));
					if(diffX > 0) {
						if(diffY > 0) {
							oldY += 1;
						} else if(diffY < 0) {
							oldY -= 1;
						}
						oldX += 1;
					} else {
						if(diffY > 0) {
							oldY += 1;
						} else if(diffY < 0) {
							oldY -= 1;
						}
						oldX -= 1;
					}
					diffX = newX - oldX;
				}
			} else {
				while(diffY != 0) {
					retList.add(new Position(oldX, oldY));
					if(diffY > 0) {
						oldY += 1;
					} else {
						oldY -= 1;
					}
					diffY = newY - oldY;
				}				
			}
			return retList;
		}
		return null;
	}
}
