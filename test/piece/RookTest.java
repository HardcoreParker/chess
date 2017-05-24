package piece;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import orchestration.Board;
import orchestration.Space;
import orchestration.Team;

public class RookTest {

	LinkedHashMap<Space, Piece> board;
	Space origin = Space.D5;
	Rook testRook;
	
	@Before
	public void setUpBefore() {
		board = getEmptyBoard();
		board.put(origin, new Rook(Team.WHITE));
		testRook = (Rook) board.get(origin);
	}
	
	@Test
	public void rook_can_move_to_edges_of_board_in_every_direction_test() {
		ArrayList<Space> validMoves = testRook.calculateValidMoves(origin);
		
		assert(validMoves.size() == 14);
		assert(validMoves.contains(Space.D1));
		assert(validMoves.contains(Space.D2));
		assert(validMoves.contains(Space.D3));
		assert(validMoves.contains(Space.D4));
		assert(validMoves.contains(Space.D6));
		assert(validMoves.contains(Space.D7));
		assert(validMoves.contains(Space.D8));
		assert(validMoves.contains(Space.A5));
		assert(validMoves.contains(Space.B5));
		assert(validMoves.contains(Space.C5));
		assert(validMoves.contains(Space.E5));
		assert(validMoves.contains(Space.F5));
		assert(validMoves.contains(Space.G5));
		assert(validMoves.contains(Space.H5));
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
