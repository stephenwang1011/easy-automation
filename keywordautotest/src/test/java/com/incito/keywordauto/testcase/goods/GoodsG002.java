package com.incito.keywordauto.testcase.goods; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import java.io.IOException; 
import com.incito.keywordauto.util.TestOperation; 
public class GoodsG002 extends BaseParpare{ 
@Test 
 public void G002() throws IOException{ 
TestOperation.readExcel("Goods","G002",seleniumUtil);
 }
}