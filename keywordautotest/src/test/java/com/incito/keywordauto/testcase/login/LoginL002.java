package com.incito.keywordauto.testcase.login; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import com.incito.keywordauto.util.SeleniumKeyWordAction; 
public class LoginL002 extends BaseParpare{ 
@Test 
 public void L002() { 
SeleniumKeyWordAction.readExcel("Login","L002",seleniumUtil);
 }
}