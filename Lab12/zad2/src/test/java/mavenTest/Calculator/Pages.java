package mavenTest.Calculator;

import org.jbehave.web.selenium.WebDriverProvider;

import mavenTest.Calculator.pages.Home;

public class Pages {

private WebDriverProvider driverProvider;
	
	private Home home;

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Home home() {
		if (home == null) {
			home = new Home(driverProvider);
		}
		return home;
	}
}
