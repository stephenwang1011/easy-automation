package com.incito.keywordauto.util;
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

public class SeleniumKeyWordAction {
	public static Logger logger = Logger.getLogger(SeleniumKeyWordAction.class.getName());
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
		 	else{
		 		Assert.fail("你选择的定位方式：["+locateWay+"] 不被支持!");
		 	}
		 	return elementLocator;
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
	public static void readExcel(String founction, String caseName, SeleniumUtil seleniumUtil) {
		FileInputStream filePath = null;
		XSSFWorkbook workbook = null;
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
		String elementLocatorWay = null; // 元素定位方式,比如是xpath,id等。。
		String elementLocatorValue = null;//定位方式的具体值比如 id = name 这个name就是具体值
		 int cellsNumInOneRow = sheet.getRow(0).getPhysicalNumberOfCells();
		 String column[] = new String[cellsNumInOneRow];
		 Iterator<Cell> cell = sheet.getRow(0).iterator();
		 int ii =0;
		 while(cell.hasNext()){
			 column[ii]= String.valueOf(cell.next());
			 ii++;
		 }
 			int actionColumnIndex =0;
			int locateWayColumnIndex = 0;
			int locateValueColumnIndex = 0;
			int testDataColumnIndex = 0;
			//动态获取这几个关键列所在位置
		 for (int i = 0; i < column.length; i++) {
			 if(column[i].equals("执行步骤")){
				 actionColumnIndex = i;
			 }
			 if(column[i].equals("定位方式")){
				 locateWayColumnIndex = i;
			 }
			 if(column[i].equals("定位值")){
				 locateValueColumnIndex = i;
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
				case "打开URL":
					testData = sheet.getRow(i).getCell(testDataColumnIndex).getStringCellValue();
					seleniumUtil.get(testData);
					break;
				case "输入":
					testData = sheet.getRow(i).getCell(testDataColumnIndex).getStringCellValue();
					elementLocatorValue = sheet.getRow(i).getCell(locateValueColumnIndex).getStringCellValue();
					elementLocatorWay = sheet.getRow(i).getCell(locateWayColumnIndex).getStringCellValue();
					seleniumUtil.type(seleniumUtil.findElementBy(getLocateWay(elementLocatorWay, elementLocatorValue)), testData);
					break;
				case "点击":
					elementLocatorWay = sheet.getRow(i).getCell(locateValueColumnIndex).getStringCellValue();
					seleniumUtil.click(seleniumUtil.findElementBy(By.id(elementLocatorWay)));
					break;
				case "暂停":
					testData = sheet.getRow(i).getCell(testDataColumnIndex).getStringCellValue();
					seleniumUtil.pause(Integer.parseInt(testData));
					break;
				case "等待元素":
					testData = sheet.getRow(i).getCell(testDataColumnIndex).getStringCellValue();
					seleniumUtil.waitForElementToLoad(Integer.parseInt(testData), getLocateWay(elementLocatorWay, elementLocatorValue));
					break;
					
					
					
					
					
					
					
					
					
				}
			}
		}
	}

}
