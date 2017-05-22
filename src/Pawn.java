import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Pawn extends Piece {

	private boolean hasAlreadyMoved = false;
	
	public Pawn(Team team) {
		super(team);
	}

	@Override
	public void move() {
	}

	@Override
	public ArrayList<Space> calculateValidMoves(Space origin) {
		ArrayList<Space> availableSpaces = new ArrayList<>();
		
		availableSpaces.addAll(calculateSpacesPawnCanMoveTo(origin, hasAlreadyMoved));
		
		return availableSpaces;
	}
	
	private ArrayList<Space> calculateSpacesPawnCanMoveTo(Space origin, boolean hasAlreadyMoved) {
		ArrayList<Space> list = new ArrayList<>();
		
		// Calculate one move 'forward'
		int times = hasAlreadyMoved ? 1 : 2;
		
		if(this.getTeam() == Team.WHITE) {
			list = Board.walkBoardUntilNextSpaceUnavailable(origin, "N", times);
			hasAlreadyMoved = true;
		} else {
			list = Board.walkBoardUntilNextSpaceUnavailable(origin, "S", times);
			hasAlreadyMoved = true;
		}
		
		// Diagonal calculations
		if(this.getTeam() == Team.WHITE) {
			Space diagonalNE = Board.calculateDiagonalNE(origin);
			Space diagonalNW = Board.calculateDiagonalNW(origin);
			if(canPawnMoveDiagonally(diagonalNE, this.getTeam())) {
				list.add(diagonalNE);
			}
			if(canPawnMoveDiagonally(diagonalNW, this.getTeam())) {
				list.add(diagonalNW);
			}
		} else {
			Space diagonalSW = Board.calculateDiagonalSW(origin);
			Space diagonalSE = Board.calculateDiagonalSW(origin);
			if(canPawnMoveDiagonally(diagonalSW, this.getTeam())) {
				list.add(diagonalSW);
			}
			if(canPawnMoveDiagonally(diagonalSE, this.getTeam())) {
				list.add(diagonalSE);
			}
		}
		return list;
	}

	private boolean canPawnMoveDiagonally(Space space, Team team) {
		return space != null && 
				!Board.isSpaceEmpty(space) && 
				Board.isSpaceOccupiedByEnemy(space, team);
	}
}
