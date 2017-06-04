package piece;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import orchestration.Board;
import orchestration.Space;
import orchestration.Team;

public class KingTest {

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
	public void king_can_move_every_direction_test() {
		ArrayList<Space> validMoves = testKing.calculateValidMoves(origin);
		
		assert(validMoves.size() == 8);
		
		assert(validMoves.contains(Space.D5));
		assert(validMoves.contains(Space.D3));
		assert(validMoves.contains(Space.C4));
		assert(validMoves.contains(Space.E4));
		assert(validMoves.contains(Space.C5));
		assert(validMoves.contains(Space.E5));
		assert(validMoves.contains(Space.E3));
		assert(validMoves.contains(Space.C3));
	}
	
	@Test
	public void king_can_take_enemies_in_every_direction_test() {
		// Rotates putting 3 pawns above, right, bottom, then left of a king
		board.put(Space.D5, new Pawn(Team.BLACK));
		board.put(Space.C5, new Pawn(Team.BLACK));
		board.put(Space.E5, new Pawn(Team.BLACK));
		
		ArrayList<Space> validMoves = testKing.calculateValidMoves(origin);

		assert(validMoves.size() == 6);
		
		assert(validMoves.contains(Space.D5));
		assert(validMoves.contains(Space.C5));
		assert(validMoves.contains(Space.E5));
		
		assert(validMoves.contains(Space.D3));
		assert(validMoves.contains(Space.E3));
		assert(validMoves.contains(Space.C3));
		
		board = getEmptyBoard();
		board.put(origin, new King(Team.WHITE));
		testKing = (King) board.get(origin);
		
		board.put(Space.E5, new Pawn(Team.BLACK));
		board.put(Space.E4, new Pawn(Team.BLACK));
		board.put(Space.E3, new Pawn(Team.BLACK));
		
		validMoves = testKing.calculateValidMoves(origin);
		assert(validMoves.size() == 7);
		
		assert(validMoves.contains(Space.D5));
		assert(validMoves.contains(Space.C4));
		assert(validMoves.contains(Space.E4));
		assert(validMoves.contains(Space.C5));
		assert(validMoves.contains(Space.E5));
		assert(validMoves.contains(Space.E3));
		assert(validMoves.contains(Space.C3));
		
		
		board = getEmptyBoard();
		board.put(origin, new King(Team.WHITE));
		testKing = (King) board.get(origin);
		
		board.put(Space.C3, new Pawn(Team.BLACK));
		board.put(Space.D3, new Pawn(Team.BLACK));
		board.put(Space.E3, new Pawn(Team.BLACK));
		
		validMoves = testKing.calculateValidMoves(origin);
		assert(validMoves.size() == 8);
		
		assert(validMoves.contains(Space.D5));
		assert(validMoves.contains(Space.D3));
		assert(validMoves.contains(Space.C4));
		assert(validMoves.contains(Space.E4));
		assert(validMoves.contains(Space.C5));
		assert(validMoves.contains(Space.E5));
		assert(validMoves.contains(Space.E3));
		assert(validMoves.contains(Space.C3));
		
		board = getEmptyBoard();
		board.put(origin, new King(Team.WHITE));
		testKing = (King) board.get(origin);
		
		board.put(Space.C5, new Pawn(Team.BLACK));
		board.put(Space.C4, new Pawn(Team.BLACK));
		board.put(Space.C4, new Pawn(Team.BLACK));
		
		validMoves = testKing.calculateValidMoves(origin);
		assert(validMoves.size() == 7);
		
		assert(validMoves.contains(Space.D5));
		assert(validMoves.contains(Space.C4));
		assert(validMoves.contains(Space.E4));
		assert(validMoves.contains(Space.C5));
		assert(validMoves.contains(Space.E5));
		assert(validMoves.contains(Space.E3));
		assert(validMoves.contains(Space.C3));
	}
	
	@Test
	public void king_cant_move_through_teammates_test() {
		board.put(Space.D5, new Pawn(Team.WHITE));
		board.put(Space.D3, new Pawn(Team.WHITE));
		board.put(Space.C4, new Pawn(Team.WHITE));
		board.put(Space.E4, new Pawn(Team.WHITE));
		board.put(Space.C5, new Pawn(Team.WHITE));
		board.put(Space.E5, new Pawn(Team.WHITE));
		board.put(Space.E3, new Pawn(Team.WHITE));
		board.put(Space.C3, new Pawn(Team.WHITE));
		
		ArrayList<Space> validMoves = testKing.calculateValidMoves(origin);
		assert(validMoves.size() == 0);
	}
	
	@Test
	public void calculate_opposing_team_threats_test() {
		Space originWhite = Space.F5;
		Space originBlack = Space.D5;
		King testKingWhite;
		King testKingBlack;
		
		board.put(originWhite, new King(Team.WHITE));
		board.put(originBlack, new King(Team.BLACK));
		testKingWhite = (King) board.get(originWhite);
		testKingBlack = (King) board.get(originBlack);
		
		ArrayList<Space> spacesWhiteKingCanThreaten = testKingWhite.calculateSpacesPieceCanThreaten(originWhite);
		ArrayList<Space> spacesBlackKingCanThreaten = testKingBlack.calculateSpacesPieceCanThreaten(originBlack);
		
		assert(spacesWhiteKingCanThreaten.size() == 8);
		
		assert(spacesWhiteKingCanThreaten.contains(Space.E6));
		assert(spacesWhiteKingCanThreaten.contains(Space.F6));
		assert(spacesWhiteKingCanThreaten.contains(Space.G6));
		assert(spacesWhiteKingCanThreaten.contains(Space.E5));
		assert(spacesWhiteKingCanThreaten.contains(Space.E4));
		assert(spacesWhiteKingCanThreaten.contains(Space.F4));
		assert(spacesWhiteKingCanThreaten.contains(Space.G5));
		assert(spacesWhiteKingCanThreaten.contains(Space.G4));
		
		assert(spacesBlackKingCanThreaten.size() == 8);
		
		assert(spacesBlackKingCanThreaten.contains(Space.E6));
		assert(spacesBlackKingCanThreaten.contains(Space.E5));
		assert(spacesBlackKingCanThreaten.contains(Space.E4));
		assert(spacesBlackKingCanThreaten.contains(Space.D4));
		assert(spacesBlackKingCanThreaten.contains(Space.C4));
		assert(spacesBlackKingCanThreaten.contains(Space.C5));
		assert(spacesBlackKingCanThreaten.contains(Space.C6));
		assert(spacesBlackKingCanThreaten.contains(Space.D6));
	}
	
	@Test
	public void king_calculate_spaces_king_can_threaten_edge_test() {
		board = getEmptyBoard();
		origin = Space.A1;
		board.put(origin, new King(Team.WHITE));
		testKing = (King) board.get(origin);	
		
		ArrayList<Space> spacesKingCanThreaten = testKing.calculateSpacesPieceCanThreaten(origin);
		
		assert(spacesKingCanThreaten.size() == 3);
		assert(spacesKingCanThreaten.contains(Space.A2));
		assert(spacesKingCanThreaten.contains(Space.B2));
		assert(spacesKingCanThreaten.contains(Space.B1));
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
