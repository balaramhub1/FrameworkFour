package com.CRM.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.CRM.base.TestBase;

public class TestListener extends TestBase implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dFormat=new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		
		String methodName=result.getName();
		
		if(!result.isSuccess()){
			File srcFile=((TakesScreenshot)drv).getScreenshotAs(OutputType.FILE);
			
			try{
				String screenShotDir=new File(System.getProperty("user.dir")).getAbsolutePath()+"/screenshot/";
				File destFile=new File((String)screenShotDir + methodName + "_"+dFormat.format(cal.getTime())+".png");
				FileUtils.copyFile(srcFile, destFile);
				
				
			}catch (IOException e){
				e.printStackTrace();
			}
			
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dFormat=new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		
		String methodName=result.getName();
		
		if(result.isSuccess()){
			File srcFile=((TakesScreenshot)drv).getScreenshotAs(OutputType.FILE);
			
			try{
				String screenShotDir=new File(System.getProperty("user.dir")).getAbsolutePath()+"/screenshot/";
				File destFile=new File((String)screenShotDir + methodName + "_"+dFormat.format(cal.getTime())+".png");
				FileUtils.copyFile(srcFile, destFile);
				
				
			}catch (IOException e){
				e.printStackTrace();
			}
			
		}
		
	}
	

}
