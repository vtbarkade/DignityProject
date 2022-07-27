package com.dignity.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.dignity.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long  Page_load_timeout =30;
	public static long Implicit_wait = 10;
	public static ITestResult result;
	public static String screenshotName;
	
	public static void takeScreenshotAtEndOfTest()throws IOException {
		 Date currentdate = new Date();
		 String screen =  currentdate.toString().replace(' ', '-').replace(':', '-');
		 System.out.println(screen);
		
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile, new File("./screenshots/"+screenshotName +""+screen+".png"));
		FileUtils.copyFile(scrFile, new File("./screenshots/"+screen+".png"));
		System.out.println("Screenshot taken");
		//screenshotName=result.getName();
		
		
	}
}
