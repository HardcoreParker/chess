package piece;
import java.util.ArrayList;

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
		ArrayList<Space> validMoves = new ArrayList<>();
		
		validMoves.add(Direction.calculateN(origin));
		validMoves.add(Direction.calculateS(origin));
		validMoves.add(Direction.calculateE(origin));
		validMoves.add(Direction.calculateW(origin));
		validMoves.add(Direction.calculateNE(origin));
		validMoves.add(Direction.calculateNW(origin));
		validMoves.add(Direction.calculateSE(origin));
		validMoves.add(Direction.calculateSW(origin));
		
		
		ArrayList<Space> allOpposingTeamMoves = Board.getAllOpposingTeamsPotentialMoves(this.getTeam());
		
		
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

}
