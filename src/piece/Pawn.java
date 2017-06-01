package piece;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import orchestration.Board;
import orchestration.Direction;
import orchestration.Space;
import orchestration.Team;

public class Pawn extends Piece {

	private boolean hasMoved = false;
	
	public Pawn(Team team) {
		super(team);
	}

	@Override
	public ArrayList<Space> calculateValidMoves(Space origin) {
		return calculateSpacesPawnCanMoveTo(origin, hasMoved);
	}
	
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
	
	private ArrayList<Space> calculateSpacesPawnCanMoveTo(Space origin, boolean hasAlreadyMoved) {
		ArrayList<Space> list = new ArrayList<>();
		
		int times = hasAlreadyMoved ? 1 : 2;
		
		if(this.getTeam() == Team.WHITE) {
			list.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.N, times));
			hasAlreadyMoved = true;
		} else {
			list.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.S, times));
			hasAlreadyMoved = true;
		}
		
		ArrayList<Space> offensiveMoves = calculateOffensiveMoves(origin);
		list.addAll(offensiveMoves);
		
		return list;
	}
	
	private ArrayList<Space> calculateOffensiveMoves(Space origin) {
		ArrayList<Space> offensiveMoves = new ArrayList<>();
		
		if(this.getTeam() == Team.WHITE) {
			Space NE = Direction.calculateNE(origin);
			Space NW = Direction.calculateNW(origin);
			if(canPawnMoveOffensively(NE, this.getTeam())) {
				offensiveMoves.add(NE);
			}
			if(canPawnMoveOffensively(NW, this.getTeam())) {
				offensiveMoves.add(NW);
			}
		} else {
			Space SW = Direction.calculateSW(origin);
			Space SE = Direction.calculateSE(origin);
			if(canPawnMoveOffensively(SW, this.getTeam())) {
				offensiveMoves.add(SW);
			}
			if(canPawnMoveOffensively(SE, this.getTeam())) {
				offensiveMoves.add(SE);
			}
		}
		
		return offensiveMoves;
	}
	// PARKER - I should move the king first and then check that version of the board to see if the king's new position is within the opposing team's potential moves
	// How does this effect calculating check? It doesn't.
	private boolean canPawnMoveOffensively(Space space, Team team) {
		return space != null && 
				!Board.isSpaceEmpty(space) && 
				Board.isSpaceOccupiedByEnemy(space, team);
	}

	@Override
	public char getShortName() {
		return 'P';
	}
}
