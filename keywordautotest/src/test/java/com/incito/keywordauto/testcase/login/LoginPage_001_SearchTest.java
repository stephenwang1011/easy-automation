package com.incito.keywordauto.testcase.login; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import com.incito.keywordauto.util.SuperAction; 
public class LoginPage_001_SearchTest extends BaseParpare{ 
@Test 
 public void searchTest() { 
SuperAction.parseExcel("Login","001_SearchTest",seleniumUtil);
 }
}