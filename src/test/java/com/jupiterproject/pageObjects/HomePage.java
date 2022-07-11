package com.jupiterproject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseobjectPage{
WebDriver ldriver;
	
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

	@FindBy(partialLinkText="Start Shopping")
	@CacheLookup
	WebElement btnshopping;

	
	
	public void clickShopping()
	{
		btnshopping.click();
	}	

	
}
