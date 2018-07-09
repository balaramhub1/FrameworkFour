package com.CRM.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.CRM.base.TestBase;

public class DriverEventListener extends TestBase implements WebDriverEventListener{

	public void afterAlertAccept(WebDriver drv) {
		// TODO Auto-generated method stub
		System.out.println("Alert Accepted.");
	}

	public void afterAlertDismiss(WebDriver drv) {
		// TODO Auto-generated method stub
		System.out.println("Alert Dismissed.");
	}

	public void afterChangeValueOf(WebElement element, WebDriver drv, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterClickOn(WebElement element, WebDriver drv) {
		// TODO Auto-generated method stub
		System.out.println("Clicked on Element "+element.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver drv) {
		// TODO Auto-generated method stub
		System.out.println("Found Element : "+by);
	}

	public void afterNavigateBack(WebDriver drv) {
		// TODO Auto-generated method stub
		System.out.println("Landed on previous page");
	}

	public void afterNavigateForward(WebDriver drv) {
		// TODO Auto-generated method stub
		System.out.println("Landed on next page");
	}

	public void afterNavigateRefresh(WebDriver drv) {
		// TODO Auto-generated method stub
		System.out.println("Page Refreshed");
	}

	public void afterNavigateTo(String arg0, WebDriver drv) {
		// TODO Auto-generated method stub
		System.out.println("Navigated to : "+arg0);
	}

	public void afterScript(String arg0, WebDriver drv) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertAccept(WebDriver drv) {
		// TODO Auto-generated method stub
		System.out.println("Alert to be Accepted");
	}

	public void beforeAlertDismiss(WebDriver drv) {
		// TODO Auto-generated method stub
		System.out.println("Alert to be dismissed");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver drv, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement element, WebDriver drv) {
		// TODO Auto-generated method stub
		System.out.println("Clicking on Elemment "+element.toString());
	}

	public void beforeFindBy(By by, WebElement element, WebDriver drv) {
		// TODO Auto-generated method stub
		System.out.println("Trying to Find Element by :"+by);
	}

	public void beforeNavigateBack(WebDriver drv) {
		// TODO Auto-generated method stub
		System.out.println("Navigating back to previous page");
	}

	public void beforeNavigateForward(WebDriver drv) {
		// TODO Auto-generated method stub
		System.out.println("Navigating to next page");
	}

	public void beforeNavigateRefresh(WebDriver drv) {
		// TODO Auto-generated method stub
		System.out.println("Refreshing the Page");
	}

	public void beforeNavigateTo(String arg0, WebDriver drv) {
		// TODO Auto-generated method stub
		System.out.println("Navigating to page "+arg0);
	}

	public void beforeScript(String arg0, WebDriver drv) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable arg0, WebDriver drv) {
		// TODO Auto-generated method stub
		
	}

	

}
