package mavenTest.zad2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HultajChochlaZleTesty {

	private Psikus test;
	
	@Before
	public void setUp() throws Exception {
		test = new Kontrakt();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}
	
	@Test
	public void HultajChochlaWyrzucaWyjatek_JednaCyfra() {
		try {
			test.HultajChochla(2);
			fail("Metoda nie dziala");
		} catch (NieudanyPsikusException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void HultajChochlaWyrzucaWyjatek_Null() {
		try {
			test.HultajChochla(null);
			fail("Metoda nie dziala");
		} catch (NieudanyPsikusException e) {
			assertTrue(true);
		}
	}

}
