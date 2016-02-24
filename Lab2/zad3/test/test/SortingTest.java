package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SortingTest {

	private Sorting test;
	@Test
	public void BubbleSortShouldWork() {
		Integer[] temp = {1,4,3,-1};
		test = new Sorting(temp);
		test.bubbleSort();
		assertThat(Arrays.asList(test.table), contains(-1,1,3,4));
	}
	@Test
	public void BubbleSortShouldWork_Inverse() {
		Integer[] temp = {3,2,1,0,-1,-2};
		test = new Sorting(temp);
		test.bubbleSort();
		assertThat(Arrays.asList(test.table), contains(-2,-1,0,1,2,3));
	}
	@Test
	public void BubbleSortShouldThrowAnException_Null() {
		test = new Sorting(null);
		try{
			test.bubbleSort();
			fail("Exception");
		} catch (IllegalArgumentException e){
			assertTrue(true);
		}
	}
	@Test
	public void BubbleSortShouldThrowAnException_Empty() {
		Integer[] temp = {};
		test = new Sorting(temp);
		try{
			test.bubbleSort();
			fail("Exception");
		} catch (NullPointerException e){
			assertTrue(true);
		}
	}
}
