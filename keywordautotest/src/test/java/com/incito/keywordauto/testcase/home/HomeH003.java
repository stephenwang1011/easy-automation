package com.incito.keywordauto.testcase.home; 
import org.testng.annotations.Test; 
import com.incito.keywordauto.base.BaseParpare; 
 import java.io.IOException; 
import com.incito.keywordauto.util.TestOperation; 
public class HomeH003 extends BaseParpare{ 
@Test 
 public void H003() throws IOException{ 
TestOperation.readExcel("Home","H003",seleniumUtil);
 }
}