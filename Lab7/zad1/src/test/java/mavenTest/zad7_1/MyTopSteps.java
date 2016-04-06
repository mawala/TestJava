package mavenTest.zad7_1;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

public class MyTopSteps extends Steps{
	
	MyStack myStack;
	int element;
	
	@BeforeScenario
	public void setUp(){
		myStack = new MyStack();
	}
	
	@Given("a new element by $elem")
	public void givenANewElementByelem(@Named("elem") int elem){
		 element = elem;
	}
	
	@When("the element added to the stack")
	public void whenTheElementAddedToTheStack(){
		myStack.MyPush(element);
	}
	
	@Then("MyTop should be $elem")
	public void thenMyTopShouldBeelem(@Named("elem") int elem){
		 if (myStack.MyTop() != elem) {
			 throw new RuntimeException("Error in MyTop method!");
		 }
	}
	
	@When("the stack is empty")
	public void whenTheStackIsEmpty(){ }
	
	@Then("MyTop should throw an exception")
	public void thenMyTopShouldThrowAnExcetion(){
		 try{
			 myStack.MyTop();
			 throw new RuntimeException("Error in MyTop method (should throw exception)!");
		 } catch(NullPointerException e){
		 }
	}
}