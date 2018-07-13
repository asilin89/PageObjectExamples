package by.htp.pages.quizfull;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstarctPage{
	
	@FindBy(xpath = "//ul[@id = 'user-panel']/li//a[@rel = 'nofollow']")
	private WebElement userTitle;

	public MainPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		// TODO Auto-generated method stub
		
	}
	
	public String getUserTitle()
	{
		String user = userTitle.getText();
		return user;
	}
	
	public void verifyUserNameIsDisplayed()
	{
		userTitle.isDisplayed();
	}

}
