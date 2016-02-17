package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class LiczbaRzymskaTest {

	private LiczbaRzymska test;
	
	@Test
	public void ToStringShouldReturnAValidOutput_SmallNumber() {
		test = new LiczbaRzymska(19);
		assertEquals("XIX", test.toString());
	}
	
	@Test
	public void ToStringShouldReturnAValidOutput_BigNumber() {
		test = new LiczbaRzymska(3476);
		assertEquals("MMMCDLXXVI", test.toString());
	}
	
	@Test(expected = NumberFormatException.class)
	public void ToStringShouldThrowAnException_NegativeNumber() {
		test = new LiczbaRzymska(-12);
		test.toString();
	}

	@Test(expected = NumberFormatException.class)
	public void ToStringShouldThrowAnException_Zero() {
		test = new LiczbaRzymska(0);
		test.toString();
	}
	
	@After
	public void teardown(){
		test = null;
	}
}
