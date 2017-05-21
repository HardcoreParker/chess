
public abstract class Piece {
	
	private Team team;
	public abstract void move();

	
	public Piece(Team team) {
		setTeam(team);
	}

	public char getShortName() {
		return this.toString().charAt(0);
	}
	
	public String getPaintedName() {
		return this.getTeam().getColor() + this.getShortName();
	}
	public Team getTeam() {
		return this.team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
}
