package maven.Selenium.Jbehave;

import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mavenTest.Selenium.Helpers.Methods;
import mavenTest.Selenium.Helpers.Strings;
import mavenTest.Selenium.Pages.HomePage;
import mavenTest.Selenium.Pages.LoginPage;
import mavenTest.Selenium.Pages.RepositoriesPage;

public class MySteps extends Steps {
	
	private WebDriver driver;
	private int beforeSearch;
	private int afterSearch;
	
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
		HomePage home = new HomePage(driver);
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
	
	@Given("użytkownik jest na stronie głównej")
	public void givenUserIsOnHomePage(){
		Methods method = new Methods(driver);
		method.login();
		
		RepositoriesPage repos = new RepositoriesPage(driver);		
		beforeSearch = repos.numberRepos();
	}
	
	@When("wpisze słowo do wyszukania")
	public void whenWritesWordToSearch(){
		String search = "test";
		RepositoriesPage repos = new RepositoriesPage(driver);
		repos.searchRepos(search);
	}
	
	@Then("strona wyświetli wynik wyszukiwania")
	public void thenPageShowsResultOfSearch(){
		RepositoriesPage repos = new RepositoriesPage(driver);
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains("test");
            }
        });
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.partialLinkText("test")));
		
		afterSearch = repos.numberRepos();
		Assert.assertTrue(beforeSearch >= afterSearch);
	}
}
