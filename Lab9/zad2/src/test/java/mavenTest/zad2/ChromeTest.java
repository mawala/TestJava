package mavenTest.zad2;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeTest {

	private WebDriver driver;
	WebElement element;

	@Before
	public void driverSetup() {
		// change path to chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	@Test
	public void LoginTest() {		
		driver.get("https://github.com/");
		driver.findElement(By.linkText("Sign in")).click();
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("sign in");
            }
        });
		
		element = driver.findElement(By.id("login_field"));
		element.sendKeys("mawala");
		
		element = driver.findElement(By.id("password"));
		element.sendKeys("hidden");
		element.submit();
		
		assertEquals("GitHub", driver.getTitle());
	}

	@Test
	public void WrongLoginTest() {
		driver.get("https://github.com/");
		driver.findElement(By.linkText("Sign in")).click();
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("sign in");
            }
        });
		
		element = driver.findElement(By.id("login_field"));
		element.sendKeys("mawala");
		
		element = driver.findElement(By.id("password"));
		element.sendKeys("");
		element.submit();
		
		assertTrue(driver.getTitle().startsWith("Sign in"));
	}
	
	@Test
	public void FindTest() {		
		LoginTest();
		
		driver.findElement(By.linkText("mawala/TestJava")).click();
		
		element = driver.findElement(By.id("readme"));
		String result = element.getText();
		
		assertTrue(result.contains("TestJava"));
	}

	
	@After
	public void cleanup() {
		driver.quit();
	}
}
