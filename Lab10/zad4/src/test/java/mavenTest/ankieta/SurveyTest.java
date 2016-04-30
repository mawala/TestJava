package mavenTest.ankieta;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SurveyTest {

	private static WebDriver driver;
	private SurveyPage sPage;

	@Before
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("http://www.survio.com/survey/d/E4N2W2P9C6Y7T1N8O");
	}
	
	@Test
	public void CorrectSurveyTest() {
		sPage = new SurveyPage(driver);
		
		sPage.chooseFirstOptionInFirstQuestion();
		
		sPage.chooseSecondRadioButtonInSecondQuestion();
		
		sPage.chooseSecondCheckBoxInThirdQuestion();
		sPage.chooseThirdCheckBoxInThirdQuestion();
		
		sPage.rateOneStar();
		
		sPage.sendSurvey();
		
		assertTrue(driver.getTitle().contains("Dziękujemy"));
	}
	
	@Test
	public void CorrectSurveyWithTextTest() {
		sPage = new SurveyPage(driver);
		
		sPage.chooseFirstOptionInFirstQuestion();
		
		sPage.chooseSecondRadioButtonInSecondQuestion();
		
		sPage.chooseSecondCheckBoxInThirdQuestion();
		sPage.chooseThirdCheckBoxInThirdQuestion();
		sPage.chooseFourthCheckBoxInThirdQuestion("nie wiem");
		
		sPage.rateOneStar();
		
		sPage.sendSurvey();
		
		assertTrue(driver.getTitle().contains("Dziękujemy"));
	}
	
	@Test
	public void WrongSurveyTest() {
		sPage = new SurveyPage(driver);
		
		//no answer for first question
		
		sPage.chooseSecondRadioButtonInSecondQuestion();
		
		sPage.chooseSecondCheckBoxInThirdQuestion();
		sPage.chooseThirdCheckBoxInThirdQuestion();
		sPage.chooseFourthCheckBoxInThirdQuestion("nie wiem");
		
		sPage.rateOneStar();
		
		sPage.sendSurvey();
		
		assertTrue(sPage.isError());
	}
	
	@Test
	public void EmptySurveyTest() {
		sPage = new SurveyPage(driver);
		
		sPage.sendSurvey();
		
		assertEquals(4, sPage.numberOfErrors());
	}
	
	
	@After
	public void cleanUp() {
		driver.quit();
	}

}
