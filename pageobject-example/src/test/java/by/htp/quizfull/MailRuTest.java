package by.htp.quizfull;

import org.testng.annotations.Test;

import by.htp.driver.DriverInitializer;
import by.htp.pages.mailru.LoginPage;
import by.htp.pages.mailru.MainPage;
import by.htp.testdata.TestData;

public class MailRuTest extends DriverInitializer{
	
	/**
	 * This test verifies that a user can log in to Mail.ru and send a message.
	 */
	
	@Test
	public void testMainRu()
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(TestData.userName, TestData.password);
		
		MainPage mainPage = new MainPage(driver);
		mainPage.composeMessage(TestData.to, TestData.subject, TestData.textMessage);
		mainPage.sendMessage();
	}
}
