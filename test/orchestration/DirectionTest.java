package orchestration;
import static org.junit.Assert.*;

import org.junit.Test;

import orchestration.Board;
import orchestration.Space;

public class DirectionTest {

	@Test
	public void calculateUp_Test() {
		Space actual = Direction.calculateN(Space.A1);
		Space expected = Space.A2;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateDown_Test() {
		Space actual = Direction.calculateS(Space.A2);
		Space expected = Space.A1;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateUp_FromTopOfBoard_Test() {
		Space actual = Direction.calculateN(Space.A8);
		Space expected = null;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateDown_FromBottomOfBoard_Test() {
		Space actual = Direction.calculateS(Space.A1);
		Space expected = null;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateLeft_Test() {
		Space actual = Direction.calculateW(Space.D4);
		Space expected = Space.C4;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateRight_Test() {
		Space actual = Direction.calculateE(Space.D4);
		Space expected = Space.E4;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateLeft_OutOfBounds_Test() {
		Space actual = Direction.calculateW(Space.A1);
		Space expected = null;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateRight_OutOfBounds_Test() {
		Space actual = Direction.calculateE(Space.H1);
		Space expected = null;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateDiagonal_NE_test() {
		Space actual = Direction.calculateNE(Space.D4);
		Space expected = Space.E5;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateDiagonal_NE_OOB_test() {
		Space actual = Direction.calculateNE(Space.A8);
		assertEquals(null, actual);
		actual = Direction.calculateNE(Space.B8);
		assertEquals(null, actual);
		actual = Direction.calculateNE(Space.C8);
		assertEquals(null, actual);
		actual = Direction.calculateNE(Space.D8);
		assertEquals(null, actual);
		actual = Direction.calculateNE(Space.E8);
		assertEquals(null, actual);
		actual = Direction.calculateNE(Space.F8);
		assertEquals(null, actual);
		actual = Direction.calculateNE(Space.G8);
		assertEquals(null, actual);
		actual = Direction.calculateNE(Space.H8);
		assertEquals(null, actual);

		actual = Direction.calculateNE(Space.H1);
		assertEquals(null, actual);
		actual = Direction.calculateNE(Space.H2);
		assertEquals(null, actual);
		actual = Direction.calculateNE(Space.H3);
		assertEquals(null, actual);
		actual = Direction.calculateNE(Space.H4);
		assertEquals(null, actual);
		actual = Direction.calculateNE(Space.H5);
		assertEquals(null, actual);
		actual = Direction.calculateNE(Space.H6);
		assertEquals(null, actual);
		actual = Direction.calculateNE(Space.H7);
		assertEquals(null, actual);
	}
	
	@Test
	public void calculateDiagonal_SE_test() {
		Space actual = Direction.calculateSE(Space.D4);
		Space expected = Space.E3;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateDiagonal_SE_OOB_test() {
		Space actual = Direction.calculateSE(Space.A1);
		assertEquals(null, actual);
		actual = Direction.calculateSE(Space.B1);
		assertEquals(null, actual);
		actual = Direction.calculateSE(Space.C1);
		assertEquals(null, actual);
		actual = Direction.calculateSE(Space.D1);
		assertEquals(null, actual);
		actual = Direction.calculateSE(Space.E1);
		assertEquals(null, actual);
		actual = Direction.calculateSE(Space.F1);
		assertEquals(null, actual);
		actual = Direction.calculateSE(Space.G1);
		assertEquals(null, actual);
		actual = Direction.calculateSE(Space.H1);
		assertEquals(null, actual);
		
		actual = Direction.calculateSE(Space.H1);
		assertEquals(null, actual);
		actual = Direction.calculateSE(Space.H2);
		assertEquals(null, actual);
		actual = Direction.calculateSE(Space.H3);
		assertEquals(null, actual);
		actual = Direction.calculateSE(Space.H4);
		assertEquals(null, actual);
		actual = Direction.calculateSE(Space.H5);
		assertEquals(null, actual);
		actual = Direction.calculateSE(Space.H6);
		assertEquals(null, actual);
		actual = Direction.calculateSE(Space.H7);
		assertEquals(null, actual);
	}
	
	@Test
	public void calculateDiagonal_NW_test() {
		Space actual = Direction.calculateNW(Space.D4);
		Space expected = Space.C5;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateDiagonal_NW_OOB_test() {
		Space actual = Direction.calculateNW(Space.A8);
		assertEquals(null, actual);
		actual = Direction.calculateNW(Space.B8);
		assertEquals(null, actual);
		actual = Direction.calculateNW(Space.C8);
		assertEquals(null, actual);
		actual = Direction.calculateNW(Space.D8);
		assertEquals(null, actual);
		actual = Direction.calculateNW(Space.E8);
		assertEquals(null, actual);
		actual = Direction.calculateNW(Space.F8);
		assertEquals(null, actual);
		actual = Direction.calculateNW(Space.G8);
		assertEquals(null, actual);
		actual = Direction.calculateNW(Space.H8);
		assertEquals(null, actual);
		
		actual = Direction.calculateNW(Space.A1);
		assertEquals(null, actual);
		actual = Direction.calculateNW(Space.A2);
		assertEquals(null, actual);
		actual = Direction.calculateNW(Space.A3);
		assertEquals(null, actual);
		actual = Direction.calculateNW(Space.A4);
		assertEquals(null, actual);
		actual = Direction.calculateNW(Space.A5);
		assertEquals(null, actual);
		actual = Direction.calculateNW(Space.A6);
		assertEquals(null, actual);
		actual = Direction.calculateNW(Space.A7);
		assertEquals(null, actual);
		actual = Direction.calculateNW(Space.A8);
		assertEquals(null, actual);
	}
	
	@Test
	public void calculateDiagonal_SW_test() {
		Space actual = Direction.calculateSW(Space.D4);
		Space expected = Space.C3;
		
		assertEquals(expected, actual);
	}

	@Test
	public void calculateDiagonal_SW_OOB_test() {
		Space actual = Direction.calculateSW(Space.A1);
		assertEquals(null, actual);
		actual = Direction.calculateSW(Space.A2);
		assertEquals(null, actual);
		actual = Direction.calculateSW(Space.A3);
		assertEquals(null, actual);
		actual = Direction.calculateSW(Space.A4);
		assertEquals(null, actual);
		actual = Direction.calculateSW(Space.A5);
		assertEquals(null, actual);
		actual = Direction.calculateSW(Space.A6);
		assertEquals(null, actual);
		actual = Direction.calculateSW(Space.A7);
		assertEquals(null, actual);
		actual = Direction.calculateSW(Space.A8);
		assertEquals(null, actual);
		
		actual = Direction.calculateSW(Space.A1);
		assertEquals(null, actual);
		actual = Direction.calculateSW(Space.B1);
		assertEquals(null, actual);
		actual = Direction.calculateSW(Space.C1);
		assertEquals(null, actual);
		actual = Direction.calculateSW(Space.D1);
		assertEquals(null, actual);
		actual = Direction.calculateSW(Space.E1);
		assertEquals(null, actual);
		actual = Direction.calculateSW(Space.F1);
		assertEquals(null, actual);
		actual = Direction.calculateSW(Space.G1);
		assertEquals(null, actual);
		actual = Direction.calculateSW(Space.H1);
		assertEquals(null, actual);
	}
}
