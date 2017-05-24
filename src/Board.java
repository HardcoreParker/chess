import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
	// is this right, should we be returning the actual enum or the value of the board hashmap - YES, it's right. 
	// We will use the value of 'up' to compare to valid move sets, which will be ran against the state of the board 
	public static Space calculateUp(Space origin) {
		if(origin.getRow() < 8) {
			int newRow = origin.getRow() + 1;
			
			return calculateSpace(origin.getColumn(), newRow);
		} else {
			return null;
		}
	}

	public static Space calculateDown(Space origin) {
		if(origin.getRow() > 1) {
			int newRow = origin.getRow() - 1;
			
			return calculateSpace(origin.getColumn(), newRow);
		} else {
			return null;
		}
	}
	
	public static Space calculateLeft(Space origin) {
		if(isLeftColumn(origin.getColumn())) {
			return null;
		}
		char newColumn = (char) (origin.getColumn() - 1);
		
		return calculateSpace(newColumn, origin.getRow());
	}

	public static Space calculateRight(Space origin) {
		if(isRightColumn(origin.getColumn())) {
			return null;
		}
		char newColumn = (char) (origin.getColumn() + 1);
		
		return calculateSpace(newColumn, origin.getRow());
	}

	public static Space calculateDiagonalNE(Space origin) {
		if(isTopRow(origin.getRow()) || isRightColumn(origin.getColumn())) {
			return null;
		}
		char newColumn = (char) (origin.getColumn() + 1);
		int newRow = origin.getRow() + 1;
		
		return calculateSpace(newColumn, newRow);
	}

	public static Space calculateDiagonalSE(Space origin) {
		if(isBottomRow(origin.getRow()) || isRightColumn(origin.getColumn())) {
			return null;
		}
		char newColumn = (char) (origin.getColumn() + 1);
		int newRow = origin.getRow() - 1;
		
		return calculateSpace(newColumn, newRow);
	}

	public static Space calculateDiagonalNW(Space origin) {
		if(isTopRow(origin.getRow()) || isLeftColumn(origin.getColumn())) {
			return null;
		}
		char newColumn = (char) (origin.getColumn() - 1);
		int newRow = origin.getRow() + 1;
		
		return calculateSpace(newColumn, newRow);
	}

	public static Space calculateDiagonalSW(Space origin) {
		if(isBottomRow(origin.getRow()) || isLeftColumn(origin.getColumn())) {
			return null;
		}
		char newColumn = (char) (origin.getColumn() - 1);
		int newRow = origin.getRow() - 1;
		
		return calculateSpace(newColumn, newRow);
	}
	
	public static ArrayList<Space> walkBoardUntilNextSpaceUnavailable(Space origin, String direction) {
		ArrayList<Space> list = new ArrayList<Space>();
		Space next = origin;
		while(next != null) {
			
			if(direction.equals("NE")) {
				next = calculateDiagonalNE(next);
			} else if(direction.equals("NW")) {
				next = calculateDiagonalNW(next);
			} else if(direction.equals("SE")) {
				next = calculateDiagonalSE(next);
			} else if(direction.equals("SW")) {
				next = calculateDiagonalSW(next);
			} else if(direction.equals("N")) {
				next = calculateUp(next);
			} else if(direction.equals("S")) {
				next = calculateDown(next);
			} else if(direction.equals("W")) {
				next = calculateLeft(next);
			} else if(direction.equals("E")) {
				next = calculateRight(next);
			}
			
			if(isSpaceEmpty(next)) {
				list.add(next);
			} else {
				next = null;
			}
		}
		return list;
	}
	
	public static ArrayList<Space> walkBoardUntilNextSpaceUnavailable(Space origin, String direction, int times) {
		ArrayList<Space> list = new ArrayList<Space>();
		Space next = origin;
		while(next != null && times > 0) {
			
			if(direction.equals("NE")) {
				next = calculateDiagonalNE(next);
			} else if(direction.equals("NW")) {
				next = calculateDiagonalNW(next);
			} else if(direction.equals("SE")) {
				next = calculateDiagonalSE(next);
			} else if(direction.equals("SW")) {
				next = calculateDiagonalSW(next);
			} else if(direction.equals("N")) {
				next = calculateUp(next);
			} else if(direction.equals("S")) {
				next = calculateDown(next);
			} else if(direction.equals("W")) {
				next = calculateLeft(next);
			} else if(direction.equals("E")) {
				next = calculateRight(next);
			}
			
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
		return board.get(space) != null && board.get(space).getTeam() != team;
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
}
