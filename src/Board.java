import java.util.HashMap;
import java.util.LinkedHashMap;

public class Board {
	
	LinkedHashMap<Space, Piece> board = new LinkedHashMap<>();
	
	public Board() {
		for(Space value : Space.values()) {
			board.put(value, value.getOccupant());
		}
		
		//		Space.values();
//		
//		board.put("A3", null);
//		board.put("B3", null);
//		board.put("C3", null);
//		board.put("D3", null);
//		board.put("E3", null);
//		board.put("F3", null);
//		board.put("G3", null);
//		board.put("H3", null);
//		board.put("A4", null);
//		board.put("B4", null);
//		board.put("C4", null);
//		board.put("D4", null);
//		board.put("E4", null);
//		board.put("F4", null);
//		board.put("G4", null);
//		board.put("H4", null);
//		board.put("A5", null);
//		board.put("B5", null);
//		board.put("C5", null);
//		board.put("D5", null);
//		board.put("E5", null);
//		board.put("F5", null);
//		board.put("G5", null);
//		board.put("H5", null);
//		board.put("A6", null);
//		board.put("B6", null);
//		board.put("C6", null);
//		board.put("D6", null);
//		board.put("E6", null);
//		board.put("F6", null);
//		board.put("G6", null);
//		board.put("H6", null);
//		
//		
//		board.put("A2", new Pawn(Team.WHITE));
//		board.put("B2", new Pawn(Team.WHITE));
//		board.put("C2", new Pawn(Team.WHITE));
//		board.put("D2", new Pawn(Team.WHITE));
//		board.put("E2", new Pawn(Team.WHITE));
//		board.put("F2", new Pawn(Team.WHITE));
//		board.put("G2", new Pawn(Team.WHITE));
//		board.put("H2", new Pawn(Team.WHITE));
//		board.put("A7", new Pawn(Team.BLACK));
//		board.put("B7", new Pawn(Team.BLACK));
//		board.put("C7", new Pawn(Team.BLACK));
//		board.put("D7", new Pawn(Team.BLACK));
//		board.put("E7", new Pawn(Team.BLACK));
//		board.put("F7", new Pawn(Team.BLACK));
//		board.put("G7", new Pawn(Team.BLACK));
//		board.put("H7", new Pawn(Team.BLACK));
//		
//		board.put("A1", new Rook(Team.WHITE));
//		board.put("H1", new Rook(Team.WHITE));
//		board.put("A8", new Rook(Team.BLACK));
//		board.put("H8", new Rook(Team.BLACK));
//		
//		board.put("B1", new Knight(Team.WHITE));
//		board.put("G1", new Knight(Team.WHITE));
//		board.put("B8", new Knight(Team.BLACK));
//		board.put("G8", new Knight(Team.BLACK));
//		
//		board.put("C1", new Bishop(Team.WHITE));
//		board.put("F1", new Bishop(Team.WHITE));
//		board.put("C8", new Bishop(Team.BLACK));
//		board.put("F8", new Bishop(Team.BLACK));
//		
//		board.put("D1", new Queen(Team.WHITE));
//		board.put("D8", new Queen(Team.BLACK));
//
//		board.put("E1", new King(Team.WHITE));
//		board.put("E8", new King(Team.BLACK));
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
				result.append(System.lineSeparator()) // Take note
				.append("|");
				row--;
			}
			result.append("|");
//			.append(space.name())
//			.append(":");
			if(board.get(space) != null) {
				result.append(board.get(space).toString());				
			} else {
				result.append("_");
			}
		}
		
		return result.toString();
	}
}
