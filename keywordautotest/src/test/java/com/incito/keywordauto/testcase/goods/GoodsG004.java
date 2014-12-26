package com.incito.keywordauto.testcase.goods; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import com.incito.keywordauto.util.SeleniumKeyWordAction; 
public class GoodsG004 extends BaseParpare{ 
@Test 
 public void G004() { 
SeleniumKeyWordAction.readExcel("Goods","G004",seleniumUtil);
 }
}