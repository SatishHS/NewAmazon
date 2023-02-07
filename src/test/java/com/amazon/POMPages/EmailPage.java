package com.amazon.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {
	public WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"ap_email\"]")
	private WebElement emailTF;
	
	@FindBy(xpath="//*[@id=\"continue\"]")
	private WebElement continueBtn;
	
	public EmailPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public PasswordPage entermail(String mailid)
	{
		emailTF.sendKeys(mailid);
		continueBtn.click();
		return new PasswordPage(driver);
	}

	public WebElement getEmailTF() {
		return emailTF;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	
}
