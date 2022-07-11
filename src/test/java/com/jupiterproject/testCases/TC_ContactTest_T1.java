package com.jupiterproject.testCases;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import com.jupiterproject.pageObjects.HomePage;
import com.jupiterproject.pageObjects.contactPage;
import com.jupiterproject.testData.BaseClass;

import junit.framework.Assert;

public class TC_ContactTest_T1 extends BaseClass{

	@Test
	public void loginTest() throws Exception
	{

		HomePage hp =new HomePage(driver);
		contactPage cp =new contactPage(driver);

		String A_nameErr="Forename is required";
		String A_emailErr="Email is required";
		String A_messageErr="Message is required";
		String forenameerror;
		String emailerror;
		String messageerror;
		boolean b=false;

		//Go to home page
		driver.get(baseURL);
		logger.info("URL opened");


		//1.	From the home page go to contact page
		hp.clickContact();
		Thread.sleep(3000);
		b=driver.getPageSource().contains("We welcome your feedback");
		status(b);


		//2.	Click submit button

		cp.clickSubmit();
		Thread.sleep(3000);
		b=driver.getPageSource().contains("but we won't get it unless you complete the form correctly");
		status(b);
		logger.info("Submitted without filling mandatory fields");

		//3.	Verify error messages
		forenameerror=driver.findElement(By.xpath(".//*[@id='forename-err']")).getText();
		if(forenameerror.equals(A_nameErr)){
			logger.info("Forename not found");
			Assert.assertTrue(true);
		}
		else{
			captureScreen(driver,"TestCase1");			
			logger.info("Entered Forename");
			Assert.assertTrue(false);
		}
		emailerror=driver.findElement(By.xpath(".//*[@id='email-err']"	)).getText();
		if(emailerror.equals(A_emailErr)){
			logger.info("Email not found");
			Assert.assertTrue(true);
		}
		else{
			captureScreen(driver,"TestCase1");			
			logger.info("Entered email");
			Assert.assertTrue(false);
		}
		messageerror=driver.findElement(By.xpath(".//*[@id='message-err']"	)).getText();
		if(messageerror.equals(A_messageErr)){
			logger.info("Message not found");
			Assert.assertTrue(true);
		}
		else{
			captureScreen(driver,"TestCase1");			
			logger.info("Entered message");
			Assert.assertTrue(false);
		}


		//4.	Populate mandatory fields
		//Thread.sleep(3000);
		cp.setUserName(forename);
		logger.info("Entered forename");
		cp.setEmail(email);
		logger.info("Entered email");
		cp.setMessage(message);
		logger.info("Entered message");

		
		//5.	Validate errors are gone
		List<WebElement> lstfn = driver.findElements(By.xpath(".//*[@id='forename-err']"));
		if(lstfn.size()>0){
			captureScreen(driver,"TestCase1");	
			logger.info("Forename required field validator still exists");
			Assert.assertTrue(false);
		}
		else{		
			logger.info("Forename required field validator gone");
			Assert.assertTrue(true);
		}
		List<WebElement> lstemail = driver.findElements(By.xpath(".//*[@id='email-err']"));
		if(lstemail.size()>0){
			captureScreen(driver,"TestCase1");	
			logger.info("Email required field still exists");
			Assert.assertTrue(false);
		}
		else{
			logger.info("Email required field validator gone");
			Assert.assertTrue(true);
		}
		List<WebElement> lstmsg = driver.findElements(By.xpath(".//*[@id='message-err']"));
		if(lstmsg.size()>0){
			captureScreen(driver,"TestCase1");	
			logger.info("Message required field still exists");
			Assert.assertTrue(false);
		}
		else{
			logger.info("Message required field validator gone");
			Assert.assertTrue(true);
		}

	}
	public void status(boolean br) throws Exception {{
		if(br==true)
		{
			Assert.assertTrue(true);

		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"TestCase1");
			Assert.assertTrue(false);
		}
	}
	}
}

