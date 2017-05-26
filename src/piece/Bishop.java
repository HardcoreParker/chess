package piece;
import java.util.ArrayList;

import orchestration.Space;
import orchestration.Team;

public class Bishop extends Piece {

	public Bishop(Team team) {
		super(team);
	}

	@Override
	public ArrayList<Space> calculateValidMoves(Space origin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char getShortName() {
		return 'B';
	}

}
