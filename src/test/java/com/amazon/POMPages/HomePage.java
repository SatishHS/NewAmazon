package com.amazon.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"nav-cart\"]")
	private WebElement cartBtn;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public CartPage clickoncart()
	{
		cartBtn.click();
		return new CartPage(driver);
	}

	public WebElement getCartBtn() {
		return cartBtn;
	}
	
	
	
}
