package orchestration;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import exception.NoKingFoundException;
import piece.King;
import piece.Piece;
import piece.Queen;
import piece.Rook;

public class CheckAndCheckmateTest {

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
	public void isCheck_Test() {
		board.put(Space.D5, new Rook(Team.BLACK));
		boolean isTeamInCheck;
		
		try {
			isTeamInCheck = Board.isTeamInCheck(Team.WHITE);
			assertTrue(isTeamInCheck);
		} catch (NoKingFoundException e) {
			assert(false);
		}
	}
	
	@Test
	public void isCheck_false_Test() {
		board.put(Space.A1, new Rook(Team.BLACK));
		boolean isTeamInCheck;
		
		try {
			isTeamInCheck = Board.isTeamInCheck(Team.WHITE);
			assertFalse(isTeamInCheck);
		} catch (NoKingFoundException e) {
			assert(false);
		}
	}
	
	@Test
	public void isCheck_noKingFoundException_Test() {
		try {
			boolean isTeamInCheck = Board.isTeamInCheck(Team.BLACK);
			assert(false);
		} catch (NoKingFoundException e) {
			assert(true);
		}
	}
	
	@Test
	public void isCheckMate_Test() {
		
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
