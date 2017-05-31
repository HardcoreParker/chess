package orchestration;

public enum Team {	
	WHITE("\u001B[37m"),
	BLACK("\u001B[35m");
	
	private String color;
	Team(String color) {
		this.color = color;
	}
	public String getColor() {
		return this.color;
	}
	
	public static Team getOpposingTeam(Team team) {
		if(team.equals(Team.WHITE)) {
			return Team.BLACK;
		} else {
			return Team.WHITE;
		}
	}
}
