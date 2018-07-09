package com.CRM.testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExl1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
		sh=wb.getSheet("contacts");
		Object [][] data=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for(int i=0;i<sh.getLastRowNum();i++){
			
			for(int j=0;j<sh.getRow(0).getLastCellNum();j++){
				Row row=sh.getRow(i+1);
				System.out.println(row.getCell(j));
				data[i][j]=sh.getRow(i+1).getCell(j).toString();
				
			}
		}

		System.out.println(data);
		for(int i=0;i<4;i++){
			for (int j=0;j<7;j++){
				System.out.println(data[i][j]);
			}
		}
	}

}
