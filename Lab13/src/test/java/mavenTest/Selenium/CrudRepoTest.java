package mavenTest.Selenium;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import mavenTest.Selenium.Helpers.*;
import mavenTest.Selenium.Pages.*;

public class CrudRepoTest {

	private static WebDriver driver;
	private Methods method;
	
	String parentWindow;
	String childWindow;
	
	@Before
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Karol\\Desktop\\studia\\informatyka\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		method = new Methods(driver);
	}
	
	
	@Test
	public void NewRepoTest() {
		String name = "tests";
		RepositoriesPage repos = new RepositoriesPage(driver);
		
		method.login();
		
		int before = repos.numberRepos();
		parentWindow = driver.getWindowHandle();
		
		method.toCreateRepoToNewWindow();
		for (String page : driver.getWindowHandles()) {
			if (!page.equals(parentWindow)) {
				childWindow = page;
				break;
			}
		}
		driver.switchTo().window(childWindow);
		method.createRepo(name, null);
		
		driver.switchTo().window(parentWindow);
		driver.navigate().refresh();
		int middle = repos.numberRepos();
		
		driver.switchTo().window(childWindow);
		method.deleteRepo();
		
		driver.navigate().refresh();
		int after = repos.numberRepos();
		
		Assert.assertEquals(before + 1, middle);
		Assert.assertEquals(before, after);
	}

	@Test
	public void NewRepoWrongTest() {
		NewRepoPage newRepo = new NewRepoPage(driver);
		
		method.login();
		method.toCreateRepo();
		method.createRepo(null, null);
		
		Assert.assertNotEquals(0, newRepo.checkError());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
