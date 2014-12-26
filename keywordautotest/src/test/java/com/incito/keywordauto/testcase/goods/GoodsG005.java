package com.incito.keywordauto.testcase.goods; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import com.incito.keywordauto.util.SeleniumKeyWordAction; 
public class GoodsG005 extends BaseParpare{ 
@Test 
 public void G005() { 
SeleniumKeyWordAction.readExcel("Goods","G005",seleniumUtil);
 }
}