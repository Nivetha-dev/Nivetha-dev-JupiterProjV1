package com.jupiterproject.pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage extends BaseobjectPage{
WebDriver ldriver;
	
	public ShopPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

	@FindBy(xpath="//*[@id=\"product-1\"]/div/p/span")
	@CacheLookup
	WebElement priceP1;
	@FindBy(xpath="//*[@id=\"product-2\"]/div/p/span")
	@CacheLookup
	WebElement priceP2;
	@FindBy(xpath="//*[@id=\"product-3\"]/div/p/span")
	@CacheLookup
	WebElement priceP3;
	@FindBy(xpath="//*[@id=\"product-4\"]/div/p/span")
	@CacheLookup
	WebElement priceP4;
	@FindBy(xpath="//*[@id=\"product-5\"]/div/p/span")
	@CacheLookup
	WebElement priceP5;
	
	@FindBy(xpath="//*[@id=\"product-6\"]/div/p/span")
	@CacheLookup
	WebElement priceP6;
	@FindBy(xpath="//*[@id=\"product-7\"]/div/p/span")
	@CacheLookup
	WebElement priceP7;
	@FindBy(xpath="//*[@id=\"product-8\"]/div/p/span")
	@CacheLookup
	WebElement priceP8;
	
	@FindBy(xpath="//*[@id=\"product-1\"]/div/h4")
	@CacheLookup
	WebElement Pname1;
	@FindBy(xpath="//*[@id=\"product-2\"]/div/h4")
	@CacheLookup
	WebElement Pname2;
	@FindBy(xpath="//*[@id=\"product-3\"]/div/h4")
	@CacheLookup
	WebElement Pname3;
	@FindBy(xpath="//*[@id=\"product-4\"]/div/h4")
	@CacheLookup
	WebElement Pname4;
	@FindBy(xpath="//*[@id=\"product-5\"]/div/h4")
	@CacheLookup
	WebElement Pname5;
	@FindBy(xpath="//*[@id=\"product-6\"]/div/h4")
	@CacheLookup
	WebElement Pname6;
	@FindBy(xpath="//*[@id=\"product-7\"]/div/h4")
	@CacheLookup
	WebElement Pname7;
	@FindBy(xpath="//*[@id=\"product-8\"]/div/h4")
	@CacheLookup
	WebElement Pname8;
	

	@FindBy(xpath="//*[@id=\"product-1\"]/div/p/a")
	@CacheLookup
	WebElement lnkp1;
	@FindBy(xpath="//*[@id=\"product-2\"]/div/p/a")
	@CacheLookup
	WebElement lnkp2;
	@FindBy(xpath="//*[@id=\"product-3\"]/div/p/a")
	@CacheLookup
	WebElement lnkp3;
	@FindBy(xpath="//*[@id=\"product-4\"]/div/p/a")
	@CacheLookup
	WebElement lnkp4;
	@FindBy(xpath="//*[@id=\"product-5\"]/div/p/a")
	@CacheLookup
	WebElement lnkp5;
	
	@FindBy(xpath="//*[@id=\"product-6\"]/div/p/a")
	@CacheLookup
	WebElement lnkp6;
	@FindBy(xpath="//*[@id=\"product-7\"]/div/p/a")
	@CacheLookup
	WebElement lnkp7;
	@FindBy(xpath="//*[@id=\"product-8\"]/div/p/a")
	@CacheLookup
	WebElement lnkp8;
	

	
	public HashMap<String, String> setitemprice()
	{
		Map<String,String> map = new HashMap<String,String>();
		map.put(Pname1.getText(),priceP1.getText());
		map.put(Pname2.getText(),priceP2.getText());
		map.put(Pname3.getText(),priceP3.getText());
		map.put(Pname4.getText(),priceP4.getText());
		map.put(Pname5.getText(),priceP5.getText());
		map.put(Pname6.getText(),priceP6.getText());
		map.put(Pname7.getText(),priceP7.getText());
		map.put(Pname8.getText(),priceP8.getText());
		return  (HashMap<String, String>) map;
	}

	
	
	public void clickP1()
	{
		lnkp1.click();
	}	
	public void clickP2()
	{
		lnkp2.click();
	}	
	public void clickP3()
	{
		lnkp3.click();
	}	
	public void clickP4()
	{
		lnkp4.click();
	}	
	public void clickP5()
	{
		lnkp5.click();
	}	
	public void clickP6()
	{
		lnkp6.click();
	}	
	public void clickP7()
	{
		lnkp7.click();
	}	
	public void clickP8()
	{
		lnkp8.click();
	}	
	

}
