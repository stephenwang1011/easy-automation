package com.incito.keywordauto.testcase.login; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import com.incito.keywordauto.util.SeleniumKeyWordAction; 
public class LoginL001 extends BaseParpare{ 
@Test 
 public void L001() { 
SeleniumKeyWordAction.readExcel("Login","L001",seleniumUtil);
 }
}