package com.amazon.GenericLib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public FileUtilities fu=new FileUtilities();
	public WebDriver driver;
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports reports;
	public static ExtentTest test;
	public WebDriverUtilities webutilies=new WebDriverUtilities();

	
	
	@BeforeSuite		//Before and After suite executes only once during entire execution
	public void configBS()
	{
		
		htmlreport= new ExtentHtmlReporter(AutoConstants.reportPath);
		htmlreport.config().setDocumentTitle("NewAmazonReport");
		htmlreport.config().setTheme(Theme.DARK);
		reports=new ExtentReports();
		reports.attachReporter(htmlreport);
		
		
	}
	
	@BeforeMethod
	public void openApp() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fu.getPropertydata("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void closeApp(ITestResult res) throws IOException 
	{
		int result = res.getStatus();
		if(result==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, res.getName()+" Test case is failed");
			test.log(Status.FAIL, res.getThrowable()+" Test case is failed exception");
		}
		else if(result==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, res.getName()+" Test Case is Passed");
		}
		else if(result==ITestResult.SKIP)
		{
			test.log(Status.SKIP, res.getName()+" Test case is skipped");
		}
		
		String name = res.getName();
		if(result==2)
		{
			ScreenShot s= new ScreenShot();
			s.getPhoto(driver, name);
		}
		
		driver.quit();
	}
	
	@AfterSuite
	public void configAS()
	{
		reports.flush();
		
	}

}
