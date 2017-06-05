package orchestration;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import piece.Piece;

public class BoardTest {

	LinkedHashMap<Space, Piece> board;
	Space origin = Space.D5;
	
	@Before
	public void setUpBefore() {
		board = getEmptyBoard();
		
	}
	
	@Test
	public void getAllOpposingTeamsThreats_test() {
		// TODO - Stub
	}
	
	@Test
	public void walkBoardUntilNextSpaceUnavailable_happypath_test() {
		ArrayList<Space> spaces = Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.N);
		
		assert(spaces.size() == 3);
		assert(spaces.contains(Space.D6));
		assert(spaces.contains(Space.D7));
		assert(spaces.contains(Space.D8));
		
		spaces = Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.S);
		
		assert(spaces.size() == 4);
		
		assert(spaces.contains(Space.D4));
		assert(spaces.contains(Space.D3));
		assert(spaces.contains(Space.D2));
		assert(spaces.contains(Space.D1));
		
		spaces = Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.W);
		
		assert(spaces.size() == 3);
		assert(spaces.contains(Space.A5));
		assert(spaces.contains(Space.B5));
		assert(spaces.contains(Space.C5));
		
		spaces = Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.E);
		
		assert(spaces.size() == 4);
		assert(spaces.contains(Space.E5));
		assert(spaces.contains(Space.F5));
		assert(spaces.contains(Space.G5));
		assert(spaces.contains(Space.H5));
	}
	
	@Test
	public void walkBoardUntilNextSpaceUnavailable_times_happypath_test() {
		// Walk to edge
		ArrayList<Space> spaces = Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.N, 3);
		
		assert(spaces.size() == 3);
		assert(spaces.contains(Space.D6));
		assert(spaces.contains(Space.D7));
		assert(spaces.contains(Space.D8));
		
		spaces = Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.S, 4);
		
		assert(spaces.size() == 4);
		
		assert(spaces.contains(Space.D4));
		assert(spaces.contains(Space.D3));
		assert(spaces.contains(Space.D2));
		assert(spaces.contains(Space.D1));
		
		spaces = Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.W, 3);
		
		assert(spaces.size() == 3);
		assert(spaces.contains(Space.A5));
		assert(spaces.contains(Space.B5));
		assert(spaces.contains(Space.C5));
		
		spaces = Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.E, 4);
		
		assert(spaces.size() == 4);
		assert(spaces.contains(Space.E5));
		assert(spaces.contains(Space.F5));
		assert(spaces.contains(Space.G5));
		assert(spaces.contains(Space.H5));
		
		// Walk a few spaces
		spaces = Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.N, 2);
		
		assert(spaces.size() == 2);
		assert(spaces.contains(Space.D6));
		assert(spaces.contains(Space.D7));
		
		spaces = Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.S, 2);
		
		assert(spaces.size() == 2);
		
		assert(spaces.contains(Space.D4));
		assert(spaces.contains(Space.D3));
		
		spaces = Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.W, 2);
		
		assert(spaces.size() == 2);
		assert(spaces.contains(Space.B5));
		assert(spaces.contains(Space.C5));
		
		spaces = Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.E, 2);
		
		assert(spaces.size() == 2);
		assert(spaces.contains(Space.E5));
		assert(spaces.contains(Space.F5));
	}
	
	@Test
	public void walkBoardUntilNextSpaceUnavailable_times_more_times_than_spaces_edge_test() {
		// Walk to edge
		origin = Space.A1;
		ArrayList<Space> spaces = Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.N, 9);
		
		assert(spaces.size() == 7);
		
		assert(spaces.contains(Space.A2));
		assert(spaces.contains(Space.A3));
		assert(spaces.contains(Space.A4));
		assert(spaces.contains(Space.A5));
		assert(spaces.contains(Space.A6));
		assert(spaces.contains(Space.A7));
		assert(spaces.contains(Space.A8));
	}
	
	@Test
	public void walkBoardUntilNextSpaceUnavailable_times_zero_times_edge_test() {
		origin = Space.A1;
		ArrayList<Space> spaces = Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.N, 0);
		
		assert(spaces.size() == 0);
	}
	
	@Test
	public void walkBoardUntilNextSpaceUnavailable_times_lots_of_times_OOB_test() {
		origin = Space.A1;
		ArrayList<Space> spaces = Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.S, 9);
		
		assert(spaces.size() == 0);
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
