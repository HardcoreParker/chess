package piece;
import java.util.ArrayList;

import orchestration.Board;
import orchestration.Space;
import orchestration.Team;

public class Rook extends Piece {

	public Rook(Team team) {
		super(team);
	}

	@Override
	public void move() {
		
	}

	@Override
	public ArrayList<Space> calculateValidMoves(Space origin) {
		ArrayList<Space> validMoves = new ArrayList<>();

		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, "N"));
		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, "S"));
		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, "E"));
		validMoves.addAll(Board.walkBoardUntilNextSpaceUnavailable(origin, "W"));
		
		return validMoves;
	}

}
