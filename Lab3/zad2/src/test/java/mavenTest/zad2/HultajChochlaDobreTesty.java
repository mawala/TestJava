package mavenTest.zad2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class HultajChochlaDobreTesty {

	private Psikus test;
	
	@Before
	public void setUp() throws Exception {
		test = new Kontrakt();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}
	
	@Parameters
    public static Collection<Object[]> dane() {
        return Arrays.asList(new Object[][] {     
        		{ 12, 2 }, { 313, 3 }, { -1234, 5 }, { 82378239, 8 }, { 2718, 4 }  
           });
    }
	
    private Integer argument;
    private int oczekiwany;

    public HultajChochlaDobreTesty(Integer argument, int oczekiwany) {
        this.argument = argument;
        this.oczekiwany = oczekiwany;
    }
    
    @Test
	public void HultajChochlaDziala() {
		try {
			assertThat(test.HultajChochla(argument).toString().length(), is(oczekiwany));
		} catch (NieudanyPsikusException e) {
			fail("Metoda nie dziala");
		}
	}
}
