package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CalculatorTest {
	private Calculator test;

	@Before
	public void setup() {
		test = new Calculator();
	}

	@Test
	public void AddShouldReturnAValidOutput() {
		assertThat(test.add(8, 7), is(15));
	}

	@Test
	public void SubShouldReturnAValidOutput() {
		assertThat(test.sub(32, 17), is(15));
	}

	@Test
	public void MultiShouldReturnAValidOutput() {
		assertThat(test.multi(3, 5), is(15));
	}

	@Test
	public void MultiShouldReturnAValidOutput_Negative() {
		assertThat(test.multi(-3, 5), is(-15));
	}

	@Test
	public void DivShouldReturnAZeroIfFirstLess() {
		assertThat(test.div(2, 5), is(0));
	}

	@Test
	public void DivShouldReturnAValidOutput() {
		assertThat(test.div(30, 2), is(15));
	}

	@Test
	public void GreaterShouldReturnTrueIfFirstGreater() {
		assertThat(test.greater(30, 2), is(true));
	}

	@Test
	public void GreaterShouldReturnFalseIfSecondGreater() {
		assertThat(test.greater(0, 2), is(false));
	}

	@After
	public void teardown() {
		test = null;
	}
}
