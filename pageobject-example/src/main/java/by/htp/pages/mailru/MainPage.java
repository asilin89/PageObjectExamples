package by.htp.pages.mailru;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends MailRuAbstractPage{

	//Write a message button
	@FindBy(xpath = "//span[text() = 'Написать письмо']")
	private WebElement btnComposeMessage;
	
	//Send To text field
	@FindBy(xpath = "//textarea[@data-original-name = 'To']")
	private WebElement sendToField;
	
	//Subject text field
	@FindBy(xpath = "//input[@name = 'Subject']")
	private WebElement subjectField;
	
	//Compose message frame
	@FindBy(xpath = "//iframe[@id[contains(.,'toolkit')]]")
	private WebElement composeFrame;
	
	//Send button
	@FindBy(xpath = "//span[text() = 'Отправить']")
	private WebElement btnSend;
	
	public MainPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() 
	{
		
	}
	
	public void composeMessage(String to, String subject, String message)
	{
		String composeMsgBtn = "//span[text() = 'Написать письмо']";
		waitForPresenceOfElement(By.xpath(composeMsgBtn));
		btnComposeMessage.click();
		//sendToField.sendKeys("sviatlana.zakharenka@gmail.com");
		sendToField.sendKeys(to);
		subjectField.sendKeys(subject);
		driver.switchTo().frame(composeFrame);
		driver.findElement(By.xpath("//body[@id = 'tinymce' and @class = 'mceContentBody compose2']")).sendKeys(message);
		driver.switchTo().defaultContent();
	}
	
	public void sendMessage()
	{
		btnSend.click();
	}
}
