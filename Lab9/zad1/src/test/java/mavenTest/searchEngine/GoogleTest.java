package mavenTest.searchEngine;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTest {

	private static WebDriver driver;
	WebElement element;

	String searchFor;
	String result;
	
	@BeforeClass
	public static void driverSetup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	@Test
	public void homePage(){
		driver.get("https://www.google.pl");
		String title = driver.getTitle(); 
		assertEquals("Google", title);
	}
	
	@Test
	public void searchForPage(){
		driver.get("https://www.google.pl");
		searchFor = "kitties";
		
		element = driver.findElement(By.name("q"));
		element.clear();
		element.sendKeys(searchFor);
        element.submit();
        
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(searchFor);
            }
        });
        
        result = driver.getTitle();
        String expected = searchFor + " - Szukaj w Google";
		assertEquals(expected, result);
		
		element = driver.findElement(By.partialLinkText(searchFor));
		assertNotNull(element);
	}
	
	@Test
	public void ImagesPage(){
		driver.get("https://www.google.pl");
		searchFor = "puppies";
		
		element = driver.findElement(By.name("q"));
		element.clear();
		element.sendKeys(searchFor);
        element.submit();		
		driver.findElement(By.linkText("Obrazy dla " + searchFor)).click();
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);
		try {
			FileUtils.copyFile(screenshot, new File("test/resources/puppies.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}
	
	@Test
	public void NotFoundPage(){
		driver.get("https://www.google.pl");
		searchFor = "fhsldnfofadfsdf";
		
		element = driver.findElement(By.name("q"));
		element.sendKeys(searchFor);
        element.submit();		
        
        
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(searchFor);
            }
        });
        
        element = driver.findElement(By.id("res"));
        assertTrue(element.getText().contains("Podana fraza - fhsldnfofadfsdf - nie została odnaleziona."));
	}

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
