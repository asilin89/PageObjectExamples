package by.htp.driver;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DriverInitializer {
	
	protected static WebDriver driver;
	private static final Logger logger = LogManager.getRootLogger();
	
	public static final String CHROME = "webdriver.chrome.driver";
	public static final String CHROME_PATH = "c:\\chromedriver.exe";
	
	@BeforeTest
	public static WebDriver getDriver()
	{
		if(driver == null)
		{
			System.setProperty(CHROME, CHROME_PATH);
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			logger.info("Browser started");
			
		}
		return driver;
	}
	
	@AfterTest
	public static void quiteDriver()
	{
		try
		{
			driver.manage().deleteAllCookies();
		}
		catch(Exception e)
		{
			logger.warn("Couldn't delete all cookies.");
		}
		driver.quit();
	}
}
