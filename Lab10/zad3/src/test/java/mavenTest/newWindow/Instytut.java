package mavenTest.newWindow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Instytut {

	@FindBy(name="s")
	private WebElement searchField;
		
	@FindBy(className="sbutton")
	private WebElement searchButton;
	
	@FindBy(partialLinkText="MFI UG")
	private WebElement mfiLink;
	
	@FindBy(linkText="Kontakt")
	public WebElement kontaktLink;
	
	public Instytut(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void find(String search) {
		searchField.clear();
		searchField.sendKeys(search);
		searchButton.click();
	}
	
	public void goToMFIPage() {
		mfiLink.click();
	}
}
