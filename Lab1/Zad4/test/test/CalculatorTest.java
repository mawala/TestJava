package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator test;
	private static double EPSILON = 1E-15;
	
	@Before
	public void setup(){
		test = new Calculator();
	}
	@Test
	public void AddShouldReturnAValidOutput() {
		assertEquals(4, test.add(1.5, 2.5), EPSILON);
	}
	@Test
	public void SubShouldReturnAValidOutput() {
		assertEquals(20.1, test.sub(32.2, 12.1), EPSILON);
	}
	@Test
	public void MultiShouldReturnAValidOutput() {
		assertEquals(7.5, test.multi(3, 2.5), EPSILON);
	}
	@Test
	public void MultiShouldReturnAValidOutput_Negative() {
		assertEquals(-15, test.multi(-3, 5), EPSILON);
	}
	@Test
	public void DivShouldReturnAValidOutput() {
		assertEquals(15, test.div(30, 2), EPSILON);
	}
	@Test
	public void GreaterShouldReturnTrueIfFirstGreater() {
		assertTrue(test.greater(30.2, 2));
	}
	@Test
	public void GreaterShouldReturnFalseIfSecondGreater() {
		assertFalse(test.greater(0.1, 2));
	}
	@After
	public void teardown(){
		test = null;
	}

}
