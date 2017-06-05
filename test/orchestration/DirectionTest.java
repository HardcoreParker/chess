package orchestration;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DirectionTest {

	@Test
	public void calculateUp_Test() {
		Space actual = Direction.calculateDirection(Direction.N, Space.A1);
		Space expected = Space.A2;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateDown_Test() {
		Space actual = Direction.calculateDirection(Direction.S, Space.A2);
		Space expected = Space.A1;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateUp_FromTopOfBoard_Test() {
		Space actual = Direction.calculateDirection(Direction.N, Space.A8);
		Space expected = null;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateDown_FromBottomOfBoard_Test() {
		Space actual = Direction.calculateDirection(Direction.S, Space.A1);
		Space expected = null;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateLeft_Test() {
		Space actual = Direction.calculateDirection(Direction.W, Space.D4);
		Space expected = Space.C4;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateRight_Test() {
		Space actual = Direction.calculateDirection(Direction.E, Space.D4);
		Space expected = Space.E4;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateLeft_OutOfBounds_Test() {
		Space actual = Direction.calculateDirection(Direction.W, Space.A1);
		Space expected = null;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateRight_OutOfBounds_Test() {
		Space actual = Direction.calculateDirection(Direction.E, Space.H1);
		Space expected = null;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateDiagonal_NE_test() {
		Space actual = Direction.calculateDirection(Direction.NE, Space.D4);
		Space expected = Space.E5;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateDiagonal_NE_OOB_test() {
		Space actual = Direction.calculateDirection(Direction.NE, Space.A8);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NE, Space.B8);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NE, Space.C8);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NE, Space.D8);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NE, Space.E8);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NE, Space.F8);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NE, Space.G8);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NE, Space.H8);
		assertEquals(null, actual);

		actual = Direction.calculateDirection(Direction.NE, Space.H1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NE, Space.H2);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NE, Space.H3);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NE, Space.H4);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NE, Space.H5);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NE, Space.H6);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NE, Space.H7);
		assertEquals(null, actual);
	}
	
	@Test
	public void calculateDiagonal_SE_test() {
		Space actual = Direction.calculateDirection(Direction.SE, Space.D4);
		Space expected = Space.E3;
		
		assertEquals(expected, actual);
	}
	@Test
	public void calculateDiagonal_SE_OOB_test() {
		Space actual = Direction.calculateDirection(Direction.SE, Space.A1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SE, Space.B1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SE, Space.C1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SE, Space.D1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SE, Space.E1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SE, Space.F1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SE, Space.G1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SE, Space.H1);
		assertEquals(null, actual);
		
		actual = Direction.calculateDirection(Direction.SE, Space.H1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SE, Space.H2);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SE, Space.H3);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SE, Space.H4);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SE, Space.H5);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SE, Space.H6);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SE, Space.H7);
		assertEquals(null, actual);
	}
	
	@Test
	public void calculateDiagonal_NW_test() {
		Space actual = Direction.calculateDirection(Direction.NW, Space.D4);
		Space expected = Space.C5;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateDiagonal_NW_OOB_test() {
		Space actual = Direction.calculateDirection(Direction.NW, Space.A8);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NW, Space.B8);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NW, Space.C8);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NW, Space.D8);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NW, Space.E8);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NW, Space.F8);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NW, Space.G8);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NW, Space.H8);
		assertEquals(null, actual);
		
		actual = Direction.calculateDirection(Direction.NW, Space.A1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NW, Space.A2);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NW, Space.A3);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NW, Space.A4);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NW, Space.A5);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NW, Space.A6);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NW, Space.A7);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.NW, Space.A8);
		assertEquals(null, actual);
	}
	
	@Test
	public void calculateDiagonal_SW_test() {
		Space actual = Direction.calculateDirection(Direction.SW, Space.D4);
		Space expected = Space.C3;
		
		assertEquals(expected, actual);
	}

	@Test
	public void calculateDiagonal_SW_OOB_test() {
		Space actual = Direction.calculateDirection(Direction.SW, Space.A1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SW, Space.A2);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SW, Space.A3);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SW, Space.A4);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SW, Space.A5);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SW, Space.A6);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SW, Space.A7);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SW, Space.A8);
		assertEquals(null, actual);
		
		actual = Direction.calculateDirection(Direction.SW, Space.A1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SW, Space.B1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SW, Space.C1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SW, Space.D1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SW, Space.E1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SW, Space.F1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SW, Space.G1);
		assertEquals(null, actual);
		actual = Direction.calculateDirection(Direction.SW, Space.H1);
		assertEquals(null, actual);
	}
}
