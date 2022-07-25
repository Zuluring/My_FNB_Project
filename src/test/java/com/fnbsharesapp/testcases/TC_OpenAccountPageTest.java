<<<<<<< HEAD
package com.fnbsharesapp.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		myAccpg.selectTitle("PROF");
		logger.info("Title entered");
		
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
		
		myAccpg.enterPassword("Pass@123");
		logger.info("Password entered");
		
		myAccpg.selectCitizen("Yes");
		logger.info("Citizenship selected");
		
		myAccpg.enterSAID("2001014800086");
		logger.info("ID Number entered");
		
		/*
		 * Step 4.  Select product you are interested in (Local Trading Account, 
		 * Derivatives Trader, Global Trading Account (offshore) or all) (Choose one)
		 */
		myAccpg.clickAllProduct();
		logger.info("All products selected");
		
		myAccpg.clickCaptcha();
		logger.info("Captcha checked");
		
		//Validation
		String saID = myAccpg.getSAID();
				
		if(saID.length() != 13) {
					
					logger.info("invalid SA ID entered");
					String saIdErrMsg = myAccpg.getSAIdErrMsg();
					Assert.assertEquals("South African ID numbers are thirteen digits.",saIdErrMsg);
		}
		
		//myAccpg.clickSubmit();
		logger.info("Submit button clicked");
		
	}
}
=======
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
>>>>>>> 5f7e01c35c76d1e23e285c5b07a5a6e2a44fb91b
