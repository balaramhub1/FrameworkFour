package com.CRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.base.TestBase;
import com.CRM.pompages.ContactsPage;
import com.CRM.pompages.HomePage;
import com.CRM.pompages.LoginPage;
import com.CRM.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	@BeforeMethod
	public void setUp(){
		init();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void homePageTitleTest(){
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "HomePage title mismatch");
		// the message will be displayed if the Assertion fails.
	}
	
	@Test(priority=2)
	public void userNameTest(){
		testUtil.waitFor();
		testUtil.switchToFrame();
		
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test(priority=3)
	public void contactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	
	@AfterMethod
	public void tearDown(){
		drv.close();
	}

}
