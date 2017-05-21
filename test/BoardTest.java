import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void calculateUp_Test() {
		Space actual = Board.calculateUp(Space.A1);
		Space expected = Space.A2;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateDown_Test() {
		Space actual = Board.calculateDown(Space.A2);
		Space expected = Space.A1;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateUp_FromTopOfBoard_Test() {
		Space actual = Board.calculateUp(Space.A8);
		Space expected = null;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateDown_FromBottomOfBoard_Test() {
		Space actual = Board.calculateDown(Space.A1);
		Space expected = null;
		
		assertEquals(expected, actual);
	}
	// Calculate Left and Right
	
	@Test
	public void calculateDiagonal_NE_test() {
		Space actual = Board.calculateDiagonalNE(Space.D4);
		Space expected = Space.E5;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateDiagonal_SE_test() {
		Space actual = Board.calculateDiagonalSE(Space.D4);
		Space expected = Space.E3;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateDiagonal_NW_test() {
		Space actual = Board.calculateDiagonalNW(Space.D4);
		Space expected = Space.C5;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateDiagonal_SW_test() {
		Space actual = Board.calculateDiagonalSW(Space.D4);
		Space expected = Space.C3;
		
		assertEquals(expected, actual);
	}


}
