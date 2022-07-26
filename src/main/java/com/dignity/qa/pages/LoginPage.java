package com.dignity.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dignity.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	@FindBy(xpath="//a[@id='loginButton']")
	WebElement MycareLogin;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailLocator;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordLocator;
	
	@FindBy(xpath="//button[text()=' Log in ']")
	WebElement loginButon;
	
	@FindBy(xpath="//p[text()='Hello, vijay']")
	WebElement UserNameVerify;
	
	//Initialization 
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
		
	public FindaDoctor Login() {
		MycareLogin.click();
		emailLocator.sendKeys(prop.getProperty("email"));
		passwordLocator.sendKeys(prop.getProperty("password"));
		loginButon.click();
		try
		{
			driver.findElement(By.xpath("//a[text()=' No, thanks ']")).click();
		}
		catch(NoSuchElementException e)
		{}
		System.out.println(UserNameVerify.getText());
		return new FindaDoctor();
	}
	
}
