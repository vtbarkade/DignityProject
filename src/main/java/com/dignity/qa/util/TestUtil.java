package com.dignity.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.dignity.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long  Page_load_timeout =30;
	public static long Implicit_wait = 10;
	public static ITestResult result;
	public static String screenshotName;
	
	public static void takeScreenshotAtEndOfTest(WebDriver driver, String screenshotName)throws IOException {
		 Date currentdate = new Date();
		 String screen =  currentdate.toString().replace(' ', '-').replace(':', '-');
		 System.out.println(screen);
		
		 try {
			    //screenshotName=result.getName();
				TakesScreenshot ts= (TakesScreenshot)driver;
				File scrFile = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("./screenshots/"+screenshotName+""+screen+".png"));
				System.out.println("Screenshot taken");
				
			} 
		 catch (Exception e) {
				e.printStackTrace();
			}
		
		
	}
}
