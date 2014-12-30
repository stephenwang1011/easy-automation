package com.incito.keywordauto.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
/**
 * 
 * @author xy-incito-wy
 * @Description 把Selenium操作的变成关键字操作
 *
 */
public class SuperAction {
	public static Logger logger = Logger.getLogger(SuperAction.class.getName());
	static  String pageFilePath = "res/page/PageElements.xlsx";
	/**
	 * 
	 * @param locateWay 定位方式
	 * @param locateValue 定位的方式的具体值
	 * @return 定位的方式（By）
	 */
	public static By getLocateWay(String locateWay,String locateValue){
		 By elementLocator=null;
		 	if(locateWay.equalsIgnoreCase("xpath")){
		 		elementLocator=By.xpath(locateValue);
		 	}
		 	else if(locateWay.equalsIgnoreCase("class")){
		 		elementLocator=By.className(locateValue);
		 	}
		 	else if(locateWay.equalsIgnoreCase("id")){
		 		elementLocator=By.id(locateValue);
		 	}
		 	else	if(locateWay.equalsIgnoreCase("linktext")){
		 		elementLocator=By.linkText(locateValue);
		 	}
		 	else	if(locateWay.equalsIgnoreCase("name")){
		 		elementLocator=By.name(locateValue);
		 	}
		 	else	if(locateWay.equalsIgnoreCase("css")){
		 		elementLocator=By.cssSelector(locateValue);
		 	}
		 	else	if(locateWay.equalsIgnoreCase("tagname")){
		 		elementLocator=By.tagName(locateValue);
		 	}
		 	else{
		 		Assert.fail("你选择的定位方式：["+locateWay+"] 不被支持!");
		 	}
		 	return elementLocator;
		 }
	
	/**
	 * 
	 * @param sheet - 测试用例表中的sheet
	 * @param rowIndex - 测试用例表中的行index
	 * @param locateColumnIndex - 测试用例表中的定位列的index
	 * @return 从page表中 返回定位方式和定位值
	 * @Description 根据testcase中的定位列，去取得page页中的 定位方式和定位值
	 */
	public static String[] getPageElementLocator(Sheet sheet,int rowIndex,int locateColumnIndex){

			XSSFWorkbook pageBook = null;
			String elementLocatorWay = null;
			String elementLocatorValue = null;
			Sheet pageSheet = null;
			String locator = sheet.getRow(rowIndex).getCell(locateColumnIndex).getStringCellValue();
			String locatorSplit[] = locator.split("\\.");
		try {
			pageBook = new XSSFWorkbook(new FileInputStream(new File(pageFilePath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		  pageSheet =  pageBook.getSheet(locatorSplit[0]); //取得对应页面的sheet
		 int pageRowNum =  pageSheet.getPhysicalNumberOfRows();
		 for (int j = 0; j < pageRowNum; j++) {
			if(pageSheet.getRow(j).getCell(0).getStringCellValue().equalsIgnoreCase(locatorSplit[1])){
				 elementLocatorWay = pageSheet.getRow(j).getCell(1).getStringCellValue();
				 elementLocatorValue = pageSheet.getRow(j).getCell(2).getStringCellValue();
				break;
			}
		}
		return new String[]{elementLocatorWay,elementLocatorValue};
	
	}

	/**
	 * @param founction
	 *            excel文件的名字
	 * @param caseName
	 *            excel中sheet的名字
	 * @param seleniumUtil
	 *            引用seleniumUtil
	 * @Description 读取excel中每个sheet的操作步骤，进而生成测试用例
	 * */
	public static void parseExcel(String founction, String caseName, SeleniumUtil seleniumUtil) {
		FileInputStream filePath = null;
		XSSFWorkbook workbook = null;
		String locateSplit[]  = null;
		String file = "res/testcase/" + founction + ".xlsx";
		try {
			filePath = new FileInputStream(file);// 读取功能模块
		} catch (FileNotFoundException e) {
			logger.error("文件：" + file + "不存在");
			Assert.fail("文件：" + file + "不存在");
		}
		try {
			workbook = new XSSFWorkbook(filePath);
		} catch (IOException e) {
			logger.error("IO异常");
			Assert.fail("IO异常");
		}
		Sheet sheet = workbook.getSheet(caseName);// 取得指定的case名字
		int rows = sheet.getPhysicalNumberOfRows(); // 获得的实际行数
		String testData = null; // excel中的测试数据
		 int cellsNumInOneRow = sheet.getRow(0).getPhysicalNumberOfCells();
		 String column[] = new String[cellsNumInOneRow];
		 Iterator<Cell> cell = sheet.getRow(0).iterator();
		 int ii =0;
		 while(cell.hasNext()){
			 column[ii]= String.valueOf(cell.next());
			 ii++;
		 }
 			int actionColumnIndex =0;
			int locateColumnIndex = 0;
			int testDataColumnIndex = 0;
			//动态获取这几个关键列所在位置
		 for (int i = 0; i < column.length; i++) {
			 if(column[i].equals("动作")){
				 actionColumnIndex = i;
			 }
			 if(column[i].equals("定位")){
				 locateColumnIndex = i;
			 }
			 if(column[i].equals("测试数据")){
				 testDataColumnIndex = i;
			 }
			
		}

				
		for (int i = 1; i < rows; i++) {// 循环每行的操作，根据switch来判断每行的操作是什么，然后转换成具体的代码
			String action = sheet.getRow(i).getCell(actionColumnIndex).getStringCellValue();
			Row row = sheet.getRow(i);
			if (row != null) {
				switch (action) {
				case "打开链接":
					testData = sheet.getRow(i).getCell(testDataColumnIndex).getStringCellValue();
					seleniumUtil.get(testData);
					break;
					
				case "输入":
					testData = sheet.getRow(i).getCell(testDataColumnIndex).getStringCellValue();
					locateSplit = getPageElementLocator(sheet, i, locateColumnIndex);
					seleniumUtil.type(seleniumUtil.findElementBy(getLocateWay(locateSplit[0], locateSplit[1])), testData);
					break;
					
				case "点击":
					locateSplit = getPageElementLocator(sheet, i, locateColumnIndex);
					seleniumUtil.click(seleniumUtil.findElementBy(getLocateWay(locateSplit[0], locateSplit[1])));
					break;
					
				case "暂停":
					testData = sheet.getRow(i).getCell(testDataColumnIndex).getStringCellValue();
					seleniumUtil.pause(Integer.parseInt(testData));
					break;
				case "等待元素":
					testData = sheet.getRow(i).getCell(testDataColumnIndex).getStringCellValue();
					locateSplit = getPageElementLocator(sheet, i, locateColumnIndex);
					seleniumUtil.waitForElementToLoad(Integer.parseInt(testData), getLocateWay(locateSplit[0], locateSplit[1]));
					break;
					
					
					
					
					
					
					
					
					
				}
			}
		}
	}

}
