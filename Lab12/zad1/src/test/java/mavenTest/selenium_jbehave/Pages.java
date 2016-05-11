package mavenTest.selenium_jbehave;

import mavenTest.selenium_jbehave.pages.Login;
import org.jbehave.web.selenium.WebDriverProvider;

public class Pages {

	private WebDriverProvider driverProvider;
	
	//Pages
	private Login login;
	// ...

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Login login() {
		if (login == null) {
			login = new Login(driverProvider);
		}
		return login;
	}
}
