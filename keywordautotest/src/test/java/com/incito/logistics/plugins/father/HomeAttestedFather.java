package com.incito.logistics.plugins.father;

import org.testng.ITestContext;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;
import com.incito.logistics.util.SeleniumUtil;

/**
 * @author wangyang
 * @description 每个流程 开始之间的一个准备类，主要是做登录准备以及相关数据加载准备
 * 
 * */
public class HomeAttestedFather extends BaseParpare {
	protected static int timeOut = 0;
	protected static int sleepTime = 0;

	/**
	 * 首页上证用户的登录操作以及相关数据准备
	 * */
	public static void homeAuthenticationParpare(ITestContext context, SeleniumUtil seleniumUtil) {

		timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
		String configFilePath = String.valueOf(context.getCurrentXmlTest().getParameter("userInfoPath"));
		String username = PropertiesDataProvider.getTestData(configFilePath, "username");
		String password = PropertiesDataProvider.getTestData(configFilePath, "password");
		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.checkHomePageText(seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.login(seleniumUtil, username, password);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
	}

}
