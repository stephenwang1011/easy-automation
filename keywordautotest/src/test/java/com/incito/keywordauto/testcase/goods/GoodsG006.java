package com.incito.keywordauto.testcase.goods; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import com.incito.keywordauto.util.SeleniumKeyWordAction; 
public class GoodsG006 extends BaseParpare{ 
@Test 
 public void G006() { 
SeleniumKeyWordAction.readExcel("Goods","G006",seleniumUtil);
 }
}