package com.dignity.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dignity.qa.base.TestBase;

public class FindaDoctor extends TestBase{

	//Object Repository
	@FindBy(xpath="//p[text()='Hello, vijay']")
	WebElement UserNameVerify;
	
	@FindBy(xpath = "//ul//child::a[contains(text(),'Schedule an appointment')]")
	WebElement scheduleappointment;
	
	@FindBy (xpath ="//div[@class='provider-search']//child::input")
	WebElement doctorname;
	
	@FindBy(xpath="//input[@placeholder='City or zip']")
	WebElement location;
	
	@FindBy(xpath="//li[text()=' Washington D.C., DC ']")
	WebElement selectCity;
	
	@FindBy(xpath="//button[@class='search-button']")
	WebElement search;
	
	@FindBy(xpath="//div[@class='logo brand-logo']//child::img[@class='image-responsive']")
	WebElement logo;
	
	@FindBy(xpath="//a[text()=' Ankit Nayyar, MD']")
	WebElement doctorResult;
	
	//initialize webelements
	public FindaDoctor() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	
	public String validateCorrectUsername() {
		return UserNameVerify.getText();
	}
	
		
	public OurLocation DoctorSearch(String doctor, String citynm) {
		scheduleappointment.click();
		try
		{
			driver.findElement(By.xpath("//a[text()=' No, thanks ']")).click();
		}
		catch(NoSuchElementException e)
		{}
		location.sendKeys(citynm);
		selectCity.click();
		doctorname.sendKeys(doctor);
			
		search.click();
		System.out.println(doctorResult.getText());
		
		return new OurLocation();
	}
}
