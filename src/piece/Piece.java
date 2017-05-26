package piece;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import orchestration.Space;
import orchestration.Team;

public abstract class Piece {
	
	private Team team;
	public abstract void move();
	
	public Piece(Team team) {
		setTeam(team);
	}

	public abstract char getShortName();
	
	public String getPaintedName() {
		return this.getTeam().getColor() + this.getShortName();
	}
	public Team getTeam() {
		return this.team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
	public abstract ArrayList<Space> calculateValidMoves(Space origin);
}
