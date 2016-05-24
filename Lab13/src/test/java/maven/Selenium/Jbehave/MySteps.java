package maven.Selenium.Jbehave;

import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import mavenTest.Selenium.Helpers.Strings;
import mavenTest.Selenium.Pages.HomePage;
import mavenTest.Selenium.Pages.LoginPage;
import mavenTest.Selenium.Pages.RepositoriesPage;

public class MySteps extends Steps {
	
	private WebDriver driver;
	private HomePage home;
	
	@BeforeScenario
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	@AfterScenario
	public void tearDown() {
		driver.quit();
	}

	@Given("użytkownik jest na stronie do logowania")
	public void givenUserIsOnPageToLogin(){
		home = new HomePage(driver);
		driver.get(home.getWebLink());
		home.clickLoginButton();
	}
	
	@When("poda login i hasło")
	public void whenGivesLoginAndPassword(){
		LoginPage login = new LoginPage(driver);
		login.logIn(Strings.getEmail(), Strings.getPassword());
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("home");
            }
        });
	}
	
	@Then("użytkownik zaloguje się")
	public void thenUserLogsIn() {
		RepositoriesPage repos = new RepositoriesPage(driver);
		Assert.assertNotEquals(0, repos.numberRepos());
	}
}
