package mavenTest.zad7_1;
import java.util.List;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

public class MyPopSteps extends Steps{
	
	MyStack myStack;
	
	@Given("the nonempty stack by $list")
	public void givenTheNonemptyStackBylist(@Named("list") List<Integer> list){
		 myStack = new MyStack(list);
	}
	
	@When("MyPop occurs")
	public void whenMyPopOccurs(){
		 myStack.MyPop();
	}
	
	@Then("the top of stack should be $elem")
	public void thenTheTopOfStackShouldBeelem(@Named("elem") int elem){
		 if (myStack.MyTop() != elem){
			 throw new RuntimeException("Error in MyPop method!");
		 }
	}
	
	@When("stack is empty")
	public void whenStackIsEmpty(){
		 myStack = new MyStack();
	}
	
	@Then("MyPop throws an exception")
	public void thenMyPopThrowsAnException(){
		 try{
			 myStack.MyPop();
			 throw new RuntimeException("Error in MyPop method (should throw exception)!");
		 } catch(NullPointerException e){
		 }
	}
}