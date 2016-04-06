package mavenTest.zad2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TititDobreTesty {
	
	private Psikus test;

	@After
	public void tearDown() throws Exception {
		test = null;
	}
	
	@Parameters
    public static Collection<Object[]> dane() {
        return Arrays.asList(new Object[][] {     
        		{ 12, 3, true }, { -12, 1, true }, { 14, 3, false }, { 0, 10, true }, { -66, -6, true }  
           });
    }
    
    private Integer dzielna;
    private Integer dzielnik;
    private boolean oczekiwany;

    public TititDobreTesty(Integer dzielna, Integer dzielnik, boolean oczekiwany) {
        this.dzielna = dzielna;
        this.dzielnik = dzielnik;
        this.oczekiwany = oczekiwany;
    }

	@Test
	public void TititDziala() {
		test = new Kontrakt(dzielna);
		assertThat(test.Titit(dzielnik), is(oczekiwany));
	}

}
