package mavenTest.zad1;
import java.util.List;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

public class IsEmptySteps extends Steps{
	
	MyStack myStack = new MyStack();
	
	@Given("the empty stack")
	public void givenTheEmptyStack(){ myStack = new MyStack(); }
	
	@Then("IsEmpty should be true")
	public void thenIsEmptyShouldBeTrue(){
		 if (myStack.IsEmpty() == true){
			 throw new RuntimeException("Error in IsEmpty method (should be true)!");
		 }
	}
	
	@Given("the stack by $list")
	public void givenTheStackBylist(@Named("list") List<Integer> list){
		 myStack = new MyStack(list);
	}
	
	@Then("IsEmpty should be false")
	public void thenIsEmptyShouldBeFalse(){
		if (myStack.IsEmpty() != false){
			 throw new RuntimeException("Error in IsEmpty method (should be false)!");
		}
	}
}