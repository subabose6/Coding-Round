package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModel.WikiPojoClass;

public class BaseClass {

	public static WebDriver driver;

	@Test(priority = 0)
	public void OpenBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		PageFactory.initElements(driver, WikiPojoClass.class);
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");

	}

	@Test(priority = 1)
	public void CheckReleaseDate() {

		String releaseDate = WikiPojoClass.getReleaseDate().getText();
		System.out.println(releaseDate);
		Assert.assertEquals("17 December 2021", releaseDate);
	}

	@Test(priority = 2)
	public void CheckReleaseCountryName() {

		String countryName = WikiPojoClass.getCountryName().getText();
		System.out.println(countryName);
		Assert.assertEquals("India", countryName);
	}

	@Test(priority = 3)
	public void closeBrowser() {
		driver.close();
	}
}
