package mavenTest.Selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import mavenTest.Selenium.Helpers.Strings;
import mavenTest.Selenium.Pages.HomePage;
import mavenTest.Selenium.Pages.LoginPage;
import mavenTest.Selenium.Pages.RepositoriesPage;

public class FirefoxTest {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void LoginCorrectTest() {
		HomePage home = new HomePage(driver);
		driver.get(home.getWebLink());
		home.clickLoginButton();
		
		LoginPage login = new LoginPage(driver);
		login.logIn(Strings.getEmail(), Strings.getPassword());
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("home");
            }
        });
		
		RepositoriesPage repos = new RepositoriesPage(driver);
		Assert.assertNotEquals(0, repos.numberRepos());
	}
}
