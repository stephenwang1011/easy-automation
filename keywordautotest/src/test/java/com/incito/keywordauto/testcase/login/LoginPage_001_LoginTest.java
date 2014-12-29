package com.incito.keywordauto.testcase.login; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import com.incito.keywordauto.util.SuperKeyWordAction; 
public class LoginPage_001_LoginTest extends BaseParpare{ 
@Test 
 public void loginTest() { 
SuperKeyWordAction.parseExcel("Login","001_LoginTest",seleniumUtil);
 }
}