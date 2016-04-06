package mavenTest.zad2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CyfroKradDobreTesty.class, CyfroKradZleTesty.class, HeheszkiDobreTesty.class, HeheszkiZleTesty.class,
		HultajChochlaDobreTesty.class, HultajChochlaZleTesty.class, NieksztaltekDobreTesty.class, NieksztaltekZleTesty.class,
		TititDobreTesty.class, TititZleTesty.class })
public class AllTest {

}
