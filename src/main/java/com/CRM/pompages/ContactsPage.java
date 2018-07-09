package com.CRM.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.CRM.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(id="phone")
	WebElement phoneNum;
	
	@FindBy(id="mobile")
	WebElement mobileNum;
	
	@FindBy(id="email")
	WebElement emailId;
	
	@FindBy(xpath="//input[@value='Save' and @type='submit']")
	WebElement saveBtn;
	
	//@FindBy(xpath="//table/tbody/tr[6]/td/input")
	
	
	public ContactsPage(){
		PageFactory.initElements(drv, this);
	}

	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name){
		drv.findElement(By.xpath("//a[text()='"+name+"']/parent::td[@class='datalistrow']"
				+ "/preceding-sibling::td[@class='datalistrow']/input[@name='contact_id']")).click();
		
	}
	
	public void createNewContact(String title,String fName,String lName,String comp,String pNum,String mNum,String mail){
		Select sel=new Select(drv.findElement(By.name("title")));
		sel.selectByVisibleText(title);
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(comp);
		phoneNum.sendKeys(pNum);
		mobileNum.sendKeys(mNum);
		emailId.sendKeys(mail);
		saveBtn.click();
	}
}
