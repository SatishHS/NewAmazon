package com.amazon.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
	public WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"ap_password\"]")
	private WebElement passwordTF;
	
	@FindBy(xpath="//*[@id=\"signInSubmit\"]")
	private WebElement submitBtn;
	
	public PasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public HomePage enterpassword(String pwd)
	{
		passwordTF.sendKeys(pwd);
		submitBtn.click();
		return new HomePage(driver);
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	

}
