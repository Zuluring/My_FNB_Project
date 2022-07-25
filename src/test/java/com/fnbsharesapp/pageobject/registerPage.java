package com.fnbsharesapp.pageobject;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


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
	
	@FindBy(xpath = "//*[@ng-if='$ctrl.RegistrationForm.sa_id.$touched && $ctrl.RegistrationForm.sa_id.$invalid']/div")
	WebElement saIdErrMsg;
	
	public String getSAIdErrMsg() {
		
		String text = saIdErrMsg.getText();
		
		return text;
	}
	
	@FindBy(xpath = "//label[@for='all-product']")
	WebElement allProduct;
	
	//@FindBy(css = "div.recaptcha-checkbox-checkmark")
	@FindBy(id = "recaptcha-anchor")
	WebElement reCaptcha;
	
	@FindBy(xpath= "//*[contains(text(), 'SUBMIT')]")
	WebElement submit;
	
	
	//identify action on WebElement
	public void selectTitle(String titleAdd) {
		
	//click dropdown first - show title list
	title.click();
		
	//ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	WebElement titles = ldriver.findElement(By.xpath("/html/body/fnb-securities/div/div/div/ui-view/div/ai-register/div/div/div/div/ai-registration-landing/div/div/div/div[2]/form/div[1]/div[1]/div/ul"));
	List<WebElement> listTitles = titles.findElements(By.tagName("li"));
		for (int i = 1; i < listTitles.size(); i++)
		{
		    System.out.println(listTitles.get(i).getText());
		    
		   if(listTitles.get(i).getText().trim().equals(titleAdd)) {
			   
			   System.out.println("inside if statement");
			   listTitles.get(i).click();
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
	
	
	public void selectCitizen(String citizenAdd) {
		
		//click dropdown first
		citizen.click();
			
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		WebElement isCitizen = ldriver.findElement(By.xpath("/html/body/fnb-securities/div/div/div/ui-view/div/ai-register/div/div/div/div/ai-registration-landing/div/div/div/div[2]/form/div[4]/div[2]/div/ul"));
		List<WebElement> isCitizenList = isCitizen.findElements(By.tagName("li"));
			for (int i = 1; i < isCitizenList.size(); i++)
			{
			    System.out.println(isCitizenList.get(i).getText());
			    
			   if(isCitizenList.get(i).getText().trim().equals(citizenAdd)) {
				   
				   System.out.println("inside if statement2");
				   isCitizenList.get(i).click();
				   break;
			   }
			
			}
		}
	
	public void enterSAID(String saIdAdd) {
		saID.sendKeys(saIdAdd);
	}
	
	public void clickAllProduct() {
		
		allProduct.click();
		
	}
	
	public void clickCaptcha() {
		
		
		 WebElement cap  = ldriver.findElement(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]"));
		((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", cap);
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
			wait.until(ExpectedConditions.elementToBeClickable(reCaptcha)).click();
			//ldriver.switchTo().defaultContent();
			System.out.println("we waited");
			reCaptcha.click();
	
	}
	
	public void clickSubmit() {
		submit.click();
	}
	
}
