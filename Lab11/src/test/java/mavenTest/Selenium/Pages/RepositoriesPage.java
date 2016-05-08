package mavenTest.Selenium.Pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RepositoriesPage {

	private Actions act;
	
	@FindBy(partialLinkText="Repositories")
	private WebElement reposLink;
	
	@FindBy(partialLinkText="Create repository")
	private WebElement createRepoLink;
	
	@FindBy(xpath="//span[contains(.,'Owner')]")
	private WebElement ownerDropDown;
	
	@FindBy(id="repo-filter")
	private WebElement filterField;
	
	@FindBy(className="iterable-item")
	private List<WebElement> reposList;
	
	public RepositoriesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}
	
	public void clickReposLink() {
		reposLink.click();
	}
	
	public void clickCreateRepoLink() {
		clickReposLink();
		createRepoLink.click();
	}
	
	public void clickCreateRepoLinkToNewWindow() {
		clickReposLink();
		act.keyDown(Keys.SHIFT).click(createRepoLink).keyUp(Keys.SHIFT).build().perform();
	}
	
	public void chooseOwner(int which) {
		ownerDropDown.click();
		for(int i = 1; i <= which; i++) {
			ownerDropDown.sendKeys(Keys.ARROW_DOWN);
		}
		ownerDropDown.sendKeys(Keys.ENTER);
	}
	
	public void searchRepos(String search) {
		filterField.clear();
		filterField.sendKeys(search);
	}
	
	public int numberRepos() {
		return reposList.size();
	}
	
}
