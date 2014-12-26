package com.incito.keywordauto.testcase.goods; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import com.incito.keywordauto.util.SeleniumKeyWordAction; 
public class GoodsG002 extends BaseParpare{ 
@Test 
 public void G002() { 
SeleniumKeyWordAction.readExcel("Goods","G002",seleniumUtil);
 }
}