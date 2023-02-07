package com.amazon.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	public WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"nav-link-accountList-nav-line-1\"]")
	private WebElement mousehover;
	
	@FindBy(xpath="/html/body/div[1]/header/div/div[3]/div[3]/div[2]/div/div[1]/div/a/span")
	private WebElement signinBtn;
	
	
	public WelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public EmailPage welcoming()
	{
		signinBtn.click();
		return new EmailPage(driver);
	}

	public WebElement getMousehover() {
		return mousehover;
	}

	public WebElement getSigninBtn() {
		return signinBtn;
	}
	
	

}
