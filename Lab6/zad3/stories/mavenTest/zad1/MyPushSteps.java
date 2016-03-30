package mavenTest.zad1;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

public class MyPushSteps extends Steps{
	
	MyStack myStack = new MyStack();
	int element;
	
	@Given("an element by $elem")
	public void givenAnElementByelem(@Named("elem") int elem){
		 element = elem;
	}
	
	@When("an element is added to the stack")
	public void whenAnElementIsAddedToTheStack(){
		myStack.MyPush(element);
	}
	
	@Then("the stack should have $elem")
	public void thenTheStackShouldHaveelem(@Named("elem") int elem){
		 if (myStack.MyTop() != elem) {
			 throw new RuntimeException("Error in MyPush method!");
		 }
	}
}
