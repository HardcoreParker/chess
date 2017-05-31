package orchestration;
import static org.junit.Assert.*;

import org.junit.Test;

import orchestration.Board;
import orchestration.Space;

public class BoardTest {

	@Test
	public void calculateUp_Test() {
		Space actual = Board.calculateN(Space.A1);
		Space expected = Space.A2;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateDown_Test() {
		Space actual = Board.calculateS(Space.A2);
		Space expected = Space.A1;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateUp_FromTopOfBoard_Test() {
		Space actual = Board.calculateN(Space.A8);
		Space expected = null;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateDown_FromBottomOfBoard_Test() {
		Space actual = Board.calculateS(Space.A1);
		Space expected = null;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateLeft_Test() {
		Space actual = Board.calculateW(Space.D4);
		Space expected = Space.C4;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateRight_Test() {
		Space actual = Board.calculateE(Space.D4);
		Space expected = Space.E4;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateLeft_OutOfBounds_Test() {
		Space actual = Board.calculateW(Space.A1);
		Space expected = null;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateRight_OutOfBounds_Test() {
		Space actual = Board.calculateE(Space.H1);
		Space expected = null;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateDiagonal_NE_test() {
		Space actual = Board.calculateNE(Space.D4);
		Space expected = Space.E5;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateDiagonal_NE_OOB_test() {
		Space actual = Board.calculateNE(Space.A8);
		assertEquals(null, actual);
		actual = Board.calculateNE(Space.B8);
		assertEquals(null, actual);
		actual = Board.calculateNE(Space.C8);
		assertEquals(null, actual);
		actual = Board.calculateNE(Space.D8);
		assertEquals(null, actual);
		actual = Board.calculateNE(Space.E8);
		assertEquals(null, actual);
		actual = Board.calculateNE(Space.F8);
		assertEquals(null, actual);
		actual = Board.calculateNE(Space.G8);
		assertEquals(null, actual);
		actual = Board.calculateNE(Space.H8);
		assertEquals(null, actual);

		actual = Board.calculateNE(Space.H1);
		assertEquals(null, actual);
		actual = Board.calculateNE(Space.H2);
		assertEquals(null, actual);
		actual = Board.calculateNE(Space.H3);
		assertEquals(null, actual);
		actual = Board.calculateNE(Space.H4);
		assertEquals(null, actual);
		actual = Board.calculateNE(Space.H5);
		assertEquals(null, actual);
		actual = Board.calculateNE(Space.H6);
		assertEquals(null, actual);
		actual = Board.calculateNE(Space.H7);
		assertEquals(null, actual);
	}
	
	@Test
	public void calculateDiagonal_SE_test() {
		Space actual = Board.calculateSE(Space.D4);
		Space expected = Space.E3;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateDiagonal_SE_OOB_test() {
		Space actual = Board.calculateSE(Space.A1);
		assertEquals(null, actual);
		actual = Board.calculateSE(Space.B1);
		assertEquals(null, actual);
		actual = Board.calculateSE(Space.C1);
		assertEquals(null, actual);
		actual = Board.calculateSE(Space.D1);
		assertEquals(null, actual);
		actual = Board.calculateSE(Space.E1);
		assertEquals(null, actual);
		actual = Board.calculateSE(Space.F1);
		assertEquals(null, actual);
		actual = Board.calculateSE(Space.G1);
		assertEquals(null, actual);
		actual = Board.calculateSE(Space.H1);
		assertEquals(null, actual);
		
		actual = Board.calculateSE(Space.H1);
		assertEquals(null, actual);
		actual = Board.calculateSE(Space.H2);
		assertEquals(null, actual);
		actual = Board.calculateSE(Space.H3);
		assertEquals(null, actual);
		actual = Board.calculateSE(Space.H4);
		assertEquals(null, actual);
		actual = Board.calculateSE(Space.H5);
		assertEquals(null, actual);
		actual = Board.calculateSE(Space.H6);
		assertEquals(null, actual);
		actual = Board.calculateSE(Space.H7);
		assertEquals(null, actual);
	}
	
	@Test
	public void calculateDiagonal_NW_test() {
		Space actual = Board.calculateNW(Space.D4);
		Space expected = Space.C5;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateDiagonal_NW_OOB_test() {
		Space actual = Board.calculateNW(Space.A8);
		assertEquals(null, actual);
		actual = Board.calculateNW(Space.B8);
		assertEquals(null, actual);
		actual = Board.calculateNW(Space.C8);
		assertEquals(null, actual);
		actual = Board.calculateNW(Space.D8);
		assertEquals(null, actual);
		actual = Board.calculateNW(Space.E8);
		assertEquals(null, actual);
		actual = Board.calculateNW(Space.F8);
		assertEquals(null, actual);
		actual = Board.calculateNW(Space.G8);
		assertEquals(null, actual);
		actual = Board.calculateNW(Space.H8);
		assertEquals(null, actual);
		
		actual = Board.calculateNW(Space.A1);
		assertEquals(null, actual);
		actual = Board.calculateNW(Space.A2);
		assertEquals(null, actual);
		actual = Board.calculateNW(Space.A3);
		assertEquals(null, actual);
		actual = Board.calculateNW(Space.A4);
		assertEquals(null, actual);
		actual = Board.calculateNW(Space.A5);
		assertEquals(null, actual);
		actual = Board.calculateNW(Space.A6);
		assertEquals(null, actual);
		actual = Board.calculateNW(Space.A7);
		assertEquals(null, actual);
		actual = Board.calculateNW(Space.A8);
		assertEquals(null, actual);
	}
	
	@Test
	public void calculateDiagonal_SW_test() {
		Space actual = Board.calculateSW(Space.D4);
		Space expected = Space.C3;
		
		assertEquals(expected, actual);
	}

	@Test
	public void calculateDiagonal_SW_OOB_test() {
		Space actual = Board.calculateSW(Space.A1);
		assertEquals(null, actual);
		actual = Board.calculateSW(Space.A2);
		assertEquals(null, actual);
		actual = Board.calculateSW(Space.A3);
		assertEquals(null, actual);
		actual = Board.calculateSW(Space.A4);
		assertEquals(null, actual);
		actual = Board.calculateSW(Space.A5);
		assertEquals(null, actual);
		actual = Board.calculateSW(Space.A6);
		assertEquals(null, actual);
		actual = Board.calculateSW(Space.A7);
		assertEquals(null, actual);
		actual = Board.calculateSW(Space.A8);
		assertEquals(null, actual);
		
		actual = Board.calculateSW(Space.A1);
		assertEquals(null, actual);
		actual = Board.calculateSW(Space.B1);
		assertEquals(null, actual);
		actual = Board.calculateSW(Space.C1);
		assertEquals(null, actual);
		actual = Board.calculateSW(Space.D1);
		assertEquals(null, actual);
		actual = Board.calculateSW(Space.E1);
		assertEquals(null, actual);
		actual = Board.calculateSW(Space.F1);
		assertEquals(null, actual);
		actual = Board.calculateSW(Space.G1);
		assertEquals(null, actual);
		actual = Board.calculateSW(Space.H1);
		assertEquals(null, actual);
	}
}
