/**
 * @author Ananth Rao
 * @author Allon Fineziber
 */
package chess;

import java.util.Scanner;
import java.util.StringTokenizer;

import util.Position;

import control.Board;

public class Chess {
	private static Board board;
	private static util.Scanner scanner;
	private static Scanner stdin;
	
	public static void main(String[] args) {
		//TODO Implement command line interface to game
		stdin = new Scanner(System.in);
		board = new Board();
		scanner = new util.Scanner();
		drawBoard();
		while(board.gameInProgress()) {
			String input = stdin.nextLine();
			StringTokenizer tk = new StringTokenizer(input);
			boolean valid = false;
			switch(tk.countTokens()) {
			case 1:
				valid = board.move(tk.nextToken());
				break;
			case 2:
				Position p = scanner.extractPosition(tk.nextToken());
				valid = board.move(p, scanner.extractPosition(tk.nextToken()));
				break;
			case 3:
				valid = board.move(scanner.extractPosition(tk.nextToken()), scanner.extractPosition(tk.nextToken()), tk.nextToken());
			default:
				;
			}
			if(!valid) {
				invalidMove();
			}
		}
	}
	
	public static void drawBoard() {
/*		for(int i = 7; i > -1; i--) {
			for(int j = 0; j < 8; j++) {
				if(board.board[i][j] == null) {
					if(((i%2)^(j%2)) == 0) {
						System.out.print("##");
					} else {
						System.out.print("  ");
					}
				} else {
					System.out.print(board.board[i][j]);
				}
				System.out.print(" ");					
			}
			System.out.println(i+1);			
		}
		System.out.println(" a  b  c  d  e  f  g  h");
	*/
		board.drawBoard();
		
		System.out.print("White's move: ");
	}
	
	public static void invalidMove() {
		System.out.println();
		System.out.print("Illegal move. Try again: ");
	}
}
