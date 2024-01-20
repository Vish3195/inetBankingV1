package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		Logger.info("User name is provided");
		lp.setPassword(password);
		Logger.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
	
		Logger.info("provided customer details....");
		
		addcust.custName("Vishal");
		addcust.custgender("male");
		addcust.custdob("11", "03", "1995");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("BOKARO");
		addcust.custstate("JHARKHAND");
		addcust.custpinno("827009");
		addcust.custtelephoneno("7209277521");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("fgtyf");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		Logger.info("validation started.....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			Logger.info("tset case passed....");
		}
		else
		{
			Logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	
	
	

}
