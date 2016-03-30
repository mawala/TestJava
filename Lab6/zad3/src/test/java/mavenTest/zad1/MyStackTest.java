package mavenTest.zad1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {

	private MyStack test;
	
	@Before
	public void setUp() throws Exception {
		test = new MyStack();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void IsEmptyShouldWork() {
		assertTrue(test.IsEmpty());
		
		test.MyPush(2);
		assertFalse(test.IsEmpty());
	}
	@Test
	public void MyPushShouldWork() {
		int a = 2;
		test.MyPush(a);
		assertEquals(a, test.MyTop());
		
		a++;
		test.MyPush(a);
		assertEquals(a, test.MyTop());
	}

	@Test
	public void MyPushShouldWork_MaxValue() {
		test.MyPush(Integer.MAX_VALUE);
		assertEquals(Integer.MAX_VALUE, test.MyTop());
	}
	
	@Test
	public void MyPushShouldWork_MinValue() {
		test.MyPush(Integer.MIN_VALUE);
		assertEquals(Integer.MIN_VALUE, test.MyTop());
	}
	
	@Test
	public void MyPopShouldWork() {
		int a = 8;
		int b = 2;
		int c = 4;
		test.MyPush(a);
		test.MyPush(b);
		test.MyPush(c);
		
		test.MyPop();
		assertEquals(b, test.MyTop());
		
		test.MyPop();
		test.MyPop();
		assertTrue(test.IsEmpty());
	}
	
	@Test(expected = NullPointerException.class)
	public void MyPopShouldThrowAnException_EmptyStack() {
		test.MyPop();
	}
	
	@Test
	public void MyTopShouldWork() {
		int a = 8;
		int b = 2;
		test.MyPush(a);
		assertEquals(a, test.MyTop());
		test.MyPush(b);
		assertEquals(b, test.MyTop());
	}
	
	@Test(expected = NullPointerException.class)
	public void MyTopShouldThrowAnException_EmptyStack() {
		test.MyTop();
	}
}
