package piece;
import java.util.ArrayList;

import orchestration.Board;
import orchestration.Direction;
import orchestration.Space;
import orchestration.Team;

public class Queen extends Piece {

	public Queen(Team team) {
		super(team);
	}

	@Override
	public ArrayList<Space> calculateValidMoves(Space origin) {
		ArrayList<Space> validMoves = new ArrayList<>();
		
		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.N));
		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.S));
		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.E));
		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.W));
		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.NE));
		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.NW));
		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.SE));
		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, Direction.SW));
		
		return validMoves;
	}

	@Override
	public char getShortName() {
		return 'Q';
	}

}
