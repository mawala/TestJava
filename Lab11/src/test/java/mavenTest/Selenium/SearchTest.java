package mavenTest.Selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {

	private static WebDriver driver;
	
	@Before
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Karol\\Desktop\\studia\\informatyka\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
