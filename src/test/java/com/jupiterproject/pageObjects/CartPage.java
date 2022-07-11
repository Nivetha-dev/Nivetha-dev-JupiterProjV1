	package com.jupiterproject.pageObjects;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class CartPage  extends BaseobjectPage{
	WebDriver ldriver;
		
		public CartPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
				
		@FindBy(xpath="/html/body/div[2]/div/form/table/tbody/tr/td[2]")
		@CacheLookup
		WebElement price;
		@FindBy(xpath="/html/body/div[2]/div/form/table/tbody/tr/td[3]/input")
		@CacheLookup
		WebElement subtotal;
		@FindBy(xpath="/html/body/div[2]/div/form/table/tbody/tr/td[4]")
		@CacheLookup
		WebElement quantity;
		@FindBy(xpath="/html/body/div[2]/div/form/table/tbody/tr/td[5]/ng-confirm")
		@CacheLookup
		WebElement btndelete;
		@FindBy(partialLinkText="Check Out")
		@CacheLookup
		WebElement btnCheckout;
		
		@FindBy(partialLinkText="Empty Cart")
		@CacheLookup
		WebElement btnEmptycart;

		
		

		public void clickCheckout()
		{
			btnCheckout.click();
		}	
		public void clickEmptyCart()
		{
			btnEmptycart.click();
		}	
		
	}

