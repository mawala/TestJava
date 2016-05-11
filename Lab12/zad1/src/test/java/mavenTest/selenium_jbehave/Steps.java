package mavenTest.selenium_jbehave;

import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.By;

import mavenTest.selenium_jbehave.Pages;

public class Steps{
	
	private final Pages pages;

	public Steps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("user is on login page")
	public void givenUserIsOnLoginPage(){
		pages.login().open();
	}
	
	@When("user gives correct email")
	public void whenUserGivesCorrectEmail(){
		pages.login().findElement(By.id("js-email-field")).sendKeys("marta.w41@gmail.com");
	}
	
	
	@When("user gives incorrect password")
	public void whenUserGivesIncorrectPassword(){
		pages.login().findElement(By.id("js-password-field")).sendKeys("asd");
	}
	
	@When("user gives correct password")
	public void whenUserGivesCorrectPassword(){
		pages.login().findElement(By.id("js-password-field")).sendKeys("pushmerge"); 
	}
	
	@When("user clicks submit")
	public void whenUserClicksSubmit(){
		pages.login().findElement(By.className("selenium-login-submit")).click();
	}
	
	@Then("user logs in")
	public void thenUserLogsIn(){
		try {
			pages.login().findElement(By.id("user-dropdown-trigger"));
			Assert.assertTrue(true);
		} catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Then("user does not log in")
	@Pending
	public void thenUserDoesNotLogIn(){
		try {
			pages.login().findElement(By.xpath("//p[contains(.,'Invalid username/email or password.')]"));
			Assert.assertTrue(true);
		} catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
}