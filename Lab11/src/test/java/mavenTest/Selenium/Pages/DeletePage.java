package mavenTest.Selenium.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePage {

	@FindBy(xpath="//button[contains(.,'Delete repository')]")
	private WebElement deleteButton;
	
	@FindBy(xpath="//div[@class='aui-dialog2-footer-actions']/button[contains(.,'Delete')]")
	private WebElement deleteAcceptButton;
	
	public DeletePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void deleteRepo() {
		deleteButton.click();
		deleteAcceptButton.click();
	}
}
