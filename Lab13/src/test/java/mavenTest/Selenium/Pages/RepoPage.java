package mavenTest.Selenium.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepoPage {
	
	@FindBy(id="repo-settings-link")
	private WebElement toSettingsLink;
	
	@FindBy(linkText="testy")
	private WebElement repoName;
	
	public RepoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void toSettings() {
		toSettingsLink.click();
	}
	
	public boolean checkRepoPage() {
		boolean result;
		try {
			repoName.getClass();
			result = true;
		} catch (Exception ex) {
			result = false;
		}
		return result;
	}
}
