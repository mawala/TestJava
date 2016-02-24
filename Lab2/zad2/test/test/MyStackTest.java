package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MyStackTest {

	private MyStack test;
	
	@Before
	public void setup(){
		test = new MyStack();
	}
	@Test
	public void MyPushShouldWork() {		
		test.MyPush(1);
		assertThat(test.IsNull(), is(false));
		assertThat(test.MyTop().getValue(), is(1));
	}
	@Test
	public void MyPopShouldWork() {
		test.MyPush(1);
		test.MyPop();
		assertThat(test.IsNull(), is(true));
	}
	@Test
	public void MyPopShouldThrowAnException_Null() {
		try{
			test.MyPop();
			fail("My exception");
		} catch (NullPointerException e){
			assertTrue(true);
		}
	}
	@Test
	public void IsNullShouldWork(){
		assertThat(test.IsNull(), is(true));
		test.MyPush(1);
		assertThat(test.IsNull(), is(false));
	}
	@Test
	public void MyTopShouldWork(){
		test.MyPush(1);
		assertThat(test.MyTop().getValue(), is(1));
	}
	@Test
	public void MyTopShouldThrowAnException_Null(){
		try{
			test.MyTop();
			fail("My exception");
		} catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}
	@After
	public void teardown(){
		test = null;
	}
}
