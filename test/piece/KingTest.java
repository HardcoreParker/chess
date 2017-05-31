package piece;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import orchestration.Board;
import orchestration.Space;
import orchestration.Team;

public class KingTest {

	LinkedHashMap<Space, Piece> board;
	Space origin = Space.D4;
	King testKing;
	
	@Before
	public void setUpBefore() {
		board = getEmptyBoard();
		board.put(origin, new King(Team.WHITE));
		testKing = (King) board.get(origin);
	}
	
	@Test
	public void king_can_move_every_direction_test() {
		ArrayList<Space> validMoves = testKing.calculateValidMoves(origin);
		
		assert(validMoves.size() == 8);
		
		assert(validMoves.contains(Space.D5));
		assert(validMoves.contains(Space.D3));
		assert(validMoves.contains(Space.C4));
		assert(validMoves.contains(Space.E4));
		assert(validMoves.contains(Space.C5));
		assert(validMoves.contains(Space.E5));
		assert(validMoves.contains(Space.E3));
		assert(validMoves.contains(Space.C3));
	}
	
	@Test
	public void king_can_take_enemies_in_every_direction_test() {
		board.put(Space.D5, new Pawn(Team.BLACK));
		board.put(Space.C5, new Pawn(Team.BLACK));
		board.put(Space.E5, new Pawn(Team.BLACK));
		
		ArrayList<Space> validMoves = testKing.calculateValidMoves(origin);

		assert(validMoves.size() == 6);
		
		assert(validMoves.contains(Space.D5));
		assert(validMoves.contains(Space.C5));
		assert(validMoves.contains(Space.E5));
		
		assert(validMoves.contains(Space.D3));
		assert(validMoves.contains(Space.E3));
		assert(validMoves.contains(Space.C3));
		
		//board = getEmptyBoard();
		
		
		
//		board.put(Space.D3, new Pawn(Team.BLACK));
//		board.put(Space.C4, new Pawn(Team.BLACK));
//		board.put(Space.E4, new Pawn(Team.BLACK));
//		board.put(Space.C5, new Pawn(Team.BLACK));
//		board.put(Space.E5, new Pawn(Team.BLACK));
//		board.put(Space.E3, new Pawn(Team.BLACK));
//		board.put(Space.C3, new Pawn(Team.BLACK));
//		
//		ArrayList<Space> validMoves = testKing.calculateValidMoves(origin);
//		
//		assert(validMoves.size() == 8);
//		
//		assert(validMoves.contains(Space.D5));
//		assert(validMoves.contains(Space.D3));
//		assert(validMoves.contains(Space.C4));
//		assert(validMoves.contains(Space.E4));
//		assert(validMoves.contains(Space.C5));
//		assert(validMoves.contains(Space.E5));
//		assert(validMoves.contains(Space.E3));
//		assert(validMoves.contains(Space.C3));
	}

	private LinkedHashMap<Space, Piece> getEmptyBoard() {
		Board board = new Board();
		LinkedHashMap<Space, Piece> boardMap = board.getBoard();
		
		for(Space space : boardMap.keySet()) {
			boardMap.put(space, null); // empty out the board
		}
				
		return boardMap;
	}
}
