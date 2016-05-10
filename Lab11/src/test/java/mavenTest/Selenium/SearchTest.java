package mavenTest.Selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mavenTest.Selenium.Helpers.Methods;
import mavenTest.Selenium.Pages.RepositoriesPage;

public class SearchTest {

	private static WebDriver driver;
	private Methods method;
	
	@Before
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Karol\\Desktop\\studia\\informatyka\\chromedriver.exe");
		driver = new ChromeDriver();
		
		method = new Methods(driver);
	}

	@Test
	public void SearchRepoTest() {
		String search = "test";
		RepositoriesPage repos = new RepositoriesPage(driver);
		
		method.login();
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("home");
            }
        });
		
		int before = repos.numberRepos();
		
		repos.searchRepos(search);
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains("test");
            }
        });
		
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.partialLinkText("test")));
		
		int after = repos.numberRepos();
		
		Assert.assertTrue(before >= after);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
