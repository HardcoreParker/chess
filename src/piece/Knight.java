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

		Space n = Direction.calculateN(origin);
		Space twiceN = null;
		if(n != null) {
			twiceN = Direction.calculateN(n);
			if(twiceN != null) {
				Space NNE = Direction.calculateE(twiceN);
				Space NNW = Direction.calculateW(twiceN);
				if(NNE != null || Board.isSpaceOccupiedByEnemy(NNE, this.getTeam())) {
					validMoves.add(NNE);
				}
				if(NNW != null || Board.isSpaceOccupiedByEnemy(NNW, this.getTeam())) {
					validMoves.add(NNW);
				}
			}
		}
		
		Space s = Direction.calculateS(origin);
		Space twiceS = null;
		if(s != null) {
			twiceS = Direction.calculateS(s);
			if(twiceS != null) {
				Space SSE = Direction.calculateE(twiceS);
				Space SSW = Direction.calculateW(twiceS);
				if(SSE != null || Board.isSpaceOccupiedByEnemy(SSE, this.getTeam())) {
					validMoves.add(SSE);
				}
				if(SSW != null || Board.isSpaceOccupiedByEnemy(SSW, this.getTeam())) {
					validMoves.add(SSW);
				}
			}
		}

		Space e = Direction.calculateE(origin);
		Space twiceE = null;
		if(e != null) {
			twiceE = Direction.calculateE(e);
			if(twiceE != null) {
				Space EEN = Direction.calculateN(twiceE);
				Space EES = Direction.calculateS(twiceE);
				if(EEN != null || !Board.isSpaceOccupiedByEnemy(EEN, this.getTeam())) {
					validMoves.add(EEN);
				}
				if(EES != null || !Board.isSpaceOccupiedByEnemy(EES, this.getTeam())) {
					validMoves.add(EES);
				}
			}
		}

		Space w = Direction.calculateW(origin);
		Space twiceW;
		if(w != null) {
			twiceW = Direction.calculateW(w);
			if(twiceW != null) {
				Space WWN = Direction.calculateN(twiceW);
				Space WWS = Direction.calculateS(twiceW);
				if(WWN != null || !Board.isSpaceOccupiedByEnemy(WWN, this.getTeam())) {
					validMoves.add(WWN);
				}
				if(WWS != null || !Board.isSpaceOccupiedByEnemy(WWS, this.getTeam())) {
					validMoves.add(WWS);
				}
			}
		}
		
		return validMoves;
	}
}
