package piece;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import orchestration.Board;
import orchestration.Space;
import orchestration.Team;

public class KnightTest {

	LinkedHashMap<Space, Piece> board;
	Space origin = Space.D4;
	Knight testKnight;
	
	@Before
	public void setUpBefore() {
		board = getEmptyBoard();
		board.put(origin, new Knight(Team.WHITE));
		testKnight = (Knight) board.get(origin);
	}
	
	@Test
	public void knight_can_move_to_edges_of_board_in_every_diagonal_direction_test() {
		ArrayList<Space> validMoves = testKnight.calculateValidMoves(origin);
		
	}
	
	@Test
	public void knight_can_move_through_friendlies_test() {
		board.put(Space.D5, new Pawn(Team.WHITE));
		board.put(Space.C4, new Pawn(Team.WHITE));
		board.put(Space.D3, new Pawn(Team.WHITE));
		board.put(Space.E4, new Pawn(Team.WHITE));
		
		ArrayList<Space> validMoves = testKnight.calculateValidMoves(origin);
		
		assert(validMoves.size() == 8);
		
		assert(validMoves.contains(Space.C6));
		assert(validMoves.contains(Space.B5));
		
		assert(validMoves.contains(Space.E6));
		assert(validMoves.contains(Space.F5));

		assert(validMoves.contains(Space.B3));
		assert(validMoves.contains(Space.C2));

		assert(validMoves.contains(Space.E2));
		assert(validMoves.contains(Space.F3));
	}
	
	@Test
	public void knight_can_take_enemeies_in_8_directions_test() {
		board.put(Space.C6, new Pawn(Team.BLACK));
		board.put(Space.B5, new Pawn(Team.BLACK));
		
		board.put(Space.E6, new Pawn(Team.BLACK));
		board.put(Space.F5, new Pawn(Team.BLACK));
		
		board.put(Space.B3, new Pawn(Team.BLACK));
		board.put(Space.C2, new Pawn(Team.BLACK));
		
		board.put(Space.E2, new Pawn(Team.BLACK));
		board.put(Space.F3, new Pawn(Team.BLACK));
		
		ArrayList<Space> validMoves = testKnight.calculateValidMoves(origin);
		
		assert(validMoves.size() == 8);
		
		assert(validMoves.contains(Space.C6));
		assert(validMoves.contains(Space.B5));
		
		assert(validMoves.contains(Space.E6));
		assert(validMoves.contains(Space.F5));

		assert(validMoves.contains(Space.B3));
		assert(validMoves.contains(Space.C2));

		assert(validMoves.contains(Space.E2));
		assert(validMoves.contains(Space.F3));
	}
	
	@Test
	public void knight_can_take_enemies_through_friendlies_and_enemies() {
		board.put(Space.C6, new Pawn(Team.BLACK));
		board.put(Space.B5, new Pawn(Team.BLACK));
		
		board.put(Space.E6, new Pawn(Team.BLACK));
		board.put(Space.F5, new Pawn(Team.BLACK));
		
		board.put(Space.B3, new Pawn(Team.BLACK));
		board.put(Space.C2, new Pawn(Team.BLACK));
		
		board.put(Space.E2, new Pawn(Team.BLACK));
		board.put(Space.F3, new Pawn(Team.BLACK));
		
		// Surround knight with friendlies and enemies
		board.put(Space.D5, new Pawn(Team.WHITE));
		board.put(Space.C4, new Pawn(Team.WHITE));
		board.put(Space.D3, new Pawn(Team.BLACK));
		board.put(Space.E4, new Pawn(Team.BLACK));
		
		ArrayList<Space> validMoves = testKnight.calculateValidMoves(origin);
		
		assert(validMoves.size() == 8);
		
		assert(validMoves.contains(Space.C6));
		assert(validMoves.contains(Space.B5));
		
		assert(validMoves.contains(Space.E6));
		assert(validMoves.contains(Space.F5));

		assert(validMoves.contains(Space.B3));
		assert(validMoves.contains(Space.C2));

		assert(validMoves.contains(Space.E2));
		assert(validMoves.contains(Space.F3));
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
