package com.dignity.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dignity.qa.base.TestBase;

public class FindaDoctor extends TestBase{

	//Object Repository
	@FindBy(xpath="//p[text()='Hello, vijay']")
	WebElement UserNameVerify;
	
	@FindBy(xpath = "//ul//child::a[contains(text(),'Schedule an appointment')]")
	WebElement scheduleappointment;
	
	@FindBy (xpath ="//input[@placeholder='Doctor’s name, specialty, procedure, or insurance']")
	WebElement doctorname;
	
	@FindBy(xpath="//input[@placeholder='City or zip']")
	WebElement location;
		
	@FindBy(xpath="//button[@class='search-button']")
	WebElement search;
	
	@FindBy(xpath="//div[@class='logo brand-logo']//child::img[@class='image-responsive']")
	WebElement logo;
	
	@FindBy(xpath="//div[@class='no-search-results-title']")
	WebElement nosearchResult;
	
	//initialize webelements
	public FindaDoctor() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	
	public String validateCorrectUsername() {
		return UserNameVerify.getText();
	}
	
		
	public OurLocation DoctorSearch(String doctor, String citynm) {
				
		js.executeScript("arguments[0].click();",scheduleappointment );
		try
		{
			driver.findElement(By.xpath("//a[text()=' No, thanks ']")).click();
		}
		catch(NoSuchElementException e)
		{}
		js.executeScript("arguments[0].value = '"+doctor+"';", doctorname);
		js.executeScript("arguments[0].value = '"+citynm+"';", location);
		js.executeScript("arguments[0].click();",search );
		
		wait = new WebDriverWait(driver,5);
		//wait.until(ExpectedConditions.visibilityOf(location)).sendKeys(citynm);
		//wait.until(ExpectedConditions.visibilityOf(doctorname)).sendKeys(doctor);
		//wait.until(ExpectedConditions.visibilityOf(search)).click();
		
		
		//doctorname.sendKeys(doctor);
		//location.sendKeys(citynm);
		// search.click();
		
		
		try {
			//if (nosearchResult.isDisplayed())
			if(wait.until(ExpectedConditions.visibilityOf(nosearchResult)).isDisplayed())
			{
				System.out.println(nosearchResult.getText());
				Assert.assertFalse(true);
			}
		}
		catch(Exception e)
		{}
				
		return new OurLocation();
	}
}
