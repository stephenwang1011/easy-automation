package com.incito.keywordauto.testcase.login; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import java.io.IOException; 
import com.incito.keywordauto.util.TestOperation; 
public class LoginL001 extends BaseParpare{ 
@Test 
 public void L001() throws IOException{ 
TestOperation.readExcel("Login","L001",seleniumUtil);
 }
}