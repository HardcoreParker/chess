package piece;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import orchestration.Board;
import orchestration.Space;
import orchestration.Team;


public class PawnTest {
		
	LinkedHashMap<Space, Piece> board;
	Space origin = Space.B2;
	Pawn testPawn;
	@Before
	public void setUpBefore() {
		board = getEmptyBoard();
		board.put(origin, new Pawn(Team.WHITE));
		testPawn = (Pawn) board.get(origin);
	}
	
	@Test
	public void pawn_can_move_twice_on_first_move_Test() {
		/* 
		 * My original thought is that its a problem that a pawn needs to intake its own space to compute where it can move to
		 * I've changed my mentality on this once I consider that the board is orchestrating all movement.
		 * We could potentially have the pawn hold a reference to its own position, but we run into issues where we could fail to update one of the positional pointers
		 * Good to keep in mind in the future, but currently unnecessary
		 */
		
		ArrayList<Space> validMoves = testPawn.calculateValidMoves(origin);
		
		assert(validMoves.size() == 2);
		assert(validMoves.contains(Space.B3));
		assert(validMoves.contains(Space.B4));
	}
	
	@Test
	public void pawn_can_move_once_forward_on_first_move_Test() {
		testPawn.setHasMoved(true);
		ArrayList<Space> validMoves = testPawn.calculateValidMoves(origin);
		
		assert(validMoves.size() == 1);
		assert(validMoves.contains(Space.B3));
		assert(!validMoves.contains(Space.B4));
	}
	
	@Test
	public void pawn_cannot_move_through_enemies_on_forward_move_Test() {
		board.put(Space.B3, new Pawn(Team.BLACK));
		
		ArrayList<Space> validMoves = testPawn.calculateValidMoves(origin);
		assert(validMoves.size() == 0);
	}

	@Test
	public void pawn_cannot_move_through_friendlies_on_forward_move_Test() {
		board.put(Space.B3, new Pawn(Team.WHITE));
		
		ArrayList<Space> validMoves = testPawn.calculateValidMoves(origin);
		assert(validMoves.size() == 0);
	}	
	
	@Test
	public void pawn_can_take_enemy_pieces_diagonally_Test() {
		board.put(Space.B3, new Pawn(Team.WHITE));
		board.put(Space.A3, new Pawn(Team.BLACK));
		
		ArrayList<Space> validMoves = testPawn.calculateValidMoves(origin);
		assert(validMoves.size() == 1);
		assert(validMoves.contains(Space.A3));
	}
	
	@Test
	public void pawn_cannot_take_friendly_pieces_diagonally_Test() {
		board.put(Space.C3, new Pawn(Team.WHITE));
		board.put(Space.B3, new Pawn(Team.WHITE));
		board.put(Space.A3, new Pawn(Team.WHITE));
		
		ArrayList<Space> validMoves = testPawn.calculateValidMoves(origin);
		assert(validMoves.size() == 0);
	}
	
	@Test
	public void pawn_cannot_take_enemy_pieces_forward_Test() {
		board.put(Space.B3, new Pawn(Team.BLACK));
		
		ArrayList<Space> validMoves = testPawn.calculateValidMoves(origin);
		assert(validMoves.size() == 0);
	}
	
	@Test
	public void pawn_can_take_enemy_pieces_in_both_diagonal_directions_Test() {
		board.put(Space.C3, new Pawn(Team.BLACK));
		board.put(Space.A3, new Pawn(Team.BLACK));
		
		ArrayList<Space> validMoves = testPawn.calculateValidMoves(origin);
		assert(validMoves.size() == 4);
		assert(validMoves.contains(Space.C3));
		assert(validMoves.contains(Space.A3));
		assert(validMoves.contains(Space.B3));
		assert(validMoves.contains(Space.B4));
		
		board.put(Space.B3, new Pawn(Team.BLACK));
		
		validMoves = testPawn.calculateValidMoves(origin);
		assert(validMoves.size() == 2);
		assert(validMoves.contains(Space.C3));
		assert(validMoves.contains(Space.A3));
	}
	
	@Test
	public void pawn_cannot_take_enemy_pieces_behind_Test() {
		board.put(Space.C1, new Pawn(Team.BLACK));
		board.put(Space.B3, new Pawn(Team.BLACK));
		
		ArrayList<Space> validMoves = testPawn.calculateValidMoves(origin);

		assert(validMoves.size() == 0);
	}
	
	@Test
	public void pawn_movement_check_from_corner() {
		board = getEmptyBoard();
		origin = Space.A2;
		board.put(origin, new Pawn(Team.WHITE));
		
		ArrayList<Space> validMoves = testPawn.calculateValidMoves(origin);
		assert(validMoves.size() == 2);
		assert(validMoves.contains(Space.A3));
		assert(validMoves.contains(Space.A4));
	}
	
	@Test
	public void pawn_threat_check_from_corner() {
		board = getEmptyBoard();
		origin = Space.A2;
		board.put(origin, new Pawn(Team.WHITE));
		
		ArrayList<Space> validMoves = testPawn.calculateSpacesPieceCanThreaten(origin);
		assert(validMoves.size() == 1);
		assert(validMoves.contains(Space.B3));
	}
	
	// TODO - Test calculateSpacesPieceCanThreaten
	
	private LinkedHashMap<Space, Piece> getEmptyBoard() {
		Board board = new Board();
		LinkedHashMap<Space, Piece> boardMap = board.getBoard();
		
		for(Space space : boardMap.keySet()) {
			boardMap.put(space, null); // empty out the board
		}
				
		return boardMap;
	}

}
