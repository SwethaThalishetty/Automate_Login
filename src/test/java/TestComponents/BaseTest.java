package TestComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import PageComponents.ConfigDataReader;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class BaseTest {

	public WebDriver driver;

	ConfigDataReader config = new ConfigDataReader();

	@BeforeClass
	public void launchApplication() {

		switch (config.getBrowser()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			break;
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to(config.getUrl());

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
