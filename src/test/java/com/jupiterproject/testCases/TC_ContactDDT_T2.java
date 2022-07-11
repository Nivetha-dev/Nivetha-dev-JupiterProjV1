package com.jupiterproject.testCases;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jupiterproject.pageObjects.HomePage;
import com.jupiterproject.pageObjects.contactPage;
import com.jupiterproject.testData.BaseClass;
import com.jupiterproject.utilities.XLUtils;

import junit.framework.Assert;

public class TC_ContactDDT_T2 extends BaseClass{
	@Test(dataProvider="contactData")
	public void loginDDT(String fname,String email,String msg) throws InterruptedException,Exception
	{
		boolean b=false;
		//Go to home page
		driver.get(baseURL);
		logger.info("URL opened");
		Thread.sleep(3000);
		HomePage hp =new HomePage(driver);
		contactPage cp =new contactPage(driver);


		//	From the home page go to contact page
		hp.clickContact();
		Thread.sleep(3000);
		logger.info(b=driver.getPageSource().contains("We welcome your feedback"));
		if(b) {Assert.assertTrue(true);
		logger.info("Navigated to contact page");}
		else {
			try {
				logger.info("Navigation failed");
				captureScreen(driver,"TestCase2");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}Assert.assertTrue(false);
		}


		//	Populate mandatory fields
		cp.setUserName(fname);
		logger.info("Entered forename");
		cp.setEmail(email);
		logger.info("Entered email");
		cp.setMessage(msg);
		logger.info("Entered message");


		//	Click submit button
		cp.clickSubmit();
		Assert.assertTrue(true);

		WebDriverWait wait1 = new WebDriverWait(driver, 10000);
		wait1.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='alert alert-success']"))));
		boolean r=driver.getPageSource().contains("we appreciate your feedback");

		if(r)
		{
			Assert.assertTrue(true);
			logger.info("User details Submitted");
		}
		else
		{
			try {
				captureScreen(driver,"TestCase2");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
			Thread.sleep(3000);
			logger.info("Submission failed");
		}

	}


	@DataProvider(name="contactData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/jupiterproject/testData/contactData.xlsx";

		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}

		}
		return logindata;
	}
}
