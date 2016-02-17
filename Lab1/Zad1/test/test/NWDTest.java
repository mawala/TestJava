package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NWDTest {

	private NWD test;
	
	@Before
	public void setup(){
		test = new NWD();
	}
	
	@Test
	public void NWDShouldReturnAValidOutput() {
		//int result = ;
		assertEquals(6, test.nwd(120, 6));
	}
	
	@Test
	public void NWDShouldWorkWithFirstZero(){
		int result = test.nwd(0, 2);
		assertEquals(2, result);
	}
	
	@Test
	public void NWDShouldWorkWithSecondZero(){
		int result = test.nwd(12, 0);
		assertEquals(12, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NWDShouldThrowAnException_TwoZeros(){
		test.nwd(0, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NWDShouldThrowAnException_FirstNegative(){
		test.nwd(-1, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NWDShouldThrowAnException_SecondNegative(){
		test.nwd(2, -2);
	}
	
	@After
	public void teardown(){
		test = null;
	}

}
