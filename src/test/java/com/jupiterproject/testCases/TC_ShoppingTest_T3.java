package com.jupiterproject.testCases;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jupiterproject.pageObjects.HomePage;
import com.jupiterproject.pageObjects.ShopPage;
import com.jupiterproject.testData.BaseClass;

import junit.framework.Assert;

public class TC_ShoppingTest_T3 extends BaseClass{

	@Test
	public void ShoppingTest() throws Exception 

	{driver.get(baseURL);
	logger.info("URL opened");

	HomePage hp =new HomePage(driver);
	ShopPage sp =new ShopPage(driver);
	hp.clickShop();
	Assert.assertTrue(true);
	logger.info("Navigated to Shopping page");
	Map<String,String> mapIemPrice = sp.setitemprice();


	//1.	Buy 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear
	for (int i = 1; i <= itemCount[0]; i++){
		sp.clickP2();
		Assert.assertTrue(true);
	}
	for (int i = 1; i <= itemCount[1]; i++){
		sp.clickP4();
		Assert.assertTrue(true);
	}

	for (int i = 1; i <= itemCount[2]; i++){
		sp.clickP7();
		Assert.assertTrue(true);
	}
	Thread.sleep(3000);

	sp.clickCart();
	Assert.assertTrue(true);
	
	//3.	Verify the subtotal for each product is correct

	List<WebElement> lstrow=driver.findElements(By.xpath("//table[contains(@class,'table table-striped cart-items')]/tbody//tr"));

	// private static final DecimalFormat df = new DecimalFormat(0.00);
	DecimalFormat df = new DecimalFormat("###.##");
//	int[] abc=new int[5];
//	abc=itemCount;
//	abc[1]=2;
//	abc[2]=5;
//	abc[3]=3;
//	int co=abc.length;
	float itemprice=(float) 0.00;
	float subtl=(float) 0.00;
	for (int c=1;c<=lstrow.size();c++)
	{

		String stritemprice=driver.findElement(By.xpath("//table[contains(@class,'table table-striped cart-items')]/tbody/tr["+c+"]/td[2]")).getText();
		itemprice=Float.parseFloat(stritemprice.substring(1).toString());
		String strsubtl=driver.findElement(By.xpath("//table[contains(@class,'table table-striped cart-items')]/tbody/tr["+c+"]/td[4]")).getText();
		subtl=Float.parseFloat(strsubtl.substring(1).toString());

		Float finalsubtl=Float.parseFloat(df.format(itemprice * itemCount[c-1]));
		if(finalsubtl==subtl)
		{
			logger.info("sub total : "+ finalsubtl);
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"TestCase3");			
			logger.info("Incorrect Sub-total");
			Assert.assertTrue(false);
		}

	}


	//5.	Verify that total = sum(sub totals)
	float total=(float) 0.00;
	for (int i=1;i<=lstrow.size();i++)
	{
		String strsubtotal=driver.findElement(By.xpath("//table[contains(@class,'table table-striped cart-items')]/tbody/tr["+i+"]/td[4]")).getText();


		total=Float.parseFloat(strsubtotal.substring(1).toString())+total;
	}
	//logger.info(total);
	if(driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tfoot/tr[1]/td/strong")).getText().contains(" " +total))
	{

		logger.info("total : "+total);
		Assert.assertTrue(true);
	}
	else
	{
		captureScreen(driver,"TestCase3");			
		logger.info("Incorrect total");
		Assert.assertTrue(false);
	}


	//	Verify the price for each product

	for (int i=1;i<=lstrow.size();i++)
	{
		Iterator<Map.Entry<String, String> >
		iterator = mapIemPrice.entrySet().iterator();

		// Iterate over the HashMap
		while (iterator.hasNext()) {

			// Get the entry at this iteration
			Map.Entry<String, String>
			entry
			= iterator.next();

			// Check if this key is the required key
			if ((driver.findElement(By.xpath("//table[contains(@class,'table table-striped cart-items')]/tbody/tr["+i+"]/td[1]")).getText()).contains(entry.getKey())) {

				if((driver.findElement(By.xpath("//table[contains(@class,'table table-striped cart-items')]/tbody/tr["+i+"]/td[2]")).getText()).contains(entry.getValue()))
				{
					logger.info("Price of individual item "+entry.getValue());
					Assert.assertTrue(true);
				}
				else {logger.info("Wrong value" +entry.getValue());
				captureScreen(driver,"TestCase3");			
				logger.info("Price mismatch");
				Assert.assertTrue(false);
				}
			}
		}


	}

	}
}
