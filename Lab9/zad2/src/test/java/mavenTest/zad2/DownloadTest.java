package mavenTest.zad2;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DownloadTest {

	private static WebDriver driver;
	private static String downloadFilepath;
	
	@BeforeClass
	public static void driverSetup() {
		// change path to chromedriver
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

		// change path for download
		downloadFilepath = "path/of/downloads/";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver = new ChromeDriver(cap);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	
	@Test
	public void DownloadingTest() throws InterruptedException {
		
		driver.get("https://github.com/mawala/TestJava/");
		driver.findElement(By.linkText("Download ZIP")).click();
		
		Thread.sleep(3000);
		
		File f = new File(downloadFilepath + "TestJava-master.zip");
		assertTrue(f.exists());
	}

	
	@AfterClass
	public static void cleanup() {
		driver.quit();
	}
}
