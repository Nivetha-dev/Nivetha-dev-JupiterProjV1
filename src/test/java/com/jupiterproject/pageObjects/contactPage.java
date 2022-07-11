package com.jupiterproject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactPage extends BaseobjectPage{

	WebDriver ldriver;
	
	public contactPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
	@FindBy(name="forename")
	@CacheLookup
	WebElement txtforeName;
	
	@FindBy(name="surname")
	@CacheLookup
	WebElement txtsurName;
	
	@FindBy(name="email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(name="telephone")
	@CacheLookup
	WebElement txttelephone;
	
	@FindBy(name="message")
	@CacheLookup
	WebElement txtmessage;
	
	
	@FindBy(partialLinkText="Submit")
	@CacheLookup
	WebElement btnSubmit;
	
	
	
	public void setUserName(String fname)
	{
		txtforeName.sendKeys(fname);
	}
	
	public void setSurName(String sname)
	{
		txtsurName.sendKeys(sname);
	}
	public void setPassword(String sname)
	{
		txttelephone.sendKeys(sname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	
	public void setTelephone(String telephone)
	{
		txttelephone.sendKeys(telephone);
	}
	
	
	public void setMessage(String msg)
	{
		txtmessage.sendKeys(msg);
	}
	
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}	
	

	
}
