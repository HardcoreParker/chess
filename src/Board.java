import java.util.HashMap;
import java.util.LinkedHashMap;

public class Board {
	
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
				result.append("|").append(System.lineSeparator()); // Take note
				row--;
			}
			result.append("|");
			if(board.get(space) != null) {
				result.append(board.get(space).getShortName());				
			} else {
				result.append("_");
			}
		}
		result.append("|");
		return result.toString();
	}
}
