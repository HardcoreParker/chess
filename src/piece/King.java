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
		
		// TODO - WIP Pickup
		validMoves.add(Board.calculateN(origin));
		validMoves.add(Board.calculateS(origin));
		validMoves.add(Board.calculateE(origin));
		validMoves.add(Board.calculateW(origin));
		validMoves.add(Board.calculateDiagonalNE(origin));
		validMoves.add(Board.calculateDiagonalNW(origin));
		validMoves.add(Board.calculateDiagonalSE(origin));
		validMoves.add(Board.calculateDiagonalSW(origin));
		
		
		ArrayList<Space> allOpposingTeamMoves = Board.getAllOpposingTeamMoves(this.getTeam());
		
		for(Space space : validMoves) {
			if(allOpposingTeamMoves.contains(space)) {
				validMoves.remove(space);
			}
		}
		
		return validMoves;
	}

	@Override
	public char getShortName() {
		return 'K';
	}

}
