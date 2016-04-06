package mavenTest.zad2;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

public class MySteps extends Steps{
	
	Kontrakt test = new Kontrakt();
	private int temp;
	Throwable thrown;
	
	@Given("number with one integer as $number")
	public void givenNumberWithOneIntegerAsint(@Named("number") int number){
		 temp = number;
	}
	@Then("CyfroKrad should return null")
	public void thenCyfroKradShouldReturnNull(){
		 if (test.CyfroKrad(temp) != null)
			 throw new RuntimeException("Error in test");
	}
	
	@Given("dzielna by $nr1 and dzielnik by $nr2")
	public void givenDzielnaBynr1AndDzielnikBynr2(@Named("nr1") int nr1, @Named("nr2") int nr2){
		test = new Kontrakt(nr1);
		temp = nr2;
	}
	@Then("Titit should return $result")
	public void thenTititShouldReturnresult(@Named("result") boolean result){
		 if (test.Titit(temp) != result)
			 throw new RuntimeException("Error in test");
	}
	
	@When("HultajChochla with empty argument")
	public void givenEmptyArgument(){
		try{
			test.HultajChochla(null);
		} catch(Exception e){
			thrown = e;
		}
	}
	@Then("HultajChochla should throw an exception")
	public void thenHeheszkiShouldThrowAnException(){
		 if (!thrown.getClass().getSimpleName().equals("NieudanyPsikusException"))
			 throw new RuntimeException("Error in test");
	}
	
	@Given("number by $nr")
	public void givenNumberBynr(@Named("nr") int nr){
		 temp = nr;
	}
	@Then("HultajChochla returns number with $length")
	public void thenHultajChochlaReturnsNumberWithlength(@Named("length") int length) throws NieudanyPsikusException{
		 if (test.HultajChochla(temp).toString().length() != length)
			 throw new RuntimeException("Error in test");
	}
}