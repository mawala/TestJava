package mavenTest.zad2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NieksztaltekZleTesty {

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
        		{ 11 }, { 19281 }, { -1242 }, { 828290000 }, { 0 }  
           });
    }
	
    private Integer argument;
    
    public NieksztaltekZleTesty(Integer argument) {
        this.argument = argument;
    }
    
	@Test
	public void NieksztaltekDziala_BezZmienianychCyfr() {
		assertThat(test.Nieksztaltek(argument), is(argument));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NieksztaltekWyrzucaWyjatek_Null() {
		test.Nieksztaltek(null);
	}
}