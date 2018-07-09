package com.CRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.base.TestBase;
import com.CRM.pompages.ContactsPage;
import com.CRM.pompages.HomePage;
import com.CRM.pompages.LoginPage;
import com.CRM.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	ContactsPage contactsPage;
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	
	String sheetName="contacts";
	
	@BeforeMethod
	public void setUp(){
		init();
		contactsPage = new ContactsPage();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
		
	}
	
	@Test(priority=1)
	public void contactsPageLabelTest(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts Label is missing");
	}
	
	@Test(priority=2)
	public void selectSingleContactTest(){
		contactsPage.selectContactsByName("Sunitha Minz");
	}
	
	@Test(priority=3)
	public void selectMultiContactTest(){
		contactsPage.selectContactsByName("Sunitha Minz");
		contactsPage.selectContactsByName("Anirudh Choudhary");
	}
	
	@Test(priority=4,dataProvider="getNewContactData")
	public void createNewContactTest(String title,String fName,String lName, String comp,String pNum,String mNum,String mail){
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Anuj","Yahoo", "Mehta", "040989898", "6565656565", "anuj@yahoo.com");
		contactsPage.createNewContact(title, fName, lName, comp, pNum, mNum, mail);
	}
	
	@DataProvider
	public Object[][] getNewContactData(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@AfterMethod
	public void tearDown(){
		drv.close();
	}

}
