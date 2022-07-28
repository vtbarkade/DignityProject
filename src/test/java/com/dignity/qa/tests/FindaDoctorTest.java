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
import com.dignity.qa.pages.OurLocation;
import com.dignity.qa.util.TestUtil;

public class FindaDoctorTest extends TestBase{
	LoginPage loginpage;
	FindaDoctor find;
    OurLocation location;
    
    
	public FindaDoctorTest() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();
		find = loginpage.Login();
				
	}
	
	@Test(priority=1)
	public void ValidateCorrectUsernameTest() {
		String name =find.validateCorrectUsername();
		Assert.assertEquals(name, "Hello, vijay" , "Username is not matched");
	}
	
		
	@Test (priority =2)
	public void doctorSearchTest() {
		location = find.DoctorSearch(prop.getProperty("doctor"), prop.getProperty("city"));
				
	}
	
	
	@AfterMethod
	public static void takeScreenshot(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			TestUtil.takeScreenshotAtEndOfTest(driver, result.getName());
		}
		driver.quit();
	}
	
}
