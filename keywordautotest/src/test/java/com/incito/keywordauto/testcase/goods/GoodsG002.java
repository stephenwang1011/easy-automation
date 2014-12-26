package com.incito.keywordauto.testcase.goods; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import com.incito.keywordauto.util.TestOperation; 
public class GoodsG002 extends BaseParpare{ 
@Test 
 public void G002() { 
TestOperation.readExcel("Goods","G002",seleniumUtil);
 }
}