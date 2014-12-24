package com.incito.keywordauto.util;

import java.io.*;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

public class DynamicCompilation {

  public static void main(String[] args) throws Exception {
    // 创建测试用例源码，指定存放路径
    File sourceFile   = new File("src/test/java/com/incito/keywordauto/testcase/login/Login.java");
    FileWriter writer = new FileWriter(sourceFile);

    writer.write( //生成头
    		"package com.incito.keywordauto.testcase.login; \n"+
    		"import org.testng.annotations.Test; \n"+
    		"import com.incito.keywordauto.base.BaseParpare; \n "+
    		"import java.io.IOException; \n"+
    		"import com.incito.keywordauto.util.TestOperation; \n"+
            "public class Login extends BaseParpare{ \n" 
    );
    for(int i=0;i<casesNum();i++){
    	String functionName=getFunctionName(i);
    writer.write( //生成@Test以及相关方法
    		"@Test \n" +
    	    " public void"+" "+functionName.toLowerCase()+"() throws IOException{ \n" +
    	    "TestOperation.readExcel(\""+functionName+"\",\"001\",seleniumUtil);\n" +
    	    " }\n" 
    	    
    		);
    }
    writer.write(
    		"}"
    		);
    writer.close();
//编译
//    JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
//    StandardJavaFileManager fileManager =
//        compiler.getStandardFileManager(null, null, null);
//
//    fileManager.setLocation(StandardLocation.CLASS_OUTPUT,
//                            Arrays.asList(new File(""))); //存放编译的class文件
//    // Compile the file
//    compiler.getTask(null,
//               fileManager,
//               null,
//               null,
//               null,
//               fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile)))
//            .call();
//    fileManager.close();


    // delete the source file
    // sourceFile.deleteOnExit();

//    runIt();
  }
  //获得当前用例个数
  public static int casesNum(){
	  String path="res/testcase";
	  File file = new File(path);  
	  File[] array = file.listFiles();
	  return array.length;
  }
  //获得模块名字
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
//
//  @SuppressWarnings("unchecked")
//  public static void runIt() {
//    try {
//      Class params[] = {};
//      Object paramsObj[] = {};
//      Class thisClass = Class.forName("testdata2");
//      Object iClass = thisClass.newInstance();
//      Method thisMethod = thisClass.getDeclaredMethod("doit", params);
//      thisMethod.invoke(iClass, paramsObj);
//      }
//    catch (Exception e) {
//      e.printStackTrace();
//    }
 // }
}
