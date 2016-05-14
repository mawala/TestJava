package mavenTest.Calculator.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Home extends WebDriverPage {

	public Home(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("http://web2.0calc.com/");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}	
}
