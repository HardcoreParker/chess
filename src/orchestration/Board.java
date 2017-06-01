package orchestration;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import exception.NoKingFoundException;
import piece.King;
import piece.Pawn;
import piece.Piece;

public class Board {
	
	private static final String BOARD_COLOR = "\u001B[33m"; // purple
	static LinkedHashMap<Space, Piece> board = new LinkedHashMap<>();
	
	public Board() {
		for(Space value : Space.values()) {
			board.put(value, value.getOccupant());
		}
	}
	
	// Singleton?
	public LinkedHashMap<Space, Piece> getBoard() {
		return board;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		int row = 8;
		for(Space space : board.keySet()) {
			if(space.getRow() < row) {
				result.append(getBoardDivider()).append(System.lineSeparator()); // Take note
				row--;
			}
			result.append(getBoardDivider());
			if(board.get(space) != null) {
				result.append(board.get(space).getPaintedName());				
			} else {
				result.append(getEmptySpace());
			}
		}
		result.append("|");
		return result.toString();
	}
	
	public static ArrayList<Space> walkBoardUntilNextSpaceUnavailable(Space origin, Direction direction) {
		ArrayList<Space> list = new ArrayList<Space>();
		Space next = origin;
		while(next != null) {
			
			next = calculateDirection(direction, next);
			
			if(isSpaceEmpty(next) && next != null) {
				list.add(next);
			} else if (!isSpaceEmpty(next) && 
						isSpaceOccupiedByEnemy(next, board.get(origin).getTeam())) {
				list.add(next); // The space can be taken
				break; // Stop walking the board in that direction
			}
				else {
				next = null; // Space was occupied by friendly, nulling out next will fail the conditional
			}
		}
		return list;
	}
	
	public static ArrayList<Space> walkBoardUntilNextSpaceUnavailable(Space origin, Direction direction, int times) {
		ArrayList<Space> list = new ArrayList<Space>();
		Space next = origin;
		while(next != null && times > 0) {
			
			next = calculateDirection(direction, next);
			
			if(isSpaceEmpty(next)) {
				list.add(next);
				times--;
			} else {
				next = null;
			}
		}
		return list;
	}
	
	public static boolean isSpaceEmpty(Space space) {
		return board.get(space) == null;
	}
	
	public static boolean isSpaceOccupiedByEnemy(Space space, Team team) {
		return !isSpaceEmpty(space) && board.get(space).getTeam() != team;
	}
	
	private static Space calculateDirection(Direction direction, Space next) {
		if(direction.equals(Direction.NE)) {
			next = Direction.calculateNE(next);
		} else if(direction.equals(Direction.NW)) {
			next = Direction.calculateNW(next);
		} else if(direction.equals(Direction.SE)) {
			next = Direction.calculateSE(next);
		} else if(direction.equals(Direction.SW)) {
			next = Direction.calculateSW(next);
		} else if(direction.equals(Direction.N)) {
			next = Direction.calculateN(next);
		} else if(direction.equals(Direction.S)) {
			next = Direction.calculateS(next);
		} else if(direction.equals(Direction.W)) {
			next = Direction.calculateW(next);
		} else if(direction.equals(Direction.E)) {
			next = Direction.calculateE(next);
		}
		return next;
	}
	
	private String getBoardDivider() {
		return BOARD_COLOR + "|";
	}
	private String getEmptySpace() {
		return BOARD_COLOR + "_";
	}
	
	private static Space findKing(Team team) throws NoKingFoundException {
		for(Space space : board.keySet()) {
			if(board.get(space) != null && board.get(space).getClass().equals(King.class) && board.get(space).getTeam() == team) {
				return space;
			}
		}
		throw new NoKingFoundException();
	}

	public static boolean isTeamInCheck(Team team) throws NoKingFoundException {
		Space kingSpace = findKing(team);
		ArrayList<Space> opposingTeamThreats = getAllThreatenedSpacesFromTeam(Team.getOpposingTeam(team));
		
		if(opposingTeamThreats.contains(kingSpace)) {
			return true;
		} else {
			return false;
		}
	}

	public static ArrayList<Space> getAllThreatenedSpacesFromTeam(Team team) {
		ArrayList<Space> threatenedSpaces = new ArrayList<>();

		for(Space space : board.keySet()) {
			Piece piece = board.get(space);
			if(piece != null && piece.getTeam().equals(team)) {
				if(piece.getClass() == Pawn.class) { // Since we're only using this to calculate check and checkmates, we only calculate a pawn's offensive moves
					threatenedSpaces.addAll(((Pawn) piece).calculateSpacesPieceCanThreaten(space));
				} else if(piece.getClass() == King.class) {
					threatenedSpaces.addAll(((King) piece).calculateSpacesPieceCanThreaten(space));
				} else {
					threatenedSpaces.addAll(piece.calculateValidMoves(space));
				}
			}
		}
		
		return threatenedSpaces;
	}
	
	public static boolean isTeamInCheckmate(Team team) {
		// TODO - Implement checkmate
		
		return false;
	}
}
