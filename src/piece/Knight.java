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

		
		// In progress brute force attempt at figuring this out. Should look into handling this with errors and not null pointers
		Space n = Board.calculateN(origin);
		Space twiceN = null;
		if(n != null) {
			twiceN = Board.calculateN(n);
			if(twiceN != null) {
				Space NNE = Board.calculateE(twiceN);
				Space NNW = Board.calculateW(twiceN);
				if(NNE != null && !Board.isSpaceOccupiedByEnemy(NNE, this.getTeam())) {
					validMoves.add(NNE);
				}
				if(NNW != null && !Board.isSpaceOccupiedByEnemy(NNW, this.getTeam())) {
					validMoves.add(NNW);
				}
			}
		}
		
		
		
		Space s = Board.calculateS(origin);
		Space twiceS = null;
		if(s != null) {
			twiceS = Board.calculateS(s);
		}

		Space e = Board.calculateE(origin);
		Space twiceE = null;
		if(e != null) {
			twiceE = Board.calculateE(e);
		}

		Space w = Board.calculateW(origin);
		Space twiceW;
		if(w != null) {
			twiceW = Board.calculateW(w);
		}
		
		
		
		return validMoves;
	}
}
