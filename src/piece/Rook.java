package piece;
import java.util.ArrayList;

import orchestration.Board;
import orchestration.Direction;
import orchestration.Space;
import orchestration.Team;

public class Rook extends Piece {

	public Rook(Team team) {
		super(team);
	}

	@Override
	public ArrayList<Space> calculateValidMoves(Space origin) {
		ArrayList<Space> validMoves = new ArrayList<>();

		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.N));
		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.S));
		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.E));
		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.W));
		
		return validMoves;
	}

	@Override
	public char getShortName() {
		return 'R';
	}

}
