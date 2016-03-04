package mavenTest.zad2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CyfroKradDobreTesty {

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
        		{ 12, 1 }, { 313, 2 }, { -1234, 4 }, { 82378239, 7 }, { 2718, 3 }  
           });
    }
	
    private Integer argument;
    private int oczekiwany;

    public CyfroKradDobreTesty(Integer argument, int oczekiwany) {
        this.argument = argument;
        this.oczekiwany = oczekiwany;
    }
    
	@Test
	public void CyfroKradDziala() {
		assertThat(test.CyfroKrad(argument), not(argument));
		assertThat(test.CyfroKrad(argument).toString().length(), is(oczekiwany));	
	}

}
