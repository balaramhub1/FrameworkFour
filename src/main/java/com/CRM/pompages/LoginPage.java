package com.CRM.pompages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.base.TestBase;

public class LoginPage extends TestBase{
	
	// Initializing the LoginPage via Page Factory
	public LoginPage(){
		PageFactory.initElements(drv, this);
		
	}
	
	// Creating Object Repository for Login Page / or Page Factory
	
	@FindBy(xpath="*//form/div/input[1]")
	WebElement userName;
	
	@FindBy(xpath="*//form/div/input[2]")
	WebElement password;
	
	@FindBy(xpath="*//form/div/div/input")
	WebElement loginBtn;
	
	@FindBy(linkText="Sign Up")
	WebElement signUpBtn;
	
	
	@FindBy(className="img-responsive")
	WebElement crmLogo;
	
	public String loginPageTitle(){
		return drv.getTitle();
	}
	
	
	public boolean crmLogo(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pass){
		userName.sendKeys(un);
		password.sendKeys(pass);
		loginBtn.click();
		// clicking on login button will take us to Home page.
		// so this method should return HomePage class object.
		return new HomePage();
	}

}
