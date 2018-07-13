package by.htp.pages.quizfull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstarctPage{
	
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "http://www.quizful.net/LoginAction.loginForm";
	
	@FindBy(name = "loginForm.login")
	private WebElement userNameField;
	
	@FindBy(name = "loginForm.password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	private WebElement btnSubmit;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void login(String username, String password)
	{
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		btnSubmit.click();
	}

	@Override
	public void openPage() {
		
		driver.navigate().to(BASE_URL);
	}

}
