package piece;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;

import orchestration.Board;
import orchestration.Direction;
import orchestration.Space;
import orchestration.Team;

public class King extends Piece {

	public King(Team team) {
		super(team);
	}
	
	@Override
	public ArrayList<Space> calculateValidMoves(Space origin) {
		ArrayList<Space> potentialMoves = new ArrayList<>();

		potentialMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.N, 1));
		potentialMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.S, 1));
		potentialMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.E, 1));
		potentialMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.W, 1));
		potentialMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.NE, 1));
		potentialMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.NW, 1));
		potentialMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.SE, 1));
		potentialMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.SW, 1));
		
		ArrayList<Space> verifiedMoves = new ArrayList<>();

		
		for(Space potentialMove : potentialMoves) {
			LinkedHashMap<Space, Piece> theoreticalBoard = Board.getBoard(); // TODO - deep clone board and don't play with the real board to perform these tests
			Board.processMove(origin, potentialMove, this.getTeam());
			if(!Board.isTeamInCheck(this.getTeam())) {
				verifiedMoves.add(potentialMove);
			}
			Board.processMove(potentialMove, origin, this.getTeam()); // Move the king back
		}
		
		ArrayList<Space> allOpposingTeamMoves = Board.getAllThreatenedSpacesFromTeam(Team.getOpposingTeam(this.getTeam()), theoreticalBoard);
		
		
		ArrayList<Space> invalidMoves = new ArrayList<>();
		for(Space space : potentialMoves) {
			if(allOpposingTeamMoves.contains(space)) {
				invalidMoves.add(space);
			} else if(Board.isSpaceOccupiedByEnemy(space, Team.getOpposingTeam(this.getTeam()))) { // meaning occupied by friendly
				invalidMoves.add(space);
			}
		}
		potentialMoves.removeAll(invalidMoves);
		
		return potentialMoves;
	}
	
	@Override
	public char getShortName() {
		return 'K';
	}

	public ArrayList<Space> calculateSpacesKingCanThreaten(Space origin) {
		ArrayList<Space> validMoves = new ArrayList<>();
		
		// null checking to prevent walking over edge of board using not null safe board calculations
		ArrayList<Space> potentialMoves = new ArrayList<>();
		potentialMoves.add(Direction.calculateN(origin));
		potentialMoves.add(Direction.calculateS(origin));
		potentialMoves.add(Direction.calculateE(origin));
		potentialMoves.add(Direction.calculateW(origin));
		potentialMoves.add(Direction.calculateNE(origin));
		potentialMoves.add(Direction.calculateNW(origin));
		potentialMoves.add(Direction.calculateSE(origin));
		potentialMoves.add(Direction.calculateSW(origin));
		
		for(Space move : potentialMoves) {
			if (move != null) {
				validMoves.add(move);
			}
		}
		
		return validMoves;
	}

}
