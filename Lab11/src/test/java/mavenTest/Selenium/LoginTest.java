package mavenTest.Selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import mavenTest.Selenium.Helpers.Strings;
import mavenTest.Selenium.Pages.HomePage;
import mavenTest.Selenium.Pages.LoginPage;
import mavenTest.Selenium.Pages.RepositoriesPage;

public class LoginTest {

	private static WebDriver driver;
	
	@Before
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Karol\\Desktop\\studia\\informatyka\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void LoginCorrectTest() {
		HomePage home = new HomePage(driver);
		driver.get(home.getWebLink());
		home.clickLoginButton();
		
		LoginPage login = new LoginPage(driver);
		login.logIn(Strings.getEmail(), Strings.getPassword());
		
		RepositoriesPage repos = new RepositoriesPage(driver);
		Assert.assertNotEquals(0, repos.numberRepos());
	}
	
	@Test
	public void LoginNullTest() {
		HomePage home = new HomePage(driver);
		driver.get(home.getWebLink());
		home.clickLoginButton();
		
		LoginPage login = new LoginPage(driver);
		login.logIn(null, null);
		
		Assert.assertNotEquals(0, login.checkNullErrors());
	}
	
	@Test
	public void LoginWrongTest() {
		HomePage home = new HomePage(driver);
		driver.get(home.getWebLink());
		home.clickLoginButton();
		
		LoginPage login = new LoginPage(driver);
		login.logIn(Strings.getEmail(), "pass");
		
		Assert.assertNotEquals(0, login.checkWrongErrors());
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
