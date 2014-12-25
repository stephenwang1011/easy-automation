package com.incito.keywordauto.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import jxl.read.biff.BiffException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class DynamicCompilation {

  public static void main(String[] args)   {
		final String caseFolder = "src/test/java/com/incito/keywordauto/testcase/";
	    File sourceFile = null;
	  for (int i = 0; i < getFunctionNum(); i++) { //第一层循环 取得模块的个数
	 try{
		 
		 String functionName = getFunctionName(i);//获得每轮循环的 模块名

		 for (int j = 0; j < getSheetNum(getExcelRelativePath(i)); j++) { //第二层循环，根据传入的模块文件路径获得 模块中sheet数量 也就是用例个数
			 if(j==getSheetNum(getExcelRelativePath(i))-1){
				 
				break;
			 }
		
				try {
					sourceFile = new File(caseFolder+functionName.toLowerCase()+File.separator+functionName+getSheetName(j+1, getExcelRelativePath(i))+".java");// 创建测试用例源码，指定存放路径
				} catch (BiffException e) {
					e.printStackTrace();
				}    
			    FileWriter writer = new FileWriter(sourceFile);

			    try {
					writer.write( //生成头
							"package com.incito.keywordauto.testcase."+functionName.toLowerCase()+"; \n"+
							"import org.testng.annotations.Test; \n"+
							"import com.incito.keywordauto.base.BaseParpare; \n "+
							"import java.io.IOException; \n"+
							"import com.incito.keywordauto.util.TestOperation; \n"+
					        "public class "+functionName+getSheetName(j+1, getExcelRelativePath(i))+" extends BaseParpare{ \n" 
					);
				} catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    //@Test的主体部分
			    try {
					writer.write( //生成@Test以及相关方法
							"@Test \n" +
						    " public void"+" "+getSheetName(j+1, getExcelRelativePath(i))+"() throws IOException{ \n" +
						    "TestOperation.readExcel(\""+functionName+"\",\""+getSheetName(j+1, getExcelRelativePath(i))+"\",seleniumUtil);\n" +
						    " }\n" 
						    
							);
				} catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    //结尾
			    writer.write(
			    		"}"
			    		);
			    writer.close();
			    
			    
			    
			    
			    
			}}catch(IOException e){
				Assert.fail("IO异常", e);
			}
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
