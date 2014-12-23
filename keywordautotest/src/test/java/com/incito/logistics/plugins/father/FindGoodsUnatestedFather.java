package com.incito.logistics.plugins.father;

import java.io.IOException;
import java.util.Iterator;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.util.ExcelDataProvider;
import com.incito.logistics.util.PropertiesDataProvider;
import com.incito.logistics.util.SeleniumUtil;

/**
 * @author xy-incito-wk
 * @description 每个流程 开始之间的一个准备类，主要是做登录准备以及相关数据加载准备
 * */
public class FindGoodsUnatestedFather extends BaseParpare {
	protected static int timeOut = 0;
	protected static int sleepTime = 0;

	/** 首页上未认证用户的登录操作以及相关数据准备 **/
	public static void UnattestedFindGoodsParpare(ITestContext context, SeleniumUtil seleniumUtil) {
		String configFilePath = String.valueOf(context.getCurrentXmlTest().getParameter("userInfoPath"));
		timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
		String unattestedUsername = PropertiesDataProvider.getTestData(configFilePath, "unauthusername");
		String unattestedPassword = PropertiesDataProvider.getTestData(configFilePath, "unauthpassword");

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.login(seleniumUtil, unattestedUsername, unattestedPassword);
		LoginPageHelper.checkUserInfo(timeOut, sleepTime, seleniumUtil, unattestedUsername);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_FINDGOODS);
		FindGoodsPageHelper.waitFindGoodsPageToLoad(timeOut, seleniumUtil);
	}

	@DataProvider(name = "data")
	public Iterator<Object[]> dataFortestMethod() throws IOException {
		String moduleName = null; // 模块的名字
		String caseNum = null; // 用例编号
		String className = this.getClass().getName();
		int dotIndexNum = className.indexOf("."); // 取得第一个.的index
		int underlineIndexNum = className.indexOf("_"); // 取得第一个_的index

		if (dotIndexNum > 0) {
			moduleName = className.substring(30, className.lastIndexOf(".")); // 取到模块的名称
		}

		if (underlineIndexNum > 0) {
			caseNum = className.substring(underlineIndexNum + 1, underlineIndexNum + 4); // 取到用例编号
		}
		// 将模块名称和用例的编号传给 ExcelDataProvider ，然后进行读取excel数据
		return new ExcelDataProvider(moduleName, caseNum);
	}
}
