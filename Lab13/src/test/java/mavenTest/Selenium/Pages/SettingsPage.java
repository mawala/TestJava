package mavenTest.Selenium.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

	@FindBy(linkText="Delete repository")
	private WebElement toDeleteLink;
	
	public SettingsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void toDeleteRepoSettings() {
		toDeleteLink.click();
	}
}
