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
	
	public static Space calculateN(Space origin) {
		if(isTopRow(origin.getRow())) {
			return null;
		} else {
			int newRow = origin.getRow() + 1;
			
			return calculateSpace(origin.getColumn(), newRow);
		}
	}

	public static Space calculateS(Space origin) {
		if(isBottomRow(origin.getRow())) {
			return null;
		} else {
			int newRow = origin.getRow() - 1;
			
			return calculateSpace(origin.getColumn(), newRow);
		}
	}
	
	public static Space calculateW(Space origin) {
		if(isLeftColumn(origin.getColumn())) {
			return null;
		} else {
			char newColumn = (char) (origin.getColumn() - 1);
			
			return calculateSpace(newColumn, origin.getRow());
		}
	}

	public static Space calculateE(Space origin) {
		if(isRightColumn(origin.getColumn())) {
			return null;
		} else {
			char newColumn = (char) (origin.getColumn() + 1);
			
			return calculateSpace(newColumn, origin.getRow());
		}
	}

	public static Space calculateNE(Space origin) {
		if(isTopRow(origin.getRow()) || isRightColumn(origin.getColumn())) {
			return null;
		} else {
			char newColumn = (char) (origin.getColumn() + 1);
			int newRow = origin.getRow() + 1;
			
			return calculateSpace(newColumn, newRow);
		}
	}

	public static Space calculateSE(Space origin) {
		if(isBottomRow(origin.getRow()) || isRightColumn(origin.getColumn())) {
			return null;
		} else {
			char newColumn = (char) (origin.getColumn() + 1);
			int newRow = origin.getRow() - 1;
			
			return calculateSpace(newColumn, newRow);
		}
	}

	public static Space calculateNW(Space origin) {
		if(isTopRow(origin.getRow()) || isLeftColumn(origin.getColumn())) {
			return null;
		} else {
			char newColumn = (char) (origin.getColumn() - 1);
			int newRow = origin.getRow() + 1;
			
			return calculateSpace(newColumn, newRow);
		}
	}

	public static Space calculateSW(Space origin) {
		if(isBottomRow(origin.getRow()) || isLeftColumn(origin.getColumn())) {
			return null;
		} else {
			char newColumn = (char) (origin.getColumn() - 1);
			int newRow = origin.getRow() - 1;
			
			return calculateSpace(newColumn, newRow);
		}
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
			next = calculateNE(next);
		} else if(direction.equals(Direction.NW)) {
			next = calculateNW(next);
		} else if(direction.equals(Direction.SE)) {
			next = calculateSE(next);
		} else if(direction.equals(Direction.SW)) {
			next = calculateSW(next);
		} else if(direction.equals(Direction.N)) {
			next = calculateN(next);
		} else if(direction.equals(Direction.S)) {
			next = calculateS(next);
		} else if(direction.equals(Direction.W)) {
			next = calculateW(next);
		} else if(direction.equals(Direction.E)) {
			next = calculateE(next);
		}
		return next;
	}
	
	private static Space calculateSpace(char column, int row) {
		return Space.valueOf(Space.class, String.valueOf(column)+String.valueOf(row));
	}
	
	private static boolean isLeftColumn(char column) {
		return column == 'A';
	}
	private static boolean isRightColumn(char column) {
		return column == 'H';
	}
	private static boolean isTopRow(int row) {
		return row == 8;
	}
	private static boolean isBottomRow(int row) {
		return row == 1;
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
		ArrayList<Space> opposingTeamValidMoves = getAllOpposingTeamsPotentialMoves(team);
		
		if(opposingTeamValidMoves.contains(kingSpace)) {
			return true;
		} else {
			return false;
		}
	}

	public static ArrayList<Space> getAllOpposingTeamsPotentialMoves(Team team) {
		ArrayList<Space> opposingTeamValidMoves = new ArrayList<>();

		for(Space space : board.keySet()) {
			Piece piece = board.get(space);
			if(piece != null && piece.getTeam().equals(Team.getOpposingTeam(team))) {
				if(piece.getClass() == Pawn.class) { // Since we're only using this to calculate check and checkmates, we only calculate a pawn's offensive moves
					opposingTeamValidMoves.addAll(((Pawn) piece).calculateSpacesPawnCanThreaten(space));
				} else {
					opposingTeamValidMoves.addAll(piece.calculateValidMoves(space));
				}
			}
		}
		
		return opposingTeamValidMoves;
	}
	
	public static boolean isTeamInCheckmate(Team team) {
		// TODO - Stub
		return false;
	}
}
