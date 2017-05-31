package orchestration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import piece.Piece;

public class Game {
	
	private static Board board = new Board();
	private static boolean checkMate = false;
	private static Team team = Team.WHITE;
	
	public static void main(String[] args) {	
		while(!checkMate) {
			System.out.println(board.toString());
			
			System.out.println(team.toString() + " player's move");

			
			String input = System.console().readLine();
			
			Space origin = null;
			Space destination = null;
			String[] split = input.split(":");
			String potentialOrigin = split[0];
			String potentialDestination = split[1];
			
			try {
				origin = Space.valueOf(potentialOrigin);
				destination = Space.valueOf(potentialDestination);
				boolean success = processMove(origin, destination, team);
				
				if(success == false) {
					System.out.println("That move isn't possible. Try again "+team);
				} else {
					team = Team.getOpposingTeam(team);
				}
			} catch(IllegalArgumentException ex) {
				System.out.println("Try again, one of those inputs isn't correct");
			}
		}
		
	}
	
	private static boolean processMove(Space origin, Space destination, Team playerTeam) {
		LinkedHashMap<Space, Piece> liveBoard = board.getBoard();
		
		Piece pieceToMove = liveBoard.get(origin);
		
		if(pieceToMove.calculateValidMoves(origin).contains(destination)) {
			liveBoard.put(origin, null);
			liveBoard.put(destination, pieceToMove);
			return true;
		} else {
			return false;
		}
	}
	
	/* 
	 * First, the game initializes and gives the WHITE player the opportunity to make a move
	 * White player selects a origin space and a destination space
	 * Game calculates if that move is possible, and if so, updates the board
	 * Repeat with black player's move
	 *  
	 * */
	
}