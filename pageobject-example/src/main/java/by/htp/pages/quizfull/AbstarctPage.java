package by.htp.pages.quizfull;

import org.openqa.selenium.WebDriver;

public abstract class AbstarctPage {
	
	protected WebDriver driver;

	public abstract void openPage();
	
	public AbstarctPage(WebDriver driver)
	{
		this.driver = driver;
	}

}
