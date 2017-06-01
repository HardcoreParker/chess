package orchestration;

import exception.SpaceOutOfBoundsException;

public enum Direction {
	N(),
	S(),
	E(),
	W(),
	NE(),
	NW(),
	SW(),
	SE();
	
	public static Space calculateN(Space origin) {
		if(isTopRow(origin.getRow())) {
			return null;
		} else {
			int newRow = origin.getRow() + 1;
			
			return calculateSpace(origin.getColumn(), newRow);
		}
	}

	public static Space calculateS(Space origin) {
		if(isBottomRow(origin.getRow())) {
			return null;
		} else {
			int newRow = origin.getRow() - 1;
			
			return calculateSpace(origin.getColumn(), newRow);
		}
	}
	
	public static Space calculateW(Space origin) {
		if(isLeftColumn(origin.getColumn())) {
			return null;
		} else {
			char newColumn = (char) (origin.getColumn() - 1);
			
			return calculateSpace(newColumn, origin.getRow());
		}
	}

	public static Space calculateE(Space origin) {
		if(isRightColumn(origin.getColumn())) {
			return null;
		} else {
			char newColumn = (char) (origin.getColumn() + 1);
			
			return calculateSpace(newColumn, origin.getRow());
		}
	}

	public static Space calculateNE(Space origin) {
		if(isTopRow(origin.getRow()) || isRightColumn(origin.getColumn())) {
			return null;
		} else {
			char newColumn = (char) (origin.getColumn() + 1);
			int newRow = origin.getRow() + 1;
			
			return calculateSpace(newColumn, newRow);
		}
	}

	public static Space calculateSE(Space origin) {
		if(isBottomRow(origin.getRow()) || isRightColumn(origin.getColumn())) {
			return null;
		} else {
			char newColumn = (char) (origin.getColumn() + 1);
			int newRow = origin.getRow() - 1;
			
			return calculateSpace(newColumn, newRow);
		}
	}

	public static Space calculateNW(Space origin) {
		if(isTopRow(origin.getRow()) || isLeftColumn(origin.getColumn())) {
			return null;
		} else {
			char newColumn = (char) (origin.getColumn() - 1);
			int newRow = origin.getRow() + 1;
			
			return calculateSpace(newColumn, newRow);
		}
	}

	public static Space calculateSW(Space origin) {
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
