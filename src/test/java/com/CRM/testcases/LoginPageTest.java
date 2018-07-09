package com.CRM.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.base.TestBase;
import com.CRM.pompages.HomePage;
import com.CRM.pompages.LoginPage;

public class LoginPageTest extends TestBase{
	
	public static final Logger log=Logger.getLogger(LoginPageTest.class.getName());
	
	HomePage homepage;
	LoginPage loginpage;
	
	@BeforeMethod
	public void setUp(){
		init();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title=loginpage.loginPageTitle();
		System.out.println("title is :"+title);
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
		
	}
	
	@Test(priority=2)
	public void crmLogoTest(){
		boolean logo=loginpage.crmLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=3)
	public void loginTest(){
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown(){
		drv.close();
	}
}
