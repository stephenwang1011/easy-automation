package com.incito.keywordauto.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException   {

		FileInputStream filePath = null;
		XSSFWorkbook workbook = null;
		filePath = new FileInputStream("res/B.xlsx");// 读取功能模块
		workbook = new XSSFWorkbook(filePath);
		Sheet sheet = workbook.getSheet("B");
		System.out.println(sheet.getRow(0).getCell(0));

		  }

	}


