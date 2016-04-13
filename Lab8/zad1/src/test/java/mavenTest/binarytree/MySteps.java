package mavenTest.binarytree;

import java.util.List;
import static org.junit.Assert.*;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

public class MySteps extends Steps{
	BinaryTree test;
	
	@BeforeStory
	public void setUp() {
		test = new BinaryTree();
	}
	
	@AfterStory
	public void tearDown() {
		test.root = null;
		test = null;
	}
	
	@Given("empty binary tree")
	public void givenEmptyBinaryTree() {
		test.root = null;
	}
	
	@Given("binary tree by $nodes")
	public void givenBinaryTreeBynodes(List<Integer> nodes){
		for(Integer nr : nodes) {
			test.insert(nr);
		}
	}
	
	@When("inserting node with key $key")
	public void whenInsertingNodeWithKeykey(int key){
		test.insert(key);
	}
	
	@When("deleting node with key $key")
	public void whenDeletingNodeWithKeykey(int key){
		test.delete(key);
	}
	
	@Then("binary tree should have $newNodes")
	public void thenBinaryTreeShouldHavenewNodes(List<Integer> newNodes){
		for (Integer nr : newNodes) {
			assertNotNull(test.findNode(nr));
		}
	}
	
	@Then("binary tree should throw exception")
	public void thenBinaryTreeShouldThrowException(){
		try {
			test.delete(2);
			assertTrue(false);
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}
	
	@Then("inOrderPrint should return $result1")
	public void thenInOrderPrintShouldReturnresult1(String result1){
		test.inOrderPrint();
		assertEquals(result1, test.print); 
	}
	
	@Then("preOrderPrint should return $result2")
	public void thenPreOrderPrintShouldReturnresult2(String result2){
		test.preOrderPrint();
		assertEquals(result2, test.print); 
	}
	
	@Then("postOrderPrint should return $result3")
	public void thenPostOrderPrintShouldReturnresult3(String result3){
		test.postOrderPrint();
		assertEquals(result3, test.print); 
	}
}
