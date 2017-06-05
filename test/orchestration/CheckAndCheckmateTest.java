package orchestration;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import exception.NoKingFoundException;
import piece.Bishop;
import piece.King;
import piece.Knight;
import piece.Pawn;
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
	
	// TODO - Implement
	@Ignore
	@Test
	public void isCheckmate_fools_mate_Test() {
		Board board = new Board();
		LinkedHashMap<Space, Piece> boardMap = board.getBoard();

		boardMap.put(Space.D8, null);
		boardMap.put(Space.E7, null);
		boardMap.put(Space.F2, null);
		boardMap.put(Space.G2, null);
		
		boardMap.put(Space.E5, new Pawn(Team.BLACK));
		boardMap.put(Space.H4, new Queen(Team.BLACK));

		boardMap.put(Space.F3, new Pawn(Team.WHITE));
		boardMap.put(Space.G4, new Pawn(Team.WHITE));
		
		assertTrue(Board.isTeamInCheckmate(Team.WHITE));
	}
	
	// TODO - Implement
	@Ignore
	@Test
	public void isCheckmate_rook_checkmake_Test() {
		board.put(Space.H5, new King(Team.BLACK));

		board.put(Space.F5, new King(Team.WHITE));
		board.put(Space.H1, new Rook(Team.WHITE));
		
		assertTrue(Board.isTeamInCheckmate(Team.WHITE));
	}
	
	// TODO - Implement
	@Ignore
	@Test
	public void isCheckmate_Byrne_vs_Fischer_1956_test() {
		board.put(Space.B8, new Queen(Team.WHITE));
		board.put(Space.E5, new Knight(Team.WHITE));
		board.put(Space.H4, new Pawn(Team.WHITE));
		board.put(Space.G2, new Pawn(Team.WHITE));
		board.put(Space.C1, new King(Team.WHITE));

		board.put(Space.F7, new Pawn(Team.BLACK));
		board.put(Space.G7, new King(Team.BLACK));
		board.put(Space.C6, new Pawn(Team.BLACK));
		board.put(Space.G6, new Pawn(Team.BLACK));
		board.put(Space.B5, new Pawn(Team.BLACK));
		board.put(Space.H5, new Pawn(Team.BLACK));
		board.put(Space.B4, new Bishop(Team.BLACK));
		board.put(Space.B3, new Bishop(Team.BLACK));
		board.put(Space.C3, new Knight(Team.BLACK));
		board.put(Space.C2, new Rook(Team.BLACK));
		
		try {
			assertTrue(Board.isTeamInCheck(Team.WHITE));
		} catch (NoKingFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
