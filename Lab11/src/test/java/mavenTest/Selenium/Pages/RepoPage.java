package mavenTest.Selenium.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepoPage {
	
	@FindBy(id="repo-settings-link")
	private WebElement toSettingsLink;
	
	public RepoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void toSettings() {
		toSettingsLink.click();
	}
}
