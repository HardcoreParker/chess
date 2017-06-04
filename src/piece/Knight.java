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

		Space n = Direction.calculateDirection(Direction.N, origin);
		Space twiceN = null;
		if(n != null) {
			twiceN = Direction.calculateDirection(Direction.N, n);
			if(twiceN != null) {
				Space NNE = Direction.calculateDirection(Direction.E, twiceN);
				Space NNW = Direction.calculateDirection(Direction.W, twiceN);
				if(NNE != null || Board.isSpaceOccupiedByEnemy(NNE, this.getTeam())) {
					validMoves.add(NNE);
				}
				if(NNW != null || Board.isSpaceOccupiedByEnemy(NNW, this.getTeam())) {
					validMoves.add(NNW);
				}
			}
		}
		
		Space s = Direction.calculateDirection(Direction.S, origin);
		Space twiceS = null;
		if(s != null) {
			twiceS = Direction.calculateDirection(Direction.S, s);
			if(twiceS != null) {
				Space SSE = Direction.calculateDirection(Direction.E, twiceS);
				Space SSW = Direction.calculateDirection(Direction.W, twiceS);
				if(SSE != null || Board.isSpaceOccupiedByEnemy(SSE, this.getTeam())) {
					validMoves.add(SSE);
				}
				if(SSW != null || Board.isSpaceOccupiedByEnemy(SSW, this.getTeam())) {
					validMoves.add(SSW);
				}
			}
		}

		Space e = Direction.calculateDirection(Direction.E, origin);
		Space twiceE = null;
		if(e != null) {
			twiceE = Direction.calculateDirection(Direction.E, e);
			if(twiceE != null) {
				Space EEN = Direction.calculateDirection(Direction.N, twiceE);
				Space EES = Direction.calculateDirection(Direction.S, twiceE);
				if(EEN != null || !Board.isSpaceOccupiedByEnemy(EEN, this.getTeam())) {
					validMoves.add(EEN);
				}
				if(EES != null || !Board.isSpaceOccupiedByEnemy(EES, this.getTeam())) {
					validMoves.add(EES);
				}
			}
		}

		Space w = Direction.calculateDirection(Direction.W, origin);
		Space twiceW;
		if(w != null) {
			twiceW = Direction.calculateDirection(Direction.W, w);
			if(twiceW != null) {
				Space WWN = Direction.calculateDirection(Direction.N, twiceW);
				Space WWS = Direction.calculateDirection(Direction.S, twiceW);
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
