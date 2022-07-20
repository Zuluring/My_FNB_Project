package com.fnbsharesapp.pageobject;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.SearchContext;



public class registerPage {
	
	//create object of WebDriver
	WebDriver ldriver;
	
	//constructor
	public registerPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);	
	}
	
	//identify WebElements
	@FindBy(xpath = "//form[@name='$ctrl.RegistrationForm']//input[@value='MR']")
	
	WebElement title;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement surname;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "phone")
	WebElement mobileNumber;
	
	@FindBy(id = "username")
	WebElement userName;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath = "//form[@name='$ctrl.RegistrationForm']//input[@value='Yes']")
	WebElement citizen;
	
	@FindBy(name = "sa_id")
	WebElement saID;
	
	public String getSAID() {
		
		String text = saID.getText();
		
		return text;
	}
	
	@FindBy(xpath = "//*[@id=\"sa-id-field\"]/div/div")
	WebElement saIdErrMsg;
	
	public String getSAIdErrMsg() {
		
		String text = saIdErrMsg.getText();
		
		return text;
	}
	
	@FindBy(xpath = "//label[@for='all-product']")
	WebElement allProduct;
	
	@FindBy(xpath = "//*[@id='recaptcha-anchor']//*[@class='recaptcha-checkbox-border']")
	WebElement reCaptcha;
	
	@FindBy(xpath= "//*[contains(text(), 'SUBMIT')]")
	WebElement submit;
	
	
	//identify action on WebElement
	public void selectTitle(String titleAdd) {
		
		//click dropdown first
		title.click();
		
		//get dropdown options
		List<WebElement> options = findElements(By.tagName("li"));
		for(WebElement option : options) {
			
			if(option.getText().equals(titleAdd)) {
				 option.click();
				 break;
			}
		}
		
	}
	
	

	public void enterFirstName(String firstNameAdd) {
		firstName.sendKeys(firstNameAdd);
	}
	
	public void enterSurname(String surnameAdd) {
		surname.sendKeys(surnameAdd);
	}
	
	public void enterEmail(String emailAdd) {
		email.sendKeys(emailAdd);
	}

	public void enterMobileNumber(String pnoneAdd) {
		mobileNumber.sendKeys(pnoneAdd);
	}
	
	public void enterUserName(String userNameAdd) {
		userName.sendKeys(userNameAdd);
	}
	
	public void enterPassword(String passwordAdd) {
		password.sendKeys(passwordAdd);
	}
	
	public void enterCitizen(String citizendAdd) {
		citizen.sendKeys(citizendAdd);
	}
	
	public void enterSAID(String saIdAdd) {
		saID.sendKeys(saIdAdd);
	}
	
	public void clickAllProduct() {
		allProduct.click();
	}
	
	public void clickCaptcha() {
		try {
			ldriver.manage().window().wait(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reCaptcha.click();
	
	}
	
	public void clickSubmit() {
		submit.click();
	}
	
}
