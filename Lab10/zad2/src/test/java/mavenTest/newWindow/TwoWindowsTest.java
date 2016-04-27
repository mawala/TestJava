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
	WebElement element;
	String parentWindow;
	String childWindow;
	
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
	public void newWindowOpenTest() {
		driver.get("https://mat.ug.edu.pl/");
		parentWindow = driver.getWindowHandle();
		driver.findElement(By.partialLinkText("MFI UG")).click();
		driver.close();
		driver.switchTo().window(driver.getWindowHandles().iterator().next());
		
    	assertTrue(driver.getTitle().contains("Fizyki"));
	}

	@Test
	public void newWindowClickTest() {
		driver.get("https://mat.ug.edu.pl/");
		parentWindow = driver.getWindowHandle();
		driver.findElement(By.partialLinkText("MFI UG")).click();
		for (String page : driver.getWindowHandles()) {
			if (!page.equals(parentWindow)) {
				childWindow = page;
				break;
			}
		}
		driver.switchTo().window(childWindow);
		driver.findElement(By.partialLinkText("Studia I i II stopnia")).click();
		driver.close();
		
		driver.switchTo().window(parentWindow);
    	assertTrue(driver.getTitle().contains("Instytut"));
	}
}
