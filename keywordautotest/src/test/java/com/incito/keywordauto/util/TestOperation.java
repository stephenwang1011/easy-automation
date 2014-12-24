package com.incito.keywordauto.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
import org.openqa.selenium.By;
import org.testng.Assert;



public class TestOperation   {
	 public static void readExcel(String founction,String caseName,SeleniumUtil seleniumUtil) throws IOException{
		FileInputStream filePath=new FileInputStream("res/testcase/"+founction+".xlsx"); //读取功能模块
		XSSFWorkbook workbook = new XSSFWorkbook(filePath);//实例化
		Sheet sheet = workbook.getSheet(caseName);//取得指定的case名字
		 int rows = sheet.getPhysicalNumberOfRows(); //获得的实际行数
		String data=null;
		String ele=null;
	for (int i = 1; i < rows; i++) {
		String action=sheet.getRow(i).getCell(2).getStringCellValue();
	     Row row = sheet.getRow(i);  
	   if (row != null) { 
		switch(action){
		case "Go to URL":
			data=sheet.getRow(i).getCell(5).getStringCellValue();
			seleniumUtil.get(data);
			break;
		case "AssertElementPresent":
			ele=sheet.getRow(i).getCell(6).getStringCellValue();
//			Assert.assertEquals(true,autoMan.getElement(By.className(ele)));
			break;
		case "Type":
			data=sheet.getRow(i).getCell(7).getStringCellValue();
			ele=sheet.getRow(i).getCell(6).getStringCellValue();
//			autoMan.getElement(By.id(ele)).sendKeys(data);
		break;
		case "ClickAndWait":
			ele=sheet.getRow(i).getCell(6).getStringCellValue();
//			autoMan.getElement(By.xpath(ele)).click();
		break;
		case "AssertTextPresent":
			data=sheet.getRow(i).getCell(7).getStringCellValue();
			ele=sheet.getRow(i).getCell(6).getStringCellValue();
//			String b=autoMan.getElement(By.id(ele)).getText();
//			autoMan.textEquals(data,b);
			break;
		case "AssertLocation":
			data=sheet.getRow(i).getCell(7).getStringCellValue();
//			autoMan.UrlEquals(data);
			break;
		}
	   }
	}
	}

	}
