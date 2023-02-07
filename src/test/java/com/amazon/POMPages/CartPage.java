package com.amazon.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	public WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"sc-saved-cart-list-caption-text\"]")
	private WebElement savedforlaterBtn;
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void savedforlater()
	{
		savedforlaterBtn.click();
	}
	
}
