import java.util.List;

import mavenTest.Max.*;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

public class MySteps extends Steps{
	
	private List<Integer> list;
	MaxElem impl = new MaxElemImpl();
	
	@Given("an array list by $value")
	public void givenAnArrayListByValue(@Named("value") List<Integer> value){
		list = value;
	}
	@Then("getMax should equal $value")
	public void thenGetMaxShouldEqual(@Named("value") Integer value){
		 if(impl.GetMax(list) != value){
			 throw new RuntimeException("Error in test!");
		 }
	}
}