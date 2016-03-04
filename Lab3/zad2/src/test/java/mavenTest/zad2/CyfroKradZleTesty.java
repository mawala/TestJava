package mavenTest.zad2;

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
public class CyfroKradZleTesty {

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
        		{ 1 }, { -1 }, { 0 }, { 7 }, { -8 }  
           });
    }
	
    private Integer argument;

    public CyfroKradZleTesty(Integer argument) {
        this.argument = argument;
    }
    
    @Test
	public void CyfroKradJednaCyfra_ZwracaNull() {
    	assertNull(test.CyfroKrad(argument));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CyfroKradWyrzucaWyjatek_Null() {
		test.CyfroKrad(null);
	}
}
