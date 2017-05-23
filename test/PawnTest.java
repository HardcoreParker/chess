import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Test;

public class PawnTest {
		
	Board board = new Board();
	
	@Test
	public void moveForwardOneTest() {
		LinkedHashMap<Space, Piece> board = getTestBoardForPawns();
		
		Space origin = Space.B2;
		
		/* 
		 * My original thought is that its a problem that a pawn needs to intake its own space to compute where it can move to
		 * I've changed my mentality on this once I consider that the board is orchestrating all movement.
		 * We could potentially have the pawn hold a reference to its own position, but we run into issues where we could fail to update one of the positional pointers
		 * Good to keep in mind in the future, but currently unnecessary
		 */
		
		Piece pawn = board.get(origin);
		ArrayList<Space> validMoves = pawn.calculateValidMoves(origin);
		
		assert(validMoves.size() == 2);
		
	}
	
	private LinkedHashMap<Space, Piece> getTestBoardForPawns() {				
		LinkedHashMap<Space, Piece> boardMap = board.getBoard();
		
		for(Space space : boardMap.keySet()) {
			boardMap.put(space, null); // empty out the board
		}
		
		boardMap.put(Space.B2, new Pawn(Team.WHITE));
		
		return boardMap;
	}

}
