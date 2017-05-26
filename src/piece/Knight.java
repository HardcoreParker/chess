package piece;
import java.util.ArrayList;

import orchestration.Board;
import orchestration.Direction;
import orchestration.Space;
import orchestration.Team;

public class Knight extends Piece {

	public Knight(Team team) {
		super(team);
	}

	@Override
	public char getShortName() {
		return 'N';
	}

	// We're going to break the methodology of the knight's move to "Twice in every cardinal direction, then once to each side"
	@Override
	public ArrayList<Space> calculateValidMoves(Space origin) {
		ArrayList<Space> validMoves = new ArrayList<>();

		Space twiceNorth = (Board.calculateN(Board.calculateN(origin)));
		Space twiceSouth = (Board.calculateS(Board.calculateS(origin)));
		Space twiceEast = (Board.calculateE(Board.calculateE(origin)));
		Space twiceWest = (Board.calculateW(Board.calculateW(origin)));
		
		return validMoves;
	}

}
