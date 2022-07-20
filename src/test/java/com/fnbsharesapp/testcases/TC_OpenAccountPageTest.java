package com.fnbsharesapp.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fnbsharesapp.pageobject.indexPage;
import com.fnbsharesapp.pageobject.registerPage;

public class TC_OpenAccountPageTest extends BaseClass {
	
	@Test(enabled=true)
	public void createAnAccount() {
		
		//Step 1.  Open FNB Shares website.
		driver.get(url);
		logger.info("url opened");
		
		
		//Step 2.  Click on Open Account button
		indexPage pg = new indexPage(driver);
		pg.clickOpenAccount();
		logger.info("click open account");
		

		registerPage myAccpg = new registerPage(driver);
		//myAccpg.selectTitle("PROF");
		
		myAccpg.enterFirstName("Mdu");
		logger.info("Firtname entered");
		
		myAccpg.enterSurname("Zulu");
		logger.info("Surname entered");
		
		myAccpg.enterEmail("zuluring@gmail.com");
		logger.info("Email entered");
		
		myAccpg.enterMobileNumber("0835687859");
		logger.info("Phone entered");
		
		myAccpg.enterUserName("asdf");
		logger.info("Username entered");
		
		myAccpg.enterPassword("pass123");
		logger.info("Password entered");
		
		myAccpg.enterSAID("8912235985088");
		logger.info("ID Number entered");
		
		/*
		 * Step 4.  Select product you are interested in (Local Trading Account, 
		 * Derivatives Trader, Global Trading Account (offshore) or all) (Choose one)
		 */
		myAccpg.clickAllProduct();
		
		//Validation
		String saID = myAccpg.getSAID();
		String saIdErrMsg = myAccpg.getSAIdErrMsg();
		
		if(saID.length() != 13) {
			
			logger.info("invalid SA ID entered");
			Assert.assertEquals("South African ID numbers are thirteen digits.",saIdErrMsg);
		}
		
	}
}
