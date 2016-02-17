package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator test;
	
	@Before
	public void setup(){
		test = new Calculator();
	}
	@Test
	public void AddShouldReturnAValidOutput() {
		assertEquals(15, test.add(8, 7));
	}
	@Test
	public void SubShouldReturnAValidOutput() {
		assertEquals(15, test.sub(32, 17));
	}
	@Test
	public void MultiShouldReturnAValidOutput() {
		assertEquals(15, test.multi(3, 5));
	}
	@Test
	public void MultiShouldReturnAValidOutput_Negative() {
		assertEquals(-15, test.multi(-3, 5));
	}
	@Test
	public void DivShouldReturnAZeroIfFirstLess() {
		assertEquals(0, test.div(2, 5));
	}
	@Test
	public void DivShouldReturnAValidOutput() {
		assertEquals(15, test.div(30, 2));
	}
	@Test(expected = ArithmeticException.class)
	public void DivShouldThrowAException_ByZero() {
		test.div(30, 0);
	}
	@Test
	public void GreaterShouldReturnTrueIfFirstGreater() {
		assertEquals(true, test.greater(30, 2));
	}
	@Test
	public void GreaterShouldReturnFalseIfSecondGreater() {
		assertEquals(false, test.greater(0, 2));
	}
	@After
	public void teardown(){
		test = null;
	}
}
