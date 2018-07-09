package com.CRM.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CRM.base.TestBase;

public class TestUtil extends TestBase{
	
	// All classes can consume the below static variables.
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPL_WAIT=10;
	
	static Workbook book;
	static Sheet sheet;
	
	public static String TESTDATA_SHEET_PATH="D:\\Selenimum Training\\Selenium Framework 3\\CRM_TestData.xlsx";
	
	WebDriverWait wa;
	
	public void switchToFrame(){
		drv.switchTo().frame("mainpanel");
	}
	
	public void waitFor(){
		wa=new WebDriverWait(drv,2000);
		
	}
	
	public static Object [][] getTestData(String sheetName){
		XSSFWorkbook wb=null;
		XSSFSheet sh=null;
		FileInputStream fis=null;
		
		try{
		fis = new FileInputStream("D:\\Selenimum Training\\Selenium Framework 3\\CRM_TestData.xlsx");
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		try{
			wb=new XSSFWorkbook(fis);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		sh=wb.getSheet(sheetName);
		Object [][] data=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for(int i=0;i<sh.getLastRowNum();i++){
			
			for(int j=0;j<sh.getRow(0).getLastCellNum();j++){
				//Row row=sh.getRow(i+1);
				//System.out.println(row.getCell(j));
				data[i][j]=sh.getRow(i+1).getCell(j).toString();
				
			}
		}
		
		return data;
	}
	
	
}
