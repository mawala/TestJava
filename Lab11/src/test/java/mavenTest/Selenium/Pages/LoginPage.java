package mavenTest.Selenium.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	@FindBy(id="js-email-field")
	private WebElement emailField;
	
	@FindBy(id="js-password-field")
	private WebElement passwordField;
	
	@FindBy(className="selenium-login-submit")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@id='js-global-login-error-container']/p")
	private List<WebElement> errorsList;
	
	@FindBy(xpath="//div[contains(.,'This field is required.')]")
	private List<WebElement> errorsListSecond;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void fillEmail(String email)
	{
		emailField.clear();
		if (email != null)
			emailField.sendKeys(email);
	}
	
	public void fillPassword(String password)
	{
		passwordField.clear();
		if (password != null)
			passwordField.sendKeys(password);
	}
	
	public boolean checkLoginButton()
	{
		boolean result = true;
		try
		{
			loginButton.getClass();
		}
		catch(Exception e)
		{
			result = false;
		}
		return result;
	}
	
	public void logIn(String email, String password)
	{
		fillEmail(email);
		fillPassword(password);
		loginButton.click();
	}
	
	public int checkErrors()
	{
		return errorsList.size();
	}
	
	public int checkErrorsSecond()
	{
		return errorsListSecond.size();
	}
}
