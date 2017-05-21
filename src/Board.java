import java.util.HashMap;
import java.util.LinkedHashMap;

public class Board {
	
	private static final String BOARD_COLOR = "\u001B[33m"; // purple
	LinkedHashMap<Space, Piece> board = new LinkedHashMap<>();
	
	public Board() {
		for(Space value : Space.values()) {
			board.put(value, value.getOccupant());
		}
	}
	
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
			char newColumn = origin.getColumn();
			int newRow = origin.getRow() + 1;
			
			return calculateSpace(newColumn, newRow);
		} else {
			return null;
		}
	}
	public static Space calculateDown(Space origin) {
		if(origin.getRow() > 1) {
			char newColumn = origin.getColumn();
			int newRow = origin.getRow() - 1;
			
			return calculateSpace(newColumn, newRow);
		} else {
			return null;
		}
	}
	
	private String getBoardDivider() {
		return BOARD_COLOR + "|";
	}
	private String getEmptySpace() {
		return BOARD_COLOR + "_";
	}

	public static Space calculateDiagonalNE(Space origin) {
		char newColumn = (char) (origin.getColumn() + 1);
		int newRow = origin.getRow() + 1;
		
		return calculateSpace(newColumn, newRow);
	}

	public static Space calculateDiagonalSE(Space origin) {
		char newColumn = (char) (origin.getColumn() + 1);
		int newRow = origin.getRow() - 1;
		
		return calculateSpace(newColumn, newRow);
	}

	public static Space calculateDiagonalNW(Space origin) {
		char newColumn = (char) (origin.getColumn() - 1);
		int newRow = origin.getRow() + 1;
		
		return calculateSpace(newColumn, newRow);
	}

	public static Space calculateDiagonalSW(Space origin) {
		char newColumn = (char) (origin.getColumn() - 1);
		int newRow = origin.getRow() - 1;
		
		return calculateSpace(newColumn, newRow);
	}
	
	private static Space calculateSpace(char column, int row) {
		return Space.valueOf(Space.class, String.valueOf(column)+String.valueOf(row));
	}
	
}
