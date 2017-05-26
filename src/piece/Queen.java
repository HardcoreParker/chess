package piece;
import java.util.ArrayList;

import orchestration.Space;
import orchestration.Team;

public class Queen extends Piece {

	public Queen(Team team) {
		super(team);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Space> calculateValidMoves(Space origin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char getShortName() {
		return 'P';
	}

}
