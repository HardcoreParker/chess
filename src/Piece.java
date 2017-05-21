
public abstract class Piece {
	
	private Team team;
	public abstract void move();

	
	public Piece(Team team) {
		setTeam(team);
	}
	
	public Team getTeam() {
		return this.team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
}
