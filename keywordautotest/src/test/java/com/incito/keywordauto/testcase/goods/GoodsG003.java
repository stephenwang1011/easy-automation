package com.incito.keywordauto.testcase.goods; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import com.incito.keywordauto.util.TestOperation; 
public class GoodsG003 extends BaseParpare{ 
@Test 
 public void G003() { 
TestOperation.readExcel("Goods","G003",seleniumUtil);
 }
}