package piece;
import java.util.ArrayList;

import orchestration.Board;
import orchestration.Direction;
import orchestration.Space;
import orchestration.Team;

public class King extends Piece implements ThreatenSeparateFromMove {

	public King(Team team) {
		super(team);
	}

	@Override
	public ArrayList<Space> calculateValidMoves(Space origin) {
		ArrayList<Space> potentialMoves = new ArrayList<>();
		
		potentialMoves.add(Direction.calculateDirection(Direction.N, origin));
		potentialMoves.add(Direction.calculateDirection(Direction.S, origin));
		potentialMoves.add(Direction.calculateDirection(Direction.E, origin));
		potentialMoves.add(Direction.calculateDirection(Direction.W, origin));
		potentialMoves.add(Direction.calculateDirection(Direction.NE, origin));
		potentialMoves.add(Direction.calculateDirection(Direction.NW, origin));
		potentialMoves.add(Direction.calculateDirection(Direction.SW, origin));
		potentialMoves.add(Direction.calculateDirection(Direction.SE, origin));
		
		ArrayList<Space> validMoves = new ArrayList<>();
		
		for(Space space : potentialMoves) {
			if(space != null) {
				validMoves.add(space);
			}
		}
		
		ArrayList<Space> allOpposingTeamMoves = Board.getAllThreatenedSpacesFromTeam(Team.getOpposingTeam(this.getTeam()));
		
		
		ArrayList<Space> invalidMoves = new ArrayList<>();
		for(Space space : validMoves) {
			if(allOpposingTeamMoves.contains(space)) {
				invalidMoves.add(space);
			} else if(Board.isSpaceOccupiedByEnemy(space, Team.getOpposingTeam(this.getTeam()))) { // meaning occupied by friendly
				invalidMoves.add(space);
			}
		}
		validMoves.removeAll(invalidMoves);
		
		return validMoves;
	}
	
	@Override
	public char getShortName() {
		return 'K';
	}

	@Override
	public ArrayList<Space> calculateSpacesPieceCanThreaten(Space origin) {
		ArrayList<Space> potentialMoves = new ArrayList<>();
		
		potentialMoves.add(Direction.calculateDirection(Direction.N, origin));
		potentialMoves.add(Direction.calculateDirection(Direction.S, origin));
		potentialMoves.add(Direction.calculateDirection(Direction.E, origin));
		potentialMoves.add(Direction.calculateDirection(Direction.W, origin));
		potentialMoves.add(Direction.calculateDirection(Direction.NE, origin));
		potentialMoves.add(Direction.calculateDirection(Direction.NW, origin));
		potentialMoves.add(Direction.calculateDirection(Direction.SW, origin));
		potentialMoves.add(Direction.calculateDirection(Direction.SE, origin));
		
		// Handle null spaces occurring from calculateDirection() not being boundary safe
		ArrayList<Space> validMoves = new ArrayList<>();
		
		for(Space move : potentialMoves) {
			if(move != null) {
				validMoves.add(move);
			}
		}
		
		return validMoves;
	}

}
