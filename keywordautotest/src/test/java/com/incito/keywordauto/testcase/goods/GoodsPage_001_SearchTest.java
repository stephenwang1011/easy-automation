package com.incito.keywordauto.testcase.goods; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import com.incito.keywordauto.util.SuperKeyWordAction; 
public class GoodsPage_001_SearchTest extends BaseParpare{ 
@Test 
 public void searchTest() { 
SuperKeyWordAction.parseExcel("Goods","001_SearchTest",seleniumUtil);
 }
}