package mavenTest.ankieta;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SurveyPage {

	@FindBy(name="ot[9126851]")
	private WebElement ddFirst;
	
	@FindBy(xpath="//span[contains(.,'Bo to potrzebne')]")
	private WebElement rbtnSecond;
	
	@FindBy(xpath="//span[contains(.,'Jako pracę domową')]")
	private WebElement cbxSecond;
	
	@FindBy(xpath="//span[contains(.,'Muszę')]")
	private WebElement cbxThird;
	
	@FindBy(xpath="//div[@class='text-addon']/span/input")
	private WebElement cbxFourthText;
	
	@FindBy(xpath="//div[@aria-label='1']")
	private WebElement rateFirst;
	
	@FindBy(name="odeslat")
	private WebElement btnSubmit;
	
	@FindBy(className="alert")
	private List<WebElement> alertErrors;
	
	public SurveyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void chooseFirstOptionInFirstQuestion() {
		ddFirst.click();
		ddFirst.sendKeys(Keys.ARROW_DOWN);
		ddFirst.sendKeys(Keys.ENTER);
	}
	
	public void chooseSecondRadioButtonInSecondQuestion() {
		rbtnSecond.click();
	}
	
	public void chooseSecondCheckBoxInThirdQuestion() {
		cbxSecond.click();
	}
	
	public void chooseThirdCheckBoxInThirdQuestion() {
		cbxThird.click();
	}
	
	public void chooseFourthCheckBoxInThirdQuestion(String reason) {
		cbxFourthText.click();
		cbxFourthText.sendKeys(reason);
	}
	
	public void rateOneStar() {
		rateFirst.click();
	}
	
	public void sendSurvey() {
		btnSubmit.click();
	}
	
	public boolean isError() {
		return !alertErrors.isEmpty();
	}
	
	public int numberOfErrors() {
		return alertErrors.size();
	}
	
}
