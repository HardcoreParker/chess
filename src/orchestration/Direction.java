package orchestration;

public enum Direction {
	N(),
	S(),
	E(),
	W(),
	NE(),
	NW(),
	SW(),
	SE();
	
	/* 
	 * All of these 'calculateDirection' methods do not handle out of bounds (OOB) OR occupied spaces on their own and only need to be used in threat calculation and 
	 * cases like Knight movement where the piece does not need to walk a cleared 'path' to perform calculations. All OOB and OccupiedSpace checks need to be performed manually
	 * In cases where these methods are used, otherwise use "Board.walkBoardUntilNextSpaceUnavailable" for safe calculations
	 */
	
	public static Space calculateDirection(Direction direction, Space origin) {
		if(direction.equals(Direction.NE)) {
			origin = Direction.calculateNE(origin);
		} else if(direction.equals(Direction.NW)) {
			origin = Direction.calculateNW(origin);
		} else if(direction.equals(Direction.SE)) {
			origin = Direction.calculateSE(origin);
		} else if(direction.equals(Direction.SW)) {
			origin = Direction.calculateSW(origin);
		} else if(direction.equals(Direction.N)) {
			origin = Direction.calculateN(origin);
		} else if(direction.equals(Direction.S)) {
			origin = Direction.calculateS(origin);
		} else if(direction.equals(Direction.W)) {
			origin = Direction.calculateW(origin);
		} else if(direction.equals(Direction.E)) {
			origin = Direction.calculateE(origin);
		}
		return origin;
	}
	
	private static Space calculateN(Space origin) {
		if(isTopRow(origin.getRow())) {
			return null;
		} else {
			int newRow = origin.getRow() + 1;
			
			return calculateSpace(origin.getColumn(), newRow);
		}
	}

	private static Space calculateS(Space origin) {
		if(isBottomRow(origin.getRow())) {
			return null;
		} else {
			int newRow = origin.getRow() - 1;
			
			return calculateSpace(origin.getColumn(), newRow);
		}
	}
	
	private static Space calculateW(Space origin) {
		if(isLeftColumn(origin.getColumn())) {
			return null;
		} else {
			char newColumn = (char) (origin.getColumn() - 1);
			
			return calculateSpace(newColumn, origin.getRow());
		}
	}

	private static Space calculateE(Space origin) {
		if(isRightColumn(origin.getColumn())) {
			return null;
		} else {
			char newColumn = (char) (origin.getColumn() + 1);
			
			return calculateSpace(newColumn, origin.getRow());
		}
	}

	private static Space calculateNE(Space origin) {
		if(isTopRow(origin.getRow()) || isRightColumn(origin.getColumn())) {
			return null;
		} else {
			char newColumn = (char) (origin.getColumn() + 1);
			int newRow = origin.getRow() + 1;
			
			return calculateSpace(newColumn, newRow);
		}
	}

	private static Space calculateSE(Space origin) {
		if(isBottomRow(origin.getRow()) || isRightColumn(origin.getColumn())) {
			return null;
		} else {
			char newColumn = (char) (origin.getColumn() + 1);
			int newRow = origin.getRow() - 1;
			
			return calculateSpace(newColumn, newRow);
		}
	}

	private static Space calculateNW(Space origin) {
		if(isTopRow(origin.getRow()) || isLeftColumn(origin.getColumn())) {
			return null;
		} else {
			char newColumn = (char) (origin.getColumn() - 1);
			int newRow = origin.getRow() + 1;
			
			return calculateSpace(newColumn, newRow);
		}
	}

	private static Space calculateSW(Space origin) {
		if(isBottomRow(origin.getRow()) || isLeftColumn(origin.getColumn())) {
			return null;
		} else {
			char newColumn = (char) (origin.getColumn() - 1);
			int newRow = origin.getRow() - 1;
			
			return calculateSpace(newColumn, newRow);
		}
	}
	
	private static Space calculateSpace(char column, int row) {
		return Space.valueOf(Space.class, String.valueOf(column)+String.valueOf(row));
	}
	
	private static boolean isLeftColumn(char column) {
		return column == 'A';
	}
	private static boolean isRightColumn(char column) {
		return column == 'H';
	}
	private static boolean isTopRow(int row) {
		return row == 8;
	}
	private static boolean isBottomRow(int row) {
		return row == 1;
	}
}
