package mavenTest.zad2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class HeheszkiDobreTesty {

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
        		{ 1 }, { 100 }, { 80 }, { 17 }  
           });
    }
	
    private Integer argument;

    public HeheszkiDobreTesty(Integer argument) {
        this.argument = argument;
    }

	@Test
	public void HeheszkiDziala() {
		assertThat(test.Heheszki(argument), greaterThanOrEqualTo(0));
		assertThat(test.Heheszki(argument), lessThan(argument));
	}
}
