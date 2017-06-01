package orchestration;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import piece.Pawn;
import piece.Piece;

public class BoardTest {
 
	LinkedHashMap<Space, Piece> board;
	
	@Before
	public void setUpBefore() {
		board = getEmptyBoard();
		
	}
	
	@Test
	public void getAllThreatenedSpacesFromTeam_test() {
		board.put(Space.A1, new Pawn(Team.BLACK));
		
		ArrayList<Space> allThreatenedSpacesFromTeam = Board.getAllThreatenedSpacesFromTeam(Team.BLACK, board);
		
		assert(allThreatenedSpacesFromTeam.size() == 0);
		
		assert(allThreatenedSpacesFromTeam.contains(Space.A1));
		
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
