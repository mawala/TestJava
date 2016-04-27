package mavenTest.newWindow;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TwoWindowsTest {

	private static WebDriver driver;
	String parentWindow;
	String childWindow;
	
	Instytut ins;
	Wydzial wyd;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDownAfterClass() {
		driver.quit();
	}

	@Test
	public void searchForTest() {
		driver.get("https://mat.ug.edu.pl/");
		ins = new Instytut(driver);
		
		String temp = "kontakt";
		
		ins.find(temp);
		
		assertFalse(driver.findElements(By.linkText("Kontakt")).isEmpty());
	}

	@Test
	public void newWindowTest() {
		driver.get("https://mat.ug.edu.pl/");
		ins = new Instytut(driver);
		wyd = new Wydzial(driver);
		
		parentWindow = driver.getWindowHandle();
		
		ins.goToMFIPage();
		
		for (String page : driver.getWindowHandles()) {
			if (!page.equals(parentWindow)) {
				childWindow = page;
				break;
			}
		}
		driver.close();
		driver.switchTo().window(childWindow);
		wyd.goToStudiaPage();
    	assertTrue(driver.getTitle().contains("Studia"));
	}
}
