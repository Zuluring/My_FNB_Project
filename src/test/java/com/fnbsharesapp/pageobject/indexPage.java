package com.fnbsharesapp.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	
	//create object of WebDriver
	WebDriver ldriver;
	
	//constructor
	public indexPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);	
	}
	
	//identify WebElements
	@FindBy(id = "openaccount2")
	WebElement openAccount;
	
	//identify action on WebElement
	public void clickOpenAccount() {
		openAccount.click();
	}
	
	
}
