package com.incito.keywordauto.testcase.home; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import com.incito.keywordauto.util.SeleniumKeyWordAction; 
public class HomeH002 extends BaseParpare{ 
@Test 
 public void H002() { 
SeleniumKeyWordAction.readExcel("Home","H002",seleniumUtil);
 }
}