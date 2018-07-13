package by.htp.pages.mailru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends MailRuAbstractPage{

	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://mail.ru/";
	
	//Username field
	@FindBy(name = "login")
	private WebElement userNameField;
	
	//Password field
	@FindBy(name = "password")
	private WebElement passwordField;
	
	//Login button
	@FindBy(xpath = "//input[@value = 'Войти']")
	private WebElement btnSubmit;
	
	public LoginPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() 
	{
		driver.get(BASE_URL);	
	}
	
	public void login(String username, String password)
	{
		waitForPresenceOfElement(By.name("login"));
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		//clickElement(btnSubmit);
		btnSubmit.click();
	}

}
