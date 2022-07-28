package com.dignity.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dignity.qa.base.TestBase;
import com.dignity.qa.pages.FindaDoctor;
import com.dignity.qa.pages.LoginPage;
import com.dignity.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	FindaDoctor find;
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void verifyLoginTitleTest() {
		String title = loginpage.verifyLoginPageTitle();
		Assert.assertEquals(title, "Dignity Health | Hello humankindness", "Login Page Title mismatched");
	}
	
		
	@Test(priority=2)
	public void LoginTest() {
		find = loginpage.Login();
	}
	
	@AfterMethod
	public static void takeScreenshot(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			TestUtil.takeScreenshotAtEndOfTest(driver, result.getName());
		}
		driver.quit();
	}
}
