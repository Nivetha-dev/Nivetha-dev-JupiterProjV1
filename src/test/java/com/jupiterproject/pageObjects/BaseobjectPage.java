package com.jupiterproject.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BaseobjectPage {

	@FindBy(partialLinkText="Home")
	@CacheLookup
	WebElement lnkhome;
	@FindBy(partialLinkText="Shop")
	@CacheLookup
	WebElement lnkshop;
	@FindBy(partialLinkText="Contact")
	@CacheLookup
	WebElement lnkcontact;
	@FindBy(partialLinkText="Login")
	@CacheLookup
	WebElement lnklogin;
	@FindBy(partialLinkText="Cart")
	@CacheLookup
	WebElement lnkcart;
	@FindBy(partialLinkText="Jupiter Toys")
	@CacheLookup
	WebElement lnktoys;
	
	
	
	public void clickHome()
	{
		lnkhome.click();
	}	
	public void clickShop()
	{
		lnkshop.click();
	}	
	public void clickContact()
	{
		lnkcontact.click();
	}	
	public void clickLogin()
	{
		lnklogin.click();
	}	
	public void clickCart()
	{
		lnkcart.click();
	}	
	public void clickToys()
	{
		lnktoys.click();
	}	
}
