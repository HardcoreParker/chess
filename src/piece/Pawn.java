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
		
		// Diagonal calculations
		ArrayList<Space> offensiveMoves = calculateOffensiveMoves(origin);
		list.addAll(offensiveMoves);
		
		return list;
	}
	
	private ArrayList<Space> calculateOffensiveMoves(Space origin) {
		ArrayList<Space> offensiveMoves = new ArrayList<>();
		
		if(this.getTeam() == Team.WHITE) {
			Space diagonalNE = Board.calculateDiagonalNE(origin);
			Space diagonalNW = Board.calculateDiagonalNW(origin);
			if(canPawnMoveOffensively(diagonalNE, this.getTeam())) {
				offensiveMoves.add(diagonalNE);
			}
			if(canPawnMoveOffensively(diagonalNW, this.getTeam())) {
				offensiveMoves.add(diagonalNW);
			}
		} else {
			Space diagonalSW = Board.calculateDiagonalSW(origin);
			Space diagonalSE = Board.calculateDiagonalSE(origin);
			if(canPawnMoveOffensively(diagonalSW, this.getTeam())) {
				offensiveMoves.add(diagonalSW);
			}
			if(canPawnMoveOffensively(diagonalSE, this.getTeam())) {
				offensiveMoves.add(diagonalSE);
			}
		}
		
		return offensiveMoves;
	}
	
	public ArrayList<Space> calculateSpacesPawnCanThreaten(Space origin) {
		ArrayList<Space> threatenedSpaces = new ArrayList<>();
		
		if(this.getTeam() == Team.WHITE) {
			threatenedSpaces.add(Board.calculateDiagonalNE(origin));
			threatenedSpaces.add(Board.calculateDiagonalNW(origin));
		} else {
			threatenedSpaces.add(Board.calculateDiagonalSW(origin));
			threatenedSpaces.add(Board.calculateDiagonalSE(origin));
		}
		
		return threatenedSpaces;
	}

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
