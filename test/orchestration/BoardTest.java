package orchestration;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import piece.King;
import piece.Piece;

public class BoardTest {

	LinkedHashMap<Space, Piece> board;
	
	@Before
	public void setUpBefore() {
		board = getEmptyBoard();
		
	}
	
	@Test
	public void getAllOpposingTeamsThreats_test() {
		// TODO - Stub
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
