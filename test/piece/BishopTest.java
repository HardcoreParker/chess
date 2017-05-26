package piece;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import orchestration.Board;
import orchestration.Space;
import orchestration.Team;

public class BishopTest {

	LinkedHashMap<Space, Piece> board;
	Space origin = Space.D5;
	Bishop testBishop;
	
	@Before
	public void setUpBefore() {
		board = getEmptyBoard();
		board.put(origin, new Bishop(Team.WHITE));
		testBishop = (Bishop) board.get(origin);
	}
	
	@Test
	public void bishop_can_move_to_edges_of_board_in_every_diagonal_direction_test() {
		ArrayList<Space> validMoves = testBishop.calculateValidMoves(origin);
		
		assert(validMoves.size() == 13);
		
		assert(validMoves.contains(Space.A8));
		assert(validMoves.contains(Space.B7));
		assert(validMoves.contains(Space.C6));
		assert(validMoves.contains(Space.E4));
		assert(validMoves.contains(Space.F3));
		assert(validMoves.contains(Space.G2));
		assert(validMoves.contains(Space.H1));
		
		assert(validMoves.contains(Space.A2));
		assert(validMoves.contains(Space.B3));
		assert(validMoves.contains(Space.C4));
		assert(validMoves.contains(Space.E6));
		assert(validMoves.contains(Space.F7));
		assert(validMoves.contains(Space.G8));
	}
	
	@Test
	public void bishop_cant_move_through_friendlies_test() {
		board.put(Space.C6, new Pawn(Team.WHITE));
		board.put(Space.E6, new Pawn(Team.WHITE));
		board.put(Space.C4, new Pawn(Team.WHITE));
		board.put(Space.E4, new Pawn(Team.WHITE));
		
		ArrayList<Space> validMoves = testBishop.calculateValidMoves(origin);
		
		assert(validMoves.size() == 0);
	}
	
	@Test
	public void bishop_can_take_enemeies_in_4_directions_test() {
		board.put(Space.C6, new Pawn(Team.BLACK));
		board.put(Space.E6, new Pawn(Team.BLACK));
		board.put(Space.C4, new Pawn(Team.BLACK));
		board.put(Space.E4, new Pawn(Team.BLACK));
		
		ArrayList<Space> validMoves = testBishop.calculateValidMoves(origin);
		
		assert(validMoves.size() == 4);
		
		assert(validMoves.contains(Space.C6));
		assert(validMoves.contains(Space.E6));
		assert(validMoves.contains(Space.C4));
		assert(validMoves.contains(Space.E4));
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
