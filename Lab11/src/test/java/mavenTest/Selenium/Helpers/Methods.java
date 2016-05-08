package mavenTest.Selenium.Helpers;

import org.openqa.selenium.WebDriver;

import mavenTest.Selenium.Pages.DeletePage;
import mavenTest.Selenium.Pages.HomePage;
import mavenTest.Selenium.Pages.LoginPage;
import mavenTest.Selenium.Pages.NewRepoPage;
import mavenTest.Selenium.Pages.RepoPage;
import mavenTest.Selenium.Pages.RepositoriesPage;
import mavenTest.Selenium.Pages.SettingsPage;

public class Methods {

	private WebDriver driver;
	
	public Methods(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login() {
		HomePage home = new HomePage(driver);
		driver.get(home.getWebLink());
		home.clickLoginButton();
		
		LoginPage login = new LoginPage(driver);
		login.logIn(Strings.getEmail(), Strings.getPassword());
	}
	
	public void toCreateRepo() {
		RepositoriesPage repos = new RepositoriesPage(driver);
		repos.clickCreateRepoLink();
	}
	
	public void toCreateRepoToNewWindow() {
		RepositoriesPage repos = new RepositoriesPage(driver);
		repos.clickCreateRepoLinkToNewWindow();
	}
	
	public void createRepo(String name, String desc) {
		NewRepoPage newRepo = new NewRepoPage(driver);
		newRepo.fillForm(name, desc);
	}
	
	public void deleteRepo() {
		RepoPage repo = new RepoPage(driver);
		repo.toSettings();
		
		SettingsPage sett = new SettingsPage(driver);
		sett.toDeleteRepoSettings();
		
		DeletePage delete = new DeletePage(driver);
		delete.deleteRepo();
	}
}
