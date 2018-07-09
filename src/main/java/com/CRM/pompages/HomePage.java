package com.CRM.pompages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.base.TestBase;

public class HomePage extends TestBase{
	
	public HomePage(){
		PageFactory.initElements(drv, this);
	}
	
	//CacheLookup is used to improve the performance of script execution as the elements will be stored in a cache
	// and not identified via locater every time the element is to be referenced.
	// it may throw staleElementException if the page is refreshed or the DOM is changed.
	
	@FindBy(xpath="//td[contains(text(),'User: naveen kala')]")
	//@CacheLookup
	WebElement userNameLabel;
	//userNameLabel is enclosed in a Frame, hence it cannot be accessed directly
	// by xpath, first we need to switch to the frame and then access the userNameLabel

	@FindBy(xpath="*//ul/li[4]/a[contains(text(),'Contacts')]")
	//@CacheLookup
	WebElement contactsLink;
	
	@FindBy(xpath="*//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public String verifyHomePageTitle(){
		return drv.getTitle();
	}
	
	public ContactsPage clickOnContactsLink(){
		// clicking on contacts link would return a ContactsPage object.
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		// clicking on Deals link would return a ContactsPage object.
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public boolean verifyUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public void clickOnNewContactLink(){
		Actions act=new Actions(drv);
		act.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
				
	}
	
}
