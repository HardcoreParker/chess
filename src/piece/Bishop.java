package piece;
import java.util.ArrayList;

import orchestration.Board;
import orchestration.Direction;
import orchestration.Space;
import orchestration.Team;

public class Bishop extends Piece {

	public Bishop(Team team) {
		super(team);
	}

	@Override
	public ArrayList<Space> calculateValidMoves(Space origin) {
		ArrayList<Space> validMoves = new ArrayList<>();

		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.NE));
		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.NW));
		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.SW));
		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.SE));
		
		return validMoves;
	}

	@Override
	public char getShortName() {
		return 'B';
	}

}
