package mavenTest.newWindow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wydzial {

	@FindBy(linkText="Studia I i II stopnia")
	private WebElement studiaLink;
	
	public Wydzial(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void goToStudiaPage() {
		studiaLink.click();
	}
}
