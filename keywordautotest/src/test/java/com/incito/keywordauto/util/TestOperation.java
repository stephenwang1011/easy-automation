package com.incito.keywordauto.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class TestOperation {
	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

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
			Assert.fail("IO异常", e);
		}
		Sheet sheet = workbook.getSheet(caseName);// 取得指定的case名字
		int rows = sheet.getPhysicalNumberOfRows(); // 获得的实际行数
		String data = null; // excel中的测试数据
		String elementLocator = null; // 元素定位方式的值
		for (int i = 1; i < rows; i++) {// 循环每行的操作，根据switch来判断每行的操作是什么，然后转换成具体的代码
			String action = sheet.getRow(i).getCell(2).getStringCellValue();
			Row row = sheet.getRow(i);
			if (row != null) {
				switch (action) {
				case "打开URL":
					data = sheet.getRow(i).getCell(5).getStringCellValue();
					seleniumUtil.get(data);
					break;
				case "AssertElementPresent":
					elementLocator = sheet.getRow(i).getCell(6).getStringCellValue();
					// Assert.assertEquals(true,autoMan.getElement(By.className(ele)));
					break;
				case "Type":
					data = sheet.getRow(i).getCell(7).getStringCellValue();
					elementLocator = sheet.getRow(i).getCell(6).getStringCellValue();
					// autoMan.getElement(By.id(ele)).sendKeys(data);
					break;
				case "ClickAndWait":
					elementLocator = sheet.getRow(i).getCell(6).getStringCellValue();
					// autoMan.getElement(By.xpath(ele)).click();
					break;
				case "AssertTextPresent":
					data = sheet.getRow(i).getCell(7).getStringCellValue();
					elementLocator = sheet.getRow(i).getCell(6).getStringCellValue();
					// String b=autoMan.getElement(By.id(ele)).getText();
					// autoMan.textEquals(data,b);
					break;
				case "AssertLocation":
					data = sheet.getRow(i).getCell(7).getStringCellValue();
					// autoMan.UrlEquals(data);
					break;
				}
			}
		}
	}

}
