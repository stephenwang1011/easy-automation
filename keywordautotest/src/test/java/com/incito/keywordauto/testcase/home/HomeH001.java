package com.incito.keywordauto.testcase.home; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import com.incito.keywordauto.util.SeleniumKeyWordAction; 
public class HomeH001 extends BaseParpare{ 
@Test 
 public void H001() { 
SeleniumKeyWordAction.readExcel("Home","H001",seleniumUtil);
 }
}