package com.incito.keywordauto.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import jxl.read.biff.BiffException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
/**
 * 
 * @author Administrator
 * @Description  自动生成测试代码的工具类
 *
 */
public class DynamicTestCaseFactory {
  public static void main(String[] args)   {

		final String caseFolder = "src/test/java/com/incito/keywordauto/testcase/";
	    File sourceFile = null;
	    String sheetName = null;
	    for (int i = 0; i < getFunctionNum(); i++) { //第一层循环 取得模块的个数
		  	try{
		 
		  		String functionName = getFunctionName(i);//获得每轮循环的 模块名

		  		for (int j = 0; j < getSheetNum(getExcelRelativePath(i)); j++) { //第二层循环，根据传入的模块文件路径获得 模块中sheet数量 也就是用例个数
		  			if(j==getSheetNum(getExcelRelativePath(i))-1){
				 
		  				break;
		  			}
		  		try {
		  			sheetName = getSheetName(j+1, getExcelRelativePath(i)); //取得sheetName 只进行一次全局异常捕获
		  			} catch (BiffException e1) {
		  					e1.printStackTrace();
		  				}
					sourceFile = new File(caseFolder+functionName.toLowerCase()+File.separator+functionName+sheetName+".java");// 创建测试用例源码，指定存放路径
				    FileWriter writer = new FileWriter(sourceFile);

			  //生成测试用例代码的头文件
					writer.write( 
							"package com.incito.keywordauto.testcase."+functionName.toLowerCase()+"; \n"+
							"import org.testng.annotations.Test; \n"+
							"import com.incito.keywordauto.base.BaseParpare; \n "+
							"import com.incito.keywordauto.util.TestOperation; \n"+
					        "public class "+functionName+sheetName+" extends BaseParpare{ \n" 
					);
	
			    //@Test的主体部分，也就是测试用例的方法
					writer.write( 
							"@Test \n" +
						    " public void"+" "+sheetName+"() { \n" +
						    "TestOperation.readExcel(\""+functionName+"\",\""+sheetName+"\",seleniumUtil);\n" +
						    " }\n" 
							);
		
			    //代码结尾大括号
			    writer.write(
			    		"}"
			    		);
			    writer.close(); 
			}}catch(IOException e){
				Assert.fail("IO异常", e);
			}
		  	System.out.println("模块："+getFunctionName(i)+" 的用例已经生成完毕，请到res/testcase/"+getFunctionName(i).toLowerCase()+"路径下查阅！");
		}

  }
	
  
  
	  /**
	   * 获得当前路径下模块个数
	   * @return 得到模块的个数
	   */
	  public static int getFunctionNum(){
		  String path="res/testcase";
		  File file = new File(path);  
		  File[] array = file.listFiles();
		  return array.length;
	  }
	  /**
	   * 获得模块名字 也就是excel 表名
	   * @param 循环模块名称的角标
	   * @return 得到对应index的模块名字
	   */
	  public static String getFunctionName(int index){
		  String path="res/testcase";
		  String functionName="";
		  // get file list where the path has   
	      File file = new File(path);   
	      // get the folder list   
	      File[] array = file.listFiles();
	      if(array[index].isFile()){
	    	  functionName=array[index].getName().substring(0, array[index].getName().lastIndexOf("."));
	      }
	      return functionName;
	  }
	  
	  /**
	   * 获得excel的相对路径
	   * @param 循环模块名称的角标
	   * @return 得到对应index的模块名字
	   */
	  public static String getExcelRelativePath(int index){
		  String path="res/testcase";
		  String functionName="";
		  // get file list where the path has   
	      File file = new File(path);   
	      // get the folder list   
	      File[] array = file.listFiles();
	      functionName = array[index].getPath();
	      return functionName;
	  }
	  
	  
	  /**
	   * 获得当前excel的sheet数量 - 每个模块的用例数
	   * @param filePath 文件路径
	   * @return 获得excel的sheet数量
	   * @throws FileNotFoundException
	   * @throws IOException
	   */
	  public static int getSheetNum(String filePath) throws FileNotFoundException, IOException{
		  int casesNum = 0;
		  XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(new File(filePath)));
		  casesNum =  workbook.getNumberOfSheets();
		  
		  return casesNum;
	  }
	  
	  /**
	   * 
	   * @param sheetIndex sheet的位置
	   * @param filePath excel文件路径相对的
	   * @return 返回sheet的名字
	   * @throws BiffException
	   * @throws IOException
	   */
	  public static String getSheetName(int sheetIndex,String filePath) throws BiffException, IOException{
		  String casesName = "";
			XSSFWorkbook workbook =new XSSFWorkbook(new FileInputStream(filePath));
			casesName =workbook.getSheetName(sheetIndex);
			
		  return casesName;
		  
	  }
	
	}
