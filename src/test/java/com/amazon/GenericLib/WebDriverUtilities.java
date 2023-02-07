package com.amazon.GenericLib;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtilities {
	public void dropdown(WebElement ele, String text)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(text);
		
	}
	
	public void mousehover(WebDriver driver, WebElement ele)
	{
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
	public void rightclick(WebDriver driver, WebElement ele)
	{
		Actions a=new Actions(driver);
		a.contextClick(ele).perform();
	}
	
	public void doubleclick(WebDriver driver, WebElement ele)
	{
		Actions a=new Actions(driver);
		a.doubleClick(ele).perform();
	}
	
	public void draganddrop(WebDriver driver, WebElement src, WebElement dest)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}

	public void switchFrames(WebDriver driver)
	{
		driver.switchTo().frame(0);
	}
	
	public void swithBackFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public void alertpopupaccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void alertpopupdismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void switchtabs(WebDriver driver)
	{
		Set<String> child = driver.getWindowHandles();
		for(String b:child)
		{
			driver.switchTo().window(b);
		}
	}
		
	public void scrollbar(WebDriver driver, int x, int y)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("windows.scrollBy("+x+","+y+")");
	}
	
	public void jsClick(WebDriver driver, WebElement ele)	//sometimes click may not work, in those cond we use javascript click 
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",ele);
	}

}
