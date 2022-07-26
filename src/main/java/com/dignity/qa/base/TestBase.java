package com.dignity.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.dignity.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase() {
		
		try {
		prop = new Properties();
		FileInputStream srcfile = new FileInputStream("E:\\Selenium_Java_Projects\\Dignity\\src\\main\\java\\com\\dignity\\qa\\config\\config.properties");
		prop.load(srcfile);
		}
		catch (FileNotFoundException e)
		{}
		catch(IOException e)
		{}
	}
	
	public static void initialization() {
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browsername.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.Implicit_wait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.Page_load_timeout));
		
		driver.get(prop.getProperty("url"));
	}
}
