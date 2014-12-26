package com.incito.keywordauto.testcase.home; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import com.incito.keywordauto.util.SeleniumKeyWordAction; 
public class HomeH003 extends BaseParpare{ 
@Test 
 public void H003() { 
SeleniumKeyWordAction.readExcel("Home","H003",seleniumUtil);
 }
}