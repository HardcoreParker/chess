package piece;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import orchestration.Board;
import orchestration.Space;
import orchestration.Team;

public class QueenTest {

	LinkedHashMap<Space, Piece> board;
	Space origin = Space.D4;
	Queen testQueen;
	
	@Before
	public void setUpBefore() {
		board = getEmptyBoard();
		board.put(origin, new Queen(Team.WHITE));
		testQueen = (Queen) board.get(origin);
	}
	
	@Test
	public void queen_can_move_to_edges_of_board_in_every_diagonal_direction_test() {
		ArrayList<Space> validMoves = testQueen.calculateValidMoves(origin);
		
		assert(validMoves.size() == 27);
		
		assert(validMoves.contains(Space.D1));
		assert(validMoves.contains(Space.D2));
		assert(validMoves.contains(Space.D3));
		assert(validMoves.contains(Space.D5));
		assert(validMoves.contains(Space.D6));
		assert(validMoves.contains(Space.D7));
		assert(validMoves.contains(Space.D8));
		
		assert(validMoves.contains(Space.A4));
		assert(validMoves.contains(Space.B4));
		assert(validMoves.contains(Space.C4));
		assert(validMoves.contains(Space.E4));
		assert(validMoves.contains(Space.F4));
		assert(validMoves.contains(Space.G4));
		assert(validMoves.contains(Space.H4));

		assert(validMoves.contains(Space.A1));
		assert(validMoves.contains(Space.B2));
		assert(validMoves.contains(Space.C3));
		assert(validMoves.contains(Space.E5));
		assert(validMoves.contains(Space.F6));
		assert(validMoves.contains(Space.G7));
		assert(validMoves.contains(Space.H8));
		
		assert(validMoves.contains(Space.G1));
		assert(validMoves.contains(Space.F2));
		assert(validMoves.contains(Space.E3));
		assert(validMoves.contains(Space.C5));
		assert(validMoves.contains(Space.B6));
		assert(validMoves.contains(Space.A7));
	}
	
	@Test
	public void queen_cant_move_through_friendlies_test() {
		board.put(Space.D5, new Pawn(Team.WHITE));
		board.put(Space.D3, new Pawn(Team.WHITE));
		board.put(Space.C4, new Pawn(Team.WHITE));
		board.put(Space.C5, new Pawn(Team.WHITE));
		board.put(Space.E5, new Pawn(Team.WHITE));
		board.put(Space.E4, new Pawn(Team.WHITE));
		board.put(Space.C3, new Pawn(Team.WHITE));
		board.put(Space.E3, new Pawn(Team.WHITE));
		
		ArrayList<Space> validMoves = testQueen.calculateValidMoves(origin);
		
		
		assert(validMoves.size() == 0);
	}
	
	@Test
	public void queen_can_take_enemeies_in_8_directions_test() {
		board.put(Space.D5, new Pawn(Team.BLACK));
		board.put(Space.D3, new Pawn(Team.BLACK));
		board.put(Space.C4, new Pawn(Team.BLACK));
		board.put(Space.C5, new Pawn(Team.BLACK));
		board.put(Space.E5, new Pawn(Team.BLACK));
		board.put(Space.E4, new Pawn(Team.BLACK));
		board.put(Space.C3, new Pawn(Team.BLACK));
		board.put(Space.E3, new Pawn(Team.BLACK));
		
		ArrayList<Space> validMoves = testQueen.calculateValidMoves(origin);
		
		
		assert(validMoves.size() == 8);
		
		assert(validMoves.contains(Space.D5));
		assert(validMoves.contains(Space.D3));
		assert(validMoves.contains(Space.C4));
		assert(validMoves.contains(Space.C5));
		assert(validMoves.contains(Space.E5));
		assert(validMoves.contains(Space.E4));
		assert(validMoves.contains(Space.C3));
		assert(validMoves.contains(Space.E3));
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
