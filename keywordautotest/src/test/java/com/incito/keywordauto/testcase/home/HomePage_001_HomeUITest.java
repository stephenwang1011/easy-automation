package com.incito.keywordauto.testcase.home; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import com.incito.keywordauto.util.SuperKeyWordAction; 
public class HomePage_001_HomeUITest extends BaseParpare{ 
@Test 
 public void homeUITest() { 
SuperKeyWordAction.parseExcel("Home","001_HomeUITest",seleniumUtil);
 }
}