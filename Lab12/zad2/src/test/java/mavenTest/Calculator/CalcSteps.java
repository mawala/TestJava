package mavenTest.Calculator;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CalcSteps {
	
	private final Pages pages;

	public CalcSteps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("user is on calculator page")
	public void givenUserIsOnCalculatorPage(){
		pages.home().open();  
	}
	
	@When("user enter <arg1>") 
	public void whenUserEnterarg1(@Named("arg1") String arg){
		pages.home().findElement(By.id("input")).sendKeys(arg); 
	}
	
	@When("user click <btn>")
	public void whenUserClickbtn(@Named("btn") String btn){
		 String button = "Btn" + btn;
		 pages.home().findElement(By.id(button)).click();
	}
	
	@When("user write <arg2>")
	public void whenUserClickarg2(@Named("arg2") String arg){
		pages.home().findElement(By.id("input")).sendKeys(arg);
	}
	
	@When("user submit")
	public void whenUserSubmit(){
		pages.home().findElement(By.id("BtnCalc")).click();
	}
	
	@Then("result is <result>")
	public void thenResultIsresult(@Named("result") String res){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        String result = pages.home().findElement(By.id("input")).getAttribute("value").toString();
        Assert.assertEquals(res, result);
        
        pages.home().findElement(By.id("input")).clear();
	}
}