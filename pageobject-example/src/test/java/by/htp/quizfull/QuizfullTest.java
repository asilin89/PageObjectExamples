package by.htp.quizfull;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import by.htp.driver.DriverInitializer;
import by.htp.pages.quizfull.LoginPage;
import by.htp.pages.quizfull.MainPage;

public class QuizfullTest extends DriverInitializer{
	
	String userName = "HAHAHA";
	String password = "HAHAHA";
	
	@Test
	public void login()
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(userName, password);
		
		MainPage mainPage = new MainPage(driver);
		mainPage.verifyUserNameIsDisplayed();
		String userName = mainPage.getUserTitle();
		Assert.assertEquals(this.userName, userName);
	}
}
