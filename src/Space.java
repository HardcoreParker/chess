
public enum Space {
	A8(new Rook(Team.BLACK)),
	B8(new Knight(Team.BLACK)),
	C8(new Bishop(Team.BLACK)),
	D8(new Queen(Team.BLACK)),
	E8(new King(Team.BLACK)),
	F8(new Bishop(Team.BLACK)),
	G8(new Knight(Team.BLACK)),
	H8(new Rook(Team.BLACK)),
	A7(new Pawn(Team.BLACK)),
	B7(new Pawn(Team.BLACK)),
	C7(new Pawn(Team.BLACK)),
	D7(new Pawn(Team.BLACK)),
	E7(new Pawn(Team.BLACK)),
	F7(new Pawn(Team.BLACK)),
	G7(new Pawn(Team.BLACK)),
	H7(new Pawn(Team.BLACK)),
	A6(null),
	B6(null),
	C6(null),
	D6(null),
	E6(null),
	F6(null),
	G6(null),
	H6(null),
	A5(null),
	B5(null),
	C5(null),
	D5(null),
	E5(null),
	F5(null),
	G5(null),
	H5(null),
	A4(null),
	B4(null),
	C4(null),
	D4(null),
	E4(null),
	F4(null),
	G4(null),
	H4(null),
	A3(null),
	B3(null),
	C3(null),
	D3(null),
	E3(null),
	F3(null),
	G3(null),
	H3(null),
	A2(new Pawn(Team.WHITE)),
	B2(new Pawn(Team.WHITE)),
	C2(new Pawn(Team.WHITE)),
	D2(new Pawn(Team.WHITE)),
	E2(new Pawn(Team.WHITE)),
	F2(new Pawn(Team.WHITE)),
	G2(new Pawn(Team.WHITE)),
	H2(new Pawn(Team.WHITE)),
	A1(new Rook(Team.WHITE)),
	B1(new Knight(Team.WHITE)),
	C1(new Bishop(Team.WHITE)),
	D1(new Queen(Team.WHITE)),
	E1(new King(Team.WHITE)),
	F1(new Bishop(Team.WHITE)),
	G1(new Knight(Team.WHITE)),
	H1(new Rook(Team.WHITE));
	
	private Piece occupant;
	private int row;
	private char column;
	
	Space(Piece piece){
		this.occupant = piece;
		this.row = Integer.parseInt(Character.toString(this.name().charAt(1)));
		this.column = this.name().charAt(0);
	}
	
	public Piece getOccupant() {
		return this.occupant;
	}
	public int getRow() {
		return this.row;
	}
	public char getColumn() {
		return this.column;
	}
}
