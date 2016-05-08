package mavenTest.Selenium.Pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewRepoPage {

	@FindBy(id="id_name")
	private WebElement nameField;
	
	@FindBy(xpath="//div[@class='repo-create--expandable']/button")
	private WebElement advButton;
	
	@FindBy(id="id_description")
	private WebElement descField;
	
	@FindBy(id="s2id_id_forking")
	private WebElement forkingDropDown;
	
	@FindBy(name="forking")
	private WebElement forkingSelect;
	
	@FindBy(id="id_has_issues")
	private WebElement issuesCheckBox;
	
	@FindBy(xpath="//div[contains(.,'This is a required field')]")
	private List<WebElement> errorsList;
	
	@FindBy(xpath="//button[contains(.,'Create repository')]")
	private WebElement createButton;
	
	public NewRepoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void fillNameField(String name) {
		nameField.clear();
		if (name != null)
			nameField.sendKeys(name);
	}
	
	public void clickAdvButton() {
		advButton.click();
	}
	
	public void fillDescField(String desc) {
		descField.clear();
		if (desc != null)
			descField.sendKeys(desc);
	}
	
	public void chooseForking() {
		forkingDropDown.click();
		forkingSelect.sendKeys(Keys.ARROW_DOWN);
		forkingSelect.sendKeys(Keys.ENTER);
	}
	
	public void selectIssues() {
		issuesCheckBox.click();
	}
	
	public void clickCreate() {
		createButton.click();
	}
	
	public void fillForm(String name, String desc) {
		fillNameField(name);
		clickAdvButton();
		fillDescField(desc);
		chooseForking();
		selectIssues();
		clickCreate();
	}
	
	public int checkError() {
		return errorsList.size();
	}
}
