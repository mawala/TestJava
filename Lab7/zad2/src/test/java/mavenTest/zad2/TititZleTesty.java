package mavenTest.zad2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TititZleTesty {

	private Psikus test;
	
	@Before
	public void setUp() throws Exception {
		test = new Kontrakt(12);
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test(expected = IllegalArgumentException.class)
	public void TititWyrzucaWyjatek_Null() {
		test.Titit(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TititWyrzucaWyjatek_Zero() {
		test.Titit(0);
	}

}
