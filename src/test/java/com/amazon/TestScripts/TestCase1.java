package com.amazon.TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.amazon.GenericLib.BaseClass;
import com.amazon.POMPages.CartPage;
import com.amazon.POMPages.EmailPage;
import com.amazon.POMPages.HomePage;
import com.amazon.POMPages.PasswordPage;
import com.amazon.POMPages.WelcomePage;

public class TestCase1 extends BaseClass
{
	@Test
	public void tc1() throws IOException
	{
		test=reports.createTest("Testcase1");
		
		WelcomePage w=new WelcomePage(driver);
		webutilies.mousehover(driver, w.getMousehover());
		EmailPage e = w.welcoming();
		PasswordPage p = e.entermail(fu.getPropertydata("email"));
		HomePage h = p.enterpassword(fu.getPropertydata("pwd"));
		CartPage c = h.clickoncart();
		c.savedforlater();
		
		
	}
	

}
