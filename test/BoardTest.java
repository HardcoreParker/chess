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
	
	@Test
	public void calculateLeft_Test() {
		Space actual = Board.calculateLeft(Space.D4);
		Space expected = Space.C4;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateRight_Test() {
		Space actual = Board.calculateRight(Space.D4);
		Space expected = Space.E4;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateLeft_OutOfBounds_Test() {
		Space actual = Board.calculateLeft(Space.A1);
		Space expected = null;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateRight_OutOfBounds_Test() {
		Space actual = Board.calculateRight(Space.H1);
		Space expected = null;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateDiagonal_NE_test() {
		Space actual = Board.calculateDiagonalNE(Space.D4);
		Space expected = Space.E5;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateDiagonal_NE_OOB_test() {
		Space actual = Board.calculateDiagonalNE(Space.A8);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNE(Space.B8);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNE(Space.C8);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNE(Space.D8);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNE(Space.E8);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNE(Space.F8);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNE(Space.G8);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNE(Space.H8);
		assertEquals(null, actual);

		actual = Board.calculateDiagonalNE(Space.H1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNE(Space.H2);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNE(Space.H3);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNE(Space.H4);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNE(Space.H5);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNE(Space.H6);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNE(Space.H7);
		assertEquals(null, actual);
	}
	
	@Test
	public void calculateDiagonal_SE_test() {
		Space actual = Board.calculateDiagonalSE(Space.D4);
		Space expected = Space.E3;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateDiagonal_SE_OOB_test() {
		Space actual = Board.calculateDiagonalSE(Space.A1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSE(Space.B1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSE(Space.C1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSE(Space.D1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSE(Space.E1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSE(Space.F1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSE(Space.G1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSE(Space.H1);
		assertEquals(null, actual);
		
		actual = Board.calculateDiagonalSE(Space.H1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSE(Space.H2);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSE(Space.H3);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSE(Space.H4);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSE(Space.H5);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSE(Space.H6);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSE(Space.H7);
		assertEquals(null, actual);
	}
	
	@Test
	public void calculateDiagonal_NW_test() {
		Space actual = Board.calculateDiagonalNW(Space.D4);
		Space expected = Space.C5;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateDiagonal_NW_OOB_test() {
		Space actual = Board.calculateDiagonalNW(Space.A8);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNW(Space.B8);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNW(Space.C8);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNW(Space.D8);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNW(Space.E8);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNW(Space.F8);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNW(Space.G8);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNW(Space.H8);
		assertEquals(null, actual);
		
		actual = Board.calculateDiagonalNW(Space.A1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNW(Space.A2);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNW(Space.A3);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNW(Space.A4);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNW(Space.A5);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNW(Space.A6);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNW(Space.A7);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalNW(Space.A8);
		assertEquals(null, actual);
	}
	
	@Test
	public void calculateDiagonal_SW_test() {
		Space actual = Board.calculateDiagonalSW(Space.D4);
		Space expected = Space.C3;
		
		assertEquals(expected, actual);
	}

	@Test
	public void calculateDiagonal_SW_OOB_test() {
		Space actual = Board.calculateDiagonalSW(Space.A1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSW(Space.A2);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSW(Space.A3);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSW(Space.A4);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSW(Space.A5);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSW(Space.A6);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSW(Space.A7);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSW(Space.A8);
		assertEquals(null, actual);
		
		actual = Board.calculateDiagonalSW(Space.A1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSW(Space.B1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSW(Space.C1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSW(Space.D1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSW(Space.E1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSW(Space.F1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSW(Space.G1);
		assertEquals(null, actual);
		actual = Board.calculateDiagonalSW(Space.H1);
		assertEquals(null, actual);
	}
}
