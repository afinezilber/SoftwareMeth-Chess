/**
 * @author Ananth Rao
 * @author Allon Fineziber
 */

package model;

import java.util.LinkedList;

import util.Position;

public abstract class Piece {
	public String symbol;
	private boolean white;
	public boolean firstMove = true;
	
	public Position currPos;
	
    public boolean isWhite(){
		return this.white;
	}
	
	public void setWhite(boolean w){
		white = w;
	}
	
	public Position getPosition() {
		return currPos;
	}
	
	public void setPosition(Position newPos) {
		currPos = newPos;
	}
	
	public abstract boolean canMove(Position nextPos, boolean isEmpty);
	
	public abstract LinkedList<Position> pathToSquare(Position square, boolean isEmpty);
	
	public String toString() {
		return symbol;
	}
}
