package by.htp.pages.mailru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class MailRuAbstractPage {

	protected WebDriver driver;
	
	public MailRuAbstractPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public abstract void openPage();
	
	protected void clickElement(WebElement element)
	{
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	protected void waitForPresenceOfElement(By locator)
	{
		new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
